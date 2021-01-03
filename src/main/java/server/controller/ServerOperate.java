package server.controller;

/**
 * 0到99999范围内定义不同的操作
 * 所有操作命名全部大写字母加下划线
 */
public enum ServerOperate {
    ADD_COMMENT, DELETE_COMMENT, DELETE_COMMENT_BY_UID, DELETE_COMMENT_BY_AID, UPDATE_COMMENT, QUERY_ALL_COMMENT_BY_UID, QUERY_ALL_COMMENT_BY_AID
};
