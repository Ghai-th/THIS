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



};
