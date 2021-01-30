/**
 * Copyright (c) KMG. All Rights Reserved..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */

package io.sbk.api.impl;
import io.sbk.api.Config;
import io.sbk.api.Time;
import io.sbk.api.TimeUnit;


public class MicroSeconds implements Time {

    /**
     * get the Time Unit.
     * @return time Unit in Microseconds.;
     */
    public TimeUnit getTimeUnit() {
        return TimeUnit.mcs;
    }


    /**
     * get the current Time in Micro seconds.
     * @return current Time
     */
    public long getCurrentTime() {
        return System.nanoTime() / Config.NS_PER_MICRO;
    }

    /**
     * get the current Time.
     * @param h time stamp in Micro seconds
     * @param l time stamp in Micro seconds, the l should be less than h
     * @return elapsed time in milliseconds
     */
    public double elapsedMilliSeconds(long h, long l) {
        return (h-l) / (Config.MICROS_PER_MS * 1.0);
    }

    /**
     * get the current Time.
     * @param h time stamp in Micro seconds.
     * @param l time stamp in Micro seconds, the l should be less than h
     * @return elapsed time in seconds
     */
    public double elapsedSeconds(long h, long l) {
        return (h-l) / (Config.MICROS_PER_SEC  * 1.0);
    }

}
