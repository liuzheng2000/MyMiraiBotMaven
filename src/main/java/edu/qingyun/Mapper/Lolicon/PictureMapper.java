package edu.qingyun.Mapper.Lolicon;

import edu.qingyun.lolicon.vo.PictureVo;

/**
 * 萝莉Picture返回 以图搜图 Picture返回
 * @author qingyun
 * @date 2021/12/27
 */
public interface PictureMapper {

    /**
     * 查找数据库中是否存在
     * @param PictureUrl
     * @return
     */
    PictureVo selectPicture(String PictureUrl);

    /**
     * 放入数据库中
     * @param pictureVo
     * @return
     */
    int InsertPictureVO(PictureVo pictureVo);
}
