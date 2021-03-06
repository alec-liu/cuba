/*
 * Copyright (c) 2008-2017 Haulmont.
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

package com.haulmont.cuba.core.sys.remoting.discovery;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link ServerSelector} interface working with static list of cluster members.
 */
public class StaticServerSelector extends StickySessionServerSelector {

    private Logger log = LoggerFactory.getLogger(StaticServerSelector.class);

    private String baseUrl;

    private List<String> urls = new ArrayList<>();

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public List<String> getUrls() {
        return urls;
    }

    public void init() {
        if (baseUrl == null)
            throw new IllegalStateException("baseUrl is null");
        String[] strings = baseUrl.split("[,;]");
        for (String string : strings) {
            if (!StringUtils.isBlank(string)) {
                urls.add(string + "/" + servletPath);
            }
        }
        log.info("Server URLs: {}", urls);
        initSelectorId();
    }

    protected void initSelectorId() {
        id = DigestUtils.md5Hex(baseUrl);
        log.trace("Selector id for '" + baseUrl + "' is '" + id + "'");
    }
}
