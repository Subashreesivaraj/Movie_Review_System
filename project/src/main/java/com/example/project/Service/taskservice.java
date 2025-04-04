package com.example.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.project.Entity.dataentity;
import com.example.project.repo.tarepo;

@Service
public class taskservice {
	@Autowired tarepo rep;
	public List<dataentity> findAll() {
		return rep.findAll();
	}
	public dataentity post(dataentity user) {
		return rep.save(user);
	}
	public String deleteid(int tid) {
		if(rep.existsById(tid)) {
			rep.deleteById(tid);
			return "Value Deleted Successfully";
		}
		else {
			return "Value Not Found"+tid;
		}
	}
	public dataentity updateid(int tid, dataentity etd) {
		if(rep.existsById(tid)) {
			dataentity obj=rep.findById(tid).get();
			obj.setTaskname(etd.getTaskname());
			obj.setDescription(etd.getDescription());
			obj.setDuedate(etd.getDuedate());
			obj.setStatus(etd.getStatus());
			return rep.save(obj);
		}
		return etd;
	}
	public Page<dataentity> get_data_all(int page,int size) {
		PageRequest obj=PageRequest.of(page, size);
		return rep.findAll(obj);
	}

	public List<dataentity> retrive_specific(String taskname,String description) {
		return rep.findByTasknameAndDescription(taskname, description);
	}

	public List<dataentity> fetchone(List<String> taskname) {
		return rep.findByTasknameIn(taskname);
	}
	public List<dataentity> start(String taskname) {
		return rep.findByTasknameStartingWith(taskname);
	}
	public List<dataentity> end(String taskname) {
		return rep.findByTasknameEndingWith(taskname);
	}
	public List<dataentity> contains(String taskname) {
		return rep.findByTasknameContains(taskname);
	}
	public List<dataentity> iscontains(String taskname) {
		return rep.findByTasknameIsContaining(taskname);
	}
	public List<dataentity> notcontains(String description) {
		return rep.findByDescriptionNotContains(description);
	}
	public List<dataentity> notlike(String taskname) {
		return rep.findByTasknameNotLike(taskname);
	}
	public List<dataentity> dtask() {
		return rep.task();
	}
	public List<dataentity> dtaskid(int taskid) {
		return rep.task_1(taskid);
	}
}
