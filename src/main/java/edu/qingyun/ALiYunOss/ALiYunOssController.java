package edu.qingyun.ALiYunOss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import edu.qingyun.Utils.QingYunUtils;

import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 阿里云OSS控制中心
 * @author qingyun
 * @date 2021/12/16
 */
public class ALiYunOssController {


    final static String endpoint = "--";
    final static String accessKeyId = "--";
    final static String accessKeySecret = "--";

    /**
     * 上传图片流 返回图片地址
     * @param bufferedImage
     * @param userID
     * @return
     */
    public String UploadImage(BufferedImage bufferedImage,String userID){
        QingYunUtils qingYunUtils = new QingYunUtils();
        InputStream inputStream = QingYunUtils.BufferedImageToInputStream(bufferedImage);
// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
// 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
// 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
        ossClient.putObject("qingyun-test", "QueHun/" + userID + ".png",
                inputStream);
// 关闭OSSClient。
        ossClient.shutdown();
        return "https://qingyun-test.oss-cn-hangzhou.aliyuncs.com/QueHun/"+userID+".png?x-oss-process=style/qingyun";
    }



}
