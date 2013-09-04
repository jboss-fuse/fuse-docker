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

import feign.Feign;
import org.jboss.fuse.docker.codec.DockerDecoder;
import org.jboss.fuse.docker.container.Change;
import org.jboss.fuse.docker.container.ContainerConfig;
import org.jboss.fuse.docker.container.ContainerCreateStatus;
import org.jboss.fuse.docker.container.HostConfig;

import java.util.List;

public class Example {

    private Example() {
    }

    public static void main(String... args) throws InterruptedException {
        Docker docker = Feign.create(Docker.class, args[0], new DockerDecoder());
        displayVersion(docker);
        displayInfo(docker);
        displayContainers(docker);
        displayImages(docker);

        String newContainer = createContainer(docker);
        containerStart(docker, newContainer);
        inspectContainer(docker, newContainer);
        containerTop(docker, newContainer);
        containerChanges(docker, newContainer);
        containerStop(docker, newContainer);
        deleteContainer(docker, newContainer);
        displayContainers(docker);
    }

    static void displayInfo(Docker docker) {
        Info info = docker.info();
        System.out.println(info);
    }

    static void displayVersion(Docker docker) {
        Version version = docker.version();
        System.out.println(version);
    }

    static void displayContainers(Docker docker) {
        List<Container> containers = docker.containers(1, 10, null, null, 1);
        for (Container contaier : containers) {
            System.out.println(contaier);
        }
    }

    static void displayImages(Docker docker) {
        List<Image> images = docker.images(1);
        for (Image image : images) {
            System.out.println(image);
        }
    }

    static String createContainer(Docker docker) {
        ContainerCreateStatus status = docker.containerCreate(ContainerConfig.builder()
                .image("ubuntu")
                .cmd(new String[]{"date"})
                .build()
        );
        System.out.println(status);
        return status.getId();
    }

    static void inspectContainer(Docker docker, String id) {
        System.out.println(docker.containerInspect(id));
    }

    static void containerStart(Docker docker, String id) {
        docker.containerStart(id, new HostConfig(null, null));
    }

    static void containerStop(Docker docker, String id) {
        docker.containerStop(id, 100000);
    }

    static void containerTop(Docker docker, String id) {
        System.out.println(docker.containerTop(id));
    }

    static void containerChanges(Docker docker, String id) {
        List<Change> changes = docker.containerChanges(id);
        for (Change chane : changes) {
            System.out.println(docker.containerChanges(id));
        }
    }

    static void deleteContainer(Docker docker, String id) {
        docker.containerRemove(id, 1);
    }
}
