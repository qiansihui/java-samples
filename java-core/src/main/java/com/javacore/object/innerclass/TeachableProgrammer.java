package com.javacore.object.innerclass;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class TeachableProgrammer extends Programmer implements Teach {
    public TeachableProgrammer() {
    }

    public TeachableProgrammer(String name) {
        super(name);
    }

    private void teach() {
        System.out.println(getName() + " is teaching....");
    }

    private class Closure implements Teach {

        public void work() {
            teach();
        }
    }

    public Teach getCallbackReferecn() {
        return new Closure();
    }

    public static void main(String[] args) {
        TeachableProgrammer p = new TeachableProgrammer("sqq");
        p.work();
        p.getCallbackReferecn().work();

    }
}
