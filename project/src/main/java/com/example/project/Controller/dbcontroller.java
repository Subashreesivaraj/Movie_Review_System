package com.example.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Entity.databaseEntity;
import com.example.project.Service.userservice;

@RestController
public class dbcontroller {
	@Autowired userservice std;
	@GetMapping("/dfetch")
	public List<databaseEntity> getall() {
		return std.findAll();
	}
	@PostMapping("/dpost")
	public databaseEntity postall(@RequestBody databaseEntity obj)
	{
		return std.post(obj);
	}
	@DeleteMapping("/dbdelete/{id}")
	public String deleted(@PathVariable int id) {
		return std.deleteid(id);
	}
	@PutMapping("/dbupdate/{id}")
	public databaseEntity updatebyid(@PathVariable int id,@RequestBody databaseEntity etd) {
		return std.updateid(id, etd);
	}
	@GetMapping("/dbpage")
	public Page<databaseEntity> page_12(@RequestParam int page,@RequestParam int size) {
		return std.get_data_all(page, size);
	}
	@GetMapping("/dband")
	public List<databaseEntity> specific(@RequestParam String name,@RequestParam String email) {
		return std.retrive_specific(name, email);
	}
	@GetMapping("/dbstart")
	public List<databaseEntity> startingwith(@RequestParam String name) {
		return std.start(name);
	}
	@GetMapping("/dbend")
	public List<databaseEntity> endingwith(@RequestParam String name) {
		return std.end(name);
	}
	@GetMapping("/dbcontain")
	public List<databaseEntity> containing(@RequestParam String name) {
		return std.contains(name);
	}
	@GetMapping("/dbiscontain")
	public List<databaseEntity> iscontaining(@RequestParam String name) {
		return std.iscontains(name);
	}
	@GetMapping("/dbnotcontains")
	public List<databaseEntity> notcontaining(@RequestParam String email) {
		return std.notcontains(email);
	}
	@GetMapping("/dbnotlike")
	public List<databaseEntity> notlike(@RequestParam String name) {
		return std.notlike(name);
	}
	@GetMapping("/dbtask")
	public List<databaseEntity> dbtask() {
		return std.dtask();
	}
	@GetMapping("/dbtaskid")
	public List<databaseEntity> dtaskid(@RequestParam int id) {
		return std.dtaskid(id);
	}
}
