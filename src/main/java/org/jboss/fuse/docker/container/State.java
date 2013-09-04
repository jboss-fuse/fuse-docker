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

public class State {

    @SerializedName("Running")
    private final boolean running;
    @SerializedName("Pid")
    private final int pid;
    @SerializedName("ExitCode")
    private final int exitCode;
    @SerializedName("StartedAt")
    private final String startedAt;
    @SerializedName("Ghost")
    private final boolean ghost;

    public State(boolean running, int pid, int exitCode, String startedAt, boolean ghost) {
        this.running = running;
        this.pid = pid;
        this.exitCode = exitCode;
        this.startedAt = startedAt;
        this.ghost = ghost;
    }

    public boolean isRunning() {
        return running;
    }

    public int getPid() {
        return pid;
    }

    public int getExitCode() {
        return exitCode;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public boolean isGhost() {
        return ghost;
    }

    @Override
    public String toString() {
        return "State{" +
                "running=" + running +
                ", pid=" + pid +
                ", exitCode=" + exitCode +
                ", startedAt='" + startedAt + '\'' +
                ", ghost=" + ghost +
                '}';
    }
}
