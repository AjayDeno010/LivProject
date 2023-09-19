package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.AddDisputeReasonDto;
import com.m2p.livQuik.demo.dto.GetCardListDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddDisputeReasonStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;

    public Response response;
    public AddDisputeReasonDto addDisputeReasonDto;
    public void PrepareaddDisputeReasonPayload() {
        addDisputeReasonDto = AddDisputeReasonDto
                .builder()
                .reason("Double Charges")
                .build();

    }
    public void executeaddDisputeReason(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        String refreshToken = loginresponse.jsonPath().get("refreshToken");
        response= apiCallSetup.AddDisputeReason(addDisputeReasonDto,accessToken,refreshToken);
    }
    public void VerifyaddDisputeReason(){

        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();
    }
}
