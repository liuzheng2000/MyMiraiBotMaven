import com.google.gson.Gson;
import edu.qingyun.ALiYunOss.ALiYunOssController;
import edu.qingyun.GsonConfig.QueHun.Test.QueHunBasicReturn;
import edu.qingyun.GsonConfig.QueHun.Test.QueHunReturn;
import edu.qingyun.GsonConfig.QueHun.Utils.TemplatingInfo;
import edu.qingyun.HttpUtils.HttpUtilsClient;
import edu.qingyun.Picture.PictureUtils;
import edu.qingyun.quehun.QueHunClient;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class HttpTest {



    public static void main(String[] args) throws IOException {



        QueHunClient queHunClient = new QueHunClient();
        HttpUtilsClient httpUtilsClient = new HttpUtilsClient();
        Gson gson = new Gson();
        //https://ak-data-2.sapk.ch/api/v2/pl4/player_stats/1149278/1262304000000/1639583999999?mode=16.12.9.15.11.8&tag=count
        String url1 = "https://ak-data-2.sapk.ch/api/v2/pl4/player_extended_stats/"
                +"1149278"+ "/1262304000000"+"/"+"httpUtilsClient.getDateTime()"+"?mode=16.12.9.15.11.8&tag=count";
        String UserInfo = httpUtilsClient.SendHttp2Get(url1);
        QueHunReturn queHunReturn = gson.fromJson(UserInfo, QueHunReturn.class);


        String url2 ="https://ak-data-2.sapk.ch/api/v2/pl4/player_stats/"
                +"1149278"+ "/1262304000000"+"/"+"httpUtilsClient.getDateTime()"+"?mode=16.12.9.15.11.8&tag=count";
        String UserInfoTwo = httpUtilsClient.SendHttp2Get(url2);
        QueHunBasicReturn queHunBasicReturn = gson.fromJson(UserInfoTwo, QueHunBasicReturn.class);

        TemplatingInfo templatingInfo = new TemplatingInfo();
        String userInfo = templatingInfo.TemplatingString(queHunReturn, queHunBasicReturn);
        BufferedImage image = PictureUtils.createImage(userInfo, new Font("正楷", Font.BOLD, 20), 800, 400);
//        ImageIO.write(image, "png", new File("e:/a.png"));
        ALiYunOssController aLiYunOssController = new ALiYunOssController();
        String ReturnPicture = aLiYunOssController.UploadImage(image, "1149278");
        System.out.println(ReturnPicture);
    }



}
