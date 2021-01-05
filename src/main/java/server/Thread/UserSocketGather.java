package server.Thread;

import client.entity.User;
import server.util.ServerUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserSocketGather {
    public static Map<User, ServerUtil> userServerUtilMap = new HashMap<User,ServerUtil>();
    public static Iterator iterator = userServerUtilMap.entrySet().iterator();
    /**
     * 插入新的元素
     * @param user
     * @param serverUtil
     */
    public static void addUserServerUtilMap(User user,ServerUtil serverUtil){
        userServerUtilMap.put(user,serverUtil);
    }

    /**
     * 将集合中键值为user的元素删除
     * @param user
     */
    public static void deleteUserServerUtilMap(User user){
        while(iterator.hasNext()){
            Map.Entry<User,ServerUtil> entry = (Map.Entry<User, ServerUtil>) iterator.next();
            if(entry.getKey().getUid().equals(user.getUid())){
                userServerUtilMap.remove(entry.getKey());
            }
        }
    }

    /**
     * 传入user对象取到集合中对应的entry元素
     * @param user
     * @return
     */
    public static Map.Entry<User,ServerUtil> getUserServerUtilMap(User user){
        while(iterator.hasNext()){
            Map.Entry<User,ServerUtil> entry = (Map.Entry<User, ServerUtil>) iterator.next();
            if(entry.getKey().getUid().equals(user.getUid())){
                return entry;
            }
        }
        return null;
    }

}
