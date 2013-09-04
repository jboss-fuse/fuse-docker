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

package org.jboss.fuse.docker.image;

import com.google.gson.annotations.SerializedName;
import org.jboss.fuse.docker.container.ContainerConfig;

public class ImageInfo {

    private final String id;
    private final String parent;
    private final String created;
    private final String container;
    @SerializedName("container_config")
    private final ContainerConfig containerConfig;
    @SerializedName("Size")
    private final long size;

    public ImageInfo(String id, String parent, String created, String container, ContainerConfig containerConfig, long size) {
        this.id = id;
        this.parent = parent;
        this.created = created;
        this.container = container;
        this.containerConfig = containerConfig;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public String getParent() {
        return parent;
    }

    public String getCreated() {
        return created;
    }

    public String getContainer() {
        return container;
    }

    public ContainerConfig getContainerConfig() {
        return containerConfig;
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "id='" + id + '\'' +
                ", parent='" + parent + '\'' +
                ", created='" + created + '\'' +
                ", container='" + container + '\'' +
                ", containerConfig=" + containerConfig +
                ", size=" + size +
                '}';
    }
}