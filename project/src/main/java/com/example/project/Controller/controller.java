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

import com.example.project.Entity.entity;
import com.example.project.Service.databaseService;

@RestController
public class controller {
	@Autowired databaseService std;
	@GetMapping ("/fetch")
	public List<entity> all() {
		return std.getall();
	}
	@PostMapping("/post")
	public entity postall(@RequestBody entity obj)
	{
		return std.post(obj);
	}
	@DeleteMapping("/delete/{pid}")
	public String deleted(@PathVariable int pid) {
		return std.deleteid(pid);
	}
	@PutMapping("/update/{id}")
	public entity updatebyid(@PathVariable int pid,@RequestBody entity etd) {
		return std.updateid(pid, etd);
	}
	@GetMapping("/page")
	public Page<entity> page_12(@RequestParam int page,@RequestParam int size) {
		return std.get_data_all(page, size);
	}
	@GetMapping("/and")
	public List<entity> specific(@RequestParam String pname,@RequestParam String pdescription) {
		return std.retrive_specific(pname, pdescription);
	}
	@GetMapping("/start")
	public List<entity> startingwith(@RequestParam String pname) {
		return std.start(pname);
	}
	@GetMapping("/end")
	public List<entity> endingwith(@RequestParam String pname) {
		return std.end(pname);
	}
	@GetMapping("/contain")
	public List<entity> containing(@RequestParam String pname) {
		return std.contains(pname);
	}
	@GetMapping("/iscontain")
	public List<entity> iscontaining(@RequestParam String pname) {
		return std.iscontains(pname);
	}
	@GetMapping("/notcontains")
	public List<entity> notcontaining(@RequestParam String pdescription) {
		return std.notcontains(pdescription);
	}
	@GetMapping("/notlike")
	public List<entity> notlike(@RequestParam String pname) {
		return std.notlike(pname);
	}
	@GetMapping("/task")
	public List<entity> dbtask() {
		return std.dtask();
	}
	@GetMapping("/taskid")
	public List<entity> dtaskid(@RequestParam int pid) {
		return std.dtaskid(pid);
	}
}
