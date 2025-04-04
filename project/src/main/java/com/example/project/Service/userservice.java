package com.example.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.project.Entity.databaseEntity;
import com.example.project.repo.dbrepo;

@Service
public class userservice {
	@Autowired dbrepo rep;
	public List<databaseEntity> findAll() {
		return rep.findAll();
	}
	public databaseEntity post(databaseEntity user) {
		return rep.save(user);
	}
	public String deleteid(int pid) {
		if(rep.existsById(pid)) {
			rep.deleteById(pid);
			return "Value Deleted Successfully";
		}
		else {
			return "Value Not Found"+pid;
		}
	}
	public databaseEntity updateid(int pid, databaseEntity etd) {
		if(rep.existsById(pid)) {
			databaseEntity obj=rep.findById(pid).get();
			obj.setName(etd.getName());
			obj.setRole(etd.getRole());
			obj.setEmail(etd.getEmail());
			return rep.save(obj);
		}
		return etd;
	}
	public Page<databaseEntity> get_data_all(int page,int size) {
		PageRequest obj=PageRequest.of(page, size);
		return rep.findAll(obj);
	}

	public List<databaseEntity> retrive_specific(String name,String email) {
		return rep.findByNameAndEmail(name, email);
	}

	public List<databaseEntity> fetchone(List<String> name) {
		return rep.findByNameIn(name);
	}
	public List<databaseEntity> start(String name) {
		return rep.findByNameStartingWith(name);
	}
	public List<databaseEntity> end(String name) {
		return rep.findByNameEndingWith(name);
	}
	public List<databaseEntity> contains(String name) {
		return rep.findByNameContains(name);
	}
	public List<databaseEntity> iscontains(String name) {
		return rep.findByNameIsContaining(name);
	}
	public List<databaseEntity> notcontains(String email) {
		return rep.findByemailNotContains(email);
	}
	public List<databaseEntity> notlike(String name) {
		return rep.findByNameNotLike(name);
	}
	public List<databaseEntity> dtask() {
		return rep.task();
	}
	public List<databaseEntity> dtaskid(int id) {
		return rep.task_1(id);
	}

}
