package fx17679.java.asm01;


import java.lang.Math;
import java.util.InputMismatchException;
//import java.util.NoSuchElementException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class asm01 {
    public static Scanner scan = new Scanner(System.in);
    static final String TEN_PHAN_MEM = "NGAN HANG SO";
    static final String TAC_GIA = "FX17679";
    static final String PHIEN_BAN = "@v1.0.0";
    static final String[] MA_TINH = {"001-Ha Noi"
            , "002-Ha Giang"
            , "004-Cao Bang"
            , "006-Bac Kan"
            , "008-Tuyen Quang"
            , "010-Lao Cai"
            , "011-Dien Bien"
            , "012-Lai Chau"
            , "014-Son La"
            , "015-Yen Bai"
            , "017-Hoa Binh"
            , "019-Thai Nguyen"
            , "020-Lang Son"
            , "022-Quang Ninh"
            , "024-Bac Giang"
            , "025-Phu Tho"
            , "026-Vinh Phuc"
            , "027-Bac Ninh"
            , "030-Hai Duong"
            , "031-Hai Phong"
            , "033-Hung Yen"
            , "034-Thai Binh"
            , "035-Ha Nam"
            , "036-Nam Dinh"
            , "037-Ninh Binh"
            , "038-Thanh Hoa"
            , "040-Nghe An"
            , "042-Ha Tinh"
            , "044-Quang Binh"
            , "045-Quang Tri"
            , "046-Thua Thien Hue"
            , "048-Da Nang"
            , "049-Quang Nam"
            , "051-Quang Ngai"
            , "052-Binh Dinh"
            , "054-Phu Yen"
            , "056-Khanh Hoa"
            , "058-Ninh Thuan"
            , "060-Binh Thuan"
            , "062-Kon Tum"
            , "064-Gia Lai"
            , "066-Dak Lak"
            , "067-Dak Nong"
            , "068-Lam Dong"
            , "070-Binh Phuoc"
            , "072-Tay Ninh"
            , "074-Binh Duong"
            , "075-Dong Nai"
            , "077-Ba Ria Vung Tau"
            , "079-Ho Chi Minh"
            , "080-Long An"
            , "082-Tien Giang"
            , "083-Ben Tre"
            , "084-Tra Vinh"
            , "086-Vinh Long"
            , "087-Dong Thap"
            , "089-An Giang"
            , "091-Kien Giang"
            , "092-Can Tho"
            , "093-Hau Giang"
            , "094-Soc Trang"
            , "095-Bac Lieu"
            , "096-Ca Mau"};
    static final String[] GIOI_TINH_NAM_SINH = {"019", "220", "421", "622", "823",
            "119", "320", "521", "722", "923"};

    //In menu chinh
    public static void inMenuChinh() {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| " + TEN_PHAN_MEM + " | " + TAC_GIA + PHIEN_BAN + "                 |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Nhap CCCD                                  |");
        System.out.println("| 0. Thoat                                      |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.print("Chuc nang: ");
    }

    // In menu chon do kho cua ma xac thuc
    public static void inMenuXacThuc() {
        System.out.println("Chon do kho cua ma xac thuc: ");
        System.out.println("\t| 1. Easy");
        System.out.println("\t| 2. Hard");
        System.out.println("\t| 0. Thoat");
        System.out.print("Chuc nang: ");
    }

    //In menu con (tra cuu cac thong tin lien quan tren CCCD)
    public static void inMenuCon() {
        System.out.println("\t| 1. Kiem tra noi sinh");
        System.out.println("\t| 2. Kiem tra tuoi, gioi tinh");
        System.out.println("\t| 3. Kiem tra so ngau nhien");
        System.out.println("\t| 0. Thoat");
        System.out.print("Chuc nang: ");
    }

    // Tạo 1 số ngẫu nhiên nằm trong đoạn [min, max]
    public static int taoSoNgauNhienMinMax(int min, int max) {
        return min + (int) ((max - min + 1) * Math.random());
    }

    // Tao ma xac thuc
    public static String taoMaXacThuc(int luaChon) {
        // mã xác thực từ 100 đến 999
        if (luaChon == 1) {
            return String.valueOf(taoSoNgauNhienMinMax(100, 999));
        }
        // mã xác thực 6 ký tự [0..9, A..Z, a..z]
        StringBuilder maXacThuc = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            // biến chonNhom = 0: lấy ngẫu nhiên số từ 0 đến 9;
            // biến chonNhom = 1: lấy ngẫu nhiên ký tự từ A đến Z;
            // biến chonNhom = 2: lấy ngẫu nhiên ký tự từ a đến z;
            int chonNhom = taoSoNgauNhienMinMax(0, 2);
            switch (chonNhom) {
                case 0:
                    maXacThuc.append((char) (taoSoNgauNhienMinMax(48, 57)));
                    break;
                case 1:
                    maXacThuc.append((char) (taoSoNgauNhienMinMax(65, 90)));
                    break;
                default:
                    maXacThuc.append((char) (taoSoNgauNhienMinMax(97, 122)));
                    break;
            }
        }
        return maXacThuc.toString();
    }

    // Tìm tên tỉnh thành dựa trên mã tỉnh
    public static String timTenTinh(String maTinh) {
        for (String phanTu : MA_TINH) {
            if (phanTu.startsWith(maTinh)) {
                return phanTu.substring(4);
            }
        }
        return ""; // Chuỗi rỗng là khong tồn tại mã tỉnh
    }

    // Tìm giới tính và năm sinh
    public static String timGioiTinhNamSinh(String cccd) {
        String ketQua = "Gioi tinh: ";
        for (String phanTu : GIOI_TINH_NAM_SINH) {
            // Neu ky tu thu 3 cua cccd ma CHAN thi la Nam va LE thi la Nu
            if (cccd.charAt(3) == phanTu.charAt(0)) {
                if ((cccd.charAt(3)) % 2 == 0) ketQua += "Nam | ";
                else ketQua += "Nu | ";
                ketQua += phanTu.substring(1) + cccd.substring(4, 6);
                break;
            }
        }
        return ketQua;
    }

    // Kiểm tra mã CCCD mà người dùng nhập vào.
    // Nếu không hợp lệ, ghi chi tiết lí do
    public static int kiemTraCCCD(String cccd) {
        if (cccd.length() != 12) return -3; // Không hợp lệ về độ dài
        else {
            for (int i = 0; i < 12; i++) {
                if (cccd.charAt(i) < 48 || cccd.charAt(i) > 57)
                    return -2; // Không hợp lệ vì có chứa ký tự là chữ
            }
        }
        if (timTenTinh(cccd.substring(0, 3)).contentEquals(""))
            return -1; // Không hợp lệ vì không tồn tại mã tỉnh
        else return 0; // Hợp lệ
    }

    // Thực hiện các chức năng tra cứu, sau khi người dùng nhập mã CCCD hợp lệ.
    public static void cacChucNangMenuCon(String cccd) {
        do {
            int chon;
            inMenuCon();
            chon = nhapSoHopLe(0, 3);
            switch (chon) {
                case 0:
                    scan.close();
                    return;
                case 1:
                    System.out.println("Noi Sinh: " + timTenTinh(cccd.substring(0, 3)));
                    break;
                case 2:
                    System.out.println(timGioiTinhNamSinh(cccd));
                    break;
                case 3:
                    System.out.println("So ngau nhien: " + cccd.substring(6));
                    break;
            }
        } while (true);
    }

    // Buộc người dùng nhập các số nguyên nằm trong phạm vi của các menu
    public static int nhapSoHopLe(int min, int max) {
        int chon;
        while (true) {
            try {
                chon = scan.nextInt();
                if (chon < min || chon > max) {
                    scan.nextLine();
                    System.out.println("Vui long nhap SO NGUYEN nam trong doan [" + min + " ... " + max + "]");
                } else {
                    scan.nextLine();
                    return chon;
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Vui long nhap SO NGUYEN nam trong doan [" + min + " ... " + max + "]");
            }
        }
    }

    // Buộc người dùng phải nhập CCCD hợp lệ, hoặc thoát chương trình
    public static String nhapChuoiHopLeCCCD() {
        while (true) {
            String chuoi = scan.nextLine();
            // chuoi la "no"
           // if (chuoi.toLowerCase().contentEquals("no"))
                //return "false";
            // chuoi la ma so cccd hop le
            if (kiemTraCCCD(chuoi) == 0)
                return chuoi;
            else {
                System.out.println("CCD khong hop le. Vui lòng nhập lại: ");
                //System.out.println("Vui long nhap lai, hoac nhap \"No\" de thoat.");
                switch (kiemTraCCCD(chuoi)) {
                    case -3:
                        System.out.println("(Loi: CCCD co do dai KHAC 12 ky tu!)");
                        break;
                    case -2:
                        System.out.println("(Loi: CCCD co chua ky tu KHONG phai la SO!)");
                        break;
                    case -1:
                        System.out.println("(Loi: Khong ton tai MA TINH!)");
                        break;
                }
            }
        }
    }

    // Buộc người dùng nhập ĐÚNG mã xác thực hoặc thoát chương trình
    public static boolean nhapChuoiHopLeMaXacThuc(String maXacThuc) {
        System.out.println("Nhap ma xac thuc: " + maXacThuc);
        while (true) {
            String chuoi = scan.nextLine();
            // chuoi la "no"
            if (chuoi.toLowerCase().contentEquals("no"))
                return false;
            else if (chuoi.contentEquals(maXacThuc)) return true;
            else {
                System.out.println("Ma xac thuc khong dung.");
                System.out.println("Vui long nhap lai, hoac nhap \"No\" de thoat.");
            }
        }
    }


    /*public static void main(String[] args) {
        try {
            inMenuChinh();
            switch (nhapSoHopLe(0, 1)) {
                case 0:
                    return;
                case 1:
                    inMenuXacThuc();
                    int tam = nhapSoHopLe(0, 2);
                    switch (tam) {
                        case 0:
                            return;
                        case 1:
                        case 2:
                            String maXacThuc = taoMaXacThuc(tam);
                            if (!nhapChuoiHopLeMaXacThuc(maXacThuc))
                                return;
                            else {
                                System.out.print("Vui long nhap so CCCD: ");
                                String chuoi = nhapChuoiHopLeCCCD();
                                if (chuoi.contentEquals("false")) return;
                                else {
                                    cacChucNangMenuCon(chuoi);
                                }
                            }
                            break;
                    }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }*/
}