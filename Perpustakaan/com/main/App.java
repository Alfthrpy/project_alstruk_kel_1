
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

        //USER & ADMIN
        Admin min = new Admin("Fathir","001");
        User user = new User("Ridwan","001");

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


        //TAMBAH KE SISTEM
        rak.addBuku(bk);
        rak.addBuku(bk1);
        rak.addBuku(bk2);
        
        rak1.addBuku(bk3);
        rak1.addBuku(bk4);
        rak1.addBuku(bk5);
        
        rak2.addBuku(bk6);
        rak2.addBuku(bk7);
        rak2.addBuku(bk8);

        

        Sistem sistem = new Sistem(min,user);
        sistem.initRak(rak);
        sistem.initRak(rak1);
        sistem.initRak(rak2);
        while(true){
            if(display.displayHome(sistem)){
                System.out.println("Program Selesai!");
                break;
            }
        }
    }
}
