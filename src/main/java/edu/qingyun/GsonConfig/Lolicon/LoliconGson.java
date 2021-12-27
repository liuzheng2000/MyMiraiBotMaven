package edu.qingyun.GsonConfig.Lolicon;

import com.google.gson.Gson;
import edu.qingyun.GsonConfig.Lolicon.LoliconInfo.Data;
import edu.qingyun.GsonConfig.Lolicon.LoliconInfo.LoliconReturnInfo;
import edu.qingyun.lolicon.vo.PictureVo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * 格式化页面
 */
public class LoliconGson {
    Gson jsonGson = new Gson();


    /**
     *
     * 通过LoliconInfo获取图片URL
     * @param LoliconInfo
     * @return
     */
    public List<String> GetPictureByLoliconInfo(String LoliconInfo){
        List<String> returnList = new  ArrayList<String>();
        LoliconReturnInfo loliconReturnInfo = jsonGson.fromJson(LoliconInfo, LoliconReturnInfo.class);
        List<Data> data = loliconReturnInfo.getData();
        for (Data datum : data) {
            returnList.add(datum.getUrls().getOriginal());
        }
        return returnList;
    }


    /**
     * 传入HTML 进行解析
     * @param PictureHtml
     * @return
     */
    public PictureVo  GetPictureHtmlInfoToPictureVo(String ImagePicture,String PictureHtml){
        PictureVo pictureVo = new PictureVo();
        if (PictureHtml != null){
            Document parse = Jsoup.parse(PictureHtml);
            Element firstresulttable = parse.select("div#middle").select("table.resulttable").first();
            //图片地址

            if (firstresulttable != null){
                pictureVo.setImagePictureUrl(ImagePicture);
                //图片地址
                Element element = firstresulttable.selectFirst("img#resImage0");
                String picture = element.attr("src");
                pictureVo.setPictureUrl(picture);
                String xiangsidu = firstresulttable.selectFirst("div.resultsimilarityinfo").text();
                pictureVo.setSimilarity(xiangsidu);
                String text = firstresulttable.selectFirst("div.resulttitle").text();
                pictureVo.setCreator(text);
                String attr = firstresulttable.selectFirst("div.resultcontentcolumn").selectFirst("a").attr("href");
                pictureVo.setSourced(attr);
            }

        }
        return pictureVo;
    }
}
