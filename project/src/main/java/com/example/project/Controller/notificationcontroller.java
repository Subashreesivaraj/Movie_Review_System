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

import com.example.project.Entity.tableentity;
import com.example.project.Service.notificationservice;

@RestController
public class notificationcontroller {
	@Autowired notificationservice std;
	@GetMapping("/nofetch")
	public List<tableentity> getall() {
		return std.findAll();
	}
	@PostMapping("/npost")
	public tableentity postall(@RequestBody tableentity obj)
	{
		return std.post(obj);
	}
	@DeleteMapping("/ndelete/{nid}")
	public String deleted(@PathVariable int nid) {
		return std.deleteid(nid);
	}
	@PutMapping("/nupdate/{nid}")
	public tableentity updatebyid(@PathVariable int nid,@RequestBody tableentity etd) {
		return std.updateid(nid, etd);
	}
}
