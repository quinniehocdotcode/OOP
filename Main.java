import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void Menu_Qui(){
        ListProduct product = new ListProduct();
        
        int index = 1;
        while(index != 0){
            product.Menu();
            System.out.print("Nhap lua chon cua ban:");
            index = sc.nextInt();
            switch (index){
            case 1: product.NhapSP_KeyBoard(); break;
            case 2: product.NhapSP_1(); System.out.println("Nhap san pham tu file thanh cong!"); break;
            case 3:  System.out.println("Xoa san pham thanh cong!"); break; /// Chua lam ham xoa
            case 4: product.XuatSP(); System.out.println("Xuat san pham thanh cong!"); break;
            case 5: product.Them1Sp() ; System.out.println("Them mot san pham thanh cong");
            case 6: /// chua lam 
            default :
            }
        
        }
        
    }
    public static void Menu_Thai(){
        ListProduct product =new ListProduct();
        product.NhapSP_1(); 
        product.XuatSP();
    }
    public void Menu_Nhan(){

    }
    public void Menu_So(){
        
    }
    public static void Menu_Chinh(){
        Menu_Qui();
        Menu_Thai();
    }
    public static void main(String []args){
        Menu_Chinh();
        /// 0: là đồng hồ 1: day chuyen
        // HoaDon hd = new HoaDon();
        // hd.them_chi_tiet_hd();
        // hd.Them_hoa_don();
        // hd.Xuat_Thong_Tin_Hoa_Don_Vao_File();
    // Scanner sc = new Scanner(System.in);
    // ChiTietHoaDon cthd = new ChiTietHoaDon();
    // cthd.Nhap_chi_tiet_hoa_don();
    // cthd.xuat();
    //product.XuatHoaDon();
    // hd.Xuat_Thong_Tin_Hoa_Don();
    // product.NhapSP_1();
    // product.XuatSP();
    //product.thongKeTheoGia();
    //product.FindByTen();
    // System.out.println("Chon Nhap sp bang: \n1: ban phim\n2: file");
    // int num = sc.nextInt();
    //     if(num == 1)
    //       product.NhapSP_KeyBoard();
    //     else if(num == 2) {
    //       product.NhapSP_1();
    //     }
    //     int menu = -1;
    //     while(menu != 0){
    //       product.Menu();
    //       menu = sc.nextInt();
    //       switch (menu) {
    //         case 1:{
    //           product.XuatSP();
    //           break;
    //         }
    //         case 2:{
    //             product.Them1Sp();
    //           break;
    //         }
    //         case 3:{
    //           product.XuatHoaDon();
    //           break;
    //         }  
    //         case 4:{
    //             product.FindByMaSp();
    //             break;
    //         }  
    //         case 5:{
    //             product.FindByName();
    //         }
    //         case 6:{


    //         }
    //       }
    //     }
        
    
        

     
    }
    
}
