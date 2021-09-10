/**
 * Copyright (c) KMG. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package io.sbk.perl;


public interface ReportLatencies {

    /**
     * Report a latency Record.
     *
     * @param record Latency Record
     */
    void reportLatencyRecord(LatencyRecord record);


    /**
     * Report one latency .
     *
     * @param latency Latency value
     * @param count   Number of times the latency value is observed
     */
    void reportLatency(long latency, long count);
}
