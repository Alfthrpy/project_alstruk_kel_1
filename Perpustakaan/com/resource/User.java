package com.resource;

import java.util.ArrayList;

public class User {
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

    protected int getJmlRiwayat(){
        return finishedPinjam.size();
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
