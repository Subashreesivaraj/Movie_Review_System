package com.example.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.Entity.entity;

@Repository
public interface repo extends JpaRepository<entity,Integer>,PagingAndSortingRepository<entity, Integer>{
	List<entity> findAll();
	List<entity> findByPnameAndPdescription(String pname,String pdescription);
	
	List<entity> findByPnameOrPdescription(String pname,String pdescription);
	
	List<entity> findByPnameIn(List<String> pname);
	
	List<entity> findByPnameStartingWith(String pname);
	
	List<entity> findByPnameEndingWith(String pname);
	
	List<entity> findByPnameContains(String pname);
	
	List<entity> findByPnameIsContaining(String pname);
	
	List<entity> findByPdescriptionNotContains(String pdescription);
	
	List<entity> findByPnameNotLike(String pname);
	
	@Query("SELECT d from entity d")
	List<entity> task();
	
	@Query("SELECT d from entity d WHERE d.pid=:pid")
	List<entity> task_1(@Param("pid")int pid);
	
	@Query("DELETE from entity d WHERE d.pid=:pid")
	@Modifying
	@Transactional
	void delete(@Param("pid")int pid);
}