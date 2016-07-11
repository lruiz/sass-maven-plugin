/*
 * Copyright 2015, TAUTUA
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

package org.tautua.maven.plugins.sass;

import org.apache.maven.plugin.testing.MojoRule;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Larry Ruiz. Apr 11, 2015
 */
public class SassMojoTest {
    @Rule
    public MojoRule rule = new MojoRule() {
        @Override
        protected void before() throws Throwable {
        }

        @Override
        protected void after() {
        }
    };


    @Test
    public void compile() throws Exception {
        File pom = new File("src/test/resources/_pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        SassMojo sassMojo = (SassMojo) rule.lookupMojo("compile", pom);
        assertNotNull(sassMojo);
        sassMojo.execute();
    }

    /*
    @Test
    public void watch() throws Exception {
        File pom = new File("src/test/resources/_pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        SassMojo sassMojo = (SassMojo) rule.lookupMojo("watch", pom);
        assertNotNull(sassMojo);
        sassMojo.execute();
    }
    */
}
