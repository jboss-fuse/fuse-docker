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

package org.jboss.fuse.docker.container;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Map;

public class ContainerInfo {

    @SerializedName("Id")
    private String id;
    @SerializedName("Created")
    private String created;
    @SerializedName("Path")
    private String path;
    @SerializedName("Args")
    private String[] args;
    @SerializedName("Config")
    private ContainerConfig conig;
    @SerializedName("State")
    private State state;
    @SerializedName("NetworkSettings")
    private NetworkSettings networkSettings;
    @SerializedName("SysInitPath")
    private String sysInitPath;
    @SerializedName("ReslovConfPath")
    private String resolvConfPath;
    @SerializedName("Volumes")
    private Map<String, String> volumes;

    public ContainerInfo(String id, String created, String path, String[] args, ContainerConfig conig, State state, NetworkSettings networkSettings, String sysInitPath, String resolvConfPath, Map<String, String> volumes) {
        this.id = id;
        this.created = created;
        this.path = path;
        this.args = args;
        this.conig = conig;
        this.state = state;
        this.networkSettings = networkSettings;
        this.sysInitPath = sysInitPath;
        this.resolvConfPath = resolvConfPath;
        this.volumes = volumes;
    }

    public String getId() {
        return id;
    }

    public String getCreated() {
        return created;
    }

    public String getPath() {
        return path;
    }

    public String[] getArgs() {
        return args;
    }

    public ContainerConfig getConig() {
        return conig;
    }

    public State getState() {
        return state;
    }

    public NetworkSettings getNetworkSettings() {
        return networkSettings;
    }

    public String getSysInitPath() {
        return sysInitPath;
    }

    public String getResolvConfPath() {
        return resolvConfPath;
    }

    public Map<String, String> getVolumes() {
        return volumes;
    }

    @Override
    public String toString() {
        return "ContainerInfo{" +
                "id='" + id + '\'' +
                ", created='" + created + '\'' +
                ", path='" + path + '\'' +
                ", args=" + Arrays.toString(args) +
                ", conig=" + conig +
                ", state=" + state +
                ", networkSettings=" + networkSettings +
                ", sysInitPath='" + sysInitPath + '\'' +
                ", resolvConfPath='" + resolvConfPath + '\'' +
                ", volumes=" + volumes +
                '}';
    }
}
