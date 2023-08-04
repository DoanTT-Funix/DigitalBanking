package asm02.models;

import asm03.models.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public Account() {
    }

    public void setAccountNumber(String accountNumber) {
        if (Account.validateAccountNumber(accountNumber))
            this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        if (balance >= 50000)
            this.balance = balance;
        else
            System.out.println("Số dư >= 50_000 VND");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }


    // Kiểm tra hạng của tài khoản
    //true: là tài khoản hạng Premium
    public boolean isPremium() {
        return balance >= 10000000;
    }

    public String toString() {
        String s = String.format("%10s", accountNumber) + "  |" + String.format("%31s", "") +
                String.format("%15s", String.format(Locale.ENGLISH, "%,d", (long) balance) + "đ");
        return s;
    }

    //Static Method kiểm tra Nếu STK là hợp lệ thì trả về True
    //Hợp lệ ở đây là: CHỈ bao gồm 6 kí tự SỐ.
    public static boolean validateAccountNumber(String accountNumber) {
        if (accountNumber.length() != 6) {
            // System.out.println("Số tài khoản chỉ bao gồm 6 kí tự số (0 - 9).");
            return false;
        } else
            for (int i = 0; i < 6; i++) {
                if (accountNumber.charAt(i) < 48 || accountNumber.charAt(i) > 57) {
                    // System.out.println("Số tài khoản chỉ bao gồm 6 kí tự số (0 - 9).");
                    return false;
                }
            }
        return true;
    }
}
