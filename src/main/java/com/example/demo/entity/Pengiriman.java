package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class Pengiriman extends detailPemesanan implements LacakBarang{

    private String jenisKendaraan, noPemesanan, alamatTujuan;

    private LocalDateTime waktuSampai = LocalDateTime.now();

    public Pengiriman() {}

    public Pengiriman(String catatan, String jenisKendaraan, String noPemesanan, String alamatTujuan) {
        super(catatan);
        this.jenisKendaraan = jenisKendaraan;
        this.noPemesanan = noPemesanan;
        this.alamatTujuan = alamatTujuan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }
    public String getJenisKendaraan() {
        return jenisKendaraan;
    }
    
    public void setNoPemesanan(String noPemesanan) {
        this.noPemesanan = noPemesanan;
    }
    public String getNoPemesanan() {
        return noPemesanan;
    }

    public void setAlamatTujuan(String alamatTujuan) {
        this.alamatTujuan = alamatTujuan;
    }
    public String getAlamatTujuan() {
        return alamatTujuan;
    }


    public void setWaktuSampai(LocalDateTime waktuSampai) {
        this.waktuSampai = waktuSampai;
    }

    @Override
    public LocalDateTime getWaktu() {
        return waktuSampai;
    }

    @Override
    public String getStatus() { 
        return "Sudah Sampai";
    }
}