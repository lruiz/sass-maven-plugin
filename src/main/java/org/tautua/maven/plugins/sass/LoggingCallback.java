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

import org.apache.maven.plugin.logging.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Larry Ruiz. Apr 12, 2015
 */
public class LoggingCallback implements SassCallback {
    private Log log;

    public LoggingCallback(Log log) {
        this.log = log;
    }

    @Override
    public void modified(String sassfile) {
        log.debug(sassfile + " modified");
    }

    @Override
    public void created(String sassfile) {
        log.debug(sassfile + " created");
    }

    @Override
    public void deleted(String sassfile) {
        log.debug(sassfile + " deleted");
    }

    @Override
    public void compiled(String sassfile, String cssfile){
        log.info("compiled " + sassfile);
    }

    @Override
    public void error(SyntaxException e){
        log.error("compilation error, " + e.getMessage());
    }
}
