/**
 * Copyright (c) KMG. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package io.sbk.SbkTemplate;

import io.sbk.api.ParameterOptions;
import io.sbk.api.Writer;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;


/**
 * Class for Writer.
 */
public class SbkTemplateWriter implements Writer<byte[]> {

    public SbkTemplateWriter(int writerID, ParameterOptions params) {
    }

    @Override
    public CompletableFuture writeAsync(byte[] data) throws IOException {
        throw new IOException("Its Template Writer Driver");
    }


    @Override
    public void sync() throws IOException {
        throw new IOException("Its Template Writer Driver");
    }

    @Override
    public void close() throws IOException {
        throw new IOException("Its Template Writer Driver");
    }
}