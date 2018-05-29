package com.javacore.object.Reference;

/**
 * @Author: sunqianqian
 * @Date: 2016/1/28
 */
public class Gener {
    interface A {

    }

    class B implements A {
        private String sex;

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }

    public void test() {
        A a = new A() {
        };
        System.out.println(a);
        B b = (B) a;
        System.out.println(b);
    }


    public static void main(String[] args) {
        System.out.println(false || test2());
    }

    public static boolean test2() {
        System.out.println("lu guo");
        return true;
    }
}
