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

public class HostConfig {

    @SerializedName("Binds")
    private final String[] binds;
    @SerializedName("LxcConf")
    private final Map<String, String> lxcConf;


    public HostConfig(String[] binds, Map<String, String> lxcConf) {
        this.binds = binds;
        this.lxcConf = lxcConf;
    }

    public String[] getBinds() {
        return binds;
    }

    public Map<String, String> getLxcConf() {
        return lxcConf;
    }

    @Override
    public String toString() {
        return "HostConfig{" +
                "binds=" + Arrays.toString(binds) +
                ", lxcConf=" + lxcConf +
                '}';
    }
}
