package com.javacore.object.innerclass;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class DiscernVariable {
    private String prop = "out class var";

    private class InClass {

        private String prop = "inner class var";

        public void info() {
            String prop = "method var";
            System.out.println("out class var is" + DiscernVariable.this.prop);
            System.out.println("inner class var is " + this.prop);
            System.out.println("method var is " + prop);
        }
    }

    public void test() {
        InClass in = new InClass();
        in.info();
    }

    public static void main(String[] args) {
        InClass inClass = new DiscernVariable().new InClass();
        inClass.info();

    }
}
