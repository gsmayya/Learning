package com.gsmayya.app;

import com.gsmayya.services.RuntimeKVService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.gsmayya")
@RestController
public class RuntimeKVApplication {

    private final RuntimeKVService runtimeKVService;

    public RuntimeKVApplication(RuntimeKVService runtimeKVService) {
        this.runtimeKVService = runtimeKVService;
    }

    @GetMapping("/")
    public String mesasge() {
        return runtimeKVService.message();
    }

    @RequestMapping("/name/{thisName}/{thisValue}")
    public String storeKV(@PathVariable String thisName, @PathVariable String thisValue) {
        return this.runtimeKVService.storeKV(thisName, thisValue);
    }

    @GetMapping("/name/{thisName}")
    public String getValue(@PathVariable String thisName) {
        return this.runtimeKVService.getValue(thisName);
    }

     public static void main(String[] args) {
         SpringApplication.run(RuntimeKVApplication.class, args);
     }
}