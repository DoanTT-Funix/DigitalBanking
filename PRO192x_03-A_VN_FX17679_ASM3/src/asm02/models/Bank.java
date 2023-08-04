package asm02.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private final String id;
    private final List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        this.id = String.valueOf(UUID.randomUUID());
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    // Kiểm tra số CCCD của khách hàng ĐÃ TỒN TẠI trong
    // ngân hàng hay chưa? Nếu TỒN TẠI thì return giá trị >-1
    // Giá trị này cũng chính là index của khách hàng trong List<Customer>
    // return -1 nghĩa là CHƯA TỒN TẠI
    public int isCustomerExisted(String customerId) {
        List<Customer> curs = getCustomers();
        ArrayList<String> cccdS = new ArrayList<>();
        for (Customer cus : curs)
            cccdS.add(cus.getCustomerId());
        return cccdS.indexOf(customerId);
    }

    // Method Kiểm tra Nếu STK CHƯA TỒN TẠI thì trả về -1
    public int isAccountExisted(String soTaiKhoan) {
        List<Customer> curs = getCustomers();
        ArrayList<Account> accS = new ArrayList<>();
        ArrayList<String> stkS = new ArrayList<>();
        for (Customer cus : curs)
            accS.addAll(cus.getAccounts());
        //  System.out.println("Chi muc cua khach nay trong bank: "+cccdS.indexOf(customerId));
        for (Account acc : accS)
            stkS.add(acc.getAccountNumber());
        return stkS.indexOf(soTaiKhoan);
    }

    // Kiểm tra nếu khách hàng CHƯA tồn tại,
    // thì thêm khách hàng mới này vào ngân hàng
    public void addCustomer(Customer newCustomer) {
        if(isAccountExisted(newCustomer.getCustomerId()) == -1)
            customers.add(newCustomer);
        else
            System.out.println("Khách hàng này đã tồn tại !");
    }

    // Kiểm tra nếu CÓ khách hàng và CHƯA TỒN TẠI stk
    // thì thực hiện addAccount STK này cho khách hàng này
    // vào hệ thống ngân hàng. Vận dụng addAcount() của class
    // Customer để thực hiện
    public void addAccount(String customerId, Account account) {
        int indexCus = isCustomerExisted(customerId);
        if (indexCus > -1) {
            if (isAccountExisted(account.getAccountNumber()) == -1)
                customers.get(indexCus).addAccount(account);
            else {
                System.out.println("STK đã tồn tại.");
            }
        } else
            System.out.println("Không tồn tại Khách hàng này !");
    }

    public void searchCustomerByCCCD(String customerId) {
        int indexCus = isCustomerExisted(customerId);
        List<Customer> curs = getCustomers();
        if (indexCus == -1)
            System.out.println("Không tồn tại khách hàng này !!!");
        else
            curs.get(indexCus).displayInformation();
    }

    public void searchCustomerByName(String name) {
        List<Customer> curs = getCustomers();
        for (Customer cus : curs) {
            if (cus.getName().contains(name) || name.contains(cus.getName())) {
                cus.displayInformation();
            }
        }
    }
}
