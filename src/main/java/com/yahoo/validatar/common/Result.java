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

package com.yahoo.validatar.common;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Result {
    public Map<String, List<String>> columnData = new HashMap<>();
    public Map<String, TypeSystem.Type> columnTypes = new HashMap<>();
    private String prefix = "";

    /**
     * Constructor that initializes a result with a prefix to add for each column name.
     * @param prefix The prefix to add.
     */
    public Result(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Add a new column to the result.
     * @param name The name of the column.
     * @param type The type of the column.
     */
    public void addColumn(String name, TypeSystem.Type type) {
        columnData.put(prefix + name, new ArrayList<String>());
        columnTypes.put(prefix + name, type);
    }

    /**
     * Add a new row to an existing column.
     * @param name The name of the column.
     * @param value The value to add to it.
     */
    public void addColumnRow(String name, String value) {
        columnData.get(prefix + name).add(value);
    }

    /**
     * Namespace the results, i.e. add a prefix to each column name
     *
     * @param prefix The prefix to add.
     */
    public void namespace(String prefix) {
        Map<String, List<String>> namespacedResults = new HashMap<String, List<String>>();
        for (Map.Entry<String, List<String>> column : columnData.entrySet()) {
            namespacedResults.put(prefix + column.getKey(), column.getValue());
        }
        columnData = namespacedResults;
    }
}
