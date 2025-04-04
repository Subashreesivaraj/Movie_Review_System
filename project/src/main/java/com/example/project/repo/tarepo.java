package com.example.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.Entity.dataentity;

@Repository
public interface tarepo extends JpaRepository<dataentity, Integer>,PagingAndSortingRepository<dataentity, Integer>{
	List<dataentity> findAll();
	
	List<dataentity> findByTasknameAndDescription(String taskname,String description);
	
	List<dataentity> findByTasknameOrDescription(String taskname,String description);
	
	List<dataentity> findByTasknameIn(List<String> taskname);
	
	List<dataentity> findByTasknameStartingWith(String taskname);
	
	List<dataentity> findByTasknameEndingWith(String taskname);
	
	List<dataentity> findByTasknameContains(String taskname);
	
	List<dataentity> findByTasknameIsContaining(String taskname);
	
	List<dataentity> findByDescriptionNotContains(String description);
	
	List<dataentity> findByTasknameNotLike(String taskname);
	
	@Query("SELECT d from dataentity d")
	List<dataentity> task();
	
	@Query("SELECT d from dataentity d WHERE d.taskid=:taskid")
	List<dataentity> task_1(@Param("taskid")int taskid);
	
	@Query("DELETE from dataentity d WHERE d.taskid=:taskid")
	@Modifying
	@Transactional
	void delete(@Param("taskid")int taskid);
}
