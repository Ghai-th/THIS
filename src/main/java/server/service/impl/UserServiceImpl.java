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
            if(u.getUid().equals(user.getUid())&&u.getKey().equals(user.getKey())){
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
    public void updateUserName(String name) {
        dao.updateUserName(name);
    }

    @Override
    public void updateUserPassword(String password) {
        dao.updateUserPassword(password);
    }

    @Override
    public void updateUserGender(Integer gender) {
        dao.updateUserGender(gender);
    }

    @Override
    public void updateUserFansNum(Integer fansNum) {
        dao.updateUserFansNum(fansNum);
    }

    @Override
    public void updateUserAttentionnum(Integer attentionNum) {
        dao.updateUserAttentionnum(attentionNum);
    }

    @Override
    public void updateUserVisitorNum(Integer visitorNum) {
        dao.updateUserVisitorNum(visitorNum);
    }

    @Override
    public void updateUserArticleNum(Integer articleNum) {
        dao.updateUserArticleNum(articleNum);
    }

    @Override
    public void updateUserCreate(Date create) {
        dao.updateUserCreate(create);
    }

    @Override
    public void updateUserUpdate(Date update) {
        dao.updateUserUpdate(update);
    }

    @Override
    public void updateUserSynopsis(String synopsis) {
        dao.updateUserSynopsis(synopsis);
    }

    @Override
    public void updateUserActive(Integer active) {
        dao.updateUserActive(active);
    }

    @Override
    public void updateUserKey(Integer key) {
        dao.updateUserKey(key);
    }

    @Override
    public List<User> selectUsers() {
        return dao.selectUsers();
    }


}
