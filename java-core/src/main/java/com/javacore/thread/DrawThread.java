package com.javacore.thread;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class DrawThread extends Thread {
    private Account account;
    private double drawAccount;

    public DrawThread(String name, Account account, double drawAccount) {
        super(name);
        this.account = account;
        this.drawAccount = drawAccount;
    }

    @Override
    public void run() {
       /*使用account作为同步监视器，任何线程进入下面同步代码块之前
       必须先获得对account账户的锁定---其他线程无法获得锁也无法修改
       加锁-->修改完成-->释放锁*/
/*        synchronized (account) {
            if (account.getBalance() >= drawAccount) {
                System.out.println(getName() + "吐槽成功" + drawAccount);
                account.setBalance(account.getBalance() - drawAccount);
                System.out.println("\t余额为：" + account.getBalance());
            } else {
                System.out.println(getName() + "\t取钱失败，余额不足");
            }
        }*/
        for (int i = 0; i < 100; i++) {
            account.draw(drawAccount);
        }
    }

    public static void main(String[] args) {
        Account account = new Account("account.no.1", 100);
        new DrawThread("甲", account, 80).start();
        new DrawThread("乙", account, 80).start();
    }
}
