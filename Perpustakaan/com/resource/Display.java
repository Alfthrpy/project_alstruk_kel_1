package com.resource;

import java.util.Scanner;

public class Display {
    protected void displayMenuUser(Sistem sistem,User user){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("\u001B[34m╔══════════════════════════════════╗\u001B[0m");
            System.out.println("\u001B[34m║           \u001B[33mPERPUSTAKAAN\u001B[34m           ║\u001B[0m");
            System.out.println("\u001B[34m║          \u001B[35mSelamat Datang\u001B[34m          ║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m1\u001B[34m | \u001B[39mTampilkan Buku                \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m2\u001B[34m | \u001B[39mSort Buku                     \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m3\u001B[34m | \u001B[39mCari Buku                     \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m4\u001B[34m | \u001B[39mPinjam Buku                   \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m5\u001B[34m | \u001B[39mKembalikan Buku               \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m6\u001B[34m | \u001B[39mTampilkan Riwayat Peminjaman  \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m7\u001B[34m | \u001B[39mTampilkan Status Peminjaman   \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m8\u001B[34m | \u001B[39mCek denda                     \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m9\u001B[34m | \u001B[39mBayar Denda                   \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m10\u001B[34m| \u001B[39mProfil                        \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m11\u001B[34m| \u001B[39mLog out                       \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m╚══════════════════════════════════╝\u001B[0m");
            System.out.print("Pilihan anda : ");
            int pil = scanner.nextInt();
            switch(pil){
                case 1:
                    clearConsole();
                    sistem.tampilBuku();
                    break;
                case 2:
                    clearConsole();
                    sortBook(sistem);
                    break;
                case 3:
                    clearConsole();
                    sistem.searchBook();
                    break;
                case 4:
                    clearConsole();
                    sistem.pinjamBuku(user);
                    break;
                case 5:
                    clearConsole();
                    sistem.kembaliBuku(user);
                    break;
                case 6:
                    clearConsole();
                    sistem.tampilRiwayat(user);
                    break;
                case 7:
                    clearConsole();
                    sistem.tampilStatusPinjam(user);
                    break;
                case 8:
                    clearConsole();
                    sistem.displayDenda(user);
                    break;
                case 9:
                    clearConsole();
                    sistem.bayarDenda(user);;
                    break;
                case 10:
                    clearConsole();
                    sistem.displayProfile(user);
                    break;
                case 11:
                    clearConsole();
                    return;
                default :
                    System.out.println("\u001B[31mPilihan Anda Salah..\u001B[31m ");
                    break;
            }
        }

    }

    public void displayMenuAdmin(Sistem sistem,Admin admin){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int pil;
        while(flag){
            System.out.println("\u001B[34m╔═════════════════════════════════╗\u001B[0m");
            System.out.println("\u001B[34m║       \u001B[33mADMIN PERPUSTAKAAN\u001B[34m        ║\u001B[0m");
            System.out.println("\u001B[34m║         \u001B[35mSelamat Datang\u001B[34m          ║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m1\u001B[34m | \u001B[39mTambah Buku                  \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m2\u001B[34m | \u001B[39mTambah Rak                   \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m3\u001B[34m | \u001B[39mTambah User                  \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m4\u001B[34m | \u001B[39mHapus User                   \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m5\u001B[34m | \u001B[39mHapus Buku                   \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m6\u001B[34m | \u001B[39mTampilkan User               \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m7\u001B[34m | \u001B[39mSort User                    \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m8\u001B[34m | \u001B[39mTampilkan Profile User       \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m9\u001B[34m | \u001B[39mTampilkan Riwayat User       \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m10\u001B[34m| \u001B[39mTampilkan Buku               \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m11\u001B[34m| \u001B[39mTampilkan Jumlah Buku        \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m12\u001B[34m| \u001B[39mTampilkan Kategori Denda     \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m║\u001B[33m13\u001B[34m| \u001B[39mLogout                       \u001B[34m║\u001B[0m");
            System.out.println("\u001B[34m╚═════════════════════════════════╝\u001B[0m");
            System.out.print("Pilihan anda : ");
            pil = scanner.nextInt();


            switch(pil){
                case 1:
                    clearConsole();
                    sistem.addBook();
                    break;
                case 2:
                    clearConsole();
                    sistem.addRak();
                    break;
                case 3:
                    clearConsole();
                    sistem.addUser();
                    break;
                case 4:
                    clearConsole();
                    sistem.hapusUser();
                    break;
                case 5:
                    clearConsole();
                    sistem.deleteBuku();
                    break;
                case 6:
                    clearConsole();
                    sistem.tampilUser();
                    break;
                case 7:
                    clearConsole();
                    sortUser(sistem);
                    break;
                case 8:
                    clearConsole();
                    sistem.displayProfileAll();
                    break;
                case 9:
                    clearConsole();
                    sistem.tampilRiwayatUser();
                    break;
                case 10:
                    clearConsole();
                    sistem.tampilBuku();
                    break;
                case 11:
                    clearConsole();
                    sistem.tampiljlhBuku();
                    break;
                case 12:
                    clearConsole();
                    sistem.displayKategoriDenda();
                    break;
                case 13:
                    clearConsole();
                    return;
                default :
                    System.out.println("\u001B[31mPilihan Anda Salah..\u001B[31m ");
                    break;
            }
        }
    }

    public boolean displayHome(Sistem sistem){
        Scanner input = new Scanner(System.in);
        int pil;
        System.out.println("\u001B[34m╔═════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[34m║       \u001B[33mADMIN PERPUSTAKAAN\u001B[34m        ║\u001B[0m");
        System.out.println("\u001B[34m║         \u001B[35mSelamat Datang\u001B[34m          ║\u001B[0m");
        System.out.println("\u001B[34m║\u001B[33m1\u001B[34m| \u001B[39mLOGIN USER                    \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║\u001B[33m2\u001B[34m| \u001B[39mLOGIN ADMIN                   \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║\u001B[33m3\u001B[34m| \u001B[39mKELUAR                        \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╚═════════════════════════════════╝\u001B[0m");
        System.out.print("Pilihan anda : ");
        pil = input.nextInt();
        input.nextLine();
        
        switch(pil){
            case 1:
                loginUser(sistem);
                break;
            case 2:
                loginAdmin(sistem);
                break;
            case 3:  
                return true;
            default :
                System.out.println("\u001B[31mPilihan Anda Salah..\u001B[31m ");
                break;
        }
        return false;
        
    }

    protected void loginUser(Sistem sistem){
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        String usname,pass;
        System.out.println("\u001B[34m╔═════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[34m║           \u001B[96mLOGIN USER            \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╚═════════════════════════════════╝\u001B[0m");
        System.out.print("\u001B[96mUsername\u001B[0m      : ");
        usname = scanner.nextLine();
        System.out.print("\u001B[96mNIM\u001B[0m           : ");
        pass = scanner.nextLine();
        User user = sistem.loginUser(usname, pass);
        if(user != null){
            System.out.println("Login Berhasil...");
            displayMenuUser(sistem,user);

        } else {
            System.out.println("\u001B[91mTidak terdaftar atau username dan nim salah...\u001B[0m");
        }
    }

    protected void loginAdmin(Sistem sistem){
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        String usname,pass;
        System.out.println("\u001B[34m╔═════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[34m║          \u001B[96mLOGIN ADMIN            \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╚═════════════════════════════════╝\u001B[0m");
        System.out.print("\u001B[96mUsername\u001B[0m      : ");
        usname = scanner.nextLine();
        System.out.print("\u001B[96mpass\u001B[0m          : ");
        pass = scanner.nextLine();
        Admin min = sistem.loginAdmin(usname, pass);
        if(min != null){
            System.out.println("Login Berhasil...");
            displayMenuAdmin(sistem, min);

        } else {
            System.out.println("\u001B[91mTidak terdaftar atau username dan sandi salah...\u001B[0m");
        }
    }

    protected void clearConsole(){
        System.out.print("\033[H\033[2J");
    }

    protected void displayjlhBuku(Sistem sistem){
        System.out.println();
    }

    protected void sortBook(Sistem sistem){
        Scanner input = new Scanner(System.in);

        System.out.println("\u001B[34m╔═══════════════════════╗\u001B[0m");      
        System.out.println("\u001B[34m║  \u001B[36mSORTING BERDASARKAN  \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╠═══════════════════════╣\u001B[0m");
        System.out.println("\u001B[34m║  \u001B[33m1 \u001B[0m| \u001B[32mKATEGORI         \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║  \u001B[33m2 \u001B[0m| \u001B[32mJUDUL            \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║  \u001B[33m3 \u001B[0m| \u001B[32mSTOCK            \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╚═══════════════════════╝\u001B[0m");
        System.out.print("Masukan pilihan sort : ");
        int pil = input.nextInt();
        input.nextLine();

        switch (pil) {
            case 1:
                clearConsole();
                sistem.sortBukuByKategori();
                break;
        
            case 2:
                clearConsole();
                sistem.sortBukuByJudul();
                break;
            
            case 3:
                clearConsole();
                sistem.sortBukuByStock();
                break;
            default :
                System.out.println("\u001B[31mPilihan Anda Salah..\u001B[0m ");
                break;
        }
        
    }

    protected void sortUser(Sistem sistem){
        Scanner input = new Scanner(System.in);

        System.out.println("\u001B[34m╔═══════════════════════╗\u001B[0m");      
        System.out.println("\u001B[34m║  \u001B[36mSORTING BERDASARKAN  \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╠═══════════════════════╣\u001B[0m");
        System.out.println("\u001B[34m║  \u001B[33m1 \u001B[0m| \u001B[32mNAMA             \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║  \u001B[33m2 \u001B[0m| \u001B[32mNIM              \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╚═══════════════════════╝\u001B[0m");
        System.out.print("Masukan pilihan sort : ");
        int pil = input.nextInt();
        input.nextLine();

        switch (pil) {
            case 1:
                clearConsole();
                sistem.sortUserByNama();
                break;
        
            case 2:
                clearConsole();
                sistem.sortUserByNim();
                break;
            
            default :
                System.out.println("\u001B[31mPilihan Anda Salah..\u001B[0m ");
                break;
        }
        
    }
    

}
