package com.resource;

public class Buku {
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
        System.out.println("\u001B[34m║ \u001B[35mStatus          : " + String.format("%-25s", status) + "\u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╚════════════════════════════════════════════╝\u001B[0m");
    }
}
