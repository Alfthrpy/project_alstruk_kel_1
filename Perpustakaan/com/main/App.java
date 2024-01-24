
import com.resource.Admin;
import com.resource.Buku;
import com.resource.Display;
import com.resource.Rak;
import com.resource.Sistem;
import com.resource.User;

public class App {
    public static void main(String[] args){
        Display display = new Display();

        //INISIALISASI DATABASE AWAL

        //USER & ADMIN & SISTEM
        

        Admin min = new Admin("Fathir","001");
        Admin min2 = new Admin("ucup","007");
        
        User user = new User("Ridwan","001","Teknik Informatika","Saintek");

        //RAK
        Rak rak = new Rak(1);
        Rak rak1 = new Rak(2);
        Rak rak2 = new Rak(3);

        //BUKU BUKU
        Buku bk = new Buku("Bumi","Tereliye","A");
        Buku bk1 = new Buku("Bulan","Tereliye","A");
        Buku bk2= new Buku("Matahari","Tereliye","B");

        Buku bk3 = new Buku("Geez & Ann","Rintik Sedu","C");
        Buku bk4 = new Buku("Laut Bercerita","Anwar Riza","A");
        Buku bk5= new Buku("Filosofi Kopi","Fadil Anwar","A");
        
        Buku bk6 = new Buku("Algoritma & Pemrograman","Rizki I'jazi","D");
        Buku bk7 = new Buku("Belajar Java Dalam 1 Hari","Fathir Ar-Ridwan","D");
        Buku bk8= new Buku("Memahami Wanita","Ginanjar","A");

        Sistem sistem = new Sistem(min,user);
        sistem.initRak(rak);
        sistem.initRak(rak1);
        sistem.initRak(rak2);
        //TAMBAH KE SISTEM
        sistem.addBuku(bk,rak);
        sistem.addBuku(bk1,rak);
        sistem.addBuku(bk2,rak);
        
        sistem.addBuku(bk3,rak1);
        sistem.addBuku(bk4,rak1);
        sistem.addBuku(bk5,rak1);
        
        sistem.addBuku(bk6,rak2);
        sistem.addBuku(bk7,rak2);
        sistem.addBuku(bk8,rak2);
        sistem.loadStorage();
        

        

        
        while(true){
            if(display.displayHome(sistem)){
                System.out.println("Program Selesai!");
                System.out.println("Terimakasih!");
                break;
            }
        }
    }
}
