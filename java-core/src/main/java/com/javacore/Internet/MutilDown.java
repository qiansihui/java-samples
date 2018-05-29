package com.javacore.Internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: sunqianqian
 * @Description:多线程下载
 * @CodeReviewer:
 */
public class MutilDown {
    public static void main(String[] args) {
        final int DOWN_THREAD_NUM = 4;
        final String OUT_FILE_NAME = "dog.jpg";
        InputStream[] isArr = new InputStream[DOWN_THREAD_NUM];
        RandomAccessFile[] outArr = new RandomAccessFile[DOWN_THREAD_NUM];
        try {
            //创建一个URL对象
            URL url = new URL("http://e.hiphotos.baidu.com/image/pic/item/7aec54e736d12f2efdcba76d4dc2d562843568f4.jpg");
            //以此URL对象打开第一个输入流
            isArr[0] = url.openStream();
            long fileLen = getFileLength(url);
            System.out.println("网络资源大小：" + fileLen);
            //以输出文件名创建第一个RandomAccessFile输出流
            outArr[0] = new RandomAccessFile(OUT_FILE_NAME, "rw");
            //创建一个与下载资源相同大小的空文件
            for (int i = 0; i < fileLen; i++) {
                outArr[0].write(0);
            }
            //每个线程应该下载的字节数
            long numPerThred = fileLen / DOWN_THREAD_NUM;
            //整个下载资源整除后剩下的余数
            long left = fileLen % DOWN_THREAD_NUM;
            for (int i = 0; i < DOWN_THREAD_NUM; i++) {
                //为每个线程打开一个输入流，一个RandomAccessFile对象
                if (i != 0) {
                    //以URL打开多个输入流
                    isArr[i] = url.openStream();
                    //以指定输出文件创建多个RandomAccessFile对象
                    outArr[i] = new RandomAccessFile(OUT_FILE_NAME, "rw");
                }
                //分别启动多个线程来下载网络资源
                if (i == DOWN_THREAD_NUM - 1) {
                    //最后一个线程下载指定numPerThred+left个字节
                    new DownThread(i + numPerThred, (i + 1) * numPerThred + left, isArr[i], outArr[i]).start();
                } else {
                    new DownThread(i + numPerThred, (i + 1) * numPerThred, isArr[i], outArr[i]).start();
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getFileLength(URL url) throws IOException {
        long length = 0;
        //打开该URL对应的URLConnection
        URLConnection connection = url.openConnection();
        //获取链接URL资源的长度
        long size = connection.getContentLength();
        length = size;
        return length;
    }
}
