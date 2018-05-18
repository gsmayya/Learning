package com.gsmayya.services;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@EnableConfigurationProperties(ServiceProperties.class)
public class RuntimeKVService {

    private final ServiceProperties serviceProperties;

    public RuntimeKVService(ServiceProperties serviceProperties) {
        this.serviceProperties = serviceProperties;
    }

    public String message() {
        return this.serviceProperties.getMessage();
    }

    public String storeKV(String key, String value) {
        this.serviceProperties.addAnEntry(key, value);
        return "Stored " + key + " into " + value;
    }

    public String getValue(String key) {
        Map<String, String> stringStringMap = this.serviceProperties.getMapOfNames();
        return (stringStringMap.containsKey(key)) ? stringStringMap.get(key) : "No value stored";
    }
}