package server.service.impl;

import client.entity.User;
import server.dao.IUserDao;
import server.dao.impl.UserDaoImpl;
import server.service.IUserService;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImpl implements IUserService {
    IUserDao dao = new UserDaoImpl();
    //注册是否合法
    @Override
    public boolean register(User user) {
        boolean flag =false;
        String id =user.getUid();
        String password= user.getPassword();
        if(idIsValid(id)&&this.passwordIsValid(password))
            flag = true;
        return flag;
    }

    //id是否合法
    public boolean idIsValid(String id){
        boolean flag = false;
        Pattern patter = Pattern.compile("^[a-z]\\d{6}$");
        Matcher matcher = patter.matcher(id);
        if(matcher.matches()){
            flag = true;
        }
        return flag;
    }

    //密码是否合法
    public boolean passwordIsValid(String password) {
        boolean flag = false;
        Pattern pattern = Pattern.compile("^\\w{6,12}$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches())
            flag = true;
        return flag;
    }

    //判断登录是否合法
    @Override
    public boolean isValidUser(User user) {
        List<User> users = dao.selectUsers();
        for(User u:users){
            if(u.getUid().equals(user.getUid())&&u.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

    //判断是否通过验证
    @Override
    public boolean isFind(User user) {
        List<User> users = dao.selectUsers();
        for(User u:users){
            if(u.getUid().equals(user.getUid())&&u.getMyKey().equals(user.getMyKey())){
                return true;
            }
        }
        return false;
    }

    //增删改查
    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(String uid) {
        dao.deleteUser(uid);
    }

    @Override
    public void updateUserName(String uid,String name) {
        dao.updateUserName(uid,name);
    }

    @Override
    public void updateUserlevel(String uid) {
        dao.updateUserlevel(uid);
    }

    @Override
    public void updateUserPassword(String uid,String password) {
        dao.updateUserPassword(uid,password);
    }

    @Override
    public void updateUserGender(String uid,Integer gender) {
        dao.updateUserGender(uid,gender);
    }

    @Override
    public void updateUserFansNum(String uid,Integer fansNum) {
        dao.updateUserFansNum(uid,fansNum);
    }

    @Override
    public void updateUserAttentionnum(String uid,Integer attentionNum) {
        dao.updateUserAttentionnum(uid,attentionNum);
    }

    @Override
    public void updateUserVisitorNum(String uid,Integer visitorNum) {
        dao.updateUserVisitorNum(uid,visitorNum);
    }

    @Override
    public void updateUserArticleNum(String uid,Integer articleNum) {
        dao.updateUserArticleNum(uid,articleNum);
    }

    @Override
    public void updateUserLastLogin(String uid) {
        dao.updateUserLastLogin(uid);
    }

    @Override
    public void updateUserSynopsis(String uid,String synopsis) {
        dao.updateUserSynopsis(uid,synopsis);
    }

    @Override
    public void updateUserActive(String uid,Integer active) {
        dao.updateUserActive(uid,active);
    }

    @Override
    public void updateUserMyKey(String uid,Integer mykey) {
        dao.updateUserMyKey(uid,mykey);
    }

    @Override
    public List<User> selectUsers() {
        return dao.selectUsers();
    }


}
