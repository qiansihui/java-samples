package sampels.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author qianqian.sun
 * @Date 2017/5/27
 * 描述：
 */
@Controller
public class IndexController {
    @RequestMapping("/page")
    public String page() {
        return "page";
    }
}
