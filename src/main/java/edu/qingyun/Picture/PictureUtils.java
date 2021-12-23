package edu.qingyun.Picture;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 自主生成图片
 * @author qingyun
 * @date 2021/12/15
 */
public class PictureUtils {



    /**
     * 根据str,font的样式以及输出文件目录
     * ^   用 ^ 来代替换行符号
     * @param str    字符串
     * @param font    字体
     * @param width    宽度
     * @param height    高度
     * @throws Exception
     * @return
     */
    public static BufferedImage createImage(String str, Font font,
                                            Integer width, Integer height)  {
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
                if (str.charAt(index) == '^'){
                    g.drawString(str.substring(temp,index), 30, 20 + ( count * 15));
                    break;
                }
            }
            index++;
        }

        g.dispose();
        // 输出png图片
        return image;
    }





}
