
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class Tuan {
	public static void main( String args[]) {
		

		
		Scanner sc = new Scanner(System.in);
		HoaDon[] DanhSachHoaDon = new HoaDon[100];
		ChiTietHoaDon[][] DanhSachChiTietHoaDon = new ChiTietHoaDon[100][100];
		int n;
		int i=0;
		int j;
		do {
			
			System.out.println("1.Thêm hóa đơn");
			System.out.println("2.In thông tin tất cả hóa đơn (vào file )");
			System.out.println("3.Thoát");
			System.out.println("Chọn tác vụ: ");
			n = sc.nextInt();
			sc.nextLine();
			
			switch(n) {
			
			case 1:
				i++;
				DanhSachHoaDon[i] = new HoaDon();
				DanhSachHoaDon[i].Them_hoa_don();
				
				System.out.println("Nhập số loại sản phẩm: ");
				j = sc.nextInt();
				sc.nextLine();
				for ( int k=1; k<=j; k++) {
					System.out.println("Nhập sản phẩm "+ k);
					DanhSachChiTietHoaDon[i][k] = new ChiTietHoaDon();
					DanhSachChiTietHoaDon[i][k].setMaHD(DanhSachHoaDon[i].getMaHD());
					DanhSachChiTietHoaDon[i][k].Nhap_chi_tiet_hoa_don();
					
				}
				
				
				
				break;
		
			case 2:
				//Xuat ra console
				for ( int k=1; k<=i; k++) {
					for ( int h=1; h<=10; h++) {
						if ( DanhSachChiTietHoaDon[k][h] == null)
							break;
						else
				    System.out.println("Mã hóa đơn: " + DanhSachChiTietHoaDon[k][h].getMaHD());
				    System.out.println("STT: " + h);
				    DanhSachChiTietHoaDon[k][h].Xuat_Thong_Tin_CT_Hoa_Don(DanhSachHoaDon[k]); 
				    System.out.println("---------------------\n\n");
					}
				}
					
				//Ghi vao file
				    try {
						PrintWriter pw = new PrintWriter("C:\\Users\\tito7\\OneDrive\\Máy tính\\CNTT _ Thai_Tuan\\Do_an_OOP\\HoaDon.txt", "utf-8");
						for ( int k=1; k<=i; k++) {
							for ( int h=1; h<=10; h++) {
								if (DanhSachHoaDon[k] == null || DanhSachChiTietHoaDon[k][h] == null)
									break;
								else
						pw.println("Mã hóa đơn: " + DanhSachHoaDon[k].getMaHD());
					    pw.println("STT: " + h);
						pw.println("Mã khách hàng: " + DanhSachHoaDon[k].getMaKH());
						pw.println("Mã nhân viên: " + DanhSachHoaDon[k].getMaNV());
						pw.println("Ngày: " + DanhSachHoaDon[k].getNgay()  + "/" + DanhSachHoaDon[k].getThang() + "/" + DanhSachHoaDon[k].getNam());
						pw.println("Thời gian: " + DanhSachHoaDon[k].getGio()+ " giờ: " + DanhSachHoaDon[k].getPhut() + " phút");
						pw.println("Mã sản phẩm: " +  DanhSachChiTietHoaDon[k][h].getMaSP());
						pw.println("Số lượng: " +  DanhSachChiTietHoaDon[k][h].getSoLuong());
						pw.println("Đơn giá: " +  DanhSachChiTietHoaDon[k][h].getDonGia() + "đ");
						pw.println("Thành tiền: " +  DanhSachChiTietHoaDon[k][h].getThanhTien() + "đ");
						pw.println("----------------------------------\n\n");
						pw.flush();
							}
				    	}
							
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					} 
				break;
				
			case 3:
				System.out.println("Đã thoát!");
				break;
				
			default:
				System.out.println("Sai số, vui lòng nhập lại!");
				break;
			}
			
		} while (n !=3);
		sc.close();
    }  
}       
	

