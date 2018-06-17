/*
 * MIT License
 *
 * Copyright (c) 2017-2018 nuls.io
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package io.nuls.network.connection.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.nuls.core.tools.log.Log;
import io.nuls.core.tools.network.IpUtil;
import io.nuls.network.manager.ConnectionManager;
import io.nuls.network.manager.NodeManager;
import io.nuls.network.model.Node;

import java.nio.ByteBuffer;
import java.util.Map;

public class ClientChannelHandler extends ChannelInboundHandlerAdapter {

    private NodeManager nodeManager = NodeManager.getInstance();

    private ConnectionManager connectionManager = ConnectionManager.getInstance();

    private AttributeKey<Node> key = AttributeKey.valueOf("node");

    public ClientChannelHandler() {

    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        Attribute<Node> nodeAttribute = channel.attr(key);
        Node node = nodeAttribute.get();
        String nodeId = node == null ? null : node.getId();
        Log.info("---------------------- client channelRegistered -----------" + nodeId);

        Map<String, Node> nodes = nodeManager.getNodes();
        // If a node with the same IP already in nodes, as a out node, can not add anymore
        for (Node n : nodes.values()) {
            //both ip and port equals , it means the node is myself
            if (n.getIp().equals(node.getIp()) && !n.getPort().equals(node.getSeverPort())) {
//                Log.info("----------------------client: it already had a connection: " + n.getId() + " type:" + n.getType() + ", this connection: " + nodeId + "---------------------- ");
                ctx.channel().close();
                return;
            }
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String channelId = ctx.channel().id().asLongText();
        SocketChannel channel = (SocketChannel) ctx.channel();
        String nodeId = IpUtil.getNodeId(channel.remoteAddress());
        Log.info(" ---------------------- client channelActive ----------" + nodeId);
//        Log.info("localInfo: "+channel.localAddress().getHostString()+":" + channel.localAddress().getPort());
//        Log.info("remoteInfo: "+channel.remoteAddress().getHostString()+":" + channel.remoteAddress().getPort());

        Attribute<Node> nodeAttribute = channel.attr(key);
        Node node = nodeAttribute.get();

        try {
            NioChannelMap.add(channelId, channel);
            node.setChannelId(channelId);
            node.setStatus(Node.CONNECT);
            boolean result = nodeManager.processConnectedNode(node);
            if (!result) {
                channel.close();
            }
        } catch (Exception e) {
            Log.info("client channelActive error: " + nodeId);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        String nodeId = IpUtil.getNodeId(channel.remoteAddress());
        Log.info(" ---------------------- client channelInactive ---------------------- " + nodeId);
//        Log.info("localInfo: "+channel.localAddress().getHostString()+":" + channel.localAddress().getPort());
//        Log.info("remoteInfo: "+channel.remoteAddress().getHostString()+":" + channel.remoteAddress().getPort());

        String channelId = ctx.channel().id().asLongText();
        NioChannelMap.remove(channelId);
        Node node = nodeManager.getNode(nodeId);
        if (node != null) {
            if (node.getChannelId() == null || channelId.equals(node.getChannelId())) {
                nodeManager.removeNode(node.getId());
            } else {
                Log.info("---------------- client channelId different----------------" + channelId + "," + node.getChannelId());
            }
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        String nodeId = IpUtil.getNodeId(channel.remoteAddress());

        try {
            Node node = nodeManager.getNode(nodeId);
            if (node != null && node.isAlive()) {
                ByteBuf buf = (ByteBuf) msg;
                byte[] bytes = new byte[buf.readableBytes()];
                buf.readBytes(bytes);
                buf.release();
                ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
                buffer.put(bytes);

                connectionManager.receiveMessage(buffer, node);
            }
        } catch (Exception e) {
            Log.info(" ---------------------- client channelRead exception---------------------- " + nodeId);
            throw e;
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//        Log.info("--------------- ClientChannelHandler exceptionCaught :" + cause.getMessage());
//        cause.printStackTrace();

        ctx.channel().close();
    }


    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }
}
