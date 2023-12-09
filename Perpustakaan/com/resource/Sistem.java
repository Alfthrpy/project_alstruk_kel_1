package com.resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;

public class Sistem {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Rak> rakrak = new ArrayList<Rak>();
    private ArrayList<Admin> admins = new ArrayList<Admin>();
    private HashMap<String, Integer> kategori_denda = new HashMap<String, Integer>();

    public Sistem(Admin admin, User user) {
        admins.add(admin);
        users.add(user);
        kategori_denda.put("A",3000);
        kategori_denda.put("B",5000);
        kategori_denda.put("C",8000);
        kategori_denda.put("D",10000);
    }

    public void initRak(Rak rak){
        rakrak.add(rak);
    }

    protected void addUser(){
        Scanner scanner = new Scanner(System.in);
        String nama,nim,jurusan,fakultas;

        System.out.print("Masukan Nama :");
        nama = scanner.nextLine();
        System.out.print("Masukan NIM : ");
        nim = scanner.nextLine();
        System.out.print("Masukan Jurusan :");
        jurusan = scanner.nextLine();
        System.out.print("Masukan Fakultas : ");
        fakultas = scanner.nextLine();
        User user = new User(nama,nim,jurusan,fakultas);
        users.add(user);
        System.out.println("User berhasil di tambahkan");
    }

    protected void addRak() {
        Scanner scanner = new Scanner(System.in);
        int kode;
        System.out.print("Masukan kode rak: ");
        kode = scanner.nextInt();
    
        if (rakAlreadyExists(kode)) {
            System.out.println("\u001B[31mKode rak sudah ada! Rak tidak dapat ditambahkan.\u001B[0m");
            return;
        }
    
        Rak rak = new Rak(kode);
        rakrak.add(rak);
        System.out.println("Rak baru berhasil ditambahkan");
    }
    
    //baruu
    private boolean rakAlreadyExists(int kode) {
        for (Rak rak : rakrak) {
            if (rak.getKode() == kode) {
                return true;
            }
        }
        return false;
    }
    

    protected void addBook(){
        String judul,penulis,kategori;
        int koderk;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan Judul Buku :");
        judul = scanner.nextLine();
        System.out.print("Masukan Penulis :");
        penulis = scanner.nextLine();
        System.out.print("Masukan Kategori Buku :");
        kategori = scanner.nextLine();
        System.out.print("Masukan kode rak yang akan di tempati : ");
        koderk = scanner.nextInt();
        scanner.nextLine();

        if (koderk <= 0 || koderk > rakrak.size()) {
            System.out.println("\u001B[31mPilihan tidak valid! Rak tidak tersedia!\u001B[0m");
            return;
        }
        
        Rak rak = getRak(koderk);
        Buku bk = new Buku(judul, penulis, kategori);
        rak.addBuku(bk);
        System.out.println("Buku Berhasil ditambahkan ke rak " + rak.getKode());
    }

    protected void tampilBuku(){

        for(Rak rk : rakrak){
            System.out.println("\u001B[34m╔═════════════════════════════════╗\u001B[0m");
            System.out.printf("\u001B[34m║             \u001B[96mRAK %d               \u001B[34m║\u001B[0m\n",rk.getKode());
            System.out.println("\u001B[34m╚═════════════════════════════════╝\u001B[0m");
            rk.tampilBuku(rakrak);
            System.out.println();
        }
    }
    protected void tampiljlhBuku(){
        int total = 0;
        for(Rak rk : rakrak){
            int bukuPerRak = rk.tampiljlhBuku();
            total += bukuPerRak;
            System.out.println("\u001B[34m╔═════════════════════════════════╗\u001B[0m");
            System.out.printf("\u001B[34m║         \u001B[96mJUMLAH BUKU RAK %d       \u001B[34m║\u001B[0m\n",rk.getKode());
            System.out.println("\u001B[34m╚═════════════════════════════════╝\u001B[0m");
            System.out.printf("                \u001B[31m%d\u001B[0m\n",rk.tampiljlhBuku());
        }

        System.out.println("\u001B[34m╔═════════════════════════════════╗\u001B[0m");
        System.out.printf("\u001B[34m║       \u001B[96mTOTAL JUMLAH BUKU \u001B[31m%-8d\u001B[34m║\u001B[0m\n",total);
        System.out.println("\u001B[34m╚═════════════════════════════════╝\u001B[0m");
    }

    protected void pinjamBuku(User user){
        if (user.getDenda() > 0){
            System.out.println("\u001B[31mAnda Mempunyai Denda!\u001B[0m");
            return;
        }

        Scanner input = new Scanner(System.in);

        int idx_bk,idx_rak;
        tampilBuku();
        System.out.print("Masukan kode rak : ");
        idx_rak = input.nextInt();
        System.out.print("Masukan pilihan buku : ");
        idx_bk = input.nextInt();
        input.nextLine();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate tgl_pinjam_local = LocalDate.now();
        String tgl_pinjam = tgl_pinjam_local.format(format);
        System.out.print("Tanggal peminjaman :" + tgl_pinjam);

    
        Rak rk = getRak(idx_rak);
        if(rk != null){
            Buku bk = rk.getBuku(idx_bk-1);
            int stock = bk.getStock();
            if(stock > 0){
                if(user.getDenda() == 0){
                    Pinjam pj = new Pinjam(user,tgl_pinjam,bk,rk);
                    user.addPinjam(pj);
                } else {
                    System.out.println("Anda Mempunyai Denda!");
                }

            } else {
                System.out.println("Buku sedang di pinjam!");
            }
        } else {
            System.out.println();
            System.out.println("\u001B[31mERROR...");
        }
    }

    protected void tampilUser(){
        if (users.isEmpty()) {
            System.out.println("\u001B[31mTidak ada user yang terdaftar\u001B[0m");
            return;
        }

        int maxName = 0;
        int maxNim = 0;
        int maxJurusan = 0;
        int maxFakultas = 0;

        for (User user : users) {
            maxName = Math.max(maxName, user.getNama().length());
            maxNim = Math.max(maxNim, user.getNim().length());
            maxJurusan = Math.max(maxJurusan, user.getJurusan().length());
            maxFakultas = Math.max(maxFakultas, user.getFakultas().length());
        }

        System.out.println("\u001B[34m╔══════════════════════════════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[34m║                      \u001B[96mDAFTAR USER                         \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╚══════════════════════════════════════════════════════════╝\u001B[0m");
        System.out.printf("   \u001B[33m%-2s \u001B[0m| \u001B[33m%-"+maxName+"s \u001B[0m| \u001B[33m%-"+maxNim+"s\u001B[0m | \u001B[33m%-"+maxJurusan+"s\u001B[0m | \u001B[33m%-"+maxFakultas+"s\u001B[0m\n", "No", "Nama", "NIM", "Jurusan" ,"Fakultas");
        for(int i=0; i < users.size(); i++){
            System.out.printf("   %-2d | %-"+maxName+"s | %-"+maxNim+"s | %-"+maxJurusan+"s | %-"+maxFakultas+"s\n",i+1,users.get(i).getNama(),users.get(i).getNim(), users.get(i).getJurusan(), users.get(i).getFakultas());
        }
        System.out.println();
        System.out.println();
    }

    protected User loginUser(String username, String nim){
        for(int i=0; i < users.size(); i++){
            if(users.get(i).getNama().equals(username) && users.get(i).getNim().equals(nim)){
                return users.get(i);
            }
        }
        return null;
    }

     protected Admin loginAdmin(String username, String pass){
        for(int i=0; i <admins.size(); i++){
            if(admins.get(i).getNama().equals(username) && admins.get(i).getKode().equals(pass)){
                return admins.get(i);
            }
        }
        System.out.println("test");
        return null;
    }

    protected void kembaliBuku(User user){
        if(user.getJmlPinjam() <= 0){
            System.out.println("\u001B[31mAnda tidak sedang meminjam Buku!\u001B[0m");
            return;
        }
    
        Scanner input = new Scanner(System.in);
        int pil;
        System.out.println("Peminjaman mana yang akan di kembalikan ?");
        tampilStatusPinjam(user);
        System.out.print("Pilihan anda :");
        pil = input.nextInt();
        input.nextLine();
    
        // Check if the selected index is valid
        if (pil <= 0 || pil > user.getJmlPinjam()) {
            System.out.println("\u001B[31mPilihan tidak valid! Silahkan pilih dengan benar!\u001B[0m");
            return;
        }
    
        Pinjam pj = user.getPinjam(pil - 1);
        int denda = getDendaByKategori(pj.getBuku());
        user.finishedPinjam(pj);  
        pj.kembali(user, denda, pj.getBuku().getKategori());
    }
    

    protected void tampilRiwayat(User user){
        user.tampilRiwayat();
    }

    protected void tampilStatusPinjam(User user){
        user.tampilStatus();
    }




    protected void searchBook(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan judul buku : ");
        String judul = input.nextLine();
        System.out.println("Sedang Mencari");

        int rak = -1;
        boolean found = false;
        for(int i = 0; i < rakrak.size(); i++){
            ArrayList<Buku> buku_buku = rakrak.get(i).getStorage();
            for(int j = 0; j < buku_buku.size(); j++){
                if(buku_buku.get(j).getJudul().equals(judul)){
                   rak = i;
                   found = true;
                   break;
                }
            }
        }

        rak += 1;
        if(found){
            System.out.println("Buku Ditemukan!");
            System.out.println("Buku  : "+judul);
            System.out.println("Rak   : " +rak);
        } else {
            System.out.println("Buku Tidak Ditemukan!");
        }


    }

    protected void displayDenda(User user){
        System.out.println("Denda anda adalah : Rp." + user.getDenda());
    }

    protected void displayProfile(User user){
        System.out.println("\u001B[34m╔═════════════════════════════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[34m║                     \u001B[35mPROFIL MAHASISWA                    \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╠═════════════════════════════════════════════════════════╣\u001B[0m");
        System.out.println("\u001B[34m║ \u001B[36mNama                      : " + String.format("%-28s", user.getNama()) + "\u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║ \u001B[36mNIM                       : " + String.format("%-28s", user.getNim()) + "\u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║ \u001B[32mJurusan                   : " + String.format("%-28s", user.getJurusan()) + "\u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║ \u001B[35mFakultas                  : " + String.format("%-28s", user.getFakultas()) + "\u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║ \u001B[31mBuku yang telah di pinjam : " + String.format("%-28s", user.getJmlPinjamSelesai()) + "\u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║ \u001B[31mDenda                     : Rp." + String.format("%-25s", user.getDenda()) + "\u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╚═════════════════════════════════════════════════════════╝\u001B[0m");
    }

    protected void displayProfileAll() {
        Scanner input = new Scanner(System.in);
    
        if (users.isEmpty()) {
            System.out.println("\u001B[31mTidak ada user yang terdaftar..\u001B[0m");
            return;
        }
    
        tampilUser();
        System.out.print("Nomor mahasiswa yang ingin ditampilkan : ");
        int pil = input.nextInt();
        input.nextLine();
    
        if (pil <= 0 || pil > users.size()) {
            System.out.println("Nomor tidak valid");
            return;
        }
    
        displayProfile(users.get(pil - 1));
    }
    

    protected void bayarDenda(User user){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Nominal : ");
        long bayar = input.nextLong();
        input.nextLine();

        user.bayarDenda(bayar);
        System.out.println("Pembayaran selesai!");
        displayDenda(user);

    }

    protected void displayKategoriDenda(){
        kategori_denda.display();
    }

    protected Rak getRak(int kode){
        for(Rak rak :rakrak){
            if(rak.getKode() == kode){
                return rak;
            }
        }
        return null;
    }    

    protected int getDendaByKategori(Buku buku){
        String kategori = buku.getKategori();
        return kategori_denda.get(kategori);
    }

    protected void tampilRiwayatUser() {
        Scanner input = new Scanner(System.in);
        if (users.isEmpty()) {
            System.out.println("\u001B[31mTidak ada user yang terdaftar\u001B[0m");
            return;
        }

        System.out.println("Pilih user : ");
        tampilUser();
        System.out.print("Pilihan Anda: ");
        int pil = input.nextInt();
        input.nextLine();
    
        if (pil > 0 && pil <= users.size()) 
        {
            User selectedUser = users.get(pil - 1);
            selectedUser.tampilRiwayat();
        } 
        else 
        {
            System.out.println("Pilihan tidak valid.");
        }
    }

    protected void sortByKategori(){
        for(Rak rak : rakrak){
            rak.sortByKategori();
        }
        
        System.out.println("Berhasil di Sort!");
        tampilBuku();
    }

    protected void sortByJudul(){
        for(Rak rak : rakrak){
            rak.sortByJudul();
        }

        System.out.println("Berhasil di Sort!");
        tampilBuku();
    }

    protected void sortByStock(){
        for(Rak rak : rakrak){
            rak.sortByStock();
        }

        System.out.println("Berhasil di Sort!");
        tampilBuku();
    }
    
    protected void deleteBuku() {
        Scanner input = new Scanner(System.in);


        tampilBuku();

        System.out.print("Masukan posisi Rak Buku : ");
        int index_rak = input.nextInt();
        input.nextLine();
        System.out.print("Masukan No buku         : ");
        int index_buku = input.nextInt();
        input.nextLine();



        Rak rak = getRak(index_rak);

        if(rak != null){
            if (index_buku <= 0 || index_buku > rak.tampiljlhBuku()) {
                System.out.println("Nomor buku tidak valid");
                return;
            }
            rak.deleteBuku(index_buku-1);
        } else {
            System.out.println("Rak Tidak Ditemukan");
        }
    }

    protected void hapusUser() {
        Scanner input = new Scanner(System.in);
        tampilUser();
        
        System.out.print("Nomor user yang ingin dihapus: ");
        int pil = input.nextInt();
        input.nextLine();
    
        if (pil <= 0 || pil > users.size()) {
            System.out.println("Nomor tidak valid");
            return;
        }
    
        User userToDelete = users.get(pil - 1);
        users.remove(userToDelete);
        System.out.println("User berhasil dihapus!");
    }
    
}
