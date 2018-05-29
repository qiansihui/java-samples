package com.javacore.inout.nio;

import java.nio.CharBuffer;

/**
 * @Author: sunqianqian
 * @Date: 2015/7/6
 * @Description: allocate(capacity) 创建普通Buffer 指定capacity为最大容量 此时Buffer结构如下 0—(已读写区域)——position—(可读写区域)——limit—(不可读写区域)——capacity
 * put() 向position索引位置装入数据，同时position后移（相对），若传入index参数则向index位置装入数据(绝对)position无影响
 * get() 从position索引位置读取数据，同事position后移 (相对)，若传入index参数则从index位置读取数据(绝对)position无影响
 * file() 当装入数据结束后调用，将limit定位到position,position定位到0，为读取数据做准备
 * clear() 输出数据结束后调用，将limit定位到capacity,position定位到limit.为写数据做准备。
 * @CodeReviewer:
 */
public class TestBuffer {
    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(8);
        System.out.println("已经读写区域大小position:" + charBuffer.position() + ",尚未读写区域终点索引limit:" + charBuffer.limit() + ",总容量capacity:" + charBuffer.capacity());
        charBuffer.put('a');
        charBuffer.put('b');
        charBuffer.put('c');
        System.out.println("此时是取出索引为3上的数据，为空：" + charBuffer.get());
        System.out.println("放入abc后->已经读写区域大小position:" + charBuffer.position() + ",尚未读写区域终点索引limit:" + charBuffer.limit() + ",总容量capacity:" + charBuffer.capacity());
        charBuffer.flip();//为从buffer中读取数据做准备
        System.out.println("执行flip后->已经读写区域大小position:" + charBuffer.position() + ",尚未读写区域终点索引limit:" + charBuffer.limit() + ",总容量capacity:" + charBuffer.capacity());
        charBuffer.put('d');
        System.out.println("执行flip后再放一个d->已经读写区域大小position:" + charBuffer.position() + ",尚未读写区域终点索引limit:" + charBuffer.limit() + ",总容量capacity:" + charBuffer.capacity());
        charBuffer.clear();//重置position为0，limit为capacity
        System.out.println("执行clear方法后->已经读写区域大小position:" + charBuffer.position() + ",尚未读写区域终点索引limit:" + charBuffer.limit() + ",总容量capacity:" + charBuffer.capacity());
        System.out.println(charBuffer.get(2));
    }
}
