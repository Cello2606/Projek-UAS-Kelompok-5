package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Kurir extends Orang {

    private String kurirID;

    @NotNull
    @Size(min = 3, max = 50)
    private String perusahaanKurir;

    public Kurir() {}

    public Kurir(String nama, String kurirID, String perusahaanKurir) {
        super(nama);
        this.kurirID = kurirID;
        this.perusahaanKurir = perusahaanKurir;
    }

    public String getKurirID() {
        return kurirID;
    }

    public void setKurirID(String kurirID) {
        this.kurirID = kurirID;
    }

    public String getPerusahaanKurir() {
        return perusahaanKurir;
    }

    public void setPerusahaanKurir(String perusahaanKurir) {
        this.perusahaanKurir = perusahaanKurir;
    }

    @Override
    public String getJenisOrang() {
        return "Kurir";
    }
}