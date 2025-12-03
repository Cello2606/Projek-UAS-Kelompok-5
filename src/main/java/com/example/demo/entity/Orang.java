package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Orang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer AccountID;

    @NotNull
    @Size(min = 5, max = 50)
    private String nama;

    public Orang() {}

    public Orang (String nama) {
        this.nama = nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNama() {
        return nama;
    }

    public void setAccountID(Integer accountID) {
        AccountID = accountID;
    }
    public Integer getAccountID() {
        return AccountID;
    }

    public abstract String getJenisOrang();
}
