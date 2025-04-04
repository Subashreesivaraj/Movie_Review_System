package com.example.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.fiveentity;

@Repository
public interface statrepo extends JpaRepository<fiveentity, Integer>{
	List<fiveentity> findAll();
}
