package com.gsmayya.services;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties("service")
public class ServiceProperties {

    private final Map<String, String> mapOfNames = new HashMap<>();
    private String message;

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
