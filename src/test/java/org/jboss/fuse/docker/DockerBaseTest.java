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

package org.jboss.fuse.docker;

import com.google.mockwebserver.MockWebServer;
import feign.Feign;
import org.jboss.fuse.docker.Docker;
import org.jboss.fuse.docker.codec.DockerDecoder;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class DockerBaseTest {

    public Docker createDocker(String url) throws IOException {
        return Feign.create(Docker.class, url, new DockerDecoder());
    }


    public Docker createDockerForMock(MockWebServer server) throws IOException {
        String url = "http://localhost:" + server.getPort();
        return Feign.create(Docker.class, url, new DockerDecoder());
    }

}
