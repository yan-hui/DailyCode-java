package lone.wolf.utils;

import org.apache.log4j.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HttpRequestUtil
 * @Description httpclient模拟发送get和post请求
 * @Author hechunhui
 * @Date 2018/5/24 11:01
 */
public class HttpRequestUtil {
    private static final Logger log = Logger.getLogger(HttpRequestUtil.class);
    /**
     * 超时时间
     */
    private static int TIME_OUT = 60 * 1000;
    /**
     * 请求成功状态码
     */
    private static int SUCCESS_STATUS = 200;
    /**
     * 地址未找到
     */
    private static int _404_STATUS = 404;
    /**
     * 请求已被重定向
     */
    private static int _301_STATUS = 301;
    private static int _302_STATUS = 302;
    /**
     * 资源错误
     */
    private static int _500_STATUS = 500;

    /**
     * Post请求
     *
     * @param reqUrl 请求url
     * @return
     * @para reqParam 请求参数
     */
    public static String httpPost(String reqUrl, Map<String, String> reqParam) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(reqUrl);

        //配置超时时间等请求参数
        httpPost.setConfig(setRequestConfig());
        List<NameValuePair> parames = setRequestParam(reqParam);

        //发送请求获取结果
        try {

            httpPost.setEntity(new UrlEncodedFormEntity(parames, "UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);
            int respStats = response.getStatusLine().getStatusCode();

            //获得返回的结果
            String respResult = returnRespResult(respStats, response);
            return respResult;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get请求
     *
     * @param reqUrl
     * @return
     */
    public static String httpGet(String reqUrl) {

        CloseableHttpClient httpCilent = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(reqUrl);
        //设置请求时间等参数
        httpGet.setConfig(setRequestConfig());

        try {
            HttpResponse response = httpCilent.execute(httpGet);
            int respStats = response.getStatusLine().getStatusCode();

            //获取返回结果
            String respResult = returnRespResult(respStats, response);
            return respResult;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpCilent.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 设置请求参数
     *
     * @param reqParam
     * @return
     */
    private static List<NameValuePair> setRequestParam(Map<String, String> reqParam) {
        //添加请求参数
        List<NameValuePair> params= new ArrayList<NameValuePair>();
        if (reqParam != null && !reqParam.isEmpty()) {
            for (Map.Entry<String, String> entry : reqParam.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return params;
    }

    /**
     * 设置请求时间等参数
     */
    private static RequestConfig setRequestConfig() {
        //配置超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(TIME_OUT)   //设置连接超时时间
                .setConnectionRequestTimeout(TIME_OUT) // 设置请求超时时间
                .setSocketTimeout(TIME_OUT)
                .setRedirectsEnabled(true)//默认允许自动重定向
                .build();
        return requestConfig;
    }

    /**
     * 不同行为状态处理结果
     *
     * @param status
     */
    private static String returnRespResult(int status, HttpResponse response) throws IOException {
        String respResult = null;
        if (SUCCESS_STATUS == status) {
            respResult = EntityUtils.toString(response.getEntity());
            log.info("httpPost---> 202 --> 请求成功！！");
            System.out.println("httpPost请求结果： " + respResult);
        } else if (_404_STATUS == status) {
            log.info("httpPost---> 404 --> 找不到请求地址！！");
            System.out.println("httpPost---> 404 --> 找不到请求地址！！");

        } else if (_500_STATUS == status) {
            log.info("httpPost---> 500 --> 请求资源出错！！！");
            System.out.println("httpPost---> 500 --> 请求资源出错！！！");

        } else if (_301_STATUS == status || _302_STATUS == status) {
            log.info("httpPost---> " + status + " --> 请求已被重定向！！");
            System.out.println("httpPost---> " + status + " --> 请求已被重定向！！");

        } else {
            log.info("httpPost---> " + status + "-->请求失败！！");
            System.out.println("httpPost---> " + status + "-->请求失败！！");
        }
        return respResult;
    }

}
