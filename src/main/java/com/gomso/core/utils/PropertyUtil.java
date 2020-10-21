package com.gomso.core.utils;

/*
 * Copyright (c) 2016 OpenDesign All rights reserved.
 *
 * This software is the confidential and proprietary information of OpenDesign.
 * You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into
 * with OpenDesign.
 */
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import lombok.extern.slf4j.Slf4j;

/**
 * system.properties
 *
 */
@Slf4j
public class PropertyUtil {


    private static Map<String, String> propertyMap;

    static {

        propertyMap = new HashMap<String, String>();

        ResourceBundle rb = ResourceBundle.getBundle("system");
        Enumeration<String> keys = rb.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = rb.getString(key);
            log.debug("System Property Loaded key=[" + key + "] value=[" + value + "]");
            propertyMap.put(key, value);
        }

    }

    public static String getProperty(String key) {
        return propertyMap.get(key);
    }

}
