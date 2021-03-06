/*
 * MIT License
 *
 * Copyright (c) 2017-2019 nuls.io
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
package io.nuls.protocol.message;

import io.nuls.kernel.exception.NulsException;
import io.nuls.kernel.model.BlockHeader;
import io.nuls.kernel.utils.NulsByteBuffer;
import io.nuls.protocol.constant.ProtocolConstant;

/**
 * 区块头在网络消息中的承载类
 * The host class of the block header in the network message.
 *
 * @author Niels
 */
public class BlockHeaderMessage extends BaseProtocolMessage<BlockHeader> {
    public BlockHeaderMessage() {
        super(ProtocolConstant.PROTOCOL_BLOCK_HEADER);
    }

    @Override
    protected BlockHeader parseMessageBody(NulsByteBuffer byteBuffer) throws NulsException {
        return byteBuffer.readNulsData(new BlockHeader());
    }
}
