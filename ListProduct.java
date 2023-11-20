//package FileJava.DoAnMyPham;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ListProduct {
    private  SanPham ts[] = new SanPham[6];
    //interface;
    ChucNang method = new FindProduct();
    //
    Scanner sc = new Scanner(System.in);
    public void Menu(){
        System.out.println("1: Xem");
        System.out.println("2: Them 1sp");
        System.out.println("3: Xuat Hoa Don");
        System.out.println("4: Thoat");
    }
    public void NhapSP_1() {
        int index = 0;
        try {
            File file = new File("FileSp.txt");
            Scanner scanner = new Scanner(file);
    
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
    
                if (line.equals("0")) {
                    // Đọc thông tin về đồng hồ
                    String maSp = scanner.nextLine();
                    String tenSp = scanner.nextLine();
                    int soLuong = Integer.parseInt(scanner.nextLine());
                    int giaBan = Integer.parseInt(scanner.nextLine());
                    String mauSac = scanner.nextLine();
                    String chatLieu = scanner.nextLine();
                    String thuongHieu = scanner.nextLine();
    
                    // Tạo đối tượng DongHo
                    DongHo dongHo = new DongHo(maSp, tenSp, soLuong, giaBan, mauSac, chatLieu, thuongHieu);
    
                    // Sử dụng đối tượng DongHo theo nhu cầu của bạn (ví dụ: lưu vào mảng ts[])
                     ts[index] = dongHo;
                     index++;
    
                } else if (line.equals("1")) {
                    // Đọc thông tin về dây chuyền
                    String maSp = scanner.nextLine();
                    String tenSp = scanner.nextLine();
                    int soLuong = Integer.parseInt(scanner.nextLine());
                    int giaBan = Integer.parseInt(scanner.nextLine());
                    String chatLieu = scanner.nextLine();
                    int doDai = Integer.parseInt(scanner.nextLine());
                    String thuongHieu = scanner.nextLine();
    
                    // Tạo đối tượng DayChuyen
                    DayChuyen dayChuyen = new DayChuyen(maSp, tenSp, soLuong, giaBan, chatLieu, doDai, thuongHieu);
    
                    // Sử dụng đối tượng DayChuyen theo nhu cầu của bạn (ví dụ: lưu vào mảng ts[])
                     ts[index] = dayChuyen;
                     index++;
                }
            }
    
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy tệp");
        }
    }
    public void NhapSP_KeyBoard(){
        for(int i=0;i<ts.length;i++){
            System.out.println("0: Nhap Dong Ho.\n1: Nhap Day truyen.");
            int n = sc.nextInt();
            if(n == 1){
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
                    writer.write("0\n");
                    writer.write(ts[i].getMasp()+"\n");
                    writer.write(ts[i].getTenSp()+"\n");
                    writer.write(ts[i].getSoluong()+"\n");
                    writer.write(ts[i].getDonGia()+"\n");
                    writer.write(ts[i].getChatLieu()+"\n");
                    writer.write(dh.getThuongHieu()+"\n");
                    writer.write(dh.getLoaiMay()+"\n");
                }
                else{
                    DayChuyen dc = (DayChuyen) ts[i];
                    writer.write("0\n");
                    writer.write(ts[i].getMasp()+"\n");
                    writer.write(ts[i].getTenSp()+"\n");
                    writer.write(ts[i].getSoluong()+"\n");
                    writer.write(ts[i].getDonGia()+"\n");
                    writer.write(ts[i].getChatLieu()+"\n");
                    writer.write(dc.getKichThuoc()+"\n");
                    writer.write(dc.gethatDinh()+"\n");
                }
            }
            writer.close();
            System.out.println("Ghi thành công vào tệp.");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào tệp: " + e.getMessage());
        }

    } 
    // public void FindByMaSp() {
    //     System.out.print("Nhap ma sp can tim kiem:");
    //     int Flag = 0;
    //     String ma =  sc.nextLine().replaceAll("\n", "");
    //     for(int i=0 ; i<ts.length; i++){ /// Tim bang ma chi co the ra mot sp or khong co cai nao
    //          if(ma.equals(ts[i].getMasp())){
    //             System.out.println("Tim Thay san pham!");
    //             System.out.println("Thong tin san pham:");
    //             ts[i].xuat();
    //             Flag = 1; 
    //             break;
    //         }
    //     }
    //     if(Flag == 0)
    //         System.out.println("Khong tim Thay san pham!");
    // }
    // public void FindByName(){
    //     System.out.print("Nhap ten SP muon tim:");
    //     String name = sc.nextLine().toLowerCase();
    //    int Flag = 0;
    //     for(int i=0;i<ts.length;i++){
    //          System.out.println(ts[i].getTenSp().toLowerCase());
    //         if(ts[i].getTenSp().toLowerCase().indexOf(name) != -1){
    //             ts[i].xuat();
    //             Flag = 1;
    //         }
    //         if(Flag == 0) System.out.println("Khong Tim Thay!");
    //     }
    // }
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
    // interface
    public void FindByMaSp(){
        method.FindByMaSp(ts);
    }
    public void FindByTen(){
        method.FindByTen(ts);
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
}       

    
  

