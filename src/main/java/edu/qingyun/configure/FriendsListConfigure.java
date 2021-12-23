package edu.qingyun.configure;


import lombok.RequiredArgsConstructor;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.ContactList;
import net.mamoe.mirai.contact.Friend;

import java.util.HashMap;
import java.util.Map;

/**
 *好友配置类
 * @author qingyun
 * @date 2021/12/13
 */
@RequiredArgsConstructor
public class FriendsListConfigure {
    public static ContactList<Friend> FriendList = new ContactList<Friend>();
    public static Map<Long,Friend> FriendCache =  new HashMap();

    /**
     * 获取全体好友列表
     */
    public static void setFriendsList(Bot MiraiBot){
        FriendList = MiraiBot.getFriends();
        SetFriendCacheMap();
    }

    /**
     * 创建 Map<Long,Friend> QQ对象
     */
    private static void SetFriendCacheMap(){
        for (Friend friend : FriendList) {
            FriendCache.put(friend.getId(),friend);
        }
    }

    /**
     * 用ID获取Friend
     *
     * @param id QQ号
     * @return User对象
     */
    public Friend getUserFromID(long id)
    {
        return FriendCache.get(id);
    }



}
