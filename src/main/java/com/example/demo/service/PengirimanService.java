package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pengiriman;
import com.example.demo.repository.PengirimanRepository;

@Service
public class PengirimanService {

    @Autowired
    private PengirimanRepository pengirimanRepository;

    public List<Pengiriman> getAllPengiriman() { 
        return pengirimanRepository.findAll(); 
    }

    public Pengiriman addPengiriman(Pengiriman obj){
        obj.setPesananID(null);
        return pengirimanRepository.save(obj);
    }

    public Pengiriman getPengirimanById(Integer id) { 
        return pengirimanRepository.findById(id).orElse(null); 
    }

    public Pengiriman updatePengiriman(Integer id, Pengiriman obj){
        return pengirimanRepository.save(obj);
    }

    public void savePengiriman(Pengiriman pengiriman) { 
        pengirimanRepository.save(pengiriman); 
    }

    public Pengiriman findPengiriman(Integer id){
        return pengirimanRepository.findById(id).orElse(null);
    }

    public void deletePengiriman(Integer id) { 
        pengirimanRepository.deleteById(id); 
    }
}