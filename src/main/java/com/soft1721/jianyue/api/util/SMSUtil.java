package com.soft1721.jianyue.api.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;


/**
 * 短信发送工具类
 */
public class SMSUtil {
    public static String send(String mobile) {
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-shanghai",
                "LTAIb4yR6H2XY2kU",
                "zW0DeNu8MzNUEmETN3DLmzhjct3C4d");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "哨戒班");
        request.putQueryParameter("TemplateCode", "SMS_162735607");
        String verifyCode = StringUtil.getVerifyCode();
        request.putQueryParameter("TemplateParam", "{\"code\":" + verifyCode + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return verifyCode;
    }

    public static void main(String[] args) {
        System.out.println(send("15730397743"));
    }
}