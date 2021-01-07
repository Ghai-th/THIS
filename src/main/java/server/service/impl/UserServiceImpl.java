package server.service.impl;

import client.entity.Article;
import client.entity.User;
import server.dao.IUserDao;
import server.dao.impl.UserDaoImpl;
import server.service.IUserService;

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

    //判断登陆是否合法
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
    public List<User> selectUsersInfo() {
        return dao.selectUsersInfo();
    }

    @Override
    public boolean addUser(User user) {
        return dao.addUser(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return dao.deleteUser(user);
    }

    @Override
    public boolean updateUserlevel(User user) {
        return dao.updateUserlevel(user);
    }

    @Override
    public boolean updateUserFansNum(User user) {
       return dao.updateUserFansNum(user);
    }

    @Override
    public boolean updateUserFanNum(User user) {
        return dao.updateUserFanNum(user);
    }

    @Override
    public boolean updateUserAttentionnum(User user) {
        return dao.updateUserAttentionnum(user);
    }

    @Override
    public boolean updateUserVisitorNum(User user) {
        return dao.updateUserVisitorNum(user);
    }

    @Override
    public boolean updateUserArticleNum(User user) {
        return dao.updateUserArticleNum(user);
    }

    @Override
    public boolean updateUserLastLogin(User user) {
        return dao.updateUserLastLogin(user);
    }

    @Override
    public boolean updateUserActive(User user) {
        return dao.updateUserActive(user);
    }

    @Override
    public boolean updateUser(User user) {
        return dao.updateUser(user);
    }

    @Override
    public User selectUser(User user) {
        return dao.selectUser(user);
    }

    @Override
    public List<User> selectTopLimitUsers(int limit) {
        return dao.selectTopLimitUsers(limit);
    }


    @Override
    public List<User> selectUsers() {
        return dao.selectUsers();
    }


}
