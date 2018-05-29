package note.spring.core.objenesis;

import note.spring.core.cglib.Boy;
import org.junit.Test;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;
import org.springframework.objenesis.instantiator.ObjectInstantiator;

/**
 * @Author qianqian.sun
 * @Date 2017/1/10
 * 描述：objenesis是一个小型Java类库用来实例化一个特定class的对象。
 */
public class ObjenesisTest {
    @Test
    public void test() {
        Objenesis objenesis = new ObjenesisStd();
        ObjectInstantiator<Boy> boyInstantiator = objenesis.getInstantiatorOf(Boy.class);
        Boy boy = boyInstantiator.newInstance();
        Boy boy2 = boyInstantiator.newInstance();
        boy.say("sqq01");
        boy2.say("sqq02");
    }
}
