package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.ReplacetagrequestDto;
import com.m2p.livQuik.demo.dto.TagFitmentCertificateDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagFitmentCertificateStep extends Assert {
    @Autowired
    protected ApiCallSetup apiCallSetup;

    public Response response;
    public TagFitmentCertificateDto tagFitmentCertificateDto;

    @Step
    public void preparetagFitmentCertificatePayLoad(){
   tagFitmentCertificateDto= TagFitmentCertificateDto
           .builder()
           .sendEmail(true)
           .vehicleId("TN22BP8148")
           .build();
    }
    @Step
    public void executetagFitmentCertificateRequest(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        String refreshToken = loginresponse.jsonPath().get("refreshToken");
        response= apiCallSetup.tagFitmentCertificate(tagFitmentCertificateDto,accessToken,refreshToken);
        System.out.println("Working for executeRequest");
    }
    @Step
    public void verifytagFitmentCertificateResponse(){
        System.out.println( response.getBody());
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();

    }
}
