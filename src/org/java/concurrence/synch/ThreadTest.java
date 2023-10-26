package org.java.concurrence.synch;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/7/31 19:54
 * @Description: <p>
 * <p>
 * 对于给定的步骤数，线程会转账一个随机金额，然后休眠一个随机的延迟时间
 * 两个线程并发执行
 */
public class ThreadTest {
    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(4, 100000);
        Runnable task1 = () ->
        {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0, 1, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {
            }
        };

        Runnable task2 = () ->
        {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(2, 3, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }
    public static class Bank {
        private final double[] accounts;

        /**
         * Constructs the bank.
         *
         * @param n              the number of accounts
         * @param initialBalance the initial balance for each account
         */
        public Bank(int n, double initialBalance) {
            accounts = new double[n];
            Arrays.fill(accounts, initialBalance);
        }

        /**
         * Transfers money from one account to another.
         *
         * @param from   the account to transfer from
         * @param to     the account to transfer to
         * @param amount the amount to transfer
         */
        public void transfer(int from, int to, double amount) {
            if (accounts[from] < amount) return;
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        }

        /**
         * Gets the sum of all account balances.
         *
         * @return the total balance
         */
        public double getTotalBalance() {
            double sum = 0;

            for (double a : accounts)
                sum += a;

            return sum;
        }

        /**
         * Gets the number of accounts in the bank.
         *
         * @return the number of accounts
         */
        public int size() {
            return accounts.length;
        }
    }

}

