package spring.boot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author qianqian.sun
 * @Date 2017/5/10
 * 描述：
 */
@SpringBootApplication
@MapperScan(basePackages = "spring.boot.mybatis.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
