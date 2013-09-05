/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.fuse.docker;

import org.jboss.fuse.docker.codec.DockerDecoder;

import feign.Feign;

/**
 * A simple helper class for creating instances of Docker
 */
public class DockerFactory {
    private String address = "http://localhost:4243";

    public DockerFactory() {
    }

    public DockerFactory(String address) {
        this.address = address;
    }

    public Docker createDocker() {
        return Feign.create(Docker.class, getAddress(), new DockerDecoder());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
