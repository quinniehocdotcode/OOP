//package FileJava.DoAnMyPham;
import java.util.Scanner;
public class FindProduct implements ChucNang {
    Scanner sc = new Scanner(System.in);
    @Override
    public void FindByMaSp(SanPham[] ts) {
        System.out.print("Nhap ma sp can tim kiem:");
        int Flag = 0;
        String ma =  sc.nextLine();
        for(int i=0 ; i<ts.length; i++){ /// Tim bang ma chi co the ra mot sp or khong co cai nao
             if(ma.equals(ts[i].getMasp())){
                System.out.println("Tim Thay san pham!");
                System.out.println("Thong tin san pham:");
                ts[i].xuat();
                Flag = 1; 
                break;
            }
        }
        if(Flag == 0)
            System.out.println("Khong tim Thay san pham!");
    }

    @Override
    public void FindByTen(SanPham[] ts) { //// co the ra nhieu cai
        System.out.print("Nhap ten sp can tim kiem:");
        int Flag = 0;
        String ten = sc.nextLine();
        for(int i=0;i<ts.length;i++){
           int index = ts[i].getTenSp().indexOf(ten);
            if(index != -1){
                ts[i].xuat();
                Flag = 1; 
            }
        }
        if(Flag == 0)
            System.out.println("Khong tim Thay san pham!");
    }
    
}
