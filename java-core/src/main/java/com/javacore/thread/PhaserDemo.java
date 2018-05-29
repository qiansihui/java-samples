package com.javacore.thread;

import java.util.concurrent.Phaser;

/**
 * @author qianqian.sun 2018/5/22
 * 描述：
 */
public class PhaserDemo {
    public static void main(String[] args) {
        int parties = 3;
        int phases = 4;

        Phaser phaser = new Phaser(parties) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println(String.format(" ---  Phase: %s ---", phase));
                return registeredParties == 0;
            }
        };

        for (int i = 0; i < parties; i++) {
            int threadId = i;
            Thread thread = new Thread(() -> {
                for (int phase = 0; phase < phases; phase++) {
                    System.out.println(String.format(" Thread %s , phase %s ", threadId, phase));
                    phaser.arriveAndAwaitAdvance();
                }
            });
            thread.start();
        }

    }
}
