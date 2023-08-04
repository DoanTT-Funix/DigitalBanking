package asm02;

import asm02.models.Account;
import asm02.models.Bank;
import asm02.models.Customer;
import fx17679.java.asm01.asm01;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Asm02 {
    public static Scanner scan = new Scanner(System.in);
    static final String TEN_PHAN_MEM = "NGAN HANG SO";
    static final String TAC_GIA = "FX17679";
    static final String PHIEN_BAN = "@v2.0.0";
    private static final Bank bank = new Bank();

    public static void themKhachHang() {
        System.out.println("Nhap ten khach hang: ");
        String name = scan.nextLine();
        System.out.println("Nhap so CCCD: ");
        String cccd = asm01.nhapChuoiHopLeCCCD();
        if (bank.isCustomerExisted(cccd) == -1) {
            Customer cus = new Customer();
            cus.setName(name);
            cus.setCustomerId(cccd);
            bank.addCustomer(cus);
        } else
            System.out.println("Khach hang nay da ton tai !!!");
    }

    public static void hienThiDanhSachKhachHang() {
        List<Customer> curs = bank.getCustomers();
        for (Customer cus : curs)
            cus.displayInformation();
    }

    public static String nhapHopLeSTK() {
        while (true) {
            System.out.println("Nhập số tài khoản. Số tài khoản chỉ bao gồm 6 kí tự số (0 - 9)");
            String stk = scan.nextLine();
            if (Account.validateAccountNumber(stk))
                return stk;
        }
    }

    public static double nhapHopLeSoDu() {
        System.out.println("Nhập số dư >= 50_000 VND");
        while (true) {
            try {
                double soDu = scan.nextDouble();
                if (soDu >= 50000) {
                    scan.nextLine();
                    return soDu;
                } else
                    System.out.println("Vui long nhap số dư >= 50_000 VND");
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Vui long nhap số dư >= 50_000 VND");
            }
        }
    }

    public static String nhapHopLeCCCDCuaNganHang() {
        String cccd;
        System.out.println("Nhap CCCD Khach hang: ");
        while (true) {
            cccd = asm01.nhapChuoiHopLeCCCD();
            //--- trong bài Asm02, đoạn code validate CCCD chạy 2 lần, tối ưu lại sau
            if (bank.isCustomerExisted(cccd) > -1)
                return cccd;
            //----
            else
                System.out.println("CHƯA có khách hàng này. Nhập lại số CCCD khác : ");
        }

    }

    public static void themTaiKhoanKhachHang() {
        String cccd = nhapHopLeCCCDCuaNganHang();
        String stk = nhapHopLeSTK();
        double soDu = nhapHopLeSoDu();
        bank.addAccount(cccd, new Account(stk, soDu));
    }

    public static void timTheoTen() {
        System.out.println("Nhập tên khách hàng:");
        String name = scan.nextLine();
        bank.searchCustomerByName(name);
    }

    public static void timTheoCCCD() {
        System.out.println("Nhập CCCD khách hàng: ");
        String cccd = scan.nextLine();
        bank.searchCustomerByCCCD(cccd);
    }

    public static void inMenuChinh() {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| " + TEN_PHAN_MEM + " | " + TAC_GIA + PHIEN_BAN + "                 |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println(" 1. Them khach hang                                  ");
        System.out.println(" 2. Them tai khoan cho khach hang                                  ");
        System.out.println(" 3. Hien thi danh sach khach hang                                  ");
        System.out.println(" 4. Tim theo CCCD                                  ");
        System.out.println(" 5. Tim theo ten khach hang                                  ");
        System.out.println(" 0. Thoat                                      ");
        System.out.println("+----------+-------------------------+----------+");
        System.out.print("Chuc nang: ");
    }


   /* public static void main(String[] args) {
        while (true) {
            try {
                inMenuChinh();
                switch (asm01.nhapSoHopLe(0, 5)) {
                    case 0:
                        return;
                    case 1:
                        themKhachHang();
                        break;
                    case 2:
                        themTaiKhoanKhachHang();
                        break;
                    case 3:
                        hienThiDanhSachKhachHang();
                        break;
                    case 4:
                        timTheoCCCD();
                        break;
                    case 5:
                        timTheoTen();
                        break;

                }
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }*/

}
