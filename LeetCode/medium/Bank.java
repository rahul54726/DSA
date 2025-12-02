package com.LeetCode.medium;

public class Bank {
    long[] balance;
    public Bank(long[] balance){
        this.balance = balance;
    }
    public boolean transfer(int account1, int account2, long money) {
        if (account1 > 0 && account1 <= balance.length && account2 > 0 && account2 <= balance.length){
            if (balance[account1 - 1] >= money ){
                balance[account1-1] -= money;
                balance[account2-1]+=money;
                return true;
            }
            else return false;
        }
         else return false;
    }

    public boolean deposit(int account, long money) {
        if (account > 0 && account <=balance.length){
            balance[account -1] += money;
            return true;
        }
        else return false;
    }

    public boolean withdraw(int account, long money) {
        if (account > 0 && account <=balance.length && balance[account-1] >= money){
            balance[account-1]-=money;
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        Bank bank = new Bank(new long[]{92,62,12,81,77,38,71,8,42,38});
        System.out.println(bank.transfer(3,2,18));
        System.out.println(bank.transfer(29,3,99));
        System.out.println(bank.deposit(2,50));
    }
}
