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

import java.util.Map;

public class NetworkSettings {

    @SerializedName("IpAddress")
    private final String ipAddress;
    @SerializedName("IpPrefixLen")
    private final int ipPrefixLen;
    @SerializedName("Gateway")
    private final String gateway;
    @SerializedName("Bridge")
    private final String bridge;
    @SerializedName("PortMapping")
    private final Map<String,Map<String, String>> portMapping;

    public NetworkSettings(String ipAddress, int ipPrefixLen, String gateway, String bridge, Map<String,Map<String, String>> portMapping) {
        this.ipAddress = ipAddress;
        this.ipPrefixLen = ipPrefixLen;
        this.gateway = gateway;
        this.bridge = bridge;
        this.portMapping = portMapping;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getIpPrefixLen() {
        return ipPrefixLen;
    }

    public String getGateway() {
        return gateway;
    }

    public String getBridge() {
        return bridge;
    }

    public Map<String,Map<String, String>> getPortMapping() {
        return portMapping;
    }

    @Override
    public String toString() {
        return "NetworkSettings{" +
                "ipAddress='" + ipAddress + '\'' +
                ", ipPrefixLen=" + ipPrefixLen +
                ", gateway='" + gateway + '\'' +
                ", bridge='" + bridge + '\'' +
                ", portMapping='" + portMapping + '\'' +
                '}';
    }
}
