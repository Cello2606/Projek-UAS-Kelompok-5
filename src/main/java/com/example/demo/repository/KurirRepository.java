package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Kurir;

public interface KurirRepository extends JpaRepository<Kurir, Integer> {}