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

public class Top {

    @SerializedName("Titles")
    private final String[] titles;
    @SerializedName("Processes")
    private final String[][] processes;


    public Top(String[] titles, String[][] processes) {
        this.titles = titles;
        this.processes = processes;
    }


    public String[] getTitles() {
        return titles;
    }

    public String[][] getProcesses() {
        return processes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return "Top{" +
                "titles=" + Arrays.toString(titles) +
                ", processes=" + Arrays.toString(processes) +
                '}';
    }
}
