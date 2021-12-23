package edu.qingyun;

import edu.qingyun.Listener.GroupListener;
import edu.qingyun.Listener.GroupLoliconListener;
import edu.qingyun.Listener.QueHunGroupListener;
import edu.qingyun.configure.properties.ReadProperties;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;

import net.mamoe.mirai.utils.BotConfiguration;

import java.io.File;


public class MiraiBotTest {

    public static String Dir = new ReadProperties().loadResources().get("WorkingDir");

    public static void main(String[] args) {
        Bot MiraiBot = BotFactory.INSTANCE.newBot(Long.parseLong("--"), "--", new BotConfiguration() {{
            //加载登录协议
            setHeartbeatStrategy(HeartbeatStrategy.STAT_HB);
//            修改缓存配置
//            setWorkingDir(new File("/usr/src"));
            setWorkingDir(new File(Dir));
            //设置设备信息
            fileBasedDeviceInfo();
            //开启部分缓存
            ContactListCache contactListCache = new ContactListCache();
            contactListCache.setFriendListCacheEnabled(true);
            contactListCache.setGroupMemberListCacheEnabled(true);
            contactListCache.setSaveIntervalMillis(60000);
        }});
        MiraiBot.login();
        GroupListener.GroupListenerTest();  //普通Group
        GroupListener.GroupBotSendMessageListenerTest(); //Bot消息Group
        QueHunGroupListener.GetUserIDByGroup();  // 雀魂信息查询
        QueHunGroupListener.GetUserIDByGroupTest(); // 雀魂牌谱查询
        GroupLoliconListener.setR18TrueORFalse(); //开启R18选项
        GroupLoliconListener.GetLolicon();  //开启搜图
        GroupLoliconListener.GetPictureByPicture();
        GroupListener.GroupPictureIDSToRedis();
    }
}
