package com.javacore.object.innerclass;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class Programmer {
    private String name;

    public void work() {
        System.out.println(name + "is coding");
    }

    public Programmer() {
    }

    public Programmer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface Teach {
    void work();
}
