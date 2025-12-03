package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Kurir;
import com.example.demo.repository.KurirRepository;

@Service
public class KurirService {

    @Autowired
    private KurirRepository kurirRepository;

    public List<Kurir> getAllKurir() {
        return kurirRepository.findAll();
    }

    public Kurir addKurir(Kurir obj) {
        obj.setAccountID(null);
        return kurirRepository.save(obj);
    }

    public Kurir getKurirById(Integer id) {
        return kurirRepository.findById(id).orElse(null);
    }

    public Kurir updateKurir(String id, Kurir obj) {
        return kurirRepository.save(obj);
    }

    public Kurir findKurir(Integer id) {
        return kurirRepository.findById(id).orElse(null);
    }

    public void deleteKurir(Integer id) {
        kurirRepository.deleteById(id);
    }
}