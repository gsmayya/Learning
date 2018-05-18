package com.gsmayya.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest("service.message=Hello")
public class RuntimeKVServiceTest {

    @Autowired
    private RuntimeKVService runtimeKVService;

    @Test
    public void contextLoads() {
        assertThat(runtimeKVService.message()).isNotNull();
    }

    @SpringBootApplication
    static class TestConfiguration {

    }
}
