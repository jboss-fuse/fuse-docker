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

public class Change {

    @SerializedName("Path")
    private final String path;
    @SerializedName("Kind")
    private final String kind;

    public Change(String path, String kind) {
        this.path = path;
        this.kind = kind;
    }

    public String getPath() {
        return path;
    }

    public String getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return "Change{" +
                "path='" + path + '\'' +
                ", kind='" + kind + '\'' +
                '}';
    }
}
