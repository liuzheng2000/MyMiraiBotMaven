package edu.qingyun.Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 *
 * @author qingyun
 * @date 2021/12/16
 */
public class QingYunUtils {

    /**
     * 流转换
     * @param bufferedImage
     * @return
     */
    public static InputStream BufferedImageToInputStream(BufferedImage bufferedImage){
        InputStream inputStream = null;
        try{
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", os);
            inputStream = new ByteArrayInputStream(os.toByteArray());
        }catch (Exception e){
            e.printStackTrace();
        }
        return inputStream;
    }

    /**
     * String[] 转 int[]
     * @param StringArr
     * @return
     */
    public static int[] StringArrToIntArr(String[] StringArr){
        int[] ints = new int[StringArr.length];
        for (int i = 0; i < StringArr.length; i++) {
            ints[i] = Integer.parseInt(StringArr[i]);
        }
        return ints;
    }


    /**
     * 获取网络图片
     */
}
