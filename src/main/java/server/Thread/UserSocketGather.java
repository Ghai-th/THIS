package server.Thread;

import client.entity.Message;
import client.entity.User;
import server.util.MessageServerUtil;
import server.util.ServerUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserSocketGather {
    public static Map<User, MessageServerUtil> userMessageServerUtilMap = new HashMap<User,MessageServerUtil>();
    public static Iterator iterator;
    /**
     * 插入新的元素
     * @param user
     * @param messageServerUtil
     */
    public static void addUserServerUtilMap(User user, MessageServerUtil messageServerUtil){
        userMessageServerUtilMap.put(user,messageServerUtil);
    }

    /**
     * 将集合中键值为user的元素删除
     * @param user
     */
    public static void deleteUserServerUtilMap(User user){
        iterator = userMessageServerUtilMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<User,ServerUtil> entry = (Map.Entry<User, ServerUtil>) iterator.next();
            if(entry.getKey().getUid().equals(user.getUid())){
                userMessageServerUtilMap.remove(entry.getKey());
            }
        }
    }

    /**
     * 传入user对象取到集合中对应的entry元素
     * 若为空则返回空
     * @param user
     * @return
     */
    public static Map.Entry<User,MessageServerUtil> getUserMessageServerUtil(User user){
        iterator = userMessageServerUtilMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<User,MessageServerUtil> entry = (Map.Entry<User, MessageServerUtil>) iterator.next();
            if(entry.getKey().getUid().equals(user.getUid())){
                return entry;
            }
        }
        return null;
    }

}
