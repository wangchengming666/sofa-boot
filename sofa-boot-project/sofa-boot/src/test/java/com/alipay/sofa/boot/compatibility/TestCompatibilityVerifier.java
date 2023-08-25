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
package com.alipay.sofa.boot.compatibility;

import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

/**
 * @author huzijie
 * @version TestCompatibilityVerifier.java, v 0.1 2023年08月07日 12:19 PM huzijie Exp $
 */
public class TestCompatibilityVerifier implements CompatibilityVerifier {

    public static boolean     invoked = false;

    private final Environment environment;

    public TestCompatibilityVerifier(Environment environment) {
        this.environment = environment;
    }

    @Override
    public VerificationResult verify() {
        Assert.notNull(environment, "environment must not null");
        invoked = true;
        if (!environment.containsProperty("enable.test.compatibility")) {
            return VerificationResult.compatible();
        }
        return VerificationResult.notCompatible("test error", "test action");
    }
}