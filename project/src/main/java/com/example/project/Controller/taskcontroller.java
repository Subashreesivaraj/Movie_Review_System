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

import com.example.project.Entity.dataentity;
import com.example.project.Service.taskservice;

@RestController
public class taskcontroller {
	@Autowired taskservice std;
	@GetMapping("/tafetch")
	public List<dataentity> getall() {
		return std.findAll();
	}
	@PostMapping("/tpost")
	public dataentity postall(@RequestBody dataentity obj)
	{
		return std.post(obj);
	}
	@DeleteMapping("/tdelete/{taskid}")
	public String deleted(@PathVariable int taskid) {
		return std.deleteid(taskid);
	}
	@PutMapping("/tupdate/{taskid}")
	public dataentity updatebyid(@PathVariable int taskid,@RequestBody dataentity etd) {
		return std.updateid(taskid, etd);
	}
	@GetMapping("/tpage")
	public Page<dataentity> page_12(@RequestParam int page,@RequestParam int size) {
		return std.get_data_all(page, size);
	}
	@GetMapping("/tand")
	public List<dataentity> specific(@RequestParam String taskname,@RequestParam String description) {
		return std.retrive_specific(taskname, description);
	}
	@GetMapping("/tstart")
	public List<dataentity> startingwith(@RequestParam String taskname) {
		return std.start(taskname);
	}
	@GetMapping("/tend")
	public List<dataentity> endingwith(@RequestParam String taskname) {
		return std.end(taskname);
	}
	@GetMapping("/tcontain")
	public List<dataentity> containing(@RequestParam String taskname) {
		return std.contains(taskname);
	}
	@GetMapping("/tiscontain")
	public List<dataentity> iscontaining(@RequestParam String taskname) {
		return std.iscontains(taskname);
	}
	@GetMapping("/tnotcontains")
	public List<dataentity> notcontaining(@RequestParam String description) {
		return std.notcontains(description);
	}
	@GetMapping("/tnotlike")
	public List<dataentity> notlike(@RequestParam String taskname) {
		return std.notlike(taskname);
	}
	@GetMapping("/ttask")
	public List<dataentity> dbtask() {
		return std.dtask();
	}
	@GetMapping("/ttaskid")
	public List<dataentity> dtaskid(@RequestParam int taskid) {
		return std.dtaskid(taskid);
	}

}
