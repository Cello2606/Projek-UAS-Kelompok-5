package com.example.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class Pelanggan extends Orang{

    private String noTelp;

    public Pelanggan() {}

    public Pelanggan(String nama, String noTelp) {
        super(nama);
        this.noTelp = noTelp;
    }
    
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    public String getNoTelp() {
        return noTelp;
    }

    @Override
    public String getJenisOrang() {
        return "Pelanggan";
    }
}