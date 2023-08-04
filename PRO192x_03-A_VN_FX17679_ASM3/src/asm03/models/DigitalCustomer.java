package asm03.models;

import asm02.models.Account;
import asm02.models.Customer;

import java.util.List;


public class DigitalCustomer extends Customer {

    public DigitalCustomer(String customerId, String name) {
        super(customerId, name);
    }

    // tìm trong List STK của khách hàng HIỆN TẠI
    // nếu CÓ thì thực hiện rút tiền
    public void withdraw(String accountNumber, double amount) {
        List<Account> accs = super.getAccounts();
        for (Account acc : accs) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                ((Withdraw) acc).withdraw(amount); // vận dụng đa hình
                return;
            }
        }
        System.out.println("Không tồn tại Số tài khoản này");
    }

    // in lịch sử giao dịch
    public void displayHistoryTransaction() {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| " + "LỊCH SỬ GIAO DỊCH " + "                  |");
        System.out.println("+----------+-------------------------+----------+");
        this.displayInformation();
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("| " + String.format("%10s", "Số tài khoản") + "  |" +
                String.format("%15s", "Số tiền rút") + "  |" +
                String.format("%10s", "Thuế + Phí") + "  |" +
                String.format("%15s", "Số dư") + "  |" +
                String.format("%18s", "Thời gian") + "  |");
        //System.out.println("--------------------------------------------------------------------------------------");
        for (Account acc : super.getAccounts()) {
            System.out.println("--------------------------------------------------------------------------------------");
            for (Transaction trs : acc.getTransactions())
                System.out.println(trs.toString());
        }

    }

}
