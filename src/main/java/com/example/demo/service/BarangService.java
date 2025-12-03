package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Barang;
import com.example.demo.repository.BarangRepository;

@Service
public class BarangService {
    @Autowired
    private BarangRepository barangRepository;

    public List<Barang> getAllBarang() {
        return barangRepository.findAll();
    }

    public Barang addBarang(Barang obj){
        obj.setPesananID(null);
        return barangRepository.save(obj);
    }

    public Barang getBarangById(Integer id){
        return barangRepository.findById(id).orElse(null);
    }

    public Barang updateBarang(Integer id, Barang obj){
        return barangRepository.save(obj);
    }

    public Barang findBarang (Integer id){
        return barangRepository.findById(id).orElse(null);
    }

    public void deleteBarang(Integer id){
        barangRepository.deleteById(id);
    }
}