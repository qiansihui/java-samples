package com.javacore.Internet;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class InetAddressTest {
    public static void main(String[] args) throws IOException {
        //根据主机名来获取对应InetAddress实例
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        //判断是否可达
        System.out.println("baidu是否可达：" + ip.isReachable(2000));
        //获取该InetAddress实例的IP字符串
        System.out.println("IP字符串:" + ip.getHostAddress());
        //根据原始IP地址获取对应InetAddress实例
        InetAddress local = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        System.out.println("本机是否可达：" + local.isReachable(2000));
        System.out.println("对应全限定域名：" + local.getCanonicalHostName());
    }
}
