package com.niit.backendcollaboration.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.niit.backendcollaboration.DAO.BlogDAO;
import com.niit.backendcollaboration.model.Blog;
import com.niit.backendcollaboration.model.User;

@RestController
public class BlogController {

	@Autowired
	private BlogDAO blogDAO;
	

	public BlogDAO getBlogDAO() {
		return blogDAO;
	}

	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}

	@GetMapping("/blogs") // working
	public List<Blog> getBlogs() {
		return blogDAO.list();
	}
	@GetMapping("/acceptedblog") // works
	public ResponseEntity<List<Blog>> acceptedBlogsList() {
		List<Blog> listblog = blogDAO.getApprovedList();
		return new ResponseEntity<List<Blog>>(listblog, HttpStatus.OK);
	}
	@GetMapping("/notAcceptedblog") // works
	public ResponseEntity<List<Blog>> notAcceptedBlogList() {
		List<Blog> listblog = blogDAO.getNotApprovedList();
		return new ResponseEntity<List<Blog>>(listblog, HttpStatus.OK);
	}
	@GetMapping("/blog/{id}")//works
	public ResponseEntity getBlog(@PathVariable("id") int id) {

		Blog blog = blogDAO.get(id);
		if (blog == null) {
			return new ResponseEntity("No Blog found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(blog, HttpStatus.OK);
	}
	
	@GetMapping("/blogByTitle/{blogtitle}") // works
	public ResponseEntity getBlog(@PathVariable("blogtitle") String title) {

		Blog blog = blogDAO.get_title(title);
		if (blog == null) {
			return new ResponseEntity("No Blog found for title " + title, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(blog, HttpStatus.OK);
	}

	@PostMapping("/blogs")  //  i have uncommented user stuff coz blog not getting added
	public ResponseEntity save(@RequestBody Blog blog, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		System.out.println(blog.getBlogtitle());
		blog.setUserId(user.getCusId()); // should i do this to make mapping work
		blog.setName(user.getName());
		blog.setStatus("NA");
		blogDAO.saveOrUpdate(blog);
				
		return new ResponseEntity(blog, HttpStatus.OK);
	}

	@DeleteMapping("/blogs/{id}") // works
	public ResponseEntity deleteBlog(@PathVariable int id) {
		Blog blog = blogDAO.get(id);
		if (blog == null) {
			return new ResponseEntity("No Blog found for ID " + id, HttpStatus.NOT_FOUND);
		}
		blogDAO.delete(id);
		return new ResponseEntity(id, HttpStatus.OK);

	}
	
	@PutMapping("/blogs")  // works what is id in this line how is id passed
	public ResponseEntity updateBlog(@RequestBody Blog blog) {

		 blogDAO.saveOrUpdate(blog);

		if (blog==null) {
			return new ResponseEntity("No Blog found for id " + blog.getBlogId(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(blog, HttpStatus.OK);
	}

	@PutMapping("/acceptBlog")
public ResponseEntity acceptBlog(@RequestBody Blog blog)
{
		blog.setStatus("A");
		blogDAO.saveOrUpdate(blog);
		return new ResponseEntity(blog, HttpStatus.OK);
 }
	
	
	
	
}
	 