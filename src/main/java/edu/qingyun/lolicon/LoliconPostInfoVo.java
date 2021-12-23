package edu.qingyun.lolicon;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发送的主题Post
 * @author qingyun
 * @date 2021/12/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoliconPostInfoVo {
    //设置是否为R18
    int r18 ;
    //设置返回的数量
    int num ;
    // 设置作者的uid
    int[] uid;
    //设置标签
    String[] tag;

    public LoliconPostInfoVo(int r18, int num, String[] tag) {
        this.r18 = r18;
        this.num = num;
        this.tag = tag;
    }
}
