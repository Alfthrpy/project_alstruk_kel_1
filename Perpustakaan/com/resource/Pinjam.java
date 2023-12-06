package com.resource;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Scanner;

public class Pinjam {
    private String tgl_pinjam;
    private String tgl_perjanjian;
    private String tgl_kembali_asli;
    private Buku bk;
    private User user;
    private String status = "Belum Selesai";

    Pinjam(User user, String tgl_pinjam, Buku bk){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate tgl_pinjam_date = LocalDate.parse(tgl_pinjam,format);
        LocalDate tgl_kembali_date = tgl_pinjam_date.plusDays(7);
        String tgl_perjanjian = tgl_kembali_date.format(format);
        
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_perjanjian = tgl_perjanjian;
        this.user = user;
        this.bk = bk;
        bk.removeStock();
        if(bk.getStock() == 0){
            bk.setStatus();
        }
        System.out.println("Buku telah berhasil di pinjam!");

    }

    protected void kembali(User user, int denda, String kategori){
        Scanner input = new Scanner(System.in);


        System.out.print("Masukan tanggal kembali :");
        String tgl_kembali = input.nextLine();
        tgl_kembali_asli = tgl_kembali;
        long selisih = selisihHari(this.tgl_perjanjian,tgl_kembali);
        System.out.println("\u001B[34m╔═════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[34m║     \u001B[96mBUKU TELAH DI KEMBALIKAN    \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╠═════════════════════════════════╣\u001B[0m");
        System.out.printf("\u001B[34m║ TANGGAL PERJANJIAN : " + String.format("%-11s", this.tgl_perjanjian) + "║\u001B[0m\n");
        System.out.printf("\u001B[34m║ TANGGAL KEMBALI    : " + String.format("%-11s", tgl_kembali_asli) +"║\u001B[0m\n");
        System.out.printf("\u001B[34m║ SELISIH HARI       : " + String.format("%-11d", selisih) +"║\u001B[0m\n");
        System.out.printf("\u001B[34m║ KATEGORI DENDA     : " + String.format("%-11s", kategori) +"║\u001B[0m\n");
        System.out.printf("\u001B[34m║ DENDA              : Rp. " + String.format("%-7d", countDenda(selisih,denda)) +"║\u001B[0m\n");
        System.out.println("\u001B[34m╚═════════════════════════════════╝\u001B[0m");
        
        this.status = "Selesai";
        bk.setAktif();
        bk.addStock();
        
        user.addDenda(countDenda(selisih,denda));
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

    protected long selisihHari(String tgl_pinjam,String tgl_kembali){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate pj = LocalDate.parse(tgl_pinjam,format);
        LocalDate kembali = LocalDate.parse(tgl_kembali,format);

        long selisih = ChronoUnit.DAYS.between(pj, kembali);
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
}
