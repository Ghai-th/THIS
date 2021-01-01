package frame.modle.panel;

import conf.IndexConf;
import entity.Article;
import entity.User;
import frame.modle.label.ArticleTittleLabel;

import javax.swing.*;
import java.awt.*;

public class ArticleDetailsPanel extends JPanel implements IndexConf {

    public JPanel upPanel, downPanel;
    public Article article;
    public ArticleTittleLabel tittleLabel;

    public ArticleDetailsPanel(Article article) {
        super();
        this.article = article;
        /////添加数据库连接时 注释以下
        this.article = Article.initArticle();
        init();
    }

    private void init() {


    }


}
