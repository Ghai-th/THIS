package server.controller;

import data.Operate;

public class OperateJudgeExecute {

    private Operate operate;

    public OperateJudgeExecute(Operate operate) {
        this.operate = operate;
    }

    public Operate getOperate() {
        return operate;
    }

    public void setOperate(Operate operate) {
        this.operate = operate;
    }

    public void executeOperate() {
        if (ServerOperate.GET_ALL_ARTICLE.equals(this.operate)) {

        } else if (ServerOperate.ADD_COMMENT.equals(this.operate)) {

        }
    }
}
