package com.resource;

import java.util.ArrayList;

public class Rak {
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

    // int getStockBookatRak(Buku bk){
    //     int stock = 0;
    //     for(int i = 0; i < storage.size(); i++){
    //         if(storage.get(i).getJudul().equals(bk.getJudul())){
    //             stock++;
    //         }
    //     }
    //     return stock;
    // }

    // int getBookTersedia(Buku bk){
    //     int jml = 0;
    //     for(int i = 0; i < storage.size(); i++){
    //         if(storage.get(i).getJudul().equals(bk.getJudul()) && storage.get(i).getStatus().equals("Tersedia")){
    //             jml++;
    //         }
    //     }
    //     return jml;
    // }

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
                "%s%-5s%s | %s%-"+judulWidth+"s%s | %s%-"+penulisWidth+"s%s | %s%-8s%s | %s%s%s\n",
                yellowColor, "No", resetColor,
                yellowColor, "Judul", resetColor,
                yellowColor, "Penulis", resetColor,
                yellowColor, "Stok", resetColor,
                yellowColor, "Status", resetColor
        );
    
        // Menampilkan data buku
        for (int i = 0; i < storage.size(); i++) {
            if (i > 0 && storage.get(i).getJudul().equals(storage.get(i - 1).getJudul())) {
                continue;
            } else {
                int stock = storage.get(i).getStock();
                System.out.printf("%-5d | %-"+judulWidth+"s | %-"+penulisWidth+"s | %-8d | %s\n", i + 1, storage.get(i).getJudul(), storage.get(i).getPenulis(), stock, storage.get(i).getStatus());
            }
        }
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
}
