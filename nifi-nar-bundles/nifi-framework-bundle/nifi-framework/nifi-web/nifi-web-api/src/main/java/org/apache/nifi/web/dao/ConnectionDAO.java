/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.web.dao;

import org.apache.nifi.connectable.Connection;
import org.apache.nifi.controller.queue.DropFlowFileStatus;
import org.apache.nifi.controller.queue.ListFlowFileStatus;
import org.apache.nifi.controller.repository.FlowFileRecord;
import org.apache.nifi.web.DownloadableContent;
import org.apache.nifi.web.api.dto.ConnectionDTO;

import java.util.Set;

public interface ConnectionDAO {

    /**
     * Gets the specified Connection.
     *
     * @param groupId group id
     * @param id The connection id
     * @return The connection
     */
    Connection getConnection(String groupId, String id);

    /**
     * Gets the specified flow file drop request.
     *
     * @param groupId group id
     * @param id The id of the connection
     * @param dropRequestId The drop request id
     * @return The drop request status
     */
    DropFlowFileStatus getFlowFileDropRequest(String groupId, String id, String dropRequestId);

    /**
     * Gets the specified flowfile listing request.
     *
     * @param groupId group id
     * @param id connection id
     * @param listingRequestId The listing request id
     * @return The listing request status
     */
    ListFlowFileStatus getFlowFileListingRequest(String groupId, String id, String listingRequestId);

    /**
     * Gets the specified flowfile in the specified connection.
     *
     * @param groupId group id
     * @param id connection id
     * @param flowFileUuid the flowfile uuid
     * @return The flowfile
     */
    FlowFileRecord getFlowFile(String groupId, String id, String flowFileUuid);

    /**
     * Gets the connections for the specified source processor.
     *
     * @param groupId group id
     * @param processorId processor id
     * @return connections
     */
    Set<Connection> getConnectionsForSource(String groupId, String processorId);

    /**
     * Determines if the specified connection exists.
     *
     * @param groupId group id
     * @param id id
     * @return true if connection exists
     */
    boolean hasConnection(String groupId, String id);

    /**
     * Gets all of the connections.
     *
     * @param groupId group identifier
     * @return The connections
     */
    Set<Connection> getConnections(String groupId);

    /**
     * Creates a new Connection.
     *
     * @param groupId group id
     * @param connectionDTO The connection DTO
     * @return The connection
     */
    Connection createConnection(String groupId, ConnectionDTO connectionDTO);

    /**
     * Creates a new flow file drop request.
     *
     * @param groupId group id
     * @param id connection id
     * @param dropRequestId drop request id
     * @return The drop request status
     */
    DropFlowFileStatus createFlowFileDropRequest(String groupId, String id, String dropRequestId);

    /**
     * Creates a new flow file listing request.
     *
     * @param groupId group id
     * @param id connection id
     * @param listingRequestId listing request id
     * @return The listing request status
     */
    ListFlowFileStatus createFlowFileListingRequest(String groupId, String id, String listingRequestId);

    /**
     * Verifies the listing can be processed.
     *
     * @param groupId group id
     * @param id connection id
     */
    void verifyList(String groupId, String id);

    /**
     * Verifies the create request can be processed.
     *
     * @param groupId group id
     * @param connectionDTO connection
     */
    void verifyCreate(String groupId, ConnectionDTO connectionDTO);

    /**
     * Verifies the update request can be processed.
     *
     * @param groupId group id
     * @param connectionDTO connection
     */
    void verifyUpdate(String groupId, ConnectionDTO connectionDTO);

    /**
     * Updates the specified Connection.
     *
     * @param groupId group id
     * @param connectionDTO The connection DTO
     * @return The connection
     */
    Connection updateConnection(String groupId, ConnectionDTO connectionDTO);

    /**
     * Verifies the delete request can be processed.
     *
     * @param groupId group id
     * @param id id
     */
    void verifyDelete(String groupId, String id);

    /**
     * Deletes the specified Connection.
     *
     * @param groupId group id
     * @param id The id of the connection
     */
    void deleteConnection(String groupId, String id);

    /**
     * Deletes the specified flow file drop request.
     *
     * @param groupId group id
     * @param id The id of the connection
     * @param dropRequestId The drop request id
     * @return The drop request
     */
    DropFlowFileStatus deleteFlowFileDropRequest(String groupId, String id, String dropRequestId);

    /**
     * Deletes the specified flow file listing request.
     *
     * @param groupId group id
     * @param id connection id
     * @param listingRequestId The listing request id
     * @return The listing request status
     */
    ListFlowFileStatus deleteFlowFileListingRequest(String groupId, String id, String listingRequestId);

    /**
     * Gets the content for the specified flowfile in the specified connection.
     *
     * @param groupId group id
     * @param id connection id
     * @param flowfileUuid flowfile uuid
     * @param requestUri request uri
     * @return The downloadable content
     */
    DownloadableContent getContent(String groupId, String id, String flowfileUuid, String requestUri);
}
