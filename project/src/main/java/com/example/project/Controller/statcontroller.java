package com.example.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Entity.fiveentity;
import com.example.project.Service.statservice;

@RestController
public class statcontroller {
	@Autowired statservice std;
	@GetMapping("/sfetch")
	public List<fiveentity> getall() {
		return std.findAll();
	}
	@PostMapping("/spost")
	public fiveentity postall(@RequestBody fiveentity obj)
	{
		return std.post(obj);
	}
	@DeleteMapping("/sdelete/{sid}")
	public String deleted(@PathVariable int sid) {
		return std.deleteid(sid);
	}
	@PutMapping("/supdate/{sid}")
	public fiveentity updatebyid(@PathVariable int sid,@RequestBody fiveentity etd) {
		return std.updateid(sid, etd);
	}
}
