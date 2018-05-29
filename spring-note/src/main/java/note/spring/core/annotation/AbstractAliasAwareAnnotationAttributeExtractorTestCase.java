package note.spring.core.annotation;

import org.junit.Test;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author qianqian.sun
 * @Date 2017/1/23
 * 描述：
 */
public class AbstractAliasAwareAnnotationAttributeExtractorTestCase {

    @Test
    public void testAliasFor() throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        P p = new P();
//        Method method = ReflectionUtils.findMethod(P.class, "getName");
        Method method = P.class.getDeclaredMethod("getName");
        Config config = method.getAnnotation(Config.class);
        System.out.println(config.value());
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Config {
        @AliasFor("value")
        String name() default "";

        String value() default "18";

        int age() default -1;

    }

    class P {

        @Config(name = "qq")
        void getName() {
        }

        @Config("qq")
        void getValue() {
        }

    }


}
