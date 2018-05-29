package com.javacore.Internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 * @Author: sunqianqian
 * @Description: 定义下载从start->end的内容的线程
 * @CodeReviewer:
 */
public class DownThread extends Thread {
    //定义水桶长度
    private final int BUFF_LEN = 32;
    //定义下载起点
    private long start;
    //定义下载结束点
    private long end;
    //下载资源对应的输入流
    private InputStream inputStream;
    //将下载的字输出到磁盘文件中
    private RandomAccessFile randomAccessFile;

    public DownThread(long start, long end, InputStream inputStream, RandomAccessFile randomAccessFile) {
        System.out.println(start + "====>" + end);
        this.start = start;
        this.end = end;
        this.inputStream = inputStream;
        this.randomAccessFile = randomAccessFile;
    }

    @Override
    public void run() {
        try {
            inputStream.skip(start);
            randomAccessFile.seek(start);
            //定义读取输入流内容的缓存数组
            byte[] buff = new byte[BUFF_LEN];
            //本线程负责下载资源大小
            long contentLen = end - start;
            //定义最多需要读取几次就可以完成本线程下载
            long times = contentLen / BUFF_LEN + 4;
            //实际多去的字节数
            int hasRead = 0;
            for (int i = 0; i < times; i++) {
                hasRead = inputStream.read(buff);
                if (hasRead < 0) {
                    break;
                }
                randomAccessFile.write(buff, 0, hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
