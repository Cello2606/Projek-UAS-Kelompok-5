package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Transaksi;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {}