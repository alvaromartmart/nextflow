/*
 * Copyright 2020-2022, Seqera Labs
 * Copyright 2013-2019, Centre for Genomic Regulation (CRG)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nextflow.executor.res

import spock.lang.Specification

/**
 *
 * @author Ben Sherman <bentshermann@gmail.com>
 */
class CpuResourceTest extends Specification {

    def 'should create a cpu resource' () {

        when:
        def cpu = new CpuResource(VALUE)
        then:
        cpu.request == REQ
        cpu.limit == LIM

        where:
        VALUE                   | REQ   | LIM
        1                       | 1     | 1
        [request: 2]            | 2     | null
        [limit: 4]              | 4     | 4
        [request: 2, limit: 4]  | 2     | 4
    }
}
