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

package org.jboss.fuse.docker.image;

public class Progress {

    public static class Builder {

        private String id;
        private String status;
        private String progress;
        private String error;

        public Builder id(final String id) {
            this.id = id;
            return this;
        }

        public Builder error(final String error) {
            this.error = error;
            return this;
        }

        public Builder status(final String status) {
            this.status = status;
            return this;
        }

        public Builder progress(final String progress) {
            this.progress = progress;
            return this;
        }

        public Progress build() {
            return new Progress(id, status, progress, error);
        }
    }

    private final String id;
    private final String status;
    private final String progress;
    private final String error;


    public Progress(String id, String status, String progress, String error) {
        this.id = id;
        this.status = status;
        this.progress = progress;
        this.error = error;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getProgress() {
        return progress;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", progress='" + progress + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
