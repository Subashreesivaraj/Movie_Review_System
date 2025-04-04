package com.example.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.fiveentity;
import com.example.project.repo.statrepo;

@Service
public class statservice {
	@Autowired statrepo rep;
	public List<fiveentity> findAll() {
		return rep.findAll();
	}
	public fiveentity post(fiveentity user) {
		return rep.save(user);
	}
	public String deleteid(int sid) {
		if(rep.existsById(sid)) {
			rep.deleteById(sid);
			return "Value Deleted Successfully";
		}
		else {
			return "Value Not Found"+sid;
		}
	}
	public fiveentity updateid(int sid, fiveentity etd) {
		if(rep.existsById(sid)) {
			fiveentity obj=rep.findById(sid).get();
			obj.setContent(etd.getContent());
			obj.setDelivery(etd.getDelivery());
			return rep.save(obj);
		}
		return etd;
	}
}
