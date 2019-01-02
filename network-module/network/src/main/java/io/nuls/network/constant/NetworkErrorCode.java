/*
 * *
 *  * MIT License
 *  *
 *  * Copyright (c) 2017-2019 nuls.io
 *  *
 *  * Permission is hereby granted, free of charge, to any person obtaining a copy
 *  * of this software and associated documentation files (the "Software"), to deal
 *  * in the Software without restriction, including without limitation the rights
 *  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  * copies of the Software, and to permit persons to whom the Software is
 *  * furnished to do so, subject to the following conditions:
 *  *
 *  * The above copyright notice and this permission notice shall be included in all
 *  * copies or substantial portions of the Software.
 *  *
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  * SOFTWARE.
 *
 */
package io.nuls.network.constant;


import io.nuls.kernel.constant.ErrorCode;
import io.nuls.kernel.constant.KernelErrorCode;

/**
 * Created by Niels on 2017/9/27.
 */
public interface NetworkErrorCode extends KernelErrorCode {

    ErrorCode NET_SERVER_START_ERROR = ErrorCode.init("40001");
    ErrorCode NET_MESSAGE_ERROR = ErrorCode.init("40002");
    ErrorCode NET_MESSAGE_XOR_ERROR = ErrorCode.init("40003");
    ErrorCode NET_MESSAGE_LENGTH_ERROR = ErrorCode.init("40004");
    ErrorCode NET_NODE_GROUP_ALREADY_EXISTS = ErrorCode.init("40006");
    ErrorCode NET_NODE_AREA_ALREADY_EXISTS = ErrorCode.init("40007");
    ErrorCode NET_NODE_GROUP_NOT_FOUND = ErrorCode.init("40008");
    ErrorCode NET_NODE_AREA_NOT_FOUND = ErrorCode.init("40009");
    ErrorCode NET_NODE_NOT_FOUND = ErrorCode.init("40010");
    ErrorCode NET_BROADCAST_FAIL = ErrorCode.init("40011");
    ErrorCode NET_BROADCAST_NODE_EMPTY = ErrorCode.init("40012");
    ErrorCode NET_NODE_DEAD = ErrorCode.init("40013");
    ErrorCode NET_NODE_MISS_CHANNEL = ErrorCode.init("40014");
}