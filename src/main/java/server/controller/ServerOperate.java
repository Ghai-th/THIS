package server.controller;

/**
 * 0到99999范围内定义不同的操作
 * 所有操作命名全部大写字母加下划线
 */
public interface ServerOperate {

    /**
     * 系统级 指令
     */
    int ERROR = 999999;
    int NULL = 888888;
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
    int SELECT_ALL_COMMENT_NUM = 100008;
    int SELECT_COMMENT_INFO = 100009;

    /**
     * 文章对应操作
     */
    int ADD_ARTICLE = 300001;
    int DELETE_ARTICLE = 300002;
    int UPDATE_ARTICLE = 300003;
    int GET_ARTICLE_BY_AID = 300004;
    int GET_ARTICLE_BY_CID = 300005;
    int GET_ARTICLE_BY_UID = 300006;
    int GET_ARTICLE_BY_TITTLE = 300007;
    int GET_ARTICLE_TOP_TEN = 300008;
    int GET_CLASS_HOT_ARTICLE_TOP_EIGHT = 300009;
    int ARTICLE_NOT_ANY_COMMENT = 300010;
    int SELECT_ARTICLE_INFO = 300011;
    int NONE_ARTICLE = 300012;

    /**
     * User表对应的操作
     */
    int REGISTER_USER = 200001;
    int IS_VALID_USER = 200002;
    int IS_FIND_USER = 200003;
    int ADD_USER = 200004;
    int DELETE_USER = 200005;
    int UPDATE_USER_LEVEL = 200006;
    int UPDATE_FANS_NUM = 200007;
    int UPDATE_ATTENTION_NUM = 200008;
    int UPDATE_VISITOR_NUM = 200009;
    int UPDATE_ARTICLE_NUM = 200010;
    int UPDATE_LAST_LOGIN = 200011;
    int UPDATE_ACTIVE = 200012;
    int UPDATE_USER = 200013;
    int SELECT_USER = 200014;
    int SELECT_USERS = 200015;
    int SELECT_LIMIT_USERS = 200016;
    int SELECT_USERS_INFO = 200017;
    /**
     * message表对应的操作
     */
    int TEST_MESSAGE = 400001;
    int ONLINE_MESSAGE = 400002;
    int WINDING_MESSAGE = 400003;
    int SEND_MESSAGE = 400004;
    int ACCEPT_MAP_MESSAGE = 400005;
    int ACCEPT_LIST_MESSAGE = 400006;

    /**
     * attention表对应的操作
     */
    int ADD_ATTENTION = 500001;
    int DELETE_ATTENTION = 500002;
    int SEARCH_ATTENTION_FANS = 500003;
    int SELECT_ATTENTION_IDOL = 500004;

    /**
     * class表对应的操作
     */
     int SELECT_CLASS_BY_ID = 600001;
     int SELECT_ALL_CLASS = 600002;

    /**
     * store表对应的操作
     */
    int ADD_STORE = 700001;
    int DELETE_STORE = 700002;
    int SELECT_STORE = 700003;

    /**
     * report表对应的操作
     */
    int ADD_REPORT_ARTICLE = 800001;
    int DELETE_REPORT_ARTICLE_BY_AID = 800002;
    int UPDATE_REPORT_ARTICLE = 800003;
    int SELECT_REPORT_ARTICLE_BY_AID = 800004;
    int SELECT_REPORT_ARTICLE = 800005;
};
