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
import dagger.Module;
import dagger.Provides;
import feign.FeignException;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.gson.GsonModule;
import org.jboss.fuse.docker.image.DeleteInfo;
import org.jboss.fuse.docker.image.Progress;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static dagger.Provides.Type.SET;

@Module(library = true, includes = GsonModule.class)
public class DockerDecoder {

    @Provides(type = SET)
    Decoder progressDecoder() {
        return new UpdateableDecoder<Progress>() {
            @Override
            protected Progress build(JsonReader reader) throws IOException {
                Progress.Builder builder = Progress.builder();
                while (reader.hasNext()) {
                    String key = reader.nextName();
                    if (key.equals("id")) {
                        builder.id(reader.nextString());
                    } else if (key.equals("status")) {
                        builder.status(reader.nextString());
                    } else if (key.equals("progress")) {
                        builder.progress(reader.nextString());
                    } else if (key.equals("error")) {
                        builder.error(reader.nextString());
                    } else {
                        reader.skipValue();
                    }
                }
                return builder.build();
            }
        };
    }

    @Provides(type = SET)
    Decoder deteleInfoDecoder() {
        return new Decoder.TextStream<List<DeleteInfo>>() {
            @Override
            public List<DeleteInfo> decode(Reader input, Type type) throws IOException, FeignException {
                List<DeleteInfo> list = new ArrayList<DeleteInfo>();

                JsonReader reader = new JsonReader(input);
                reader.beginArray();
                while (reader.hasNext()) {
                    reader.beginObject();
                    String key = reader.nextName();
                    if (key.equals(DeleteInfo.Status.Untagged.name())) {
                        list.add(new DeleteInfo(reader.nextString(), DeleteInfo.Status.Untagged));
                    } else if (key.equals(DeleteInfo.Status.Deleted.name())) {
                        list.add(new DeleteInfo(reader.nextString(), DeleteInfo.Status.Deleted));
                    } else {
                        reader.skipValue();
                    }
                    reader.endObject();
                }
                reader.endArray();
                reader.close();
                return list;
            }
        };
    }
}
