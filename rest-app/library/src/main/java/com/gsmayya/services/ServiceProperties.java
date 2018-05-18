package com.gsmayya.services;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties("service")
public class ServiceProperties {

    private Map<String, String> mapOfNames;
    private String message;

    public ServiceProperties() {
        mapOfNames = new HashMap<>();
    }

    public Map<String, String> getMapOfNames() {
        return mapOfNames;
    }

    public void addAnEntry(String key, String value) {
        mapOfNames.put(key, value);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
