/*package com.niit.backendcollaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backendcollaboration.DAO.ForumDAO;
import com.niit.backendcollaboration.model.Forum;

@RestController
public class ForumController {	

	@Autowired
	private ForumDAO forumDAO;
	
	public ForumDAO getForumDAO() {
		return forumDAO;
	}

	public void setForumDAO(ForumDAO forumDAO) {
		this.forumDAO = forumDAO;
	}

	@GetMapping("/forums") // works
	public ResponseEntity<List> getForums() {
		List listforum = forumDAO.list();
		return new ResponseEntity(listforum,HttpStatus.OK);
	}
	
	@GetMapping("/forum/{id}")// not wworking which value is given to path variable  class attribute name ?
	public ResponseEntity getForum(@PathVariable("forumId") int forumId) {

		Forum forum = forumDAO.get(forumId);
		if (forum == null) {
			return new ResponseEntity("No Forum found for ID " + forumId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(forum, HttpStatus.OK);
	}
	
	@PostMapping(value = "/forums")             // how to check this - id generated with other fields null after commenting reqbody
	public ResponseEntity createForum(@RequestBody Forum forum) {

		forumDAO.saveOrUpdate(forum);

		return new ResponseEntity(forum, HttpStatus.OK);
	}

	@DeleteMapping("/forums/{id}") // not working
	public ResponseEntity deleteForum(@PathVariable int forumId) {
		Forum forum = forumDAO.get(forumId);
 		if (forum==null) {
			return new ResponseEntity("No Forum found for ID " + forumId, HttpStatus.NOT_FOUND);
		}
 		forumDAO.delete(forumId);
		return new ResponseEntity(forumId, HttpStatus.OK);

	}

	@PutMapping("/forums/{id}") // new generating
	public ResponseEntity updateForum(@PathVariable int id, @RequestBody Forum forum) {

		forum = forumDAO.saveOrUpdate(forum);

		if (null == forum) {
			return new ResponseEntity("No Forum found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(forum, HttpStatus.OK);
	}

}


*/