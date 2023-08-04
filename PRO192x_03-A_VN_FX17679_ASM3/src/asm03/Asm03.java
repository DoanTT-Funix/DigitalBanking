package asm03;

import asm02.Asm02;
import asm02.models.Customer;
import asm03.models.DigitalBank;
import asm03.models.DigitalCustomer;
import asm03.models.LoanAccount;
import asm03.models.SavingAccount;
import fx17679.java.asm01.asm01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Asm03 {
    private static final String TEN_PHAN_MEM = "NGAN HANG SO";
    private static final String TAC_GIA = "FX17679";
    private static final String PHIEN_BAN = "@v3.0.0";

    private static final Scanner scan = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "051086012142";
    private static final String CUSTOMER_NAME = "DoanTR";

    // Chức năng 1. Hiển thị thông tin khách hàng
    public static void showCustomer() {
        Customer cus = activeBank.getCustomerById(CUSTOMER_ID);
        if (cus != null)
            cus.displayInformation();
    }

    // Chức năng 2: thêm tài khoản Savings
    public static void themTaiKhoanSavings() {
        String stk = Asm02.nhapHopLeSTK();
        double soDu = Asm02.nhapHopLeSoDu();
        activeBank.addAccount(CUSTOMER_ID, new SavingAccount(stk, soDu));
    }

    // Chức năng 3: Thêm tài khoản LOAN
    public static void themTaiKhoanLoan() {
        String stk = Asm02.nhapHopLeSTK();
        activeBank.addAccount(CUSTOMER_ID, new LoanAccount(stk));
    }


    // Hàm validate số tiền rút - hợp lệ bước 1 - là Số thực > 0
    public static double nhapHopLeSoTienRut() {
        do {
            try {
                System.out.println("Nhập số tiền muốn rút: ");
                double soTienRut = scan.nextDouble();
                if (soTienRut > 0) {
                    scan.nextLine();
                    return soTienRut;
                } else
                    System.out.println("Nhập số tiền rút > 0");
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Nhập số tiền rút > 0");
            }
        } while (true);
    }

    // Chức năng 4: Rút tiền
    public static void rutTien() {
        String stk = Asm02.nhapHopLeSTK();
        double soTienRut = nhapHopLeSoTienRut();
        activeBank.withdraw(CUSTOMER_ID, stk, soTienRut);
    }

    // Chức năng 5: In lịch sử giao dịch
    public static void lichSuGiaoDich() {
        ((DigitalCustomer) activeBank.getCustomerById(CUSTOMER_ID)).displayHistoryTransaction();
    }

    // Phương thức lấy thời điểm giao dịch
    public static String getDateTime() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }

    public static void inMenuChinh() {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| " + TEN_PHAN_MEM + " | " + TAC_GIA + PHIEN_BAN + "                 |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println(" 1. Thong tin khach hang                                  ");
        System.out.println(" 2. Them tai khoan SAVINGS                                  ");
        System.out.println(" 3. Them tai khoan LOAN                                  ");
        System.out.println(" 4. Rut tien                                  ");
        System.out.println(" 5. Lich su giao dich                                  ");
        System.out.println(" 0. Thoat                                      ");
        System.out.println("+----------+-------------------------+----------+");
        System.out.print("Chuc nang: ");
    }

    public static void main(String[] args) {
        activeBank.addCustomer(CUSTOMER_ID, CUSTOMER_NAME);
        do {
            try {
                inMenuChinh();
                switch (asm01.nhapSoHopLe(0, 5)) {
                    case 0:
                        return;
                    case 1:
                        showCustomer();
                        break;
                    case 2:
                        themTaiKhoanSavings();
                        break;
                    case 3:
                        themTaiKhoanLoan();
                        break;
                    case 4:
                        rutTien();
                        break;
                    case 5:
                        lichSuGiaoDich();
                        break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Thông báo lỗi: " + e.getMessage());
                return;
            }
        }
        while (true);
    }
}
