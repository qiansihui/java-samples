package com.javacore.xml;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * desc
 *
 * @Author: qianqian.sun
 * @Date: 2016/4/11
 */
public class JaxbUtils {
    public static String marshal(Object object) {
        StringWriter writer = new StringWriter();
        JAXB.marshal(object, writer);
        return writer.toString();
    }

    public static <T> T unmarshal(String xml, Class<T> clazz) {
        return JAXB.unmarshal(new StringReader(xml), clazz);
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "闪电";
        person.age = 18;
        String xml = marshal(person);
        System.out.println(xml);
        Person person2 = unmarshal(xml, Person.class);
        System.out.println(person2);
    }

    @XmlRootElement(name = "PERSON")
    static class Person {
        @XmlElement(name = "NAME")
        public String name;
        @XmlElement(name = "AGE")
        public int age;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
