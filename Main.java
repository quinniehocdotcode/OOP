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
            case 6: break;/// chua lam 
            default :
            }
        
        }
        
    }
    public static void Menu_Thai(){
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
            Menu_Qui();
            Menu_Thai();
            Menu_Nhan();
            Menu_So();
        }
        
    }
    public static void main(String []args){
        /// 0: là đồng hồ 1: day chuyen
        Menu_Chinh();
        
    }
    
}
