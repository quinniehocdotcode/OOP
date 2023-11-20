//package FileJava.DoAnMyPham;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public abstract class SanPham {
    Scanner sc = new Scanner(System.in);
    private String masp;
    private String tensp;
    private int soluong;
    private int dongia;
    private String chatlieu;
    SanPham(String masp, String tensp, int soluong, int dongia, String chatlieu){
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia =  dongia;
        this.chatlieu = chatlieu;
    }
    SanPham(){
        this.masp = "0";
        this.tensp = "Noname";
        this.soluong = 0;
        this.dongia = 0;
        this.chatlieu = "No";
    }
    public void nhapByKeyboard(){     
        System.out.println("Nhap ma san phan: ");
        this.masp = sc.nextLine().replaceAll("\n", "");
        System.out.println("Nhap ten san phan: ");
        this.tensp = sc.nextLine().replaceAll("\n", "");
        System.out.println("Nhap so luong san phan: ");
        this.soluong = sc.nextInt();
        System.out.println("Nhap donn gia: ");
        this.dongia = sc.nextInt();    
        System.out.println("Nhap chat lieu: ");
        this.chatlieu = sc.nextLine().replaceAll("\n", "");
    }
    // abstract
    public abstract void thongTin();
    ////
    public void xuat(){
        System.out.println("Ma sp:"+this.masp);
        System.out.println("Ten sp:"+this.tensp);
        System.out.println("So luong:"+this.soluong);
        System.out.println("Don gia:"+this.dongia);
        System.out.println("Chat lieu:"+this.chatlieu);    
    }

    //// All tong hop don gia
    public int getSoluong (){
        return this.soluong;
    }
    public String getMasp(){
        return this.masp;
    }
    public String getTenSp(){
        return this.tensp;
    }
    public String getChatLieu(){
        return this.chatlieu;
    }
    public int getDonGia(){
        return this.dongia;
    }
    ///// All nhan gia tri thay doi
    public void setSoLuong(int n){
        this.soluong = n + this.soluong;

    }
}
