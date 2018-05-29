package samples.springmvc.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author qianqian.sun
 * @Date 2017/5/27
 * 描述：
 */
@Controller
public class IndexController {

    @RequestMapping("/sample")
    public String sample() {
        return "sample";
    }

    @RequestMapping("/jq-ui")
    public String jqUi() {
        return "jq-ui";
    }

    @RequestMapping("/page")
    public String page() {
        return "page";
    }

}
