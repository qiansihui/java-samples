package sampels.springmvc;

import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sampels.springmvc.domain.Article;
import sampels.springmvc.mapper.ArticleMapper;

import java.util.List;

/**
 * @Author qianqian.sun
 * @Date 2017/5/31
 * 描述：
 */
public class ArticleTest extends ServiceBaseTest {
    @Autowired
    private ArticleMapper articleMapper;
    private Gson gson = new Gson();

    @Test
    public void test() {
        List<Article> articles = articleMapper.selectByExample(null);
        System.out.println(gson.toJson(articles));
    }
}
