package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.GenerateOtpDto;
import com.m2p.livQuik.demo.dto.GetCardListDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class getCardListStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;

    public Response response;
    public GetCardListDto getCardListDto;
    public void prepareGetCardList(){
     getCardListDto = GetCardListDto
             .builder()
             .entityId("9841175642")
             .build();
    }
    public void executGetCardList(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        String RefreshToken = loginresponse.jsonPath().get("refreshToken");
        response= apiCallSetup.GetCardList(getCardListDto, accessToken,RefreshToken);
    }
    public void VerifyGetcardList(){
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();

    }

}
