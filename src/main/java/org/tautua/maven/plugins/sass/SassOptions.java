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

import java.io.File;

/**
 * @author Larry Ruiz. Apr 11, 2015
 */
public class SassOptions {
    private File input = new File("src/main/sass");
    private File output = new File("target/generated-sources/sass");
    private File cache = new File("target/sass_cache");
    private Style style = Style.EXPANDED;

    public File getInput() {
        return input;
    }

    public File getOutput() {
        return output;
    }

    public File getCache() {
        return cache;
    }

    public Style getStyle() {
        return style;
    }

    enum Style {
        COMPACT,
        COMPRESSED,
        EXPANDED,
        NESTED
    }
}
