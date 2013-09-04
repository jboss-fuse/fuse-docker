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

public class Container {

    @SerializedName("Id")
    private final String id;
    @SerializedName("Image")
    private final String image;
    @SerializedName("Command")
    private final String command;
    @SerializedName("Created")
    private final long created;
    @SerializedName("Status")
    private final String status;
    @SerializedName("Ports")
    private final String ports;
    @SerializedName("SizeRw")
    private final long sizeRw;
    @SerializedName("SizeRootFs")
    private final long sizeRootFs;

    public Container(String id, String image, String command, long created, String status, String ports, long sizeRw, long sizeRootFs) {
        this.id = id;
        this.image = image;
        this.command = command;
        this.created = created;
        this.status = status;
        this.ports = ports;
        this.sizeRw = sizeRw;
        this.sizeRootFs = sizeRootFs;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getCommand() {
        return command;
    }

    public long getCreated() {
        return created;
    }

    public String getStatus() {
        return status;
    }

    public String getPorts() {
        return ports;
    }

    public long getSizeRw() {
        return sizeRw;
    }

    public long getSizeRootFs() {
        return sizeRootFs;
    }

    @Override
    public String toString() {
        return "Container{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", command='" + command + '\'' +
                ", created=" + created +
                ", status='" + status + '\'' +
                ", ports='" + ports + '\'' +
                ", sizeRw=" + sizeRw +
                ", sizeRootFs=" + sizeRootFs +
                '}';
    }
}
