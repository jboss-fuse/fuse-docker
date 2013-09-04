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

import feign.RequestLine;
import org.jboss.fuse.docker.container.Change;
import org.jboss.fuse.docker.container.ContainerConfig;
import org.jboss.fuse.docker.container.ContainerCreateStatus;
import org.jboss.fuse.docker.container.CopySource;
import org.jboss.fuse.docker.container.HostConfig;
import org.jboss.fuse.docker.container.ContainerInfo;
import org.jboss.fuse.docker.container.Status;
import org.jboss.fuse.docker.container.Top;
import org.jboss.fuse.docker.image.DeleteInfo;
import org.jboss.fuse.docker.image.ImageHistoryItem;
import org.jboss.fuse.docker.image.ImageInfo;
import org.jboss.fuse.docker.image.Progress;
import org.jboss.fuse.docker.image.ImageSearchResult;

import javax.inject.Named;
import java.util.List;

public interface Docker {

    String ID = "id";
    String NAME = "name";

    /**
     * Display system-wide information.
     * @return  Returns the {@link Info}.
     */
    @RequestLine("GET /info")
    Info info();

    /**
     * Show the docker version information
     * @return
     */
    @RequestLine("GET /version")
    Version version();

    /**
     * Get the list of {@link Container} instances.
     * @param all       1/True/true or 0/False/false, Show all containers. Only running containers are shown by default.
     * @param limit     Show limit last created containers, include non-running ones.
     * @param since     Show only containers created since Id, include non-running ones.
     * @param before    Show only containers created before Id, include non-running ones.
     * @param size      1/True/true or 0/False/false, Show the containers sizes.
     * @return
     */
    @RequestLine("GET /containers/json?all={all}&limit={limit}&since={since}&before={before}&size={size}")
    List<Container> containers(@Named("all")int all, @Named("limit")int limit, @Named("since")String since, @Named("before")String before, @Named("size")int size);


    @RequestLine("GET /containers/{id}/json")
    ContainerInfo containerInspect(@Named(ID) String id);

    /**
     * Create a {@link Container}.
     * @param config The container’s configuration
     * @return
     */
    @RequestLine("POST /containers/create")
    ContainerCreateStatus containerCreate(ContainerConfig config);

    @RequestLine("GET /containers/{id}/top")
    Top containerTop(@Named(ID) String id);

    @RequestLine("GET /containers/{id}/changes")
    List<Change> containerChanges(@Named(ID) String id);

    @RequestLine("GET /containers/{id}/changes")
    byte[] containerExport(@Named(ID) String id);

    @RequestLine("POST /containers/{id}/start")
    void containerStart(@Named(ID) String id, HostConfig hostHostConfig);

    @RequestLine("POST /containers/{id}/stop?t={t}")
    void containerStop(@Named(ID)String id, @Named("t")int timeToWait);

    @RequestLine("POST /containers/{id}/restart?t={t}")
    void containerRestart(@Named(ID)String id, @Named("t")int timeToWait);

    @RequestLine("POST /containers/{id}/kill")
    void containerRestart(@Named(ID)String id);

    /**
     * logs – 1/True/true or 0/False/false, return logs. Default false
     stream – 1/True/true or 0/False/false, return stream. Default false
     stdin – 1/True/true or 0/False/false, if stream=true, attach to stdin. Default false
     stdout – 1/True/true or 0/False/false, if logs=true, return stdout log, if stream=true, attach to stdout. Default false
     stderr – 1/True/true or 0/False/false, if logs=true, return stderr log, if stream=true, attach to stderr. Default false
     * @param id
     */
    @RequestLine("POST /containers/{id}/attach?logs={logs}&stream={stream}&stdin={stdin}&stdout={stdout}&stderr={stderr}")
    byte[] containerRestart(@Named(ID) String id, @Named("logs") int logs, @Named("stream") int stream, @Named("stdin") int stdin, @Named("stdout") int stdout, @Named("stderr") int stderr);


    @RequestLine("POST /containers/{id}/wat")
    Status containerWait(@Named(ID) String id);

    /**
     * Remove a container.
     * @param id    The container id.
     * @param v     1/True/true or 0/False/false, Remove the volumes associated to the container. Default false
     * @return
     */
    @RequestLine("DELETE /containers/{id}?v={v}")
    void containerRemove(@Named(ID) String id, @Named("v") int v);


    @RequestLine("POST /containers/{id}/copy")
    byte[] containerCopy(@Named(ID) String id, @Named("v") CopySource resource);

    /**
     * Get the list of {@link Image}s.
     * @param all       1/True/true or 0/False/false, Show all containers. Only running containers are shown by defaul
     * @return
     */
    @RequestLine("GET /images/json?all={all}")
    List<Image> images(@Named("all")int all);


    /**
     * Create an {@link Image}.
     * @param fromImage     The source image.
     * @param fromSrc       The source to import, - means stdin.
     * @param repo          The repository.
     * @param tag           The tag.
     * @param registry      The registry.
     */
    @RequestLine("POST /images/create?fromImage={fromImage}&fromSrc={fromSrc}&repo={repo}&tag={tag}&registry={registry}")
    Progress imageCreate(@Named("fromImage")String fromImage,@Named("formSrc")String fromSrc, @Named("repo") String repo, @Named("tag")String tag, @Named("registry") String registry);


    @RequestLine("POST /images/(name)/insert?path={path}&url={url}")
    Progress imageInsert(@Named(NAME) String name, @Named("path") String path, @Named("url") String url);

    /**
     * Return low-level information on the image name.
     * @param name    The image name.
     * @return        The {@link ImageInfo}.
     */
    @RequestLine("POST /images/{name}/json")
    ImageInfo imageInspect(@Named(NAME)String name);

    /**
     * Return the history of the image name.
     * @param name  The image name.
     * @return      Returns a list of {@link ImageHistoryItem} .
     */
    @RequestLine("GET /images/{name}/history")
    List<ImageHistoryItem> imageHistory(@Named(NAME)String name);

    /**
     * Return the history of the image name.
     * @param name  The image name.
     * @return      Return the {@link org.jboss.fuse.docker.image.Progress}
     */
    @RequestLine("POST /images/{name}/push?registry={registry}")
    Progress imagePush(@Named(NAME)String name, @Named("registry") String registry, Auth authConfig);

    /**
     * Tag an image into a repository
     * @param name  The image name.
     * @param repo  The repository to tag in.
     * @param force 1/True/true or 0/False/false, default false.
     * @return
     */
    @RequestLine("POST /images/{name}/tag?repo={repo}&force={force")
    void imageTag(@Named(NAME)String name, @Named("repo") String repo, @Named("force")int force);

    /**
     * Remove the image id from the filesystem
     * @param name  The image name.
     * @return      Return a list of {@link DeleteInfo}
     */
    @RequestLine("DELETE /images/{name}")
    List<DeleteInfo> imageDelete(@Named(NAME)String name);

    /**
     * Search for an image in the docker index.
     * @param term  The search term to use.
     * @return      Returns a list of {@link ImageSearchResult}.
     */
    @RequestLine("GET /images/search?test={term}")
    List<ImageSearchResult> imageSearch(@Named("term") String term);
}
