package com.m2p.livQuik.demo.constants;

/**
 * This class holds all the end-point
 */
public final class EndpointConstants {

    //-------livQuick
    public static final String GENERATE_OTP ="customer/generateOtp";

    public static final  String Verify_OTP ="lqfleet/customer/validateOtp";

    public static final String Login_New_User= "customer/login";

    public static final String Update_customer= "lqfleet/customer/update";

    public static final String validateOtp= "customer/validateOtp";
    public static final String checkUser= "customer/registered";

    public static final String fetchTransactions= "customer/fetchTransactions";

    public static  final String detailsByMobile= "customer/detailsByMobile";
    public static final String  ForgotMPIN = "customer/forgotMpin";
    public static  final  String getcardlist= "customer/getCardList";
    public static  final String VKYCLink= "customer/fetchVkycLink";
    public static final String getBalance = "customer/getBalance";
    public static final String generateHash = "customer/getBalance";
    public static  final String fetchVkycLink = "customer/fetchVkycLink";
    public static final String fetchPgUrl = "customer/fetchPgUrl";

    public static final String fetchvehicle = "vehicle/fetchVehiclesByParent";
    public static final String fetchVehicleTransactions ="vehicle/fetchTransactions";
    public static final String Fetchdisputebyentity = "dispute/entity";
    public static  final String AddDisputeReason = "dispute/addDisputeReason";
    public static final String getDisputeReasons="dispute/getDisputeReasons";
    public static final String Replacetagrequest = "tag/replace";
    public static final String tagFitmentCertificate = "tag/emailCertificate";

    public static  final String MarkDisputeTxn = "dispute/update";

    public static final String Getbanners ="banner/get";
    public static final String SerachVehicle ="vehicle/searchVehiclesForParent";

    public static  final String AccountClosure= "customer/closeAccount";

    public static  final String GetAccountClosureReason= "customer/getClosureReasons";


   // public static final String

    private EndpointConstants() {
    }
}

