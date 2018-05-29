package note.spring.core.cglib;

/**
 * @Author qianqian.sun
 * @Date 2017/1/10
 * 描述：
 */
public class Boy implements Person {
    public void say(String name) {
        System.out.println("I am a boy and name is " + name);
    }

    public String age(int age) {
        return String.format("i am %d years old ", age);
    }
}
