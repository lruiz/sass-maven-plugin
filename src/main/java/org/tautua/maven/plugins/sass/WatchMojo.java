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

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

import javax.script.ScriptException;
import java.util.concurrent.CountDownLatch;

/**
 * Watches the template directory and updates the CSS files whenever the related Sass/SCSS files change
 * @author Larry Ruiz. Apr 11, 2015
 */
@Mojo(name = "watch", defaultPhase = LifecyclePhase.COMPILE)
public class WatchMojo extends SassMojo {
    public void execute() throws MojoExecutionException {
        try {
            run("/watch.rb");
        } catch (ScriptException e) {
            throw new MojoExecutionException("Ruby script failed to executed",e);
        }
    }
}
