package com.javacore.generic;

import java.util.Date;

/**
 * @Author: sunqianqian
 * @Date: 2015/9/25
 * @Description:
 * @CodeReviewer:
 */
public class Employee {
    private String name;
    private double salary;
    private Date hireDate;

    public Employee(String name, double salary, Date hireDate) {
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }
}
