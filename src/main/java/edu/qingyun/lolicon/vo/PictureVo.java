package edu.qingyun.lolicon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图片
 * @author qingyun
 * @date 2021/12/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PictureVo {


    public String ImagePictureUrl;

    public String pictureUrl;

    public String Similarity;

    public String Creator;

    public String sourced;

    @Override
    public String toString() {
        return "PictureVo{" +
                "ImagePictureUrl='" + ImagePictureUrl + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", Similarity='" + Similarity + '\'' +
                ", Creator='" + Creator + '\'' +
                ", sourced='" + sourced + '\'' +
                '}';
    }
}
