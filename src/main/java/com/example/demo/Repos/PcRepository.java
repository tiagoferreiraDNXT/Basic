package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Pc;

@Repository
public interface PcRepository extends JpaRepository<Pc, Integer> {

}
