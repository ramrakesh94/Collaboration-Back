package com.niit.backendcollaboration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.niit.backendcollaboration.DAO.BlogCommentsDAO;
import com.niit.backendcollaboration.model.BlogCommentz;
import com.niit.backendcollaboration.model.User;
@RestController
public class BlogCommentController {
	
	@Autowired
	private BlogCommentsDAO blogCommentDAO;

	public BlogCommentsDAO getBlogCommentDAO() {
		return blogCommentDAO;
	}

	public void setBlogCommentDAO(BlogCommentsDAO blogCommentDAO) {
		this.blogCommentDAO = blogCommentDAO;
	}
	
	@GetMapping("/blogcomment")
	public List<BlogCommentz> getComments() {
		return blogCommentDAO.list();
	}
	
	@GetMapping("/blogss/{blogId}")
	public ResponseEntity getBlogId(@PathVariable("blogId") int blogId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("blogId", blogId);
		System.out.println("heeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		System.out.println(blogId);
		List<BlogCommentz> listcomment = blogCommentDAO.getBlogComments(blogId);
		if (listcomment == null) {
			return new ResponseEntity("No Comment found for ID " + blogId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(listcomment, HttpStatus.OK);
	}
	
	@GetMapping("/blogcomment/{id}")
	public ResponseEntity getBlogCommentId(@PathVariable("id") int id) {

		BlogCommentz blogComment = blogCommentDAO.getBlogComment(id);
		if (blogComment == null) {
			return new ResponseEntity("No BlogComment found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(blogComment, HttpStatus.OK);
	}
	
	@PostMapping(value = "/blogcomments") // not working in POSTMAN
	public ResponseEntity createBlogComment(@RequestBody BlogCommentz blogComment, HttpSession session) {
		System.out.println("Sup");
		
		User user = (User) session.getAttribute("user"); // what is this blue user
		System.out.println("hRakesh");
		System.out.println(user.getEmail());
		System.out.println(user.getMobile());
		blogComment.setUsername(user.getName()); // is it get username
		blogComment.setMail(user.getEmail());
		blogComment.setUserId(user.getCusId());
		
		int blogId =  (Integer) session.getAttribute("blogId"); // is this correct ?
		System.out.println("________________________________________________________---------------------------");
		System.out.println(blogId);
	      blogComment.setBlogId(blogId);
		blogCommentDAO.save(blogComment);  // saveOrUpdate not working
		return new ResponseEntity(blogComment, HttpStatus.OK);
	}
	
	@DeleteMapping("/blogcomment/{id}")
	public ResponseEntity deleteBlogComment(@PathVariable int id) {
		BlogCommentz blogComment = blogCommentDAO.getBlogComment(id);
		if (blogComment == null) {
			return new ResponseEntity("No Comment found for ID " + id, HttpStatus.NOT_FOUND);
		} else {
			blogCommentDAO.delete(id);

			return new ResponseEntity(id, HttpStatus.OK);
		}
	}
	
	@PutMapping("/blogcomment/{id}")
	public ResponseEntity updateComment(@PathVariable String id, @RequestBody BlogCommentz blogComment) {

		blogComment = blogCommentDAO.saveOrUpdate(blogComment);

		if (null == blogComment) {
			return new ResponseEntity("No Comment found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(blogComment, HttpStatus.OK);
	}

}
