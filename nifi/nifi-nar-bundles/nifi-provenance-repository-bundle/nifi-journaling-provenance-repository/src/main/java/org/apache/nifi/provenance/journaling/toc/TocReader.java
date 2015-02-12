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
package org.apache.nifi.provenance.journaling.toc;

import java.io.Closeable;

/**
 * <p>
 * Reads a Table of Contents (.toc file) for a corresponding Journal File. We use a Table of Contents
 * to map a Block Index to an offset into the Journal file where that Block begins. We do this so that
 * we can then persist a Block Index for an event and then compress the Journal later. This way, we can
 * get good compression by compressing a large batch of events at once, and this way we can also look up
 * an event in a Journal that has not been compressed by looking in the Table of Contents or lookup the
 * event in a Journal post-compression by simply rewriting the TOC while we compress the data.
 * </p>
 */
public interface TocReader extends Closeable {

    /**
     * Indicates whether or not the corresponding Journal file is compressed
     * @return
     */
    boolean isCompressed();

    /**
     * Returns the byte offset into the Journal File for the Block with the given index.
     * @param blockIndex
     * @return
     */
    long getBlockOffset(int blockIndex);
    
}