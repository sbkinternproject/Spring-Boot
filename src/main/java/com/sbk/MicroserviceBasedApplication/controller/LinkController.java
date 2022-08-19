package com.sbk.MicroserviceBasedApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbk.MicroserviceBasedApplication.service.LinkService;
import com.sbk.MicroserviceBasedApplication.model.Link;


// Rest Controller is an convient annotation that combines @Controller and @ResponseBody
// which eliminates the need to annotate every request handling method of the controller class
// with @responsebody annotation
@RestController
@RequestMapping("/link")
public class LinkController {
	private LinkService linkService;

	public LinkController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}
	// Build Create Link REST API
	@PostMapping("/saveLink")
	public ResponseEntity<Link> saveLink(@RequestBody Link link){
		// @RequestBody annotation allows us to retrieve the request's body
		// and automatically convert it to java object
//		System.out.println(fullName);
//		Link link = new Link();
//		System.out.println("Link Object from Body is "+link);
		return new ResponseEntity<Link>(linkService.saveLink(link),HttpStatus.CREATED);
	}
	@GetMapping("/getAllLinks")
	public ResponseEntity<List<Link>> getAllLinks(){
		return new ResponseEntity<List<Link>>(linkService.getAllLinks(), HttpStatus.OK);
	}
}
