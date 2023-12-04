package com.resource;

import java.util.ArrayList;

public class User {
    private String nama;
    private String nim;
    private ArrayList<Pinjam> notFinishedPinjam = new ArrayList<Pinjam>();
    private ArrayList<Pinjam> finishedPinjam = new ArrayList<Pinjam>();
    private long denda = 0;

    public User(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
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


    protected void tampilRiwayat() {
        if (finishedPinjam.size() != 0) {
            for (int i = 0; i < finishedPinjam.size(); i++) {
                System.out.println("\u001B[34m╔════════════════════════════════╗\u001B[0m");
                System.out.println("\u001B[34m║ No Pinjam " + (i + 1) + String.format("%20s", " ") + "║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[36mTanggal pinjam  : " + String.format("%-13s", finishedPinjam.get(i).getTglPinjam()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[36mTanggal kembali : " + String.format("%-13s", finishedPinjam.get(i).getTglKembaliAsli()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[32mJudul buku      : " + String.format("%-13s", finishedPinjam.get(i).getBuku().getJudul()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[35mStatus          : " + String.format("%-13s", finishedPinjam.get(i).getStatus()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m╚════════════════════════════════╝\u001B[0m");
            }
        } else {
            System.out.println("\u001B[31mRiwayat Peminjaman Kosong...\u001B[0m");
        }
    }
    

    protected void tampilStatus() {
        if (notFinishedPinjam.size() != 0) {
            for (int i = 0; i < notFinishedPinjam.size(); i++) {
                System.out.println("\u001B[34m╔════════════════════════════════╗\u001B[0m");
                System.out.println("\u001B[34m║ No Pinjam " + (i + 1) + String.format("%20s", " ") + "║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[36mTanggal pinjam  : " + String.format("%-13s", notFinishedPinjam.get(i).getTglPinjam()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[36mTanggal kembali : " + String.format("%-13s", notFinishedPinjam.get(i).getTglJanji()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[32mJudul buku      : " + String.format("%-13s", notFinishedPinjam.get(i).getBuku().getJudul()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m║ \u001B[35mStatus          : " + String.format("%-13s", notFinishedPinjam.get(i).getStatus()) + "\u001B[34m║\u001B[0m");
                System.out.println("\u001B[34m╚════════════════════════════════╝\u001B[0m");
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


}
