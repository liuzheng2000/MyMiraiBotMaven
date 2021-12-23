package edu.qingyun.GsonConfig.QueHun;

import lombok.Data;

/**
 * 四人南 数据
 * 雀魂基本信息返回类
 * @author qingyun
 * @date 2021/12/15
 */
@Data
public class QueHunInfoReturn {

    /**
     * 昵称
     */
    String NickName ;

    /**
     * 当前段位
     */
    String RankLevel ;

    /**
     * 当前PT数
     */
    String PtCount;

    /**
     *总场次
     */
    String Count;


    /**
     * 一位
     */
    String FirstRanking;

    /**
     * 二位
     */
    String SecondRanking;

    /**
     * 三位
     */
    String ThirdRanking;

    /**
     * 四位
     */
    String FourthRanking;

    /**
     * 胡牌率
     */
    String HuPai;

    /**
     * 自摸率
     */
    String ZiMo;

    /**
     * 默听
     */
    String MoTing;

    /**
     * 放铳
     */
    String FangChong;

    /**
     * 副露
     */
    String FuLou;

    /**
     * 立直
     */
    String LiZhi;

    /**
     * 流局
     */
    String LiuJu;

    /**
     * 流听
     */
    String LiuTing;

    /**
     * 一发
     */
    String YiFa;

    /**
     * 里宝
     */
    String LiBao;

    /**
     * 先制
     */
    String XianZhi;

    /**
     * 追求
     */
    String ZhuiLi;

    /**
     * 平均打点
     */
    String PingJunDaDian;

    /**
     * 平均铳点
     */
    String PingJunChongDian;

    /**
     * 最大连庄
     */
    String ZuiDaLianZhuang;

    /**
     * 和了训数
     */
    String HeLeXunShu;


}
