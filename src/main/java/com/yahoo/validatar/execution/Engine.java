/*
 * Copyright 2014-2015 Yahoo! Inc.
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

package com.yahoo.validatar.execution;

import com.yahoo.validatar.common.Query;

public interface Engine {
    /**
     * Setups the engine using the input parameters.
     *
     * @param arguments An array of parameters of the form [--param1 value1 --param2 value2...]
     * @return true iff setup was succesful.
     */
    public boolean setup(String[] arguments);

    /**
     * Prints the help for using this engine.
     */
    public void printHelp();

    /**
     * Executes the given query on this Engine and places the result into it.
     *
     * @param query The query object representing the query.
     */
    public void execute(Query query);

    /**
     * Returns the name of the engine. Ex: 'Hive', 'Pig', etc.
     *
     * @return Name of the engine.
     */
    public String getName();
}