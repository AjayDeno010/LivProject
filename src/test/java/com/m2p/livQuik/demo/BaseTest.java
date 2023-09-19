package com.m2p.livQuik.demo;

import com.m2p.livQuik.demo.setup.RestAssuredSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

import java.net.URL;

public class BaseTest extends AbstractTestNGSpringContextTests {


@Value("${spring.profiles.active:}")
     private String activeProfiles;
    @Autowired
    public RestAssuredSetup restAssuredSetup;

    @BeforeClass
    public void testClassSetup() {
//        RestAssuredSetup.restAssuredSetupHosted();
//        System.out.println("This will run before each test class");
        if ("local".equalsIgnoreCase(activeProfiles)) {
            restAssuredSetup.restAssuredSetupLocal();
        } else {
            restAssuredSetup.restAssuredSetupHosted();
        }
    }

}
