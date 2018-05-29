package note.spring.cases;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author qianqian.sun
 * @Date 2017/1/20
 * 描述：
 */
public class BeanIOC {
    @Test
    public void resources() throws IOException {
        ClassPathResource resource = new ClassPathResource("spring.txt");
        BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
        System.out.println(reader.readLine());
    }
}
