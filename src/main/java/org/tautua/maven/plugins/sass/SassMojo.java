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

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStreamReader;

/**
 * @author Larry Ruiz. Apr 11, 2015
 */
public abstract class SassMojo extends AbstractMojo {
    @Parameter
    private JRubyOptions jrubyOptions = new JRubyOptions();

    @Parameter
    private SassOptions sassOptions = new SassOptions();

    protected void run(String scriptpath) throws ScriptException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine jruby = engineManager.getEngineByName("jruby");
        SassCallback callback = new SassCallback(getLog());

        jruby.put("jrubyOptions", jrubyOptions);
        jruby.put("sassOptions", sassOptions);
        jruby.put("callback", callback);
        jruby.eval(new InputStreamReader(getClass().getResourceAsStream(scriptpath)));
    }
}
