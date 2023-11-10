//package FileJava.DoAnMyPham;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class DongHo extends SanPham{
    Scanner sc = new Scanner(System.in);
    private String thuonghieu;
    private String loaimay;
    DongHo(){}
    DongHo(String masp, String tensp,int soluong, int dongia,String chatlieu,String thuonghieu, String loaimay){
        super(masp,tensp,soluong,dongia,chatlieu);
        this.loaimay = loaimay;
        this.thuonghieu = thuonghieu;
    }
    /// Ham Nhap
    @Override public void nhapByKeyboard(){
        super.nhapByKeyboard();
        System.out.println("Thuong hieu: ");
        this.thuonghieu = sc.nextLine();
        System.out.print("Loai may: ");
        this.loaimay = sc.nextLine();
    }
    @Override public void xuat(){
        super.xuat();
        System.out.println("Thuong hieu: " + this.thuonghieu);
        System.out.println("Loai may: "+ this.loaimay);
    }
    ////  Ham get
    public String getThuongHieu(){
        return this.thuonghieu;
    }
    public String getLoaiMay(){
        return this.loaimay;
    }
    //// Ham set
    public void set( String thuonghieu,String loaimay){
        this.loaimay = loaimay;
        this.thuonghieu = thuonghieu;
    }
}
