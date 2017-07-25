package com.niit.backendcollaboration.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backendcollaboration.DAO.JobDAO;
import com.niit.backendcollaboration.model.Job;
import com.niit.backendcollaboration.model.User;
import com.niit.backendcollaboration.model.Error;

@RestController
public class JobController {
@Autowired
private JobDAO jobDAO;

public JobDAO getJobDAO() {
	return jobDAO;
}

public void setJobDAO(JobDAO jobDAO) {
	this.jobDAO = jobDAO;
}

@GetMapping("/jobs")   // works
public List getJobs() {
	return jobDAO.list();
}

@GetMapping("/jobs/{id}")   // works
public ResponseEntity getJob(@PathVariable("id") int id) {

	Job job = jobDAO.getByJobId(id);
	if (job == null) {
		return new ResponseEntity("No Job found for ID " + id, HttpStatus.NOT_FOUND);
	}

	return new ResponseEntity(job, HttpStatus.OK);
}

@PostMapping("/jobs")      // works
public ResponseEntity createjob(@RequestBody Job job) {

	jobDAO.saveOrUpdate(job);

	return new ResponseEntity(job, HttpStatus.OK);
}
@DeleteMapping("/jobs/{id}") //working
public ResponseEntity deleteJob(@PathVariable int id) {
	Job job=jobDAO.getByJobId(id);
		if (job==null) {
		return new ResponseEntity("No Job found for ID " + id, HttpStatus.NOT_FOUND);
	}
		jobDAO.delete(id);
	return new ResponseEntity(id, HttpStatus.OK);

}
@PutMapping("/job") // works
public ResponseEntity updateJob( @RequestBody Job job) {

	 jobDAO.saveOrUpdate(job);

	if (job == null) {
		
		return new ResponseEntity("No Job found for id " + job.getId(), HttpStatus.NOT_FOUND);
	}

	return new ResponseEntity(job, HttpStatus.OK);
}


}