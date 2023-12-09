package com.resource;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Scanner;

public class Pinjam {
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
        System.out.println("\nBuku telah berhasil di pinjam!");
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
