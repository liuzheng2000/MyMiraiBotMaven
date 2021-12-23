package edu.qingyun.GsonConfig.QueHun;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import edu.qingyun.ALiYunOss.ALiYunOssController;
import edu.qingyun.GsonConfig.QueHun.CardSpectrum.CardSpectrumPojo;
import edu.qingyun.GsonConfig.QueHun.CardSpectrum.Players;
import edu.qingyun.GsonConfig.QueHun.Test.QueHunBasicReturn;
import edu.qingyun.GsonConfig.QueHun.Test.QueHunReturn;
import edu.qingyun.GsonConfig.QueHun.Utils.TemplatingInfo;
import edu.qingyun.Picture.PictureUtils;
import edu.qingyun.redisConfig.RedisClientUtils;
import edu.qingyun.redisConfig.RedisUtils;
import io.lettuce.core.api.sync.RedisCommands;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.utils.ExternalResource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 雀魂游戏内容格式化
 * @author qingyun
 * @date 2021/12/13
 */
public class QueHunGson {

    Gson jsonGson = new Gson();
    SimpleDateFormat timeSf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 雀魂 返回 个人ID  格式化
     * @param UserInfo
     * @return
     */
    public String GsonUserIDInfo (String UserInfo,String UserName){

        JsonArray jsonArray = jsonGson.fromJson(UserInfo, JsonArray.class);
        RedisUtils redisUtils = new RedisUtils();
        String ReturnID = "";
        try{
            //获取redis的对象
            for (int i = 0; i < jsonArray.size(); i++) {
                QueHunInfoJson queHunInfoJson ;
                JsonElement QueHunInfoJsonElement = jsonArray.get(i);
                queHunInfoJson = jsonGson.fromJson(QueHunInfoJsonElement, QueHunInfoJson.class);
                //将查询的结果发送至Redis缓存保存
                redisUtils.IfNotExistSetKeyAndValue(queHunInfoJson.getNickname(), queHunInfoJson.getId());
                if (queHunInfoJson.getNickname().equals(UserName)){
                    ReturnID= queHunInfoJson.getId();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭redis连接
            redisUtils.RedisUtilsClose();
        }
        return ReturnID;
    }




    /**
     * 保存生成的个人信息  返回图片信息
     * @param QueHunReturnString
     * @param QueHunReturnBasicString
     * @param userID
     */
    public BufferedImage GsonUserInfo(String QueHunReturnString, String QueHunReturnBasicString, String userID){

        QueHunReturn queHunReturn = jsonGson.fromJson(QueHunReturnString, QueHunReturn.class);
        QueHunBasicReturn queHunBasicReturn = jsonGson.fromJson(QueHunReturnBasicString, QueHunBasicReturn.class);
        //生成模板信息
        TemplatingInfo templatingInfo = new TemplatingInfo();
        String userInfo = templatingInfo.TemplatingString(queHunReturn, queHunBasicReturn);
        //生成图片信息
        BufferedImage image = PictureUtils.createImage(userInfo, new Font("正楷", Font.BOLD, 20), 800, 400);


        //上传图片
//        ALiYunOssController aLiYunOssController = new ALiYunOssController();
//        String ReturnPicture = aLiYunOssController.UploadImage(image, userID);
        //设置Redis
//        RedisUtils redisUtils = new RedisUtils();
//        redisUtils.setKeyAndValueExTime(userID,151200,ReturnPicture);
//        redisUtils.RedisUtilsClose();

        return image;
    }



    /**
     * 处理牌谱信息
     * @param spectrumInfo
     * @param userID
     */
    public String GsonCardSpectrum(String spectrumInfo,  String userID){


        ArrayList<CardSpectrumPojo> CardSpectrumPojoList = jsonGson.fromJson(spectrumInfo,new TypeToken<List<CardSpectrumPojo>>() {}.getType());

        StringBuffer ReturnStringSpectrumPojoList = new StringBuffer();
        for (CardSpectrumPojo spectrumPojo : CardSpectrumPojoList) {

            String id = spectrumPojo.getUuid();  // 牌谱ID
            ReturnStringSpectrumPojoList.append("\n"+"\n"+"牌谱ID: " + id + "\n");
            long startTime = spectrumPojo.getStartTime();  //开始时间
            ReturnStringSpectrumPojoList.append("开始时间: " + timeSf.format(new Date(startTime*1000)) + "    ");
            long endTime = spectrumPojo.getEndTime();   //结束时间
            ReturnStringSpectrumPojoList.append("结束时间: " + timeSf.format(new Date(endTime*1000)) + "    "+"\n");
            int size = spectrumPojo.getPlayers().size();
            ReturnStringSpectrumPojoList.append("对局玩家: ");
            for (int i = 0; i < size; i++) {
                Players players = spectrumPojo.getPlayers().get(i);  //用户玩家
                String nickname = players.getNickname();
                ReturnStringSpectrumPojoList.append(nickname +"  ");
            }

        }
        return ReturnStringSpectrumPojoList.toString();
    }




}
