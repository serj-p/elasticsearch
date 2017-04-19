/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.index.similarity;

import org.apache.lucene.search.similarities.ClassicSimilarity;

import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;

/**
 * Provides {@link ClassicSimilarity} with constant IDF.
 */
public class TFSimilarityProvider extends AbstractSimilarityProvider {

    @SuppressWarnings("serial")
    public class TFSimilarity extends ClassicSimilarity {
        public TFSimilarity() {
        }

        @Override
        public float idf(long docFreq, long numDocs){
            return 1.0f;
        }
    }

    private final TFSimilarity similarity;

    @Inject
    public TFSimilarityProvider(String name, Settings settings, Settings indexSettings) {
        super(name);
        this.similarity = new TFSimilarity();
    }

    @Override
    public TFSimilarity get() {
        return similarity;
    }
}
