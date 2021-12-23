package edu.qingyun.HttpUtils;

import java.util.Date;
import java.util.HashMap;

public class CreateUrl {
    public static String pl4 = "https://ak-data-3.sapk.ch/api/v2/pl4/";   //四麻
    public static String pl3 = "https://ak-data-3.sapk.ch/api/v2/pl3/";   //三麻

    public static HashMap<String,String> pl3LevelMap = new HashMap();
    public static HashMap<String,String> pl4LevelMap = new HashMap();

    public static int count = 0;
    public static void init(){
        if (count == 0){
            pl4LevelMap.put("查询四人南场","16.12.9"); pl4LevelMap.put("查询四人东场","15.11.8"); pl4LevelMap.put("查询四人金南","9"); pl4LevelMap.put("查询四人金东","8");
            pl4LevelMap.put("查询四人玉南","12"); pl4LevelMap.put("查询四人玉东","11"); pl4LevelMap.put("查询四人王座南","16"); pl4LevelMap.put("查询四人王座东","15");

            pl3LevelMap.put("查询三人南场","22.24.26"); pl3LevelMap.put("查询三人东场","21.23.25"); pl3LevelMap.put("查询三人金南","22"); pl3LevelMap.put("查询三人金东","21");
            pl3LevelMap.put("查询三人玉南","24"); pl3LevelMap.put("查询三人玉东","23"); pl3LevelMap.put("查询三人王座南","26"); pl3LevelMap.put("查询三人王座东","25");

        }
        count++;
    }


    /**
     * 获取当前时间戳
     * @return
     */
    public long getDateTime(){
        Date date = new Date();
        long time = date.getTime();
        time = time;
        return time;
    }


    public String GetPl4OrPl3(String LevelMap){
        String url;
        if (LevelMap.contains("四")){
            url = pl4;
        }else {
            url = pl3;
        }
        return url;
    }




    public String GetSearch_player(String userName , String LevelMap){
        String url = GetPl4OrPl3(LevelMap);
        url = url+"search_player/" + userName;
        return url;
    }



    public String GetPlayer_extended_statsURL(String userID , String LevelMap){
        String url;
        if (LevelMap.substring(0,5).contains("四人")){
            url = pl4;
            url = url+"player_extended_stats/" + userID + "/1262304000000"+"/" + getDateTime() +"/?mode="+pl4LevelMap.get(LevelMap);
        }else {
            url = pl3;
            url = url+"player_extended_stats/" + userID + "/1262304000000"+"/" + getDateTime() +"/?mode="+pl3LevelMap.get(LevelMap);
        }
        return url;
    }

    public String GetPlayer_statsURL(String userID , String LevelMap){
        String url;
        if (LevelMap.substring(0,5).contains("四人")){
            url = pl4;
            url = url+"player_stats/" + userID + "/1262304000000"+"/" + getDateTime() +"/?mode="+pl4LevelMap.get(LevelMap);
        }else {
            url = pl3;
            url = url+"player_stats/" + userID + "/1262304000000"+"/" + getDateTime() +"/?mode="+pl3LevelMap.get(LevelMap);
        }
        return url;
    }



    public String GetCard_spectrumURL(String userID , String LevelMap){
        String url;
        if (LevelMap.contains("四麻")){
            url = pl4;
            url = url+"player_records/" + userID +   "/"+ getDateTime() +"/1262304000000"+"/?limit=5&mode=16.12.9.15.11.8&descending=true";
        }else {
            url = pl3;
            url = url+"player_records/" + userID +   "/"+ getDateTime() +"/1262304000000"+"/?limit=5&mode=22.24.26.21.23.25&descending=true";

        }
        return url;
    }

}
