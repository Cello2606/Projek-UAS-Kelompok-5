package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaksi;

    private double totalOngkos;

    private String metodePembayaran;

    @ManyToOne
    @JoinColumn(name = "pelangganID")
    private Pelanggan pelanggan;

    @ManyToOne
    @JoinColumn(name = "pengirimanID")
    private Pengiriman pengiriman;

    public Transaksi() {}

    public Transaksi (Pelanggan pelanggan, Pengiriman pengiriman, Integer idTransaksi, double totalOngkos, String metodePembayaran) {
        this.idTransaksi = idTransaksi;
        this.totalOngkos = totalOngkos;
        this.metodePembayaran = metodePembayaran;
        this.pelanggan = pelanggan;
        this.pengiriman = pengiriman;
    }

    public void setIdTransaksi(Integer idTransaksi) {
        this.idTransaksi = idTransaksi;
    }
    public Integer getIdTransaksi() {
        return idTransaksi;
    }

    public void setTotalOngkos(double totalOngkos) {
        this.totalOngkos = totalOngkos;
    }
    public double getTotalOngkos() {
        return totalOngkos;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }
    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }
    public Pelanggan getPelanggan(){
        return pelanggan;
    }

    public void setPengiriman(Pengiriman pengiriman) {
        this.pengiriman = pengiriman;
    }
    public Pengiriman getPengiriman() {
        return pengiriman;
    }
}