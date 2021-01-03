package server;

import server.controller.ServerOperate;
import server.service.IArticleService;
import server.service.impl.ArticleServiceImpl;
import server.util.ServerUtil;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        IArticleService articleService = new ArticleServiceImpl();
        ServerUtil.sendInfoList(articleService.selectTopTenArticle());
    }
}
