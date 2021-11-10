package com.cyquen.miniprogramserver.controller;

import com.cyquen.miniprogramserver.model.Result;
import com.cyquen.miniprogramserver.model.User;
import com.cyquen.miniprogramserver.model.WxSessionModel;
import com.cyquen.miniprogramserver.service.WxAuthService;
import com.cyquen.miniprogramserver.util.JwtUtil;
import com.cyquen.miniprogramserver.util.WxUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
public class WxAuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxAuthController.class);

    @Autowired
    private WxAuthService wxAuthService;

    @PostMapping("/api/v1/wx/session")
    public Result createSession(@RequestBody HashMap<String, String> wxloginData) {
        // 获取用户 openid
        WxSessionModel vxSessionModel = wxAuthService.getWxSession(wxloginData.get("code"));

        if (vxSessionModel.getErrcode() != null) {
            return Result.buildError(vxSessionModel.getErrmsg());
        }

        LOGGER.info("openid: {}", vxSessionModel.getOpenid());
        System.out.println(WxUtils.getUserInfo(wxloginData.get("encrypted_data"), vxSessionModel.getSession_key(), wxloginData.get("iv")));

        User user = new User();
        user.setId(1);
        return Result.buildSuccess(JwtUtil.createToken(user));
    }
}
