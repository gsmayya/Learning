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

    public Map<String, String> storeKV(String key, String value) {
        this.serviceProperties.addAnEntry(key, value);
        return this.serviceProperties.getMapOfNames();
    }

    public String getValue(String key) {
        Map<String, String> stringStringMap = this.serviceProperties.getMapOfNames();
        return stringStringMap.getOrDefault(key, "No value stored");
    }

    public FileList getListOfFiles(String dirName) {
        return new FileList(dirName);
    }
}