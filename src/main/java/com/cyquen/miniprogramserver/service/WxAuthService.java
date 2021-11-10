package com.cyquen.miniprogramserver.service;

import com.cyquen.miniprogramserver.config.WxConfig;
import com.cyquen.miniprogramserver.model.WxSessionModel;
import com.cyquen.miniprogramserver.util.HttpClientUtil;
import com.cyquen.miniprogramserver.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WxAuthService {

    @Autowired
    public WxConfig weChatConfig;

    public WxSessionModel getWxSession(String wxCode) {
        Map<String, String> params = new HashMap<>();
        params.put("appid", weChatConfig.appid);
        params.put("secret", weChatConfig.appsecret);
        params.put("js_code", wxCode);
        params.put("grant_type", "authorization_code");
        String res = HttpClientUtil.doGet("https://api.weixin.qq.com/sns/jscode2session", params);
        if (res == null || res.equals("")) {
            return null;
        }
        return JsonUtils.jsonToPojo(res, WxSessionModel.class);
    }
}
