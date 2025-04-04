package com.example.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.tableentity;
import com.example.project.repo.notirepo;

@Service
public class notificationservice {
	@Autowired notirepo rep;
	public List<tableentity> findAll() {
		return rep.findAll();
	}
	public tableentity post(tableentity user) {
		return rep.save(user);
	}
	public String deleteid(int nid) {
		if(rep.existsById(nid)) {
			rep.deleteById(nid);
			return "Value Deleted Successfully";
		}
		else {
			return "Value Not Found"+nid;
		}
	}
	public tableentity updateid(int nid, tableentity etd) {
		if(rep.existsById(nid)) {
			tableentity obj=rep.findById(nid).get();
			obj.setContent(etd.getContent());
			obj.setSent(etd.getSent());
			return rep.save(obj);
		}
		return etd;
	}
}