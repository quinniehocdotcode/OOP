import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DanhSachHoaDon {
    private HoaDon[] danhSachHoaDon;
    private int soLuongHoaDon; // Số lượng hóa đơn thực tế
    private static final int MAX_HOA_DON = 50; // Số lượng tối đa hóa đơn

    public DanhSachHoaDon() {
        danhSachHoaDon = new HoaDon[MAX_HOA_DON];
        soLuongHoaDon = 0;
    }

    // Phương thức thêm hóa đơn
    public void themHoaDon() {
        if (soLuongHoaDon < MAX_HOA_DON) {
            HoaDon hoaDon = new HoaDon();
            hoaDon.nhapThongTinHoaDon();
            if ( kiemtraMaHoaDon(hoaDon) == 0){
                System.out.println("Ma hoa don da ton tai, vui long nhap ma hoa don khac ");
            }
            else {
            danhSachHoaDon[soLuongHoaDon] = hoaDon;
            soLuongHoaDon++;
            }
        } else {
            System.out.println("Khong the them hoa don, danh sach da day.");
        }
    }


     public int kiemtraMaHoaDon(HoaDon newHoaDon){
        for ( int i=0; i < soLuongHoaDon; i++){
            if ( newHoaDon.getMaHoaDon().equals(danhSachHoaDon[i].getMaHoaDon())) {
                return 0;
            }
        }
        return 1;
    }

    // Phương thức sửa thông tin hóa đơn
    public void suaHoaDon() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma hoa don can sua: ");
        String maHoaDon = scanner.nextLine();

        for (int i = 0; i < soLuongHoaDon; i++) {
            if (danhSachHoaDon[i].getMaHoaDon().equals(maHoaDon)) {
                danhSachHoaDon[i].suaThongTinHoaDon();
                return;
            }
        }
        System.out.println("Khong tim thay ma hoa don can sua.");
    }

    // Phương thức xóa hóa đơn
    public void xoaHoaDon() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma hoa don can xoa: ");
        String maHoaDon = scanner.nextLine();

        for (int i = 0; i < soLuongHoaDon; i++) {
            if (danhSachHoaDon[i].getMaHoaDon().equals(maHoaDon)) {
                danhSachHoaDon[i] = null;
                for (int j = i; j < soLuongHoaDon - 1; j++) {
                    danhSachHoaDon[j] = danhSachHoaDon[j + 1];
                }
                danhSachHoaDon[soLuongHoaDon - 1] = null;
                soLuongHoaDon--;
                return;
            }
        }
        System.out.println("Khong tim thay ma hoa don can xoa.");
    }


    // Phương thức lưu thông tin hóa đơn vào file text
    private void luuThongTinVaoFile() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < soLuongHoaDon; i++) {
            danhSachHoaDon[i].luuThongTinHoaDonVaoFile("thongtin_hoadon.txt");
        }
        System.out.println("Da luu thong tin vao file ");
    }
    
    
    
    public void xuatThongTinHoaDon1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n----- MENU XUAT THONG TIN HOA DON  -----");
        System.out.println("1. Xem thong tin tat ca hoa don");
        System.out.println("2. Xem thong tin hoa don cu the ( nhap ma hoa don )");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                for (int i = 0; i < soLuongHoaDon; i++) {
                    System.out.println("\nHoa don " + (i + 1) + ":");
                    danhSachHoaDon[i].xuatThongTinHoaDon();
                }
                break;
            case 2:
                scanner.nextLine(); 
                System.out.print("Nhap ma hoa don can xuat thong tin:  ");
                String maHoaDon = scanner.nextLine();

                for (int i = 0; i < soLuongHoaDon; i++) {
                    if (danhSachHoaDon[i].getMaHoaDon().equals(maHoaDon)) {
                        danhSachHoaDon[i].xuatThongTinHoaDon();
                        return;
                    }
                }
                System.out.println("Khong tim thay ma hoa don can xuat thong tin");
                break;
            default:
                System.out.println("Lua chon khong hop le");
        }
    }


   
     public void menuQuanLy() {
            Scanner scanner = new Scanner(System.in);
            int choice;
    
            do {
                System.out.println("\n----- MENU QUAN LY HOA DON -----");
                System.out.println("1. Them hoa don");
                System.out.println("2. Sua hoa don");
                System.out.println("3. Xoa hoa don");
                System.out.println("4. Xuat thong tin hoa don");
                System.out.println("5. Luu thong tin tat ca hoa don vao file text");
                System.out.println("6. Thoat");
                System.out.print("Nhap lua chon cua ban: ");
                choice = scanner.nextInt();
    
                switch (choice) {
                    case 1:
                        themHoaDon();
                        break;
                    case 2:
                        suaHoaDon();
                        break;
                    case 3:
                        xoaHoaDon();
                        break;
                    case 4:
                        xuatThongTinHoaDon1();
                        break;
                    case 5:
                        luuThongTinVaoFile();
                        break;
                    case 6:
                        System.out.println("Da thoat quan ly hoa don");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le");
                }
            } while (choice != 6);
        }
        
        
    }















