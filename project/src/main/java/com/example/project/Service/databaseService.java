package com.example.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.project.Entity.entity;
import com.example.project.repo.repo;

@Service
public class databaseService {
	@Autowired repo rep;
	public List<entity> getall() {
		return rep.findAll();
	}
	public entity post(entity user)
	{
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
	public entity updateid(int pid, entity etd) {
		if(rep.existsById(pid)) {
			entity obj=rep.findById(pid).get();
			obj.setPdescription(etd.getPdescription());
			obj.setPname(etd.getPname());
			return rep.save(obj);
		}
		return etd;
	}
	public Page<entity> get_data_all(int page,int size) {
		PageRequest obj=PageRequest.of(page, size);
		return rep.findAll(obj);
	}
	public List<entity> retrive_specific(String pname,String pdescription) {
		return rep.findByPnameAndPdescription(pname, pdescription);
	}

	public List<entity> fetchone(List<String> pname) {
		return rep.findByPnameIn(pname);
	}
	public List<entity> start(String pname) {
		return rep.findByPnameStartingWith(pname);
	}
	public List<entity> end(String pname) {
		return rep.findByPnameEndingWith(pname);
	}
	public List<entity> contains(String pname) {
		return rep.findByPnameContains(pname);
	}
	public List<entity> iscontains(String pname) {
		return rep.findByPnameIsContaining(pname);
	}
	public List<entity> notcontains(String pdescription) {
		return rep.findByPdescriptionNotContains(pdescription);
	}
	public List<entity> notlike(String pname) {
		return rep.findByPnameNotLike(pname);
	}
	public List<entity> dtask() {
		return rep.task();
	}
	public List<entity> dtaskid(int pid) {
		return rep.task_1(pid);
	}

}
