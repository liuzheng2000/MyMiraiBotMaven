package edu.qingyun.Listener;


import edu.qingyun.redisConfig.RedisUtils;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.GroupMuteAllEvent;
import net.mamoe.mirai.event.events.MemberJoinEvent;
import net.mamoe.mirai.event.events.MessagePostSendEvent;
import net.mamoe.mirai.message.MessageReceipt;
import net.mamoe.mirai.message.data.*;

/**
 * 群消息监听
 * @author qingyun
 * @date 2021/12/13
 */
public class GroupListener {

    /**
     * 测试群消息监听
     */
    public static void GroupListenerTest(){
        GlobalEventChannel.INSTANCE.subscribeAlways(MemberJoinEvent.class, event -> {
            Group group = event.getGroup();
            group.sendMessage("欢迎新成员加入" + group.getName()+"大家庭");
        });
    }


    /**
     * 测试Bot发送消息后消息监听
     */
    public static void GroupBotSendMessageListenerTest(){
        // 创建群消息事件
        Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(MessagePostSendEvent
                .class, event -> {
            MessageReceipt receipt = event.getReceipt();

            MessageSource.recallIn(receipt.getSource(),30000);
//            System.out.println(event.getMessage().get());
        });
    }



    /**
     * 缓存所有图片的地址
     * 将图片地址发送至redis
     */
    public static void GroupPictureIDSToRedis(){
        // 创建群消息事件
        Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent
                .class, event -> {
            MessageChain message = event.getMessage();
            String TypeMessage = message.serializeToMiraiCode();
            //简单判断消息事件类型   将图片格式放入到Redis中    Ids  -  Url
            if (TypeMessage.startsWith("[mirai:image:{")){
                MessageSource messageSource = message.get(MessageSource.Key);
                int id = messageSource.getIds()[0];
                String ImageMessage = TypeMessage.substring(13,55);
                String MessageImageUrl = Image.queryUrl(Image.fromId(ImageMessage));
                RedisUtils redisUtils = new RedisUtils();
                redisUtils.setKeyAndValue(String.valueOf(id),MessageImageUrl);
            }
        });
    }
}
