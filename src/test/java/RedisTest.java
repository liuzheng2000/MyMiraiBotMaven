import edu.qingyun.redisConfig.RedisClientUtils;
import edu.qingyun.redisConfig.RedisUtils;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.sync.RedisCommands;

public class RedisTest {
    public static void main(String[] args) {
//        RedisClientUtils redisClientUtils = new RedisClientUtils();
//        RedisCommands<String, String> redisCommands = redisClientUtils.getRedisCommands();
        RedisUtils redisUtils = new RedisUtils();
//        redisUtils.setKeyAndValueExTime("1",1L,"1");/

        redisUtils.SetKeyEx("ll1553385162");
        String ll1553385162 = redisUtils.GetKeyEx("ll1553385162");
        System.out.println(ll1553385162);
//        RedisClientUtils.RedisClientClose();
    }
}
