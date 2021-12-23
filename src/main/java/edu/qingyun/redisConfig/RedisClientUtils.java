package edu.qingyun.redisConfig;


import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * 创建Redis连接
 * @author qingyun
 * @date 2021/12/14
 */
public class RedisClientUtils {

    /**
     * //创建一个Redis客户端 连接
     */
    public static RedisClient redisClient =
            RedisClient.create(RedisURI.Builder.redis("81.68.226.200", 6379).
                    withPassword("2MCFxMzyqyVQTFghUwo9sNMTDE+KuZYbt5/p21SqLvvWTry0p7lVWtciTt2D5QpA1voRt1Dnv".toCharArray()).build());

    /**
     * 获取客户端对象
     * @return
     */
    public static RedisClient getRedisClient() {
        return redisClient;
    }

    /**
     * 关闭客户端对象
     */
    public static void RedisClientClose(){
        redisClient.shutdownAsync();
    }


    /**
     * 创建一个redis连接
     * @return
     */
    public  RedisCommands<String, String>  getRedisCommands(){
        return redisClient.connect().sync();
    }






}
