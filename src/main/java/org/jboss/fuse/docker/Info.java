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

public class Info {

    @SerializedName("Containers")
    private final int containers;
    @SerializedName("Images")
    private final int images;
    @SerializedName("Debug")
    private final boolean debug;
    @SerializedName("NFd")
    private final int nfd;
    @SerializedName("NGoroutines")
    private final int ngoRoutines;
    @SerializedName("MemoryLimit")
    private final boolean memoryLimit;
    @SerializedName("SwapLimit")
    private final boolean swapLimit;
    @SerializedName("IPv4Forwarding")
    private final boolean ipV4Forwarding;

    public Info(int containers, int images, boolean debug, int nfd, int ngoRoutines, boolean memoryLimit, boolean swapLimit, boolean ipV4Forwarding) {
        this.containers = containers;
        this.images = images;
        this.debug = debug;
        this.nfd = nfd;
        this.ngoRoutines = ngoRoutines;
        this.memoryLimit = memoryLimit;
        this.swapLimit = swapLimit;
        this.ipV4Forwarding = ipV4Forwarding;
    }

    public int getContainers() {
        return containers;
    }

    public int getImages() {
        return images;
    }

    public boolean isDebug() {
        return debug;
    }

    public int getNfd() {
        return nfd;
    }

    public int getNgoRoutines() {
        return ngoRoutines;
    }

    public boolean isMemoryLimit() {
        return memoryLimit;
    }

    public boolean isSwapLimit() {
        return swapLimit;
    }

    public boolean isIpV4Forwarding() {
        return ipV4Forwarding;
    }

    @Override
    public String toString() {
        return "Info{" +
                "containers=" + containers +
                ", images=" + images +
                ", debug=" + debug +
                ", nfd=" + nfd +
                ", ngoRoutines=" + ngoRoutines +
                ", memoryLimit=" + memoryLimit +
                ", swapLimit=" + swapLimit +
                ", ipV4Forwarding=" + ipV4Forwarding +
                '}';
    }
}
