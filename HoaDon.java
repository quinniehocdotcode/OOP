import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HoaDon {
    private String maHoaDon;
    private String maKhachHang;
    private String maNhanVien;
    private String ngayLap;
    private String gioLap;
    private int tongTien;
    private ChiTietHoaDon[] chiTietHoaDonList;
    private int soLuongChiTiet; // Số lượng chi tiết hóa đơn thực tế
    private static final int MAX_CHI_TIET = 50; // Số lượng tối đa chi tiết hóa đơn
    private ListProduct product = new ListProduct();

    public HoaDon() {
        this.chiTietHoaDonList = new ChiTietHoaDon[MAX_CHI_TIET];
        this.soLuongChiTiet = 0;
    }

    public HoaDon(String maHoaDon, String maKhachHang, String maNhanVien, String ngayLap, String gioLap) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.ngayLap = ngayLap;
        this.gioLap = gioLap;
        this.chiTietHoaDonList = new ChiTietHoaDon[MAX_CHI_TIET];
        this.soLuongChiTiet = 0;
    }

    // Getters and setters
    
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getGioLap() {
        return gioLap;
    }

    public void setGioLap(String gioLap) {
        this.gioLap = gioLap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    
    public void nhapThongTinHoaDon() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ma hoa don: ");
        this.maHoaDon = scanner.nextLine();

        System.out.print("Nhap ma khach hang: ");
        this.maKhachHang = scanner.nextLine();

        System.out.print("Nhap ma nhan vien: ");
        this.maNhanVien = scanner.nextLine();

        System.out.print("Nhap ngay lap hoa don theo dinh dang ( ngay/thang/nam ): ");
        this.ngayLap = scanner.nextLine();

        System.out.print("Nhap gio lap hoa don theo dinh danh ( gio:phut ):  ");
        this.gioLap = scanner.nextLine();

        System.out.print("Nhap so luong chi tiet hoa don: ");
        this.soLuongChiTiet = scanner.nextInt();
        scanner.nextLine();

        this.chiTietHoaDonList = new ChiTietHoaDon[MAX_CHI_TIET]; // tạo mảng lưu danh sách các chi tiết hóa đơn

        for (int i = 0; i < soLuongChiTiet; i++) {
            ChiTietHoaDon chiTiet = new ChiTietHoaDon();
        int vitri =0;
            System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ":");
            System.out.print("Nhap ma san pham: ");
            product.NhapSP_1(); //// doc file
		    vitri = product.Check(scanner.nextLine());
		    //System.out.println("Nhập mã sản phẩm can mua: "); //
		    // check ma de tro ve vi tri no trong mang sp=> lay dc so tien, 
		    chiTiet.setMaSanPham(product.getMaSp(vitri));
            chiTiet.setDonGia(product.getDonGia(vitri));

            System.out.print("Nhap so luong: ");
            chiTiet.setSoLuong(scanner.nextInt());
            scanner.nextLine();

            //System.out.print("Nhập đơn giá: ");   // tự get từ mã sản phẩm từ danh sách sản phẩm, sửa sau
            // chiTiet.setDonGia(scanner.nextInt());
            //scanner.nextLine();

            chiTiet.setThanhTien(chiTiet.getSoLuong() * chiTiet.getDonGia());

            this.tongTien +=  chiTiet.getThanhTien();
            this.chiTietHoaDonList[i] = chiTiet;
        }
    }

    public void xuatThongTinHoaDon() {
        System.out.println("Ma hoa don: " + this.maHoaDon);
        System.out.println("Ma khach hang: " + this.maKhachHang);
        System.out.println("Ma nhan vien: " + this.maNhanVien);
        System.out.println("Ngay lap hoa don: " + this.ngayLap);
        System.out.println("Gio lap hoa don: " + this.gioLap);
        System.out.println("Tong tien: " + this.tongTien);

        System.out.println("Chi tiet hoa don:");
        for (int i = 0; i < soLuongChiTiet; i++) {
            System.out.println("Chi tiet " + (i + 1) + ":");
            System.out.println("  Ma san pham: " + chiTietHoaDonList[i].getMaSanPham());
            System.out.println("  So luong: " + chiTietHoaDonList[i].getSoLuong());
            System.out.println("  Don gia: " + chiTietHoaDonList[i].getDonGia());
            System.out.println("  Thanh tien: " + chiTietHoaDonList[i].getThanhTien());
        }
    }
    
    
    public void suaThongTinHoaDon() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Thong tin hoa don:");
        xuatThongTinHoaDon();

        System.out.println("\nBan muon sua thong tin nao:");
        System.out.println("1. Thong tin co ban cua hoa don");
        System.out.println("2. Sua thong tin chi tiet hoa don");

        int luaChon = scanner.nextInt();
        scanner.nextLine();

        switch (luaChon) {
            case 1:
                suaThongTinChungHoaDon();
                break;
            case 2:
                suaChiTietHoaDon();
                break;
            default:
                System.out.println("Lua chon khong hop le.");
                break;
        }
    }

    private void suaThongTinChungHoaDon() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap ma khach hang moi: ");
        this.maKhachHang = scanner.nextLine();

        System.out.println("Nhap ma nhan vien moi: ");
        this.maNhanVien = scanner.nextLine();

        System.out.println("Nhap ngay lap hoa don moi (ngay/thang/nam): ");
        this.ngayLap = scanner.nextLine();

        System.out.println("Nhap gio lap hoa don moi (gio:phut): ");
        this.gioLap = scanner.nextLine();

       // System.out.println("Nhập tổng tiền mới: ");
        //this.tongTien = scanner.nextInt();//
    }

    private void suaChiTietHoaDon() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chon so thu tu chi tiet hoa don muon sua:");
        int soThuTu = scanner.nextInt();
        scanner.nextLine();

        if (soThuTu <= soLuongChiTiet && soThuTu > 0) {
            ChiTietHoaDon chiTiet = chiTietHoaDonList[soThuTu - 1];

            System.out.println("Nhap ma san pham moi: ");
            chiTiet.setMaSanPham(scanner.nextLine());

            System.out.println("Nhap so luong moi: ");
            chiTiet.setSoLuong(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Nhap don gia moi: ");
            chiTiet.setDonGia(scanner.nextInt());
            scanner.nextLine();

            chiTiet.setThanhTien(chiTiet.getSoLuong() * chiTiet.getDonGia());
        } else {
            System.out.println("So thu tu khong hop le.");
        }
    }

    
    /*
    private void xuatChiTietHoaDon() {
        System.out.println("Chi tiết hóa đơn:");
        for (int i = 0; i < soLuongChiTiet; i++) {
            System.out.println((i + 1) + ". Mã sản phẩm: " + chiTietHoaDonList[i].getMaSanPham()
                    + ", Số lượng: " + chiTietHoaDonList[i].getSoLuong()
                    + ", Đơn giá: " + chiTietHoaDonList[i].getDonGia());
        }
    }
    */

    
// DELETE
    
    
    //LƯU THÔNG TIN HÓA ĐƠN & CHI TIẾT HÓA ĐƠN VÀO FILE
    public void luuThongTinHoaDonVaoFile(String tenFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tenFile, true))) {
            writer.write("Ma hoa don: " + this.maHoaDon + "\n");
            writer.write("Ma khach hang: " + this.maKhachHang + "\n");
            writer.write("Ma nhan vien: " + this.maNhanVien + "\n");
            writer.write("Ngay lap hoa don: " + this.ngayLap + "\n");
            writer.write("Gio lap hoa don: " + this.gioLap + "\n");
            writer.write("Tong tien: " + this.tongTien + "\n");

            writer.write("Chi tiet hoa don:\n");
            for (int i = 0; i < soLuongChiTiet; i++) {
                ChiTietHoaDon chiTiet = chiTietHoaDonList[i];
                writer.write("Ma san pham: " + chiTiet.getMaSanPham() + "\n");
                writer.write("So luong: " + chiTiet.getSoLuong() + "\n");
                writer.write("Don gia: " + chiTiet.getDonGia() + "\n");
                writer.write("Thanh tien: " + chiTiet.getThanhTien() + "\n");
            }
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("Loi khi ghi vao file: " + e.getMessage());
        }
    }
   
}
    

