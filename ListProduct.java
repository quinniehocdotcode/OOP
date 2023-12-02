//package FileJava.DoAnMyPham;
import java.io.*;
import java.util.*;

public class ListProduct {
    private  SanPham ts[];
    Scanner sc = new Scanner(System.in);
    public void NhapSP_1() {
         ts = new SanPham[0];
         String fileName = "FileSp.txt";
         String line ;
         try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
           while((line = reader.readLine())!=null){
               String []data = line.split(", ");
                System.out.println(data[1].indexOf("Ho"));
               if(data[1].indexOf("Ho")!=-1){
                   DongHo  donghomoi =   new DongHo(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4], data[5], data[6]);
                        ts = Arrays.copyOf(ts, ts.length+1);
                        ts[ts.length-1] = (DongHo)donghomoi ;

                }
                 else{
                    ts = Arrays.copyOf(ts, ts.length+1);
                    ts[ts.length-1] =  new DayChuyen(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), data[6]);
            }
           }
            reader.close();    
         } catch (IOException e) {
            // TODO: handle exception
         }       
          
    }
    public void NhapSP_KeyBoard(){
        System.out.print("Nhap so luong san pham: ");
            ts = new SanPham[sc.nextInt()];
        for(int i=0;i<ts.length;i++){
            System.out.println("0: Nhap Dong Ho.\n1: Nhap Day truyen.");
            int n = sc.nextInt();
            if(n == 0){
                ts[i] = new DongHo();
                ts[i].nhapByKeyboard();
            }
            else{
                ts[i] = new DayChuyen();
                ts[i].nhapByKeyboard();
            }
        }
    }
    public void XuatSP() {
        for (int i = 0; i < ts.length; i++) {
            if (ts[i] != null) {
                ts[i].xuat();
            } else {
                System.out.println("Phần tử là null");
            }
        }
    }
    public void Them1Sp(){
        ts  = Arrays.copyOf(ts, ts.length +1);

        System.out.println("0: Nhap Dong Ho.\n1: Nhap Day truyen.");
            int n = sc.nextInt();
            if(n == 0){
                ts[ts.length -1] = new DongHo();
                ts[ts.length-1].nhapByKeyboard();
            }
            else if(n == 1){
                ts[ts.length-1] = new DayChuyen();
                ts[ts.length-1].nhapByKeyboard();
            }
    }  
    public void XuatSanPham(){
            try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("OutputSp.txt"));
            for(int i=0; i<ts.length;i++){
                if(ts[i] instanceof DongHo ){
                    DongHo dh = (DongHo) ts[i];
                    writer.write(ts[i].getMasp()+", "+ts[i].getTenSp()+", "+ts[i].getSoluong()+", "
                    +ts[i].getDonGia()+", "+ts[i].getChatLieu()+", "+dh.getThuongHieu()+", "+dh.getLoaiMay());
                    writer.newLine();
                }
                else{
                    DayChuyen dc = (DayChuyen) ts[i];
                    writer.write(ts[i].getMasp()+", "+ts[i].getTenSp()+", "+ts[i].getSoluong()+", "
                    +ts[i].getDonGia()+", "+ts[i].getChatLieu()+", "+dc.getKichThuoc()+", "+dc.gethatDinh());
                    writer.newLine();
                }
            }
            writer.close();
            System.out.println("Ghi thành công vào tệp.");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào tệp: " + e.getMessage());
        }

    } 
    
    public void thongKeTheoGia(){
        int sl[] = new int[4];
        for(int i=0;i<4;i++){
            sl[i] = 0;
        }
        for(int i=0;i<ts.length;i++){
            //System.out.println(ts[i].getDonGia());
            if(ts[i].getDonGia() > 50000){
                sl[0]++;
            }
            else if(ts[i].getDonGia() <= 50000 && ts[i].getDonGia() >25000){
                sl[1]++;
            }
             else if(ts[i].getDonGia() <= 25000 && ts[i].getDonGia() >10000){
                sl[2]++;
            }
            else{
                sl[3]++;
            }
        }
        System.out.println("**********Bang Thong Ke San Pham:**********");
        System.out.println("Gia:"+"\t\t\t"+"<500"+"\t\t"+"250-500"+"\t\t"+"100-250"+"\t\t"+">100");
        System.out.println("SoLuong:\t\t"+sl[0]+"\t\t"+sl[1]+"\t\t"+sl[2]+"\t\t"+sl[3]);

    }

    //
    public int getDonGia(int vitri){
        return ts[vitri].getDonGia();
    }
    public int Check(String maSp){ // kiem tr vi tri san pham de lay dongia, masp, // tham so truyen vao la ma sp
        int vitri = 0;
        for(int i=0;i<ts.length;i++){
            if(maSp.equals(ts[i].getMasp())){
                vitri = i;
               
            }
        }
        return vitri;
    }
    public String getMaSp(int vitri){
        return ts[vitri].getMasp();
    }
    public String getTenSp(int vitri){
        return ts[vitri].getTenSp();
    }
    public void Menu(){ // khi goi Menu thi sp tu load len, 
        System.out.println("1. Nhap San Pham Tu Ban Phim");
        System.out.println("2. Nhap San Pham Tu File");
        System.out.println("3. Xoa San Pham");
        System.out.println("4. Xuat San Pham");
        System.out.println("5. Them mot san pham");
        System.out.println("6. Xuat toan bo san pham vao file(OutputSp.txt)");
        System.out.println("0. Thoat");
    }
}       

    
  

