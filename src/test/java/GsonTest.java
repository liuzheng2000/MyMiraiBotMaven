import edu.qingyun.GsonConfig.QueHun.QueHunGson;
import edu.qingyun.HttpUtils.HttpUtilsClient;

public class GsonTest {

    public static void main(String[] args) {
        HttpUtilsClient httpUtilsClient = new HttpUtilsClient();
        String UserInfo = httpUtilsClient.SendHttp2Get("https://ak-data-2.sapk.ch/api/v2/pl4/search_player/" + "wdasd");
        QueHunGson queHunGson = new QueHunGson();
        queHunGson.GsonUserIDInfo(UserInfo,"w");
    }
}
