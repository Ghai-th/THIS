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

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        dao.deleteUser(user);
    }

    @Override
    public void updateUserlevel(User user) {
        dao.updateUserlevel(user);
    }

    @Override
    public void updateUserFansNum(User user) {
        dao.updateUserFansNum(user);
    }

    @Override
    public void updateUserAttentionnum(User user) {
        dao.updateUserAttentionnum(user);
    }

    @Override
    public void updateUserVisitorNum(User user) {
        dao.updateUserVisitorNum(user);
    }

    @Override
    public void updateUserArticleNum(User user) {
        dao.updateUserArticleNum(user);
    }

    @Override
    public void updateUserLastLogin(User user) {
        dao.updateUserLastLogin(user);
    }

    @Override
    public void updateUserActive(User user) {
        dao.updateUserActive(user);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public List<User> selectUsers() {
        return dao.selectUsers();
    }


}
