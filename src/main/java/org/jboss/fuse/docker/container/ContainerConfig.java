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

public class ContainerConfig {

    public static class Builder {
        private String hostname;
        private String user;
        private long memory;
        private long memorySwap;
        private boolean attachStdin;
        private boolean attachStdout;
        private boolean attachStderr;
        private String portSpecs;
        private boolean priviledged;
        private String tty;
        private boolean openStdin;
        private boolean stdinOnce;
        private String evn;
        private String[] cmd;
        private String dns;
        private String image;
        private Map<String, String> volumes;
        private String volumesFrom;
        private String workingDir;

        public Builder hostname(final String hostname) {
            this.hostname = hostname;
            return this;
        }

        public Builder user(final String user) {
            this.user = user;
            return this;
        }

        public Builder memory(final long memory) {
            this.memory = memory;
            return this;
        }

        public Builder memorySwap(final long memorySwap) {
            this.memorySwap = memorySwap;
            return this;
        }

        public Builder attachStdin() {
            this.attachStdin = true;
            return this;
        }

        public Builder attachStdin(final boolean attachStdin) {
            this.attachStdin = attachStdin;
            return this;
        }

        public Builder attachStdout() {
            this.attachStdout = true;
            return this;
        }

        public Builder attachStdout(final boolean attachStdout) {
            this.attachStdout = attachStdout;
            return this;
        }

        public Builder attachStderr() {
            this.attachStderr = true;
            return this;
        }

        public Builder attachStderr(final boolean attachStderr) {
            this.attachStderr = attachStderr;
            return this;
        }

        public Builder portSpecs(final String portSpecs) {
            this.portSpecs = portSpecs;
            return this;
        }

        public Builder priviledged() {
            this.priviledged = true;
            return this;
        }

        public Builder priviledged(final boolean priviledged) {
            this.priviledged = priviledged;
            return this;
        }

        public Builder tty(final String tty) {
            this.tty = tty;
            return this;
        }

        public Builder openStdin() {
            this.openStdin = true;
            return this;
        }

        public Builder openStdin(final boolean openStdin) {
            this.openStdin = openStdin;
            return this;
        }

        public Builder stdinOnce() {
            this.stdinOnce = true;
            return this;
        }

        public Builder stdinOnce(final boolean stdinOnce) {
            this.stdinOnce = stdinOnce;
            return this;
        }

        public Builder evn(final String evn) {
            this.evn = evn;
            return this;
        }

        public Builder cmd(final String[] cmd) {
            this.cmd = cmd;
            return this;
        }

        public Builder dns(final String dns) {
            this.dns = dns;
            return this;
        }

        public Builder image(final String image) {
            this.image = image;
            return this;
        }

        public Builder volumes(final Map<String, String> volumes) {
            this.volumes = volumes;
            return this;
        }

        public Builder volumesFrom(final String volumesFrom) {
            this.volumesFrom = volumesFrom;
            return this;
        }

        public Builder workingDir(final String workingDir) {
            this.workingDir = workingDir;
            return this;
        }

        public ContainerConfig build() {
            return new ContainerConfig(hostname, user, memory, memorySwap, attachStdin, attachStdout,attachStderr,portSpecs,priviledged,tty,openStdin,stdinOnce,evn,cmd,dns,image,volumes,volumesFrom, workingDir);
        }

    }

    @SerializedName("Hosntame")
    private final String hostname;
    @SerializedName("User")
    private final String user;
    @SerializedName("Memory")
    private final long memory;
    @SerializedName("MemorySwap")
    private final long memorySwap;
    @SerializedName("AttachStdin")
    private final boolean attachStdin;
    @SerializedName("AttachStdout")
    private final boolean attachStdout;
    @SerializedName("AttachStderr")
    private final boolean attachStderr;
    @SerializedName("PortSpecs")
    private final String portSpecs;
    @SerializedName("Priviledged")
    private final boolean priviledged;
    @SerializedName("Ttty")
    private final String tty;
    @SerializedName("OpenStdin")
    private final boolean openStdin;
    @SerializedName("StdinOnce")
    private final boolean stdinOnce;
    @SerializedName("Env")
    private final String evn;
    @SerializedName("Cmd")
    private final String[] cmd;
    @SerializedName("Dns")
    private final String dns;
    @SerializedName("Image")
    private final String image;
    @SerializedName("Volumes")
    private final Map<String, String> volumes;
    @SerializedName("VolumesFrom")
    private final String volumesFrom;
    @SerializedName("WorkingDir")
    private final String workingDir;

    public static Builder builder() {
        return new Builder();
    }

    public ContainerConfig(String hostname, String user, long memory, long memorySwap, boolean attachStdin, boolean attachStdout, boolean attachStderr, String portSpecs, boolean priviledged, String tty, boolean openStdin, boolean stdinOnce, String evn, String[] cmd, String dns, String image, Map<String, String> volumes, String volumesFrom, String workingDir) {
        this.hostname = hostname;
        this.user = user;
        this.memory = memory;
        this.memorySwap = memorySwap;
        this.attachStdin = attachStdin;
        this.attachStdout = attachStdout;
        this.attachStderr = attachStderr;
        this.portSpecs = portSpecs;
        this.priviledged = priviledged;
        this.tty = tty;
        this.openStdin = openStdin;
        this.stdinOnce = stdinOnce;
        this.evn = evn;
        this.cmd = cmd;
        this.dns = dns;
        this.image = image;
        this.volumes = volumes;
        this.volumesFrom = volumesFrom;
        this.workingDir = workingDir;
    }

    public String getHostname() {
        return hostname;
    }

    public String getUser() {
        return user;
    }

    public long getMemory() {
        return memory;
    }

    public long getMemorySwap() {
        return memorySwap;
    }

    public boolean isAttachStdin() {
        return attachStdin;
    }

    public boolean isAttachStdout() {
        return attachStdout;
    }

    public boolean isAttachStderr() {
        return attachStderr;
    }

    public String getPortSpecs() {
        return portSpecs;
    }

    public boolean isPriviledged() {
        return priviledged;
    }

    public String getTty() {
        return tty;
    }

    public boolean isOpenStdin() {
        return openStdin;
    }

    public boolean isStdinOnce() {
        return stdinOnce;
    }

    public String getEvn() {
        return evn;
    }

    public String[] getCmd() {
        return cmd;
    }

    public String getDns() {
        return dns;
    }

    public String getImage() {
        return image;
    }

    public Map<String, String> getVolumes() {
        return volumes;
    }

    public String getVolumesFrom() {
        return volumesFrom;
    }

    public String getWorkingDir() {
        return workingDir;
    }

    @Override
    public String toString() {
        return "ContainerConfig{" +
                "hostname='" + hostname + '\'' +
                ", user='" + user + '\'' +
                ", memory=" + memory +
                ", memorySwap=" + memorySwap +
                ", attachStdin=" + attachStdin +
                ", attachStdout=" + attachStdout +
                ", attachStderr=" + attachStderr +
                ", portSpecs='" + portSpecs + '\'' +
                ", priviledged=" + priviledged +
                ", tty='" + tty + '\'' +
                ", openStdin=" + openStdin +
                ", stdinOnce=" + stdinOnce +
                ", evn='" + evn + '\'' +
                ", cmd=" + Arrays.toString(cmd) +
                ", dns='" + dns + '\'' +
                ", image='" + image + '\'' +
                ", volumes=" + volumes +
                ", volumesFrom='" + volumesFrom + '\'' +
                ", workingDir='" + workingDir + '\'' +
                '}';
    }
}
