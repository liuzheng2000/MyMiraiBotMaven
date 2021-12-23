package edu.qingyun.Gsonlolicon;

import com.google.gson.Gson;
import edu.qingyun.GsonConfig.Lolicon.LoliconGson;
import edu.qingyun.HttpUtils.HttpUtilsClient;
import edu.qingyun.Listener.GroupLoliconListener;
import edu.qingyun.Utils.QingYunUtils;
import edu.qingyun.lolicon.LoliconPostInfoVo;
import edu.qingyun.lolicon.vo.PictureVo;
import edu.qingyun.redisConfig.RedisUtils;

import java.util.HashMap;
import java.util.List;

/**
 * 设置色图格式化
 * @author qingyun
 * @date 2021/12/19
 */
public class LoliconClient {

    Gson jsonGson = new Gson();
    RedisUtils redisUtils = new RedisUtils();

    /**
     * 设置CD
     * @param QQ
     * @return
     */
    public void  SetLoliconCD(String QQ) {
         redisUtils.SetKeyEx("ll" + QQ);
    }


    /**
     * 获取CD
     * @param QQ
     * @return
     */
    public String  GetLoliconCD(String QQ) {
        return redisUtils.GetKeyEx("ll" + QQ);
    }



    /**
     *
     * 添加
     * !搜图     uid=123132132+12121222+2121212+54545&tag=萝莉+白丝+白满
     * !搜图     tag=萝莉&白丝&白满
     * 获取返回的图片地址
     * @return
     */
    public Object  GetLoliconPictureUrl(String LoliconPostBody){
        // 处理参数问题
        String[] PostUidArr = null;  String[] PostTagArr = null;
        //携带参数
        if (LoliconPostBody.startsWith("uid=")||LoliconPostBody.startsWith("tag=")){
            String[] ArrSplit = LoliconPostBody.split("&");  //有两个参数都有
            for (String UidArrOrTagArr : ArrSplit) {
                String[] UidOrTagPath = UidArrOrTagArr.split("=");
                    if (UidOrTagPath[0].equals("uid")){
                        PostUidArr = UidOrTagPath[1].split("\\+");
                    }else if (UidOrTagPath[0].equals("tag")){
                        PostTagArr = UidOrTagPath[1].split("\\+");
                    }
            }
        }

        //处理请求问题
        LoliconPostInfoVo loliconPostInfoVo = new LoliconPostInfoVo();
        loliconPostInfoVo.setR18(Integer.parseInt(GroupLoliconListener.R18));
        if (null != PostUidArr){
            loliconPostInfoVo.setUid(QingYunUtils.StringArrToIntArr(PostUidArr));
        }
        if (null != PostTagArr){
            loliconPostInfoVo.setTag(PostUidArr);
        }
        String loliconPost = jsonGson.toJson(loliconPostInfoVo);
        HttpUtilsClient httpUtilsClient = new HttpUtilsClient();
        String ReturnLoliconPost = httpUtilsClient.SendHttp2PostGson("https://api.lolicon.app/setu/v2", loliconPost);
        if (!ReturnLoliconPost.contains("original")){
            return "抱歉 查询可能有误 请注意查询格式";
        }


        //处理返回问题
        LoliconGson loliconGson = new LoliconGson();
        List<String> loliconPictureList = loliconGson.GetPictureByLoliconInfo(ReturnLoliconPost);
        return loliconPictureList;
    }

    /**
     *
     * 通过Url获取作者信息
     * @param PictureUrl
     * @return
     */
    public Object  GetPictureInfo(String PictureUrl){
        HashMap<String, String> pictureUrlMap = new HashMap<>();
        pictureUrlMap.put("url",PictureUrl);
        HttpUtilsClient httpUtilsClient = new HttpUtilsClient();
        //返回的HTML页面  格式化
        String returnHtml = httpUtilsClient.SendHttp2PostFormData("https://saucenao.com/search.php", pictureUrlMap);
        // 进行页面解析
        if (returnHtml!=null){
            LoliconGson loliconGson = new LoliconGson();
            PictureVo pictureVo = loliconGson.GetPictureHtmlInfoToPictureVo(returnHtml);
            return pictureVo;
        }
        return "页面出现问题";
    }


}
