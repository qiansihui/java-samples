package spring.boot.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author qianqian.sun
 * @Date 2017/5/10
 * 描述：
 */
@Controller
@EnableAutoConfiguration
public class Application {

    @RequestMapping("/")
    String home() {
        return "index.html";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
