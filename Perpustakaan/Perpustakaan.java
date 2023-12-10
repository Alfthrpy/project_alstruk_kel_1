
import java.util.Scanner;
import java.util.Map;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;


class Admin {
    private String nama;
    private String kode;

    public Admin(String nama, String kode){
        this.nama = nama;
        this.kode = kode;
    }

    protected String getNama(){
        return nama;
    }

    protected String getKode(){
        return kode;
    }
}


class Buku {
    private String judul;
    private String penulis;
    private String status = "Tersedia";
    private int stock = 1;
    private Rak rak;
    private String kategori;


    public Buku(String judul, String penulis, String kategori){
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
    }

    protected void aturRak(Rak rak){
        this.rak = rak;
    }

    protected String getJudul(){
        return judul;
    }

    protected String getPenulis(){
        return penulis;
    }

    protected String getStatus(){
        return status;
    }

    protected void setStatus(){
        status = "Tidak Tersedia";
    }

    protected void setAktif(){
        status = "Tersedia";
    }

    void addStock(){
        stock += 1;
    }

    protected void removeStock(){
        stock -=1;
    }

    protected int getStock(){
        return stock;
    }

    protected String getKategori(){
        return kategori;
    }

    protected void displayInfo(){
        System.out.println("\u001B[34m╔════════════════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[34m║                \u001B[32mINFO BUKU                   \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║ \u001B[36mJudul Buku      : " + String.format("%-25s", judul) + "\u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║ \u001B[36mPenulis         : " + String.format("%-25s", penulis) + "\u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║ \u001B[36mRak             : " + String.format("%-25s", rak.getKode()) + "\u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║ \u001B[32mStock           : " + String.format("%-25s", stock) + "\u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║ \u001B[32mKategori        : " + String.format("%-25s", kategori) + "\u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m║ \u001B[35mStatus          : " + String.format("%-25s", status) + "\u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╚════════════════════════════════════════════╝\u001B[0m");
    }
}


class Display {
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


class HashMap<Key, Value> {

    private static final int DEFAULT_CAPACITY = 16;
    private Node<Key, Value>[] table;
    private int size;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int initialCapacity) {
        this.table = new Node[initialCapacity];
        this.size = 0;
    }

    public void put(Key key, Value value) {
        int hash = hash(key);
        int index = getIndex(hash);

        if (table[index] == null) {
            table[index] = new Node<>(hash, key, value, null);
            size++;
        } else {
            // Handle collision by chaining
            Node<Key, Value> currentNode = table[index];
            while (currentNode.next != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value; // Update existing key
                    return;
                }
                currentNode = currentNode.next;
            }
            currentNode.next = new Node<>(hash, key, value, null);
            size++;
        }


    }

    public Value get(Key key) {
        int hash = hash(key);
        int index = getIndex(hash);

        Node<Key, Value> currentNode = table[index];
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null; // Key not found
    }

    public int size() {
        return size;
    }

    private int hash(Key key) {
        return key == null ? 0 : key.hashCode();
    }

    private int getIndex(int hash) {
        return (hash & 0x7FFFFFFF) % table.length; // Modulo to stay within array bounds
    }


    public void display() {
        String reset = "\u001B[0m";
        String cyan = "\u001B[36m";
        String yellow = "\u001B[33m";

        System.out.println("\u001B[34m╔════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[34m║   \u001B[35mDENDA BERDASARKAN KATEGORI   \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╚════════════════════════════════╝\u001B[0m");
        for (Node<Key, Value> node : table) {
            while (node != null) {
                Key kategori = node.key;
                Value denda = node.value;

                String formattedOutput = String.format("        %s%-3s%s :    %sRp.%-3d%s\n", cyan, kategori, reset, yellow, denda, reset);

                System.out.println(formattedOutput);

                node = node.next;
            }
        }
    }

    private static class Node<Key, Value> {
        private final int hash;
        private final Key key;
        private Value value;
        private Node<Key, Value> next;

        public Node(int hash, Key key, Value value, Node<Key, Value> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}


class Pinjam {
    private String tgl_pinjam;
    private String tgl_perjanjian;
    private String tgl_kembali_asli;
    private long denda = 0;
    private Buku bk;
    private Rak rk;
    private User user;
    private String status = "Belum Selesai";
    private long selisih = 0;

    Pinjam(User user, String tgl_pinjam, Buku bk, Rak rk){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate tgl_pinjam_date = LocalDate.now();
        LocalDate tgl_kembali_date = tgl_pinjam_date.plusDays(7);
        String tgl_perjanjian = tgl_kembali_date.format(format);
        
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_perjanjian = tgl_perjanjian;
        this.user = user;
        this.bk = bk;
        this.rk = rk;
        bk.removeStock();
        if(bk.getStock() == 0){
            bk.setStatus();
        }
    }

    protected void kembali(User user, int denda, String kategori){
        Scanner input = new Scanner(System.in);

        boolean flag = false;
        while(true){
            System.out.print("Masukan tanggal kembali :");
            String tgl_kembali = input.nextLine();
            tgl_kembali_asli = tgl_kembali;


            int kondisi = checkTanggal(tgl_kembali_asli);
            this.selisih = selisihHari(tgl_kembali_asli, tgl_pinjam);
            switch (kondisi) {
                case 4:
                case 1:
                    this.denda = 0;
                    this.selisih = 0;
                    flag = true;
                    break;
                case 2:
                    this.denda = countDenda(selisih,denda);
                    flag = true;
                    break;
                case 3:
                    System.out.println("Tanggal Tidak Valid");
                    break;
            }

            if (flag){
                break;
            }
        }
        

        System.out.println("\u001B[34m╔═════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[34m║     \u001B[96mBUKU TELAH DI KEMBALIKAN    \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╠═════════════════════════════════╣\u001B[0m");
        System.out.printf("\u001B[34m║ TANGGAL PERJANJIAN : " + String.format("%-11s", this.tgl_perjanjian) + "║\u001B[0m\n");
        System.out.printf("\u001B[34m║ TANGGAL KEMBALI    : " + String.format("%-11s", tgl_kembali_asli) +"║\u001B[0m\n");
        System.out.printf("\u001B[34m║ SELISIH HARI       : " + String.format("%-11d", this.selisih) +"║\u001B[0m\n");
        System.out.printf("\u001B[34m║ KATEGORI DENDA     : " + String.format("%-11s", kategori) +"║\u001B[0m\n");
        System.out.printf("\u001B[34m║ DENDA              : Rp. " + String.format("%-7d", this.denda) +"║\u001B[0m\n");
        System.out.println("\u001B[34m╚═════════════════════════════════╝\u001B[0m");
        
        this.status = "Selesai";
        bk.setAktif();
        bk.addStock();
        
        if(!rk.checkBook(bk)){
            rk.addBuku(bk);
        }
        
        user.addDenda(this.denda);
    }
    
    protected String getTglPinjam(){
        return tgl_pinjam;
    }

    protected String getTglJanji(){
        return tgl_perjanjian;
    }

    protected Buku getBuku(){
        return bk;
    }

    protected long selisihHari(String tgl_kembali, String tgl_perjanjian){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate tanggal_kembali_asli = LocalDate.parse(tgl_kembali,format);
        LocalDate tanggal_perjanjian = LocalDate.parse(this.tgl_perjanjian,format);
        long selisih = ChronoUnit.DAYS.between(tanggal_perjanjian,tanggal_kembali_asli);
        return selisih;
    }

    protected long countDenda(long selisih, int denda){
        return selisih != 0 ? selisih*denda : 0;
    }


    protected String getStatus(){
        return status;
    }

    protected String getTglKembaliAsli(){
        return tgl_kembali_asli;
    }

    protected long getDenda(){
        return this.denda;
    }

    protected int checkTanggal(String tgl_kembali){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate tanggal_kembali_asli = LocalDate.parse(tgl_kembali,format);
        LocalDate tanggal_perjanjian = LocalDate.parse(this.tgl_perjanjian,format);
        LocalDate tanggal_peminjaman = LocalDate.parse(this.tgl_pinjam,format);

        if(tanggal_kembali_asli.isBefore(tanggal_perjanjian) && tanggal_kembali_asli.isAfter(tanggal_peminjaman)){
            return 1;
        } else if(tanggal_kembali_asli.isAfter(tanggal_perjanjian)){
            return 2;
        } else if(tanggal_kembali_asli.isBefore(tanggal_peminjaman)){
            System.out.println("Tanggal yang di masukan tidak valid...");
            return 3;
        } else {
            return 4;
        }
    }
}


class Rak {
    private int kode_rak;
    private ArrayList<Buku> storage = new ArrayList<Buku>();

    public Rak(int kode_rak){
        this.kode_rak = kode_rak;
    }

    public void addBuku(Buku bk){
        if(!checkBook(bk)){
            storage.add(bk);
        } else {
            addStock(bk);
        }
        
    }

    protected int getKode(){
        return kode_rak;
    }

    protected void removeBuku(Buku bk){
        storage.remove(bk);
    }


    protected void tampilBuku(ArrayList<Rak> rakrak) {
        // Menentukan lebar maksimum untuk setiap kolom
        int judulWidth = 0;
        int penulisWidth = 0;
        String yellowColor = "\u001B[33m";
        String resetColor = "\u001B[0m";
    
        for (Rak rk : rakrak) {
            for (Buku book : rk.storage) {
                judulWidth = Math.max(judulWidth, book.getJudul().length());
                penulisWidth = Math.max(penulisWidth, book.getPenulis().length());
            }
        }
    
        // Menampilkan header tabel
        System.out.printf(
            "%s%-5s%s | %s%-"+judulWidth+"s%s | %s%-"+penulisWidth+"s%s | %s%-8s%s | %s%-10s%s | %s%-10s%s \n",
            yellowColor, "No", resetColor,
            yellowColor, "Judul", resetColor,
            yellowColor, "Penulis", resetColor,
            yellowColor, "Stok", resetColor,
            yellowColor, "Kategori", resetColor,
            yellowColor, "Status", resetColor
        );
    
        // Menampilkan data buku
        for (int i = 0; i < storage.size(); i++) {
            if (i > 0 && storage.get(i).getJudul().equals(storage.get(i - 1).getJudul())) {
                continue;
            } else {
                int stock = storage.get(i).getStock();
                System.out.printf("%-5d | %-"+judulWidth+"s | %-"+penulisWidth+"s | %-8d | %-10s | %s\n", 
                i + 1, 
                storage.get(i).getJudul(), 
                storage.get(i).getPenulis(), 
                stock, 
                storage.get(i).getKategori(),  // Ambil kategori dari objek storage
                storage.get(i).getStatus()
                );

            }
        }
    }
    
    protected int tampiljlhBuku() {
        // Menentukan lebar maksimum untuk setiap kolom
        int jlhbuku = 0;
    
        for (int j = 0; j < storage.size(); j++) {
            jlhbuku += storage.get(j).getStock();
        }
        return jlhbuku;
    }

    protected Buku getBuku(int index){
        return storage.get(index);
    }

    protected ArrayList<Buku> getStorage(){
        return storage;
    }

    protected boolean checkBook(Buku bk){
        for(Buku buku : storage){
            if(buku.getJudul().equals(bk.getJudul())){
                return true;
            }
        }
        return false;
    }

    protected void addStock(Buku bk){
        for(Buku buku : storage){
            if(buku.getJudul().equals(bk.getJudul())){
                buku.addStock();
                if(buku.getStock() > 0){
                    buku.setAktif();
                }
                break;
            }
        }
    }

    protected void sortByKategori(){
        int n = storage.size();

        for(int i=0; i<n; i++){
            for(int j=1; j<(n-i); j++){
                int compare = storage.get(j-1).getKategori().compareTo(storage.get(j).getKategori());
                if(compare > 0){
                    Buku temp = storage.get(j-1);
                    storage.set(j-1, storage.get(j));
                    storage.set(j, temp);
                }
            }
        }
    }

    protected void sortByJudul(){
        int n = storage.size();
        for(int i=0; i<n; i++){
            for(int j=1; j<(n-i); j++){
                String judul1 = storage.get(j-1).getJudul();
                String judul2 = storage.get(j).getJudul();
                int compare = judul1.compareTo(judul2);
                if(compare > 0){
                    Buku temp = storage.get(j-1);
                    storage.set(j-1, storage.get(j));
                    storage.set(j, temp);
                }
            }
        }
    }

    protected void sortByStock(){
        int n = storage.size();
        for(int i=0; i<n; i++){
            for(int j=1; j<(n-i); j++){
                int stock1 = storage.get(j-1).getStock();
                int stock2 = storage.get(j).getStock();

                if(stock1 < stock2){
                    Buku temp = storage.get(j-1);
                    storage.set(j-1, storage.get(j));
                    storage.set(j, temp);
                }
            }
        }
    }

    protected void deleteBuku(int index){
        if(storage.get(index).getStatus().equals("Tersedia")){
            if(storage.get(index).getStock() <= 1){
                storage.remove(index);
            } else {
                storage.get(index).removeStock();
            }
            System.out.println("\u001B[32mBuku Berhasil di Hapus!\u001B[0m");
        } else if(storage.get(index).getStatus().equals("Tidak Tersedia")){
            if(storage.get(index).getStock() <= 1){
                System.out.println("\u001B[31mBuku Sedang Dipinjam!\u001B[0m");
                return;
            } else {
                storage.get(index).removeStock();
            }
        }

        System.out.println("Buku Berhasil Di Hapus!");
    }
}


class Sistem {
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
        System.out.println("\u001B[32mUser berhasil di tambahkan\u001B[0m");
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
        System.out.println("\u001B[32mRak baru berhasil ditambahkan\u001B[0m");
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
        System.out.println("\u001B[32mBuku Berhasil ditambahkan ke rak " + rak.getKode()+"\u001B[0m");
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
        System.out.println("Tanggal peminjaman :" + tgl_pinjam);

    
        Rak rk = getRak(idx_rak);
        if(rk != null){
            Buku bk = rk.getBuku(idx_bk-1);
            int stock = bk.getStock();
            if(stock > 0){
                if(user.getDenda() == 0){
                    Pinjam pj = new Pinjam(user,tgl_pinjam,bk,rk);
                    user.addPinjam(pj);
                    System.out.println("\u001B[32mBuku Berhasil di Pinjam!\u001B[0m");
                } else {
                    System.out.println("Anda Mempunyai Denda!");
                }

            } else {
                System.out.println("\u001B[31mBuku sedang di pinjam!\u001B[0m");
            }
        } else {
            System.out.println();
            System.out.println("\u001B[31mERROR...\u001B[0m");
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
        Buku bk = null;
        for(int i = 0; i < rakrak.size(); i++){
            ArrayList<Buku> buku_buku = rakrak.get(i).getStorage();
            for(int j = 0; j < buku_buku.size(); j++){
                if(buku_buku.get(j).getJudul().equals(judul)){
                   rak = i;
                   bk = buku_buku.get(j);
                   found = true;
                   break;
                }
            }
        }

        rak += 1;
        if(found){
            System.out.println("\u001B[32mBuku Ditemukan!\u001B[0m");
            bk.displayInfo();
        } else {
            System.out.println("\u001B[31mBuku Tidak Ditemukan!\u001B[0m");
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
        System.out.println("\u001B[32mPembayaran selesai!\u001B[0m");
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

    protected void sortBukuByKategori(){
        for(Rak rak : rakrak){
            rak.sortByKategori();
        }
        
        System.out.println("\u001B[32mBerhasil di Sort!\u001B[0m");
        tampilBuku();
    }

    protected void sortBukuByJudul(){
        for(Rak rak : rakrak){
            rak.sortByJudul();
        }

        System.out.println("\u001B[32mBerhasil di Sort!\u001B[0m");
        tampilBuku();
    }

    protected void sortBukuByStock(){
        for(Rak rak : rakrak){
            rak.sortByStock();
        }

        System.out.println("\u001B[32mBerhasil di Sort!\u001B[0m");
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
                System.out.println("\u001B[31mNomor buku tidak valid\u001B[0m");
                return;
            }
            rak.deleteBuku(index_buku-1);

        } else {
            System.out.println("\u001B[31mRak Tidak Ditemukan\u001B[0m");
        }
    }

    protected void hapusUser() {
        Scanner input = new Scanner(System.in);
        tampilUser();
        
        System.out.print("Nomor user yang ingin dihapus: ");
        int pil = input.nextInt();
        input.nextLine();
    
        if (pil <= 0 || pil > users.size()) {
            System.out.println("\u001B[31mNomor tidak valid\u001B[0m");
            return;
        }
    
        User userToDelete = users.get(pil - 1);
        users.remove(userToDelete);
        System.out.println("\u001B[32mUser berhasil dihapus!\u001B[0m");
    }

    public void addBuku(Buku bk, Rak rk){
        rk.addBuku(bk);
        bk.aturRak(rk);
    }

    protected void sortUserByNama(){
        int n = users.size();
        for (int i = 1; i < n; ++i) {
            User key = users.get(i);
            int j = i - 1;
            while (j >= 0 && users.get(j).getNama().compareTo(key.getNama()) > 0) {
                users.set(j + 1, users.get(j));
                j = j - 1;
            }
            users.set(j + 1, key);
        }
        System.out.println("\u001B[32mBerhasil di Sort!\u001B[0m");
        tampilUser();
    }

    protected void sortUserByNim(){
        int n = users.size();
        for (int i = 1; i < n; ++i) {
            User key = users.get(i);
            int j = i - 1;
            while (j >= 0 && users.get(j).getNim().compareTo(key.getNim()) > 0) {
                users.set(j + 1, users.get(j));
                j = j - 1;
            }
            users.set(j + 1, key);
        }
        System.out.println("\u001B[32mBerhasil di Sort!\u001B[0m");
        tampilUser();
    }

    
}


class User {
    private String nama;
    private String nim;
    private String jurusan;
    private String fakultas;
    private ArrayList<Pinjam> notFinishedPinjam = new ArrayList<Pinjam>();
    private ArrayList<Pinjam> finishedPinjam = new ArrayList<Pinjam>();
    private long denda = 0;

    public User(String nama, String nim, String jurusan, String fakultas){
        this.nama = nama;
        this.nim = nim;
        this.fakultas = fakultas;
        this.jurusan = jurusan;
    }

    protected void addPinjam(Pinjam pj){
        notFinishedPinjam.add(pj);
    }

    protected void finishedPinjam(Pinjam pj){
        notFinishedPinjam.remove(pj);
        finishedPinjam.add(pj);
    }

    protected String getNama(){
        return nama;
    }

    protected String getNim(){
        return nim;
    }
    
    protected String getJurusan(){
        return jurusan;
    }


    protected String getFakultas(){
        return fakultas;
    }

    protected void tampilRiwayat() {
        if (finishedPinjam.size() != 0) {
            for (int i = 0; i < finishedPinjam.size(); i++) {
                System.out.println("\u001B[34m╔═══════════════════════════════════════════════╗\u001B[0m");
                System.out.println("\u001B[34m║ No Pinjam " + (i + 1) + String.format("%35s", " ") + "║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[36mTanggal pinjam  : " + String.format("%-28s", finishedPinjam.get(i).getTglPinjam()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[36mTanggal kembali : " + String.format("%-28s", finishedPinjam.get(i).getTglKembaliAsli()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[32mJudul buku      : " + String.format("%-28s", finishedPinjam.get(i).getBuku().getJudul()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[35mStatus          : " + String.format("%-28s", finishedPinjam.get(i).getStatus()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[35mDenda           : " + String.format("%-28d", finishedPinjam.get(i).getDenda()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m╚═══════════════════════════════════════════════╝\u001B[0m");
            }
        } else {
            System.out.println("\u001B[31mRiwayat Peminjaman Kosong...\u001B[0m");
        }
    }
    

    protected void tampilStatus() {
        if (notFinishedPinjam.size() != 0) {
            for (int i = 0; i < notFinishedPinjam.size(); i++) {
                System.out.println("\u001B[34m╔═══════════════════════════════════════════════╗\u001B[0m");
                System.out.println("\u001B[34m║ No Pinjam " + (i + 1) + String.format("%35s", " ") + "║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[36mTanggal pinjam  : " + String.format("%-28s", notFinishedPinjam.get(i).getTglPinjam()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[36mTanggal kembali : " + String.format("%-28s", notFinishedPinjam.get(i).getTglJanji()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[32mJudul buku      : " + String.format("%-28s", notFinishedPinjam.get(i).getBuku().getJudul()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[35mStatus          : " + String.format("%-28s", notFinishedPinjam.get(i).getStatus()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m╚═══════════════════════════════════════════════╝\u001B[0m");
            }
        } else {
            System.out.println("\u001B[31mAnda tidak sedang meminjam buku!...\u001B[0m");
        }
    }
    
    

    protected Pinjam getPinjam(int i){
        return notFinishedPinjam.get(i);
    }

    protected long getDenda(){
        return denda;
    }

    protected void addDenda(long rp){
        denda += rp;
    }

    protected void bayarDenda(long rp){
        denda -= rp;
        if(denda < 0){
            System.out.println("kembalian anda : Rp." + Math.abs(denda));
            denda = 0;
        }
    }

    protected int getJmlPinjam(){
        return notFinishedPinjam.size();
    }

    protected int getJmlPinjamSelesai(){
        return finishedPinjam.size();
    }


}


public class Perpustakaan {
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

        

        
        while(true){
            if(display.displayHome(sistem)){
                System.out.println("Program Selesai!");
                System.out.println("Terimakasih!");
                break;
            }
        }
    }
}

