package com.middleware.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author: sunqianqian
 * @Date: 2015/7/16
 * @Description: 应答程序客户端
 * @CodeReviewer:
 */
public class EchoClient {
    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws InterruptedException {
        //创建EventLoopGroup对象并设置到Bootstrap中，EventLoopGroup可理解为线程池，用来处理连接，接收数据发送数据
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建Bootstrap对象来引导启动客户端
            Bootstrap b = new Bootstrap();
            //创建InetSocketAddress并设置到BootStrap中,InetSocketAddress是只指定连接服务器的地址
            //添加一个ChannelHandler,客户端成功连接服务器后就会被执行
            b.group(group).channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress(host, port)).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new EchoClientHandler());
                }
            });
            //调用Bootstrap.connect()来连接服务器
            ChannelFuture f = b.connect().sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //最后关闭EventLoopGroup来释放资源
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoClient("127.0.0.1", 65535).start();
    }

}
