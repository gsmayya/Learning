package com.gsmayya.app;

import com.gsmayya.services.FileList;
import com.gsmayya.services.RuntimeKVService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication(scanBasePackages = "com.gsmayya")
@RestController
public class RuntimeKVApplication {

    private final RuntimeKVService runtimeKVService;

    public RuntimeKVApplication(RuntimeKVService runtimeKVService) {
        this.runtimeKVService = runtimeKVService;
    }

    @RequestMapping(value = "/list/{dirName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public FileList getListOfFiles(@PathVariable String dirName) {
        return this.runtimeKVService.getListOfFiles("/Users/gsmayya/Documents/Code/rest-app_copy/");
    }


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> message() {
        return Collections.singletonMap("response", runtimeKVService.message());
    }

    @RequestMapping("/name/{thisName}/{thisValue}")
    public Map<String, String> storeKV(@PathVariable String thisName, @PathVariable String thisValue) {
        return this.runtimeKVService.storeKV(thisName, thisValue);
    }

    @GetMapping("/name/{thisName}")
    public Map<String, String> getValue(@PathVariable String thisName) {
        return Collections.singletonMap("result", this.runtimeKVService.getValue(thisName));
    }

     public static void main(String[] args) {
         SpringApplication.run(RuntimeKVApplication.class, args);
     }
}