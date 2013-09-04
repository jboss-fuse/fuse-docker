/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.fuse.docker.codec;

import com.google.gson.stream.JsonReader;
import feign.codec.Decoder;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

public abstract class UpdateableDecoder<X> implements Decoder.TextStream<X> {

    protected abstract X build(JsonReader reader) throws IOException;

    @Override
    public X decode(Reader ireader, Type type) throws IOException {
        X last = null;
        JsonReader reader = new JsonReader(ireader);
        reader.setLenient(true);
        try {
            while (reader.hasNext()) {
                reader.beginObject();
                last = build(reader);
                reader.endObject();
            }
        } catch (IllegalStateException ex) {
            //No other object can be read. Return the last response.
        } finally {
            reader.close();
        }
        return last;
    }
}
