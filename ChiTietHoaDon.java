
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ChiTietHoaDon  {
	private ListProduct product = new ListProduct();
	private String maHD;
	private String maSP;
	private int soLuong;
	private int donGia;
	private int thanhTien = this.soLuong * this.donGia;
	Scanner sc = new Scanner(System.in);
	//constructor
	public ChiTietHoaDon() {}
	public ChiTietHoaDon(String maHD, String maSP, int soLuong, int donGia) {
		this.maHD = maHD;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	//
	int vitri = 0;
	public void Nhap_chi_tiet_hoa_don() {
		product.NhapSP_1();
		 vitri = product.Check("HJVTT01");
		//System.out.println("Nhập mã sản phẩm ca mua: "); //
		 // check ma de tro ve vi tri no trong mang sp=> lay dc so tien, 
		setMaSP(product.getMaSp(vitri));
		System.out.print("Nhập ma HD: ");
		this.maHD = sc.nextLine();
		System.out.print("Nhập số lượng: ");
		setSoLuong(sc.nextInt());
		//sc.nextLine();
		//System.out.println("Nhập đơn giá: ");
		setDonGia(product.getDonGia(vitri));
		//sc.nextLine();
		this.thanhTien = this.donGia * this.soLuong;
	}
// 
	public void xuat_display(){
		System.out.println("Ma Hoa Don:"+this.maHD);
		System.out.println("Ma San Pham:"+this.maSP);
		System.out.println("So Luong:"+this.soLuong);
		System.out.println("Don Gia"+this.donGia);
		System.out.println("Thanh Tien:"+this.thanhTien);

}
// 
	// public void Xuat_Thong_Tin_CT_Hoa_Don(HoaDon hd) {
	// hd.Xuat_Thong_Tin_Hoa_Don();
	// System.out.println("Mã sản phẩm: " + this.maSP);
	// System.out.println("Số lượng: " + this.soLuong);
	// System.out.println("Đơn giá: " + this.donGia + "đ");
	// System.out.println("Thành tiền: " + this.thanhTien + "đ");
	// }
	
	// public void Xuat_ttct_vao_file(HoaDon hd) {
	// 	try {
	// 		PrintWriter pw = new PrintWriter("OutputSp.txt");
	// 		pw.println("Mã hóa đơn: " + hd.getMaHD());
	// 		pw.println("Mã khách hàng: " + hd.getMaKH());
	// 		pw.println("Mã nhân viên: " + hd.getMaNV());
	// 		pw.println("Ngày: " + hd.getNgay()  + "/" + hd.getThang() + "/" + hd.getNam() );
	// 		pw.println("Thời gian: " + hd.getGio()+ " giờ: " + hd.getPhut() + " phút");
	// 		pw.println("Mã sản phẩm: " + this.maSP);
	// 		pw.println("Số lượng: " + this.soLuong);
	// 		pw.println("Đơn giá: " + this.donGia + "đ");
	// 		pw.println("Thành tiền: " + this.thanhTien + "đ");
	// 		pw.println("----------------------------------\n\n");
	// 		pw.flush();
	// 	} catch (FileNotFoundException e) {
	// 		e.printStackTrace();
	// 	}
		// } catch (UnsupportedEncodingException e) {
		// 	e.printStackTrace();
		// }
	//}
	//
	
	
	public String getMaHD() {
		return maHD;
	}
	public String getTenSp(){
		return product.getTenSp(product.Check("HJVTT01"));
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public int getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

	
}
