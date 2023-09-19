package com.m2p.livQuik.demo.assertions;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import io.restassured.path.json.JsonPath;

import java.util.Map;

import static  org.hamcrest.Matchers.*;

public class Assert {

    public void verifyStatusIs200(Response response){
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
    }
    public void verifythecontent(Response response) {

                // Step 2: Get the JSON response body as a string
                String responseBody = response.getBody().asString();

                // Step 3: Convert the JSON response to a Map
                Map<String, Object> jsonResponse = response.jsonPath().getMap("");

                // Step 4: Check if the key is present
                boolean hasKey = jsonResponse.containsValue("success");
        if (!jsonResponse.containsValue("success")) {
            throw new AssertionError("Value 'Success' is not present in the response");
        }

            }







    public void verifythecontentFailed(Response response){
        Assertions.assertThat(response.jsonPath().toString().contains("Failed"));
    }
}
