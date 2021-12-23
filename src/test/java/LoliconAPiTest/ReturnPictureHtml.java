package LoliconAPiTest;

import edu.qingyun.HttpUtils.HttpUtilsClient;

import java.util.HashMap;

public class ReturnPictureHtml {
    public static void main(String[] args) {
        HashMap<String, String> pictureUrlMap = new HashMap<>();
        pictureUrlMap.put("url","https://img3.gelbooru.com//samples/88/d6/sample_88d63e7fa3facaaa73bd4ea1d4da7991.jpg");
        HttpUtilsClient httpUtilsClient = new HttpUtilsClient();
        String ReturnHtml = httpUtilsClient.SendHttp2PostFormData("https://saucenao.com/search.php", pictureUrlMap);
        System.out.println(ReturnHtml);
    }
}
