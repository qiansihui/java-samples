package note.spring.core.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 92055
 * @Date 2017/1/10
 * 描述：jdk动态代理
 */
public class JdkProxy {
    @Test
    public void testProxy() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(Girl.class.newInstance(), args[0]);
            }
        };

        Class<?> proxyClass = Proxy.getProxyClass(Person.class.getClassLoader(), Person.class);
        Person boy = (Person) proxyClass.getConstructor(InvocationHandler.class).newInstance(handler);
        boy.say("sqq");
    }

    @Test
    public void testProxySimple() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Person boy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(Boy.class.newInstance(), args);
            }
        });
        boy.say("sqq");
    }

    @Test
    public void testCglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Boy.class);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return methodProxy.invokeSuper(o, objects);
            }
        });
        Boy boy = (Boy) enhancer.create();
        boy.say("sqq");
        System.out.println(boy.age(22));
    }


}
