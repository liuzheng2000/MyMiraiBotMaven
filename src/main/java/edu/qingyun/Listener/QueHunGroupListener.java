package edu.qingyun.Listener;
import edu.qingyun.Utils.QingYunUtils;
import edu.qingyun.pattern.PatternUserID;
import edu.qingyun.quehun.QueHunClient;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;

/**
 * 雀魂群功能测试
 * @author qingyun
 * @date 2021/12/14
 */
public class QueHunGroupListener {

    private static QueHunClient queHunClient = new QueHunClient();


    /**
     * 获取个人信息
     */
    public static void GetUserIDByGroup(){
        // 创建群消息事件
        Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
            MessageChain chain = event.getMessage(); // 可获取到消息内容等, 详细查阅 `GroupMessageEvent`
            String message = chain.contentToString();
            Image image = null;  InputStream inputStream = null;
            //通过" "进行分割
            String[] messageList = message.split(" ");
            if (messageList[0].contains("查询")){
                String userID = queHunClient.GetUserIdToRedis(messageList[messageList.length-1],messageList[0]);
                //判断字符
                Matcher inNum = PatternUserID.getNumberPattern().matcher(userID);

                if (inNum.matches()){
                    inputStream  = QingYunUtils.BufferedImageToInputStream(queHunClient.GetUserInfoByUserID(messageList[0],userID));
                    try{
//                    URL urlFile = new URL(returnPictureUrl);
//                    inputStream = urlFile.openStream();
                        image = Contact.uploadImage(event.getGroup(),inputStream);
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    MessageChain build = new MessageChainBuilder()
                            .append(new At(event.getSender().getId()))
                            .append(image)
                            .build();
                    event.getSubject().sendMessage(build);
                }else {
                    event.getSubject().sendMessage("用户可能不存在");
                }
            }
        });
    }



    /**
     * 获取牌谱信息
     */
    public static void GetUserIDByGroupTest(){
        // 创建群消息事件
        Listener listener = GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event -> {
            MessageChain chain = event.getMessage(); // 可获取到消息内容等, 详细查阅 `GroupMessageEvent`
            String message = chain.contentToString();
            //通过" "进行分割
            String[] messageList = message.split(" ");

            if (messageList[0].contains("牌谱")){
                String userID = queHunClient.GetUserIdToRedis(messageList[messageList.length-1],messageList[0]);
                //判断字符
                Matcher inNum = PatternUserID.getNumberPattern().matcher(userID);

                if (inNum.matches()){
                    MessageChain build = new MessageChainBuilder()
                            .append(new At(event.getSender().getId()))
                            .append(queHunClient.GetCardSpectrumByUserID(messageList[0],userID))
                            .build();
                    event.getSubject().sendMessage(build);
                }else {
                    event.getSubject().sendMessage("用户可能不存在");
                }
            }
        });
    }

}
