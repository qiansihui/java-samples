package com.javacore.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author qianqian.sun
 * @Date 2018/3/19
 * 描述：
 */
public class BufferTest {
    public void read() throws IOException {
        // 读取文件
        // 获取通道
        FileInputStream fin = new FileInputStream(BufferTest.class.getResource("/hibernate.cfg.xml").getPath());
        FileChannel fc = fin.getChannel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 将数据从通道读取到缓冲区
        fc.read(buffer);

        System.out.println(new String(buffer.array()));

    }

    public void write() throws IOException {

        // 写入文件
        FileOutputStream fos = new FileOutputStream("out.txt");
        FileChannel fc = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello".getBytes());
        buffer.flip();
        fc.write(buffer);
    }

    public void copy() throws IOException {
        FileInputStream fin = new FileInputStream(BufferTest.class.getResource("/hibernate.cfg.xml").getPath());
        FileChannel fc = fin.getChannel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        FileOutputStream fos = new FileOutputStream("out.xml");
        FileChannel outChannel = fos.getChannel();

        while (fc.read(buffer) != -1) {
            // flip 方法让缓冲区可以将新读入的数据写入另一个通道
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
    }

    public void mapped() throws IOException {
        FileInputStream fin = new FileInputStream("out.xml");
        FileChannel fc = fin.getChannel();
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        mbb.put("hello".getBytes());
        mbb.flip();
    }

    public static void main(String[] args) throws IOException {
        BufferTest test = new BufferTest();
        test.mapped();
    }
}
