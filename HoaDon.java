
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class HoaDon {
	private ChiTietHoaDon []ChiTietHoaDons = new ChiTietHoaDon[100];
	private String maHD;
	private String maNV;
	private String maKH;
	private int tongTien;
	private int gio;
	private int phut;
	private int ngay;
	private int thang;
	private int nam;
	private int n;
	Scanner sc = new Scanner(System.in);

	public HoaDon() {}
	
	public HoaDon(String maHD, String maNV, String maKH, int tongTien, int gio, int phut, int ngay, int thang,
			int nam) {
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKH = maKH;
		this.gio = gio;
		this.phut = phut;
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}
	
	public void them_chi_tiet_hd(){
		System.out.print("So luong chi tiet hoa don:");
		n = sc.nextInt();
		for(int i = 0; i < n; i++ ){
			ChiTietHoaDons[i] = new ChiTietHoaDon();
			ChiTietHoaDons[i].Nhap_chi_tiet_hoa_don();
		}
	}
    void Them_hoa_don () { /// them thong tin vao hoa don
		sc.nextLine();
		System.out.print("Nhập mã hóa đơn: ");
		setMaHD(sc.nextLine());
		System.out.print("Nhập mã nhân viên: ");
		setMaNV(sc.nextLine());
		System.out.print("Nhập mã khách hàng: ");
		setMaKH(sc.nextLine());
		// System.out.println("Nhập ngày: ");
		// setNgay(sc.nextInt());
		// sc.nextLine();
		// System.out.println("Nhập tháng: ");
		// setThang(sc.nextInt());
		// sc.nextLine();
		// System.out.println("Nhập năm: ");    // comment để đỡ nhập nhiều.
		// setNam(sc.nextInt());
		// sc.nextLine();
		// System.out.println("Nhập giờ: ");
		// setGio(sc.nextInt());
		// sc.nextLine();	
		// System.out.println("Nhập phút: ");
		// setPhut(sc.nextInt());
		// sc.nextLine();
	}
	
	public void Xuat_Thong_Tin_Hoa_Don() { /// chỗ này xuất vào file liệu có hợp lý.
		System.out.println("Xuat Hoa Don:");
		for(int i = 0; i < n; i++ ){
			ChiTietHoaDons[i].xuat_ChiTietHoaDon();
		}
		System.out.println("Mã hóa đơn: " + this.maHD);
		System.out.println("Mã khách hàng: " + this.maKH);
		System.out.println("Mã nhân viên: " + this.maNV);
		// System.out.println("Ngày: " + this.ngay  + "/" + this.thang + "/" + this.nam );
		// System.out.println("Thời gian: " + this.gio+ " giờ : " + this.phut + " phút");
	}
	public void Xuat_Thong_Tin_Hoa_Don_Vao_File() { /// chỗ này xuất vào file liệu có hợp lý không ta?
		
		try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("HoaDon.txt"));
            for(int i=0;i<n;i++){
				writer.write("Ma Hoa Don:"+ChiTietHoaDons[i].getMaHD()+"\n");
				writer.write("Ma San Pham:" + ChiTietHoaDons[i].getMaSP() +"\n");
				writer.write("Ten San Pham:" + ChiTietHoaDons[i].getTenSp() +"\n");
				writer.write("Don Gia:" + ChiTietHoaDons[i].getDonGia() +"\n");
				writer.write("So Luong:" + ChiTietHoaDons[i].getSoLuong() +"\n");
				writer.write("Thanh Tien:" + ChiTietHoaDons[i].getThanhTien()+"\n");
			}
			writer.write("Tong Tien:"+tongTien()); //nay la tong cua nhieu thanh tien cua 1 chi tiet hoa don.
            writer.close();
            System.out.println("Ghi thành công vào tệp.");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào tệp: " + e.getMessage());
        }
	}
	public int tongTien(){ /// tinh tong tien cua hoa don
		this.tongTien = 0;
		for(int i=0;i<n;i++){
			this.tongTien += ChiTietHoaDons[i].getThanhTien();
		}
		return this.tongTien;
		
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public int getGio() {
		return gio;
	}
	public void setGio(int gio) {
		this.gio = gio;
	}
	public int getPhut() {
		return phut;
	}
	public void setPhut(int phut) {
		this.phut = phut;
	}
	public int getNgay() {
		return ngay;
	}
	public void setNgay(int ngay) {
		this.ngay = ngay;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
}
