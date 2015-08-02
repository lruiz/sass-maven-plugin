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

/**
 * @author Larry Ruiz. May 02, 2015
 */
public class Gem {
    private String name;
    private String version;

    public Gem(){}

    public Gem(String arg) {
        set(arg);
    }

    public Gem(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public void set(String arg) {
        String[] args = arg.split(":");
        name = args[0];
        if(args.length > 1) {
            version = args[1];
        }
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}
