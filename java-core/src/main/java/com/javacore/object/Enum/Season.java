package com.javacore.object.Enum;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class Season {
    private String name;
    private String desc;
    private static final Season SPRING = new Season("spring", "warm");
    private static final Season SUMMER = new Season("summer", "hot");
    private static final Season FAIL = new Season("fail", "cool");
    private static final Season WINTER = new Season("winter", "cold");

    public static Season getSeason(int i) {
        switch (i) {
            case 0:
                return SPRING;
            case 1:
                return SUMMER;
            case 2:
                return FAIL;
            case 3:
                return WINTER;
            default:
                return null;
        }
    }

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
