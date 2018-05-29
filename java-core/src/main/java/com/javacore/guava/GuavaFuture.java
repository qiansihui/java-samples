package com.javacore.guava;

import com.google.common.util.concurrent.*;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * @Author qianqian.sun
 * @Date 2017/12/18
 * 描述：
 */
public class GuavaFuture {

    @Test
    public void future() {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newScheduledThreadPool(10));
        ListenableFuture<String> explosion = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                if (RandomUtils.nextInt(0, 10) > 6) throw new RuntimeException("任务执行异常");
                return "qq";
            }
        });
        Futures.addCallback(explosion, new FutureCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("执行成功回调" + s);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("执行失败回调：" + throwable.getMessage());
            }
        });
    }


    @Test
    public void futureList() {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newScheduledThreadPool(10));
        List<ListenableFuture<String>> listenableFutures = new ArrayList<>();

        listenableFutures.add(service.submit(() -> {
            if (RandomUtils.nextInt(0, 10) > 8) throw new RuntimeException("任务执行异常");
            return "qq";
        }));
        listenableFutures.add(service.submit(() -> {
            if (RandomUtils.nextInt(0, 10) > 2) throw new RuntimeException("任务执行异常2");
            return "qq";
        }));

        ListenableFuture<List<String>> successQueries = Futures.successfulAsList(listenableFutures);
        Futures.addCallback(successQueries, new FutureCallback<List<String>>() {
            @Override
            public void onSuccess(List<String> strings) {
                System.out.println("执行成功回调" + strings);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("执行失败回调：" + throwable.getMessage());
            }
        });
    }


}
