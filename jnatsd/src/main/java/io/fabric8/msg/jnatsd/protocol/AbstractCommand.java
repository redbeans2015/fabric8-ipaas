/*
 *
 *  * Copyright 2005-2016 Red Hat, Inc.
 *  * Red Hat licenses this file to you under the Apache License, version
 *  * 2.0 (the "License"); you may not use this file except in compliance
 *  * with the License.  You may obtain a copy of the License at
 *  *    http://www.apache.org/licenses/LICENSE-2.0
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  * implied.  See the License for the specific language governing
 *  * permissions and limitations under the License.
 *
 */

package io.fabric8.msg.jnatsd.protocol;

import io.vertx.core.buffer.Buffer;

public abstract class AbstractCommand<T> implements Command<T> {
    protected static final Buffer CRLF = Buffer.buffer("\r\n");

    private int read;

    @Override
    public int bytesRead() {
        return read;
    }

    @Override
    public void bytesRead(int value) {
        read = value;
    }

    @Override
    public Buffer getBuffer() {
        String str = toString();
        Buffer buffer = Buffer.buffer(str.length());
        buffer.appendString(str);
        buffer.appendBuffer(CRLF);
        return buffer;
    }

}
