package com.resource;

public class Admin {
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