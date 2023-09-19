package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetBannersStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;
    public Response response;
   public void executeGetBannersRequest(){
       response = apiCallSetup.getBanners();
   }
   public void verifyGetBannersRequest(){
       verifyStatusIs200(response);
       verifythecontent(response);
   }

}
