package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Pengiriman;

@Repository
public interface PengirimanRepository extends JpaRepository<Pengiriman, Integer> {
}