package edu.qingyun.redisConfig;


import io.lettuce.core.GetExArgs;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.Date;

/**
 * 获取链接
 */
public class RedisUtils {

    RedisCommands<String, String> redisCommands ;

    /**
     * 每次产生一个新的new 产生一个新的对象
     */
    public RedisUtils() {
        redisCommands = new RedisClientUtils().getRedisCommands();
    }

    /**
     * 关闭当前redis连接
     * @param
     */
    public void RedisUtilsClose(){
        this.redisCommands.getStatefulConnection().closeAsync();
    }


    /**
     * 进行赋值操作
     * @param key
     * @param value
     */
    public void setKeyAndValue(String key , String value){
        //无论是否存在都进行赋值
        this.redisCommands.set(key,value);
    }



    /**
     * 设置CD
     * @param key
     *
     */
    public void SetKeyEx(String key){
        this.redisCommands.setex(key,180,key);
    }


    /**
     * 获取CD
     * @param key
     *
     */
    public String GetKeyEx(String key){
        String time = this.redisCommands.get(key);
        return time;
    }



    /**
     * 进行赋值操作并生成过期时间 默认为42小时  时间单位为秒
     * @param key
     * @param value
     */
    public void setKeyAndValueExTime(String key , long exTime,String value){
        if (0==exTime){
            this.redisCommands.setex(key,151200,value);
        }else {
            this.redisCommands.setex(key,exTime,value);
        }

    }


    /**
     * 进行查找操作
     * @param key
     */
    public String getValueByKey(String key){
        String value = this.redisCommands.get(key);
        return value;
    }


    /**
     * 判断是否存在进行缓存操作
     * @param key
     * @param value
     */
    public void IfNotExistSetKeyAndValue(String key , String value){
        String valueByKey = getValueByKey(key);
        if (null != valueByKey){
            return;
        }else {
            setKeyAndValue(key,value);
        }
    }


}
