package com.javacore.thread;

/**
 * @Author: sunqianqian
 * @Description:
 * @CodeReviewer:
 */
public class Account {
    private String accountNo;
    private double balance;
    //标志账户中是否有存款
    private boolean flag = false;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public synchronized void draw(double drawAmount) {
        try {
            //若还没存款 flag = false 取款阻塞 等待存款
            if (!flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + " 取钱" + drawAmount);
                balance -= drawAmount;
                System.out.println("余额：" + balance);
                flag = false;
                //唤醒其他线程
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount) {
        try {
            //已经有人存款 存款阻塞 等待取款
            if (flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + "存款" + depositAmount);
                balance += depositAmount;
                System.out.println("余额：" + balance);
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return !(accountNo != null ? !accountNo.equals(account.accountNo) : account.accountNo != null);

    }

    @Override
    public int hashCode() {
        return accountNo != null ? accountNo.hashCode() : 0;
    }
}
