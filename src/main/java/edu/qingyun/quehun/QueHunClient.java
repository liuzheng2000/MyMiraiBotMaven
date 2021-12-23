package edu.qingyun.quehun;

import com.google.gson.Gson;
import edu.qingyun.GsonConfig.QueHun.QueHunGson;
import edu.qingyun.GsonConfig.QueHun.Test.QueHunBasicReturn;
import edu.qingyun.GsonConfig.QueHun.Test.QueHunReturn;
import edu.qingyun.HttpUtils.CreateUrl;
import edu.qingyun.HttpUtils.HttpUtilsClient;
import edu.qingyun.Picture.PictureUtils;
import edu.qingyun.redisConfig.RedisUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Date;

/**
 *
 * 雀魂功能操作类
 * @author qingyun
 * @date 2021/12/13
 */
public class QueHunClient {

    /**
     * //产生RedisUtils对象
     */
      RedisUtils  redisUtils = new RedisUtils();


    /**
     *  //发送用户昵称，将返回ID信息      （进行缓存并操作）
     * @param userName
     * @param LevelMap
     */
    public String GetUserIdToRedis(String userName ,String LevelMap ){
//      redisUtils.getValueByKey(userName);  在Redis层面中进行查找 如果可以找到则直接返回  如果是第一次请求  则 发送Http请求 并将返回结果进行储存
        String UserID = redisUtils.getValueByKey(userName);
        CreateUrl createUrl = new CreateUrl();
        if (null!=UserID){
            return UserID;
        }
        //进行Http
        HttpUtilsClient httpUtilsClient = new HttpUtilsClient();
        String UserIDInfo = httpUtilsClient.SendHttp2Get(createUrl.GetSearch_player(userName,LevelMap));
        if (!(UserIDInfo.contains("error"))){
            //进行格式化并返回
            QueHunGson queHunGson = new QueHunGson();
            String StringID = queHunGson.GsonUserIDInfo(UserIDInfo, userName);
            return StringID.equals("")?"抱歉找不到对应的ID信息":StringID;
        }else {
            System.out.println("Http请求返回为空");
            return "Http请求返回为空";
        }
    }


    /**
     * 通过用户ID查询用户信息
     * @param userID
     * @param LevelMap  所在场次
     * @return
     */
    public BufferedImage GetUserInfoByUserID(String LevelMap , String userID){
        CreateUrl.init(); // 初始化
        HttpUtilsClient httpUtilsClient = new HttpUtilsClient();
        CreateUrl createUrl = new CreateUrl();
        String QueHunReturn = httpUtilsClient.SendHttp2Get(createUrl.GetPlayer_extended_statsURL(userID,LevelMap));
        String QueHunReturnBasic =httpUtilsClient.SendHttp2Get(createUrl.GetPlayer_statsURL(userID,LevelMap));
        if ((QueHunReturn).contains("error") || (QueHunReturnBasic).contains("error") ){
            return  PictureUtils.createImage("抱歉未能查找到信息 可能不在当前分段^", new Font("正楷", Font.BOLD, 20), 800, 400);
        }
        //均不为空地请求下进行格式化操作
            // 进行返回类操作
            QueHunGson queHunGson = new QueHunGson();
            BufferedImage ReturnPictureUrl = queHunGson.GsonUserInfo(QueHunReturn, QueHunReturnBasic, userID);
            return ReturnPictureUrl;
    }


    /**
     * 通过用户ID查询用户牌谱
     * @param userID
     * @param LevelMap  所在场次
     * @return
     */
    public String GetCardSpectrumByUserID(String LevelMap , String userID){
        CreateUrl.init(); // 初始化
        HttpUtilsClient httpUtilsClient = new HttpUtilsClient();
        CreateUrl createUrl = new CreateUrl();

        String spectrumInfo = httpUtilsClient.SendHttp2Get(createUrl.GetCard_spectrumURL(userID, LevelMap));
        if ((spectrumInfo).contains("error") ){
            return  "抱歉未能查找到信息 ^";
        }

        //均不为空地请求下进行格式化操作
        // 进行返回类操作
        QueHunGson queHunGson = new QueHunGson();
        String cardSpectrum = queHunGson.GsonCardSpectrum(spectrumInfo, userID);
//        BufferedImage ReturnPictureUrl = queHunGson.GsonUserInfo(QueHunReturn, QueHunReturnBasic, userID);
        return cardSpectrum;
    }
}



//    /**
//     * 通过用户ID查询用户信息(无需保障Http请求为空)
//     * @param userID
//     * @return
//     */
//    public String GetUserInfoByUserID(String userID){
//        String UserInfoByRedis = redisUtils.getValueByKey(userID);
//        if (null!=UserInfoByRedis){
//            return UserInfoByRedis;
//        }


//        HttpUtilsClient httpUtilsClient = new HttpUtilsClient();
//        String QueHunReturn = httpUtilsClient.SendHttp2Get("https://ak-data-2.sapk.ch/api/v2/pl4/player_extended_stats/"
//                +userID+ "/1262304000000"+"/"+httpUtilsClient.getDateTime()+"?mode=16.12.9.15.11.8&tag=count");
//        String QueHunReturnBasic =httpUtilsClient.SendHttp2Get("https://ak-data-2.sapk.ch/api/v2/pl4/player_stats/"
//                +userID+ "/1262304000000"+"/"+httpUtilsClient.getDateTime()+"?mode=16.12.9.15.11.8&tag=count");
//        //均不为空地请求下进行格式化操作
//        if (!"".equals(QueHunReturn) && !"".equals(QueHunReturnBasic)){
// 进行返回类操作
//            QueHunGson queHunGson = new QueHunGson();
//            String ReturnPictureUrl = queHunGson.GsonUserInfo(QueHunReturn, QueHunReturnBasic, userID);
//            return ReturnPictureUrl;
//        }else {
//            System.out.println("Http请求返回为空");
//            return "Http请求返回为空";
//        }
//
//    }