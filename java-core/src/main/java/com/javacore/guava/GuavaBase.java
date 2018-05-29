package com.javacore.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qianqian.sun
 * @Date 2017/12/15
 * 描述：
 */
public class GuavaBase {

    // null 处理
    @Test
    public void optional() {
        Integer i = null;
        if (System.currentTimeMillis() % 2 == 0) {
            i = 5;
        }
        Optional<Integer> possible = Optional.fromNullable(i);
        if (possible.isPresent()) {
            System.out.println(possible.get());
        } else {
            System.out.println(possible.or(8));
        }
    }

    // 前置条件
    @Test
    public void check() {
        Integer i = null;
        if (System.currentTimeMillis() % 2 == 0) {
            i = 5;
        }
        Preconditions.checkNotNull(i, "i==null");
        Preconditions.checkArgument(i > 6, "i<=6");
    }

    // Guava强大的”流畅风格比较器”
    @Test
    public void order() {
        Ordering<User> ordering = new Ordering<User>() {
            @Override
            public int compare(User user, User t1) {
                return ComparisonChain
                        .start()
                        .compare(user.name, t1.name)
                        .compare(user.age, t1.age)
                        .result();
            }
        };
        ordering = Ordering.natural().nullsFirst().onResultOf(user -> user.name);
        Ordering<User> ageOrder = Ordering.natural().reverse().nullsLast().onResultOf(user -> user.age);
        List<User> users = new ArrayList<>();
        users.add(new User(18, "sqq"));
        users.add(new User(25, "sqq2"));
        users.add(new User(25, "sqq"));
        users.add(new User(25, null));
        List<User> list = ordering.compound(ageOrder).sortedCopy(users);
        System.out.println(JSON.toJSON(list));
    }

    class User {
        public Integer age;
        public String name;

        public User(Integer age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
