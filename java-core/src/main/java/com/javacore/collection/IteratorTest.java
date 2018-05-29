package com.javacore.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class IteratorTest {
    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add("book_one");
        books.add("book_two");
        Iterator iterator = books.iterator();
        while (iterator.hasNext()) {
            String book = (String) iterator.next();
            System.out.println(book);
            if (book.equals("book_one")) {
                iterator.remove();
            }
        }
        System.out.println(books);

    }
}
