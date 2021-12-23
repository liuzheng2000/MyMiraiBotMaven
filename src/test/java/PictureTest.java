import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PictureTest {

    public static void main(String[] args) throws Exception {

        createImage(

                "nPS:本数据不包含金之间以下对局以及2019.11.29之前的对局n" +
                "nn" +
                "昵称:天才麻将杏杏 当前段位:魂天 当s前pt数: 5611n" +
                "n" +
                "n" +
                "[王座之间四人南基础数据]n" +
                "n" +
                "总场次: 137n" +
                "n" +
                "一位率: 21.9%  二位率: 24.09%n" +
                "n" +
                "三位率: 34.31% 四位率: 19.71%n" +
                "nnn" +
                "和牌率: 21.95% 自摸率: 38.8% 默听率: 12.3% 放铳率: 11.57%n" +
                "n" +
                "副露率: 37.81% 立直率: 18.35% 流局率: 37.81% 流听率: 45.69%n" +
                "n" +
                "一发率: 16.0% 里宝率: 21.6% 先制率: 75.47% 追立率: 24.53%n" +
                "n" +
                "平均打点: 6274 平均铳点: 5192 最大连庄: 4和了巡数: 12.28n" +
                "n", new Font("宋体", Font.BOLD, 20), new File(
                "e:/a.png"), 800, 400);
    }

    /**
     * 根据str,font的样式以及输出文件目录
     * @param str	字符串
     * @param font	字体
     * @param outFile	输出文件位置
     * @param width	宽度
     * @param height	高度
     * @throws Exception
     */
    public static void createImage(String str, Font font, File outFile,
                                   Integer width, Integer height) throws Exception {
        // 创建图片
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.setClip(0, 0, width, height);
        g.setColor(Color.white);
        // 先用黑色填充整张图片,也就是背景
        g.fillRect(0, 0, width, height);
        // 在换成红色
        g.setColor(Color.black);
        // 设置画笔字体
        g.setFont(font);

        // 画出字符串
        int index = 0; int count = 0;
        while (index < str.length()){
            count++;
            int temp = index;
            for (; ; index++) {
                if (str.charAt(index) == 'n'){
                    g.drawString(str.substring(temp,index), 10, 20 + ( count * 15));
                    break;
                }
            }
            index++;
        }

        g.dispose();

        // 输出png图片
        ImageIO.write(image, "png", outFile);
    }

}
