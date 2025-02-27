/**
 * Copyright (c) KMG. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package io.sbk.ram;

import io.perl.api.TotalPeriodicWindow;
import io.sbk.grpc.LatenciesRecord;

/**
 * Interface for recording latencies.
 */
public interface RamPeriodicRecorder extends TotalPeriodicWindow {

    /**
     * Record the Event/record.
     *
     * @param currentTime Current Time
     * @param record      Latencies Record
     */
    void record(long currentTime, LatenciesRecord record);

}
