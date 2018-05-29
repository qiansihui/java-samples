package spring.boot.mybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.mybatis.domain.Article;
import spring.boot.mybatis.domain.ArticleExample;
import spring.boot.mybatis.mapper.ArticleMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author qianqian.sun
 * @Date 2018/1/8
 * 描述：
 */
@RestController
public class ArticleController {

    @Resource
    private ArticleMapper articleMapper;

    @RequestMapping("api/article")
    public List<Article> article() {
        return articleMapper.selectByExampleWithBLOBs(new ArticleExample());
    }
}
