package com.example.lib2.offer;

import com.example.lib2.ReqType;

public interface IReqApi {
    @ReqType(reqType = ReqType.ReqTypeEnum.GET)
    @ReqUrl(reqUrl = "https://api.mosys.xyz/rest.php/token/get")
    String login(@ReqParam("email") String username, @ReqParam("passcode") String password);

    String change(@ReqParam("e")String chang);
}
