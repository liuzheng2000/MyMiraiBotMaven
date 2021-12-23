import edu.qingyun.HttpUtils.HttpUtilsClient;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.HashMap;

public class CreateUrlTest {


    public static String pl4 = "https://ak-data-2.sapk.ch/api/v2/pl4/";   //四麻
    public static String pl3 = "https://ak-data-2.sapk.ch/api/v2/pl3/";   //三麻

    public static HashMap<String,String> pl3LevelMap = new HashMap();
    public static HashMap<String,String> pl4LevelMap = new HashMap();

    public static void init(){
        pl4LevelMap.put("查询四人南场","16.12.9"); pl4LevelMap.put("查询四人东场","15.11.8"); pl4LevelMap.put("查询四人金南","9"); pl4LevelMap.put("查询四人金东","8");
        pl4LevelMap.put("查询四人玉南","12"); pl4LevelMap.put("查询四人玉东","11"); pl4LevelMap.put("查询四人王座南","16"); pl4LevelMap.put("查询四人王座东","15");

        pl3LevelMap.put("查询三人南场","22.24.26"); pl3LevelMap.put("查询三人东场","21.23.25"); pl3LevelMap.put("查询三人金南","22"); pl3LevelMap.put("查询三人金东","21");
        pl3LevelMap.put("查询三人玉南","24"); pl3LevelMap.put("查询三人玉东","23"); pl3LevelMap.put("查询三人王座南","26"); pl3LevelMap.put("查询三人王座东","25");
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

    public String GetUserInfoByUserID(String userID , String LevelMap){
        String url;
        if (LevelMap.substring(0,5).contains("四人")){
            url = pl4;
            url = url+"/player_extended_stats/" + userID + "/1262304000000"+"/" + getDateTime() +"/?mode="+pl4LevelMap.get(LevelMap);
        }else {
            url = pl3;
            url = url+"/player_extended_stats/" + userID + "/1262304000000"+"/" + getDateTime() +"/?mode="+pl3LevelMap.get(LevelMap);
        }
        return url;
    }

    public static void main(String[] args) {
        CreateUrlTest.init();
        CreateUrlTest createUrlTest = new CreateUrlTest();
        String s = createUrlTest.GetUserInfoByUserID("73373352", "查询三人金南");
        System.out.println(s);
    }

}
