package com.example.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.Entity.emailentity;

public interface emailrepo extends JpaRepository<emailentity, Integer>{

}
