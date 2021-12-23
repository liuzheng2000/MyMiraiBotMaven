import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.qingyun.GsonConfig.QueHun.CardSpectrum.CardSpectrumPojo;
import edu.qingyun.HttpUtils.HttpUtilsClient;

import java.util.List;

public class CardHttpTest {
    public static void main(String[] args) {
        HttpUtilsClient httpUtilsClient = new HttpUtilsClient();
        String s = httpUtilsClient.SendHttp2Get("https://ak-data-3.sapk.ch/api/v2/pl4/player_records/1501243/1639843199999/1262304000000?limit=137&mode=16,12&descending=true&tag=1337");
        Gson jsonGson = new Gson();
        List<CardSpectrumPojo> CardSpectrumPojoList = jsonGson.fromJson(s,new TypeToken<List<CardSpectrumPojo>>() {}.getType());
        System.out.println(CardSpectrumPojoList.toString());
    }
}
