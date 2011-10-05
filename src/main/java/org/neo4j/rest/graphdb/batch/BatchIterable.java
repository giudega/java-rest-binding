/**
 * Copyright (c) 2002-2011 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.rest.graphdb.batch;

import java.util.Iterator;

import org.neo4j.rest.graphdb.RequestResult;
import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.UpdatableRestResult;

/**
 * @author mh
 * @since 21.09.11
 */
public class BatchIterable<T> implements Iterable<T>, UpdatableRestResult<Iterable<T>> {
    private final long batchId;
    private RestAPI restApi;
    private Iterable<T> data;

    public BatchIterable(RequestResult requestResult) {
        batchId = requestResult.getBatchId();
    }

    @Override
    public void updateFrom(Iterable<T> newValue, RestAPI restApi) {
        this.data = newValue;
        this.restApi = restApi;
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }
}