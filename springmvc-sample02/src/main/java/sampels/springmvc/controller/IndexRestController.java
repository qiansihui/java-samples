package sampels.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sampels.springmvc.mapper.ArticleMapper;

import java.util.HashMap;

/**
 * @Author qianqian.sun
 * @Date 2017/5/27
 * 描述：
 */
@RestController
public class IndexRestController {
    @Autowired
    private ArticleMapper articleMapper;

    @RequestMapping("/api")
    public HashMap api() {
        return new HashMap<String, Object>() {{
            put("articles", articleMapper.selectByExample(null));
        }};
    }
}
