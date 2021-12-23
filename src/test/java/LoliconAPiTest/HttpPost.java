package LoliconAPiTest;

import com.google.gson.Gson;
import edu.qingyun.HttpUtils.HttpUtilsClient;
import edu.qingyun.lolicon.LoliconPostInfoVo;

/**
 * 色图
 * @author qingyun
 * @date 2021/12/19
 */
public class HttpPost {
    public static void main(String[] args) {

        HttpUtilsClient httpUtilsClient = new HttpUtilsClient();
        Gson gson = new Gson();
        String json = gson.toJson(new LoliconPostInfoVo());
        httpUtilsClient.SendHttp2PostGson("https://api.lolicon.app/setu/v2",json);
    }
}
