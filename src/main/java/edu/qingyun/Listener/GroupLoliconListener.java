package edu.qingyun.Listener;

import edu.qingyun.Gsonlolicon.LoliconClient;
import edu.qingyun.HttpUtils.HttpUtilsClient;

import edu.qingyun.lolicon.vo.PictureVo;
import edu.qingyun.redisConfig.RedisUtils;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.message.data.*;

import java.util.List;
import java.util.ListIterator;

/**
 * 设置色图  群聊
 * @author qingyun
 * @date 2021/12/19
 */
public class GroupLoliconListener {

    public static String R18 = "0";
    private static LoliconClient loliconClient = new LoliconClient();

    /**
     * 设置是否开启R18  0  1   2
     */
    public static void setR18TrueORFalse() {
        Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
            String message = event.getMessage().contentToString();
            if (message.contains("切换R18") && event.getSender().getId()==1553385162){
                String[] SetR18Array = message.split(" ");
                R18 = SetR18Array[SetR18Array.length - 1];
            }
        });
    }


    /**
     * 获取萝莉色图
     */
    public static void GetLolicon() {
        Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
            System.out.println(event);
            String message = event.getMessage().contentToString();
            //获取是否cd期间
            String CD = loliconClient.GetLoliconCD(String.valueOf(event.getSender().getId()));
            if (message.startsWith("!搜图") && null != CD){
                MessageChainBuilder build = new MessageChainBuilder()
                        .append(new At(event.getSender().getId()))
                        .append("抱歉,ll色图CD期间");
                event.getSubject().sendMessage(build.build());
                return;
            }
            //主要查询逻辑
            if (message.startsWith("!搜图")){
                String[] listenerArray = message.split(" ");
                Object o = loliconClient.GetLoliconPictureUrl(listenerArray[listenerArray.length-1]);
                if (o instanceof String){
                    event.getSubject().sendMessage((String) o);
                }else if(o instanceof List) {
                    List<String> ReturnPictureMap = (List<String>) o;
                    MessageChainBuilder build = new MessageChainBuilder()
                            .append(new At(event.getSender().getId()));
                    for (String PictureUrl : ReturnPictureMap) {
                        build.append(Contact.uploadImage(event.getGroup(),new HttpUtilsClient().GetPictureInPutStreamByUrl(PictureUrl)));
                        event.getSubject().sendMessage(build.build());
                    }
                }
                //设置CD
                loliconClient.SetLoliconCD(String.valueOf(event.getSender().getId()));
            }
        });
    }


    /**
     * 通过获取ids获取图片地址是不可行的，需要进行自定义储存
     * 将所有的图片进行自定义储存
     * 依图搜图
     */
    public static void GetPictureByPicture() {
        GlobalEventChannel.INSTANCE.subscribeAlways(MessageEvent.class, event -> {
            MessageChain message = event.getMessage();
            String PictureUrl = "";
            //进行序列化JSON
//            String messageJson = MessageChain.serializeToJsonString(message);
//            System.out.println(messageJson);
//            MessageSource messageSource = message.get(MessageSource.Key);
//            MessageKey<MessageSource> key = messageSource.getKey();
//            System.out.println(key);
//            MessageChain originalMessage = messageSource.getOriginalMessage();
            //判断是否是回复的消息
            if (message.contentToString().equals(".搜图")&&message.size()==3){
                for (SingleMessage singleMessage : message) {
                    if (singleMessage instanceof QuoteReply){
                        int id = ((QuoteReply) singleMessage).getSource().getIds()[0];
                        RedisUtils redisUtils = new RedisUtils();
                        PictureUrl =  redisUtils.getValueByKey(String.valueOf(id));
                    }
                }
            }else {
                return;
            }
            //当返回Url不为空时
            if (!PictureUrl.equals("")){
                Object o = loliconClient.GetPictureInfo(PictureUrl);
                if (o instanceof PictureVo){
                    event.getSubject().sendMessage(o.toString());
                    return;
                }else {
                    event.getSubject().sendMessage("当前图片未能查找到");
                    return;
                }
            }
        });
    }




}
