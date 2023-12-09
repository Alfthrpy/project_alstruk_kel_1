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
        } else if(storage.get(index).getStatus().equals("Tidak Tersedia")){
            if(storage.get(index).getStock() <= 1){
                System.out.println("Buku Sedang Dipinjam !");
                return;
            } else {
                storage.get(index).removeStock();
            }
        }

        System.out.println("Buku Berhasil Di Hapus!");
    }
}
