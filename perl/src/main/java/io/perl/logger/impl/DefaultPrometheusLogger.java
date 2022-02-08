/**
 * Copyright (c) KMG. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */


package io.perl.logger.impl;

import io.time.Time;
import io.time.TimeUnit;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class DefaultPrometheusLogger extends DefaultLogger {
    private final PrometheusMetricsServer server;

    public DefaultPrometheusLogger(String header, double[] percentiles, Time time,
                                   @NotNull TimeUnit latencyTimeUnit, int port, String context) throws IOException {
        super(percentiles, latencyTimeUnit);
        server = new PrometheusMetricsServer(header, percentiles, time, latencyTimeUnit, port, context);
    }

    public void start() throws IOException {
        server.start();
    }

    public void stop() throws IOException {
        server.stop();
    }

    @Override
    public void print(double seconds, long bytes, long records, double recsPerSec, double mbPerSec,
                      double avgLatency, long maxLatency, long invalid, long lowerDiscard, long higherDiscard,
                      long slc1, long slc2, long[] percentiles) {
        super.print(seconds, bytes, records, recsPerSec, mbPerSec, avgLatency, maxLatency,
                invalid, lowerDiscard, higherDiscard, slc1, slc2, percentiles);
        server.print(seconds, bytes, records, recsPerSec, mbPerSec, avgLatency, maxLatency,
                invalid, lowerDiscard, higherDiscard, slc1, slc2, percentiles);
    }

}
