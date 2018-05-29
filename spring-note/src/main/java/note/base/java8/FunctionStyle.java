package note.base.java8;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author qianqian.sun
 * @Date 2017/1/22
 * 描述：
 */
public class FunctionStyle {
    @FunctionalInterface
    interface Sum {
        int sum(int[] arrays);
    }

    @Test
    public void functionInterfaceTest() {
        Sum sum = (int[] arrays) -> Arrays.stream(arrays).reduce((a, b) -> a + b).getAsInt();
        int[] a = {1, 2, 4};
        System.out.println(sum.sum(a));
        ;
    }
}
