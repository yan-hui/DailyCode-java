package test;

import lone.wolf.utils.HttpRequestUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HttpClientTest
 * @Description
 * @Author hechunhui
 * @Date 2018/5/24 11:59
 */
public class HttpClientTest {
    @Test
    public void testLoginPicture(){
        String number= "18613060932";
        String loginUrl = "http://120.198.246.76:8080/pw/system/ authenticateForPC.action";
        Map<String,String> loginParam = new HashMap<>();
        loginParam.put("loginid","");
        loginParam.put("password","");
        loginParam.put("vcode","");
        loginParam.put("","");
        loginParam.put("","");


        //String url = "http://120.198.246.76:8080/pw/business/4GBusinessForPC.action?number="+number;
        //String url = "http://120.198.246.76:8080/pw/business/4GBusinessForPC.action";
        //String url = "http://120.198.246.76:8080/pw/business/queryBaseInfo.action";
        //String url = "http://120.198.246.76:8080/pw/system/getDynamicPWD.action";
        //String url = "http://120.198.246.76:8080/pw/system/logoutForMb.action";
        String url = "http://120.198.246.76:8080/pw/business/oneCardFiveVerificationCodeFoneCa.action";
        url = url.replaceAll("&", "%26");
        url = url.replaceAll(" ", "%20");
        Map<String,String> param = new HashMap<>();
            param.put("number",number);
        //JSONObject jsonObject = HttpRequestUtil.httpGet(url);
        String result = HttpRequestUtil.httpPost(url, param);
        System.out.println(result);
    }


}
