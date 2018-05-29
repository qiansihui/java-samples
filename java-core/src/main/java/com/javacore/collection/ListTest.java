package com.javacore.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class ListTest {
    public static void main(String[] args) {
        List books = new ArrayList();
        books.add(new String("boo_one"));
        books.add(new String("boo_two"));
        System.out.println(books);
        books.set(1, new String("book_2"));
        ListIterator listIterator = books.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
            listIterator.add("----spit----");
        }
        System.out.println(books);

    }
}
