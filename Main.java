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
            case 5: product.Them1Sp() ; System.out.println("Them mot san pham thanh cong"); break;
            case 6: product.XuatSanPham(); break;
            }
        
        }
        
    }
    public static void Menu_Tuan(){
        ListProduct product =new ListProduct();
        product.NhapSP_1(); 
        product.XuatSP();
    }
    public static void Menu_Nhan(){

    }
    public static void Menu_So(){
        
    }
    public static void Menu_Chinh(){
        int index =1;
        while(index != 0){
            System.out.println("1. Menu_Qui");
            System.out.println("2. Menu_Tuan");
            System.out.println("3. Menu_Nhan");
            System.out.println("4. Menu_So");
            System.out.print("Chon Menu:");
            index = sc.nextInt();
            switch (index) {
                case 1:Menu_Qui(); break;
                case 2:Menu_Tuan(); break;
                case 3:Menu_Nhan(); break;
                case 4:Menu_So(); break;
                default:
            }    
        }
        
    }
    public static void main(String []args){
        /// 0: là đồng ; 1: day chuyen
        // Menu_Chinh();
        ListProduct pr =  new ListProduct();
        pr.NhapSP_1();
        pr.XuatSanPham();
        
    }
    
}
