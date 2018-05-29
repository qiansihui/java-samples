package com.javacore.object;

/**
 * @Author: sunqianqian
 * @Description:缓存不可变实例
 * @CodeReviewer:
 */
public class CacheImmutale {
    private final String name;
    private static CacheImmutale[] cache = new CacheImmutale[10];
    //记录缓存实例在缓存中的位置,cache[pos-1]是最新缓存实例
    private static int pos = 0;

    public CacheImmutale(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CacheImmutale valueOf(String name) {
        //遍历缓存对象,若已有相同实例直接返回
        for (int i = 0; i < pos; i++) {
            if (cache[i] != null && cache[i].getName().equals(name)) {
                return cache[i];
            }
        }
        //若缓存已满
        if (pos == 10) {
            cache[0] = new CacheImmutale(name);
            pos = 1;
            return cache[0];
        } else {
            //缓存新创建的对象
            cache[pos++] = new CacheImmutale(name);
            return cache[pos - 1];
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CacheImmutale) {
            CacheImmutale c1 = (CacheImmutale) obj;
            if (name.equals(c1.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public static void main(String[] args) {
        CacheImmutale c1 = CacheImmutale.valueOf("hello");
        CacheImmutale c2 = CacheImmutale.valueOf("hello");
        System.out.println(c1 == c2);   //true
    }
}
