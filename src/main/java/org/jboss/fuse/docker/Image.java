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

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("Id")
    private final String id;
    @SerializedName("Repository")
    private final String repository;
    @SerializedName("Tag")
    private final String tag;
    @SerializedName("Created")
    private final long created;
    @SerializedName("Size")
    private final long size;
    @SerializedName("VirtualSize")
    private final long virtualSize;


    public Image(String id, String repository, String tag, long created, long size, long virtualSize) {
        this.id = id;
        this.repository = repository;
        this.tag = tag;
        this.created = created;
        this.size = size;
        this.virtualSize = virtualSize;
    }

    public String getId() {
        return id;
    }

    public String getRepository() {
        return repository;
    }

    public String getTag() {
        return tag;
    }

    public long getCreated() {
        return created;
    }

    public long getSize() {
        return size;
    }

    public long getVirtualSize() {
        return virtualSize;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id='" + id + '\'' +
                ", repository='" + repository + '\'' +
                ", tag='" + tag + '\'' +
                ", created=" + created +
                ", size=" + size +
                ", virtualSize=" + virtualSize +
                '}';
    }
}
