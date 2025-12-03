package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class Barang extends detailPemesanan implements LacakBarang{

    private String namaBarang;
    private float berat;
    private String jenisBarang;
    private double hargaBarang;

    private LocalDateTime waktuSekarang = LocalDateTime.now();
    private LocalDateTime waktuPersiapan = waktuSekarang.minusWeeks(1);

    public Barang() {}

    public Barang(String catatan, String namaBarang, float berat, String jenisBarang, double hargaBarang) {
        super(catatan);
        this.namaBarang = namaBarang;
        this.berat = berat;
        this.jenisBarang = jenisBarang;
        this.hargaBarang = hargaBarang;
    }

    public String getNamaBarang() { 
        return namaBarang; 
    }
    public void setNamaBarang(String namaBarang) { 
        this.namaBarang = namaBarang; 
    }

    public float getBerat() { 
        return berat; 
    }
    public void setBerat(float berat) { 
        this.berat = berat; 
    }

    public String getJenisBarang() { 
        return jenisBarang; 
    }
    public void setJenisBarang(String jenisBarang) { 
        this.jenisBarang = jenisBarang; 
    }

    public double getHargaBarang() { 
        return hargaBarang; 
    }
    public void setHargaBarang(double hargaBarang) { 
        this.hargaBarang = hargaBarang; 
    }


    public void setWaktuSekarang(LocalDateTime waktuSekarang) {
        this.waktuSekarang = waktuSekarang;
    }

    public void setWaktuPersiapan(LocalDateTime waktuPersiapan) {
        this.waktuPersiapan = waktuPersiapan;
    }


    @Override
    public LocalDateTime getWaktu() {
        return waktuPersiapan;
    }

    @Override
    public String getStatus() {
        return "Sedang persiapan";
    }

}