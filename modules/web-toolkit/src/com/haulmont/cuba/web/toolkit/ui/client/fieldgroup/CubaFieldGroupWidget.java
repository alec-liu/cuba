/*
 * Copyright (c) 2008-2016 Haulmont.
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
 *
 */

package com.haulmont.cuba.web.toolkit.ui.client.fieldgroup;

import com.haulmont.cuba.web.toolkit.ui.client.groupbox.CubaGroupBoxWidget;

public class CubaFieldGroupWidget extends CubaGroupBoxWidget {

    protected static final String CLASSNAME = "c-fieldgroup";

    public CubaFieldGroupWidget() {
        super(CLASSNAME);
    }

    public void setBorderVisible(boolean borderVisible) {
        if (borderVisible) {
            addStyleDependentName("border");
        } else {
            removeStyleDependentName("border");
        }
    }
}