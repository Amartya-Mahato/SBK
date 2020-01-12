/**
 * Copyright (c) 2020 KMG. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package io.perf.drivers.Kafka;
import io.perf.core.Parameters;
import io.perf.core.Writer;
import io.perf.core.TriConsumer;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Class for Kafka writer/producer.
 */
public class KafkaWriter extends Writer {
    final private KafkaProducer<byte[], byte[]> producer;
    final private String topicName;

    public KafkaWriter(int writerID, TriConsumer recordTime, Parameters params,
                             String topicName, Properties producerProps) throws IOException {
        super(writerID, recordTime, params);
        this.topicName = topicName;
        this.producer = new KafkaProducer<>(producerProps);
    }

    @Override
    public long recordWrite(byte[] data, TriConsumer record) {
        final long time = System.currentTimeMillis();
        producer.send(new ProducerRecord<>(topicName, data), (metadata, exception) -> {
            final long endTime = System.currentTimeMillis();
            record.accept(time, endTime, data.length);
        });
        return time;
    }

    private CompletableFuture writeAsyncFuture(byte[] data) {
        CompletableFuture<Void> retFuture = new CompletableFuture();
        producer.send(new ProducerRecord<>(topicName, data), (metadata, exception) -> {
                if (exception == null) {
                    retFuture.complete(null);
                } else {
                    retFuture.completeExceptionally(exception);
                }
        });
        return retFuture;
    }


    @Override
    public CompletableFuture writeAsync(byte[] data) {
        producer.send(new ProducerRecord<>(topicName, data));
        return null;
    }

    @Override
    public void flush() {
        producer.flush();
    }

    @Override
    public synchronized void close() {
        producer.close();
    }
}