package com.example.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.tableentity;

@Repository
public interface notirepo extends JpaRepository<tableentity, Integer>{
	List<tableentity> findAll();
}
