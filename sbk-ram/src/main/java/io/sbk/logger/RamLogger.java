/**
 * Copyright (c) KMG. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package io.sbk.logger;

import io.perl.api.ReportLatencies;

/**
 * Interface RamLogger.
 */
public interface RamLogger extends Logger, ReportLatencies, SetRW, CountConnections {
}
