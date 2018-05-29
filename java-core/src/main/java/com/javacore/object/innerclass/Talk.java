package com.javacore.object.innerclass;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class Talk {
    public void talk(Person person) {
        person.say();
    }

    public static void main(String[] args) {
        Talk talk = new Talk();
        talk.talk(new Person() {
            public void say() {
                System.out.println("hi boy");
            }
        });
        final String msg = "day day up";
        Student student = new Student() {
            @Override
            void study() {
                System.out.println(msg);
            }
        };
        student.study();

    }
}
