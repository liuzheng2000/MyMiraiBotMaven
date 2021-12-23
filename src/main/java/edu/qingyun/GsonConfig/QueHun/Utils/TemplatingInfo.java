package edu.qingyun.GsonConfig.QueHun.Utils;

import edu.qingyun.GsonConfig.QueHun.Test.QueHunBasicReturn;
import edu.qingyun.GsonConfig.QueHun.Test.QueHunReturn;

import java.util.HashMap;

/**
 * 模板个人信息
 * @author qingyun
 * @date 2021/12/15
 */
public class TemplatingInfo {

    public static HashMap<String,String> level_start = new HashMap<>();
    public static HashMap<String,String> level_max = new HashMap<>();
    public static HashMap<String,String> judgeLevel = new HashMap<>();

    public static int count = 0;

    public   TemplatingInfo(){
        if (count == 0){
            level_start.put("10203","500");level_start.put("20203","500");level_start.put("10301","600");
            level_start.put("20301","600");level_start.put("10302","700");level_start.put("20302","700");
            level_start.put("10303","1000");level_start.put("20303","1000");level_start.put("10401","1400");
            level_start.put("20401","1400");level_start.put("10402","1600");level_start.put("20402","1600");
            level_start.put("10403","1800");level_start.put("20403","1800");level_start.put("10501","2000");
            level_start.put("20501","2000");level_start.put("10502","3000");level_start.put("20502","3000");
            level_start.put("10503","4500");level_start.put("20503","4500");level_start.put("1070","1000");
            level_start.put("2070","1000");


            level_max.put("10203","1000");level_max.put("20203","1000");level_max.put("10301","1200");
            level_max.put("20301","1200");level_max.put("10302","1400");level_max.put("20302","1400");
            level_max.put("10303","2000");level_max.put("20303","2000");level_max.put("10401","2800");
            level_max.put("20401","2800");level_max.put("10402","3200");level_max.put("20402","3200");
            level_max.put("10403","3600");level_max.put("20403","3600");level_max.put("10501","4000");
            level_max.put("20501","4000");level_max.put("10502","6000");level_max.put("20502","6000");
            level_max.put("10503","9000");level_max.put("20503","9000");level_max.put("1070","2000");
            level_max.put("2070","2000");


            judgeLevel.put("10203","雀士三");judgeLevel.put("20203","雀士三");judgeLevel.put("10301","雀杰一");
            judgeLevel.put("20301","雀杰一");judgeLevel.put("10302","雀杰二");judgeLevel.put("20302","雀杰二");
            judgeLevel.put("10303","雀杰三");judgeLevel.put("20303","雀杰三");judgeLevel.put("10401","雀豪一");
            judgeLevel.put("20401","雀豪一");judgeLevel.put("10402","雀豪二");judgeLevel.put("20402","雀豪二");
            judgeLevel.put("10403","雀豪三");judgeLevel.put("20403","雀豪三");judgeLevel.put("10501","雀圣一");
            judgeLevel.put("20501","雀圣一");judgeLevel.put("10502","雀圣二");judgeLevel.put("20502","雀圣二");
            judgeLevel.put("10503","雀圣三");judgeLevel.put("20503","雀圣三");judgeLevel.put("1070","魂天");
            judgeLevel.put("2070","魂天");
            count++;
        }
    }

    /**
     * 处理Doubel整数
     * @param d
     * @return
     */
    public String handleDoubleToString(Double d){
        return String.format("%.2f", d*100)+"%";
    }


    /**
     * 魂天的特殊处理
     * @param score
     * @return
     */
    public String SpecialHunTian(String score){
        if (score.substring(0,4).equals("1070")){
            return "1070";
        }else if (score.substring(0,4).equals("2070")){
            return "2070";
        }else {
            return score;
        }
    }
    /**
     * 获取当前段位处理
     * @param QueHunReturnBasic
     * @return
     */
    public String GetLevel(QueHunBasicReturn QueHunReturnBasic){
        int score  = QueHunReturnBasic.getLevel().getScore() + QueHunReturnBasic.getLevel().getDelta();
        int level =  QueHunReturnBasic.getLevel().getId();
        String StrLevel = String.valueOf(level); String StrScore = String.valueOf(score);
        if (score < 0){
            if (level % 10 == 1){
                StrLevel = String.valueOf(level - 98);
            }else {
                StrLevel = String.valueOf(level - 1);
            }
            StrScore = level_start.get(SpecialHunTian(StrLevel));
        }else if (score >= Integer.valueOf(level_max.get(SpecialHunTian(StrLevel)))){
            if ( (level % 10) == 3){
                StrLevel = String.valueOf(level + 98);
            }else {
                StrLevel = String.valueOf(level + 1);
            }
            StrScore = level_start.get(SpecialHunTian(StrLevel));
        }
        String message;
        message = "当前段位:  " + judgeLevel.get(SpecialHunTian(StrLevel));
//        if (judgeLevel.get(SpecialHunTian(StrLevel)).contains("魂天")){
//            score = Integer.getInteger(StrScore) / 100;
//        }
//        message = message + "当前PT数: " + score;
        return message;
    }




    /**
     * 生成一个模板化信息
     * @param QueHunReturn
     * @param QueHunReturnBasic
     * @return
     */
    public String TemplatingString(QueHunReturn QueHunReturn, QueHunBasicReturn QueHunReturnBasic){
        String userInfo ;
        int size = QueHunReturnBasic.getRank_rates().size();
        if (size == 4){
            userInfo = "^PS:本数据不包含金之间以下对局以及2019.11.29之前的对局^" +
                    "^^" +
                    "昵称:"+QueHunReturnBasic.getNickname()+"   " +GetLevel(QueHunReturnBasic)+"^" +
                    "^" +
                    "^" +
                    "[四人南基础数据]^" +
                    "^" +
                    "总场次: "+QueHunReturnBasic.getCount()+"^" +
                    "^" +
                    "一位率: "+handleDoubleToString(QueHunReturnBasic.getRank_rates().get(0))+"  二位率: "+handleDoubleToString(QueHunReturnBasic.getRank_rates().get(1))+"^" +
                    "^" +
                    "三位率: "+handleDoubleToString(QueHunReturnBasic.getRank_rates().get(2))+"  四位率: "+handleDoubleToString(QueHunReturnBasic.getRank_rates().get(3))+"^" +
                    "^^^" +
                    "和牌率: "+handleDoubleToString(QueHunReturn.get和牌率())+"  自摸率: "+handleDoubleToString(QueHunReturn.get自摸率())+"   默听率: "+handleDoubleToString(QueHunReturn.get默听率())+"   放铳率: "+handleDoubleToString(QueHunReturn.get放铳率())+"^" +
                    "^" +
                    "副露率: "+handleDoubleToString(QueHunReturn.get副露率())+"  立直率: "+handleDoubleToString(QueHunReturn.get立直率())+"   流局率: "+handleDoubleToString(QueHunReturn.get流局率())+"   流听率: "+handleDoubleToString(QueHunReturn.get流听率())+"^" +
                    "^" +
                    "一发率: "+handleDoubleToString(QueHunReturn.get一发率())+"  里宝率: "+handleDoubleToString(QueHunReturn.get里宝率())+"   先制率: "+handleDoubleToString(QueHunReturn.get先制率())+"   追立率: "+handleDoubleToString(QueHunReturn.get追立率())+"^" +
                    "^" +
                    "平均打点: "+(QueHunReturn.get平均打点())+"  平均铳点: "+(QueHunReturn.get平均铳点())+"   最大连庄: "+(QueHunReturn.get最大连庄())+"    和了巡数: "+String.format("%.2f", QueHunReturn.get和了巡数())+"^" +
                    "^";
        }else {
            userInfo = "^PS:本数据不包含金之间以下对局以及2019.11.29之前的对局^" +
                    "^^" +
                    "昵称:"+QueHunReturnBasic.getNickname()+"   " +GetLevel(QueHunReturnBasic)+"^" +
                    "^" +
                    "^" +
                    "[三人南基础数据]^" +
                    "^" +
                    "总场次: "+QueHunReturnBasic.getCount()+"^" +
                    "^" +
                    "一位率: "+handleDoubleToString(QueHunReturnBasic.getRank_rates().get(0))+"  二位率: "+handleDoubleToString(QueHunReturnBasic.getRank_rates().get(1))+"^" +
                    "^" +
                    "三位率: "+handleDoubleToString(QueHunReturnBasic.getRank_rates().get(2))+
                    "^^^" +
                    "和牌率: "+handleDoubleToString(QueHunReturn.get和牌率())+"  自摸率: "+handleDoubleToString(QueHunReturn.get自摸率())+"   默听率: "+handleDoubleToString(QueHunReturn.get默听率())+"   放铳率: "+handleDoubleToString(QueHunReturn.get放铳率())+"^" +
                    "^" +
                    "副露率: "+handleDoubleToString(QueHunReturn.get副露率())+"  立直率: "+handleDoubleToString(QueHunReturn.get立直率())+"   流局率: "+handleDoubleToString(QueHunReturn.get流局率())+"   流听率: "+handleDoubleToString(QueHunReturn.get流听率())+"^" +
                    "^" +
                    "一发率: "+handleDoubleToString(QueHunReturn.get一发率())+"  里宝率: "+handleDoubleToString(QueHunReturn.get里宝率())+"   先制率: "+handleDoubleToString(QueHunReturn.get先制率())+"   追立率: "+handleDoubleToString(QueHunReturn.get追立率())+"^" +
                    "^" +
                    "平均打点: "+(QueHunReturn.get平均打点())+"  平均铳点: "+(QueHunReturn.get平均铳点())+"   最大连庄: "+(QueHunReturn.get最大连庄())+"    和了巡数: "+String.format("%.2f", QueHunReturn.get和了巡数())+"^" +
                    "^";
        }

        return userInfo;
    }

}
