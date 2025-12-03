package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Transaksi;
import com.example.demo.repository.TransaksiRepository;

@Service
public class TransaksiService {
    @Autowired
    private TransaksiRepository transaksiRepository;

    public List<Transaksi> getAllTransaksi() {
        return transaksiRepository.findAll();
    }

    public Transaksi addTransaksi(Transaksi obj){
        obj.setIdTransaksi(null);
        return transaksiRepository.save(obj);
    }

    public Transaksi getTransaksiById(Integer id){
        return transaksiRepository.findById(id).orElse(null);
    }

    public Transaksi updateTransaksi(Integer id, Transaksi obj){
        return transaksiRepository.save(obj);
    }

    public Transaksi findTransaksi (Integer id){
        return transaksiRepository.findById(id).orElse(null);
    }

    public void deleteTransaksi(Integer id){
        transaksiRepository.deleteById(id);
    }
}