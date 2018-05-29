package com.middleware.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: sunqianqian
 * @Date: 2015/7/16
 * @Description: 应答程序服务端
 * @CodeReviewer:
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        //创建NioEventLoopGroup对象来处理时间，如接受新连接/接收数据/写数据等。
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建ServerBootstrap实例来引导绑定和启动服务器
            ServerBootstrap b = new ServerBootstrap();
            //指定IntetSocketAddress 服务器监听此端口
            //设置childHander执行所有的连接请求
            b.group(group).channel(NioServerSocketChannel.class).localAddress(port).childHandler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel channel) throws Exception {
                    channel.pipeline().addLast(new EchoServerHandler());
                }
            });
            //最后调用ServerBootstrap.bind()方法绑定服务器 sync()方法用来阻塞知道执行完成
            ChannelFuture f = b.bind().sync();
            System.out.println(EchoServer.class.getName() + "started and listen on " + f.channel().localAddress());
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoServer(65535).start();
    }
}
