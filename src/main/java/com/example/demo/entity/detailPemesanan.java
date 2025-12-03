package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class detailPemesanan{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PesananID;

    private String catatan;

    public detailPemesanan() {}

    public detailPemesanan (String catatan) {
        this.catatan = catatan;
    }


    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
    public String getCatatan() {
        return catatan;
    }

    public void setPesananID(Integer pesananID) {
        PesananID = pesananID;
    }
    public Integer getPesananID() {
        return PesananID;
    }

    public abstract LocalDateTime getWaktu();
}
