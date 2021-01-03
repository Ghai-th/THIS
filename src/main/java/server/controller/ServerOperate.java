package server.controller;

/**
 * 0到99999范围内定义不同的操作
 * 所有操作命名全部大写字母加下划线
 */
public interface ServerOperate {
    /**
     * 评论功能对应操作
     */
    int ADD_COMMENT = 100001;
    int DELETE_COMMENT = 100002;
    int DELETE_COMMENT_BY_UID = 100003;
    int DELETE_COMMENT_BY_AID = 100004;
    int UPDATE_COMMENT = 100005;
    int QUERY_ALL_COMMENT_BY_UID = 100006;
    int QUERY_ALL_COMMENT_BY_AID = 100007;

    /**
     * 文章对应操作
     */
    int GET_ALL_ARTICLE = 100008;


    /**
     * User表对应的操作
     */
    int REGISTER_USER = 200001;
    int IS_VALID_USER = 200002;
    int IS_FIND_USER = 200003;
    int ADD_USER_BY = 200004;
    int DELETE_USER_BY_ID = 200005;
    int UPDATE_NAME_BY_ID = 200006;
    int UPDATE_LEVEL_BY_ID = 200007;
    int UPDATE_PASSWORD_BY_ID = 200008;
    int UPDATE_GENDER_BY_ID = 200009;
    int UPDATE_FANS_NUM_BY_ID = 200010;
    int UPDATE_ATTENTION_NUM_BY_ID = 200011;
    int UPDATE_VISITOR_NUM_BY_ID = 200012;
    int UPDATE_ARTICLE_NUM_BY_ID = 200013;
    int UPDATE_LAST_LOGIN_BY_ID = 200014;
    int UPDATE_SYNOPSIS_BY_ID = 200015;
    int UPDATE_ACTIVE_BY_ID = 200016;
    int UPDATE_MYKEY_BY_ID = 200017;








};
