package asm03.models;

import asm02.models.Bank;
import asm02.models.Customer;

public class DigitalBank extends Bank {

    // sử dụng lại method isCustomerExisted(CCCD) trong class Bank
    // để tìm Customer trong phương thức này
    public Customer getCustomerById(String customerId) {
        int index = super.isCustomerExisted(customerId);
        if (index > -1)
            return super.getCustomers().get(index);
        return null;
    }

    // Kiểm tra số CCCD nếu chưa tồn tại, thì thêm khách hàng này vào ngân hàng
    public void addCustomer(String customerId, String name) {
        if (super.isCustomerExisted(customerId) == -1)
            super.getCustomers().add(new DigitalCustomer(customerId, name));
        else
            System.out.println("ĐÃ TỒN TẠI số CCCD này !");
    }

    // Giả định rằng bạn ĐÃ có dữ liệu về tất cả các STK của ngân hàng và
    // các STK này KHÔNG trùng nhau.
    // Method này sẽ thực hiện rút tiền dựa trên số CCCD và STK của khách hàng.
    // Vận dụng withdraw() của class DigitalCustomer để thực hiện.
    public void withdraw(String customerId, String accountNumber, double amount) {
        Customer cus = getCustomerById(customerId);
        if (cus != null)
            ((DigitalCustomer) cus).withdraw(accountNumber, amount);
        else
            System.out.println("Không tồn tại khách hàng này !");
    }
}
