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
}
