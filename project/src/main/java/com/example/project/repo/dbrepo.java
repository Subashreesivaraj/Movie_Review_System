package com.example.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.Entity.databaseEntity;

@Repository
public interface dbrepo extends JpaRepository<databaseEntity, Integer>,PagingAndSortingRepository<databaseEntity, Integer>{
	List<databaseEntity> findAll();
	List<databaseEntity> findByNameAndEmail(String name,String email);
	
	List<databaseEntity> findByNameOrEmail(String name,String email);
	
	List<databaseEntity> findByNameIn(List<String> name);
	
	List<databaseEntity> findByNameStartingWith(String name);
	
	List<databaseEntity> findByNameEndingWith(String name);
	
	List<databaseEntity> findByNameContains(String name);
	
	List<databaseEntity> findByNameIsContaining(String name);
	
	List<databaseEntity> findByemailNotContains(String email);
	
	List<databaseEntity> findByNameNotLike(String name);
	
	@Query("SELECT d from databaseEntity d")
	List<databaseEntity> task();
	
	@Query("SELECT d from databaseEntity d WHERE d.id=:id")
	List<databaseEntity> task_1(@Param("id")int id);
	
	@Query("DELETE from databaseEntity d WHERE d.id=:id")
	@Modifying
	@Transactional
	void delete(@Param("id")int id);
}