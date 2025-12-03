package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pelanggan;
import com.example.demo.repository.PelangganRepository;

@Service
public class PelangganService {

    @Autowired
    private PelangganRepository pelangganRepository;

    public List<Pelanggan> getAllPelanggan() {
        return pelangganRepository.findAll();
    }

    public Pelanggan addPelanggan(Pelanggan obj){
        obj.setAccountID(null);
        return pelangganRepository.save(obj);
    }

    public Pelanggan getPelangganById(long id){
        return pelangganRepository.findById(id).orElse(null);
    }

    public Pelanggan updatePelanggan(long id, Pelanggan obj){
        return pelangganRepository.save(obj);
    }

    public Pelanggan findPelanggan (long id){
        return pelangganRepository.findById(id).orElse(null);
    }

    public void deletePelanggan(long id){
        pelangganRepository.deleteById(id);
    }
}