package com.skilldistillery.trails.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.trails.entities.Trail;
import com.skilldistillery.trails.services.TrailService;

@RestController
@RequestMapping("api")
public class TrailController {

	@Autowired
	private TrailService trailSvc;

	@GetMapping("trails")
	public List<Trail> listTrails() {
		return trailSvc.listAllTrails();
	}

	@GetMapping("trails/{id}")
	public Trail findTrailById(@PathVariable int id, HttpServletResponse res) {
		Trail trail = trailSvc.showTrail(id);
		if (trail == null) {
			res.setStatus(404);
		}
		return trail;
	}

	@PostMapping("trails")
	public Trail createTrail(@RequestBody Trail trail, HttpServletResponse res, HttpServletRequest req) {
		try {
			trail = trailSvc.create(trail);
			res.setStatus(201);
			StringBuffer urlSb = req.getRequestURL();
			urlSb.append("/").append(trail.getId());
			String url = urlSb.toString();
			res.setHeader("Location", url);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			trail = null;
		}
		return trail;
	}

	@PutMapping("trails/{id}")
	public Trail updateTrail(@PathVariable int id, @RequestBody Trail trail, HttpServletResponse res) {
		try {
			trail = trailSvc.update(id, trail);
			if (trail == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			trail = null;
		}
		return trail;
	}

	@DeleteMapping("trails/{id}")
	public void deleteTrail(@PathVariable int id, HttpServletResponse res) {
		try {
			if (trailSvc.delete(id)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	// Two options for sort/order. Both options work.  
	// Option 1:
//	@GetMapping("trails/sort/elev/asc")
//	public List<Trail> listTrailsByHighestElevation() {
//		return trailSvc.findAllOrderByHighestElevationAsc();
//	}
//	
//	@GetMapping("trails/sort/elev/desc")
//	public List<Trail> listTrailsByHighestElevationDesc() {
//		return trailSvc.findAllOrderByHighestElevationDesc();
//	}
//	
//	@GetMapping("trails/sort/date/asc")
//	public List <Trail> listTrailsByDateCompletedAsc(){
//		return trailSvc.findAllByOrderByDateCompletedAsc();
//	}
//	
//	@GetMapping("trails/sort/date/desc")
//	public List <Trail> listTrailsByDateCompletedDesc(){
//		return trailSvc.findAllByOrderByDateCompletedDesc();
//	}
	
	//Option 2:
	@GetMapping("trails/sort/{field}/{order}")
	public List<Trail> listTrailsByFieldSort(@PathVariable String field, @PathVariable String order, HttpServletResponse res) {
		if (field.equals("elev")) {
			if (order.equals("asc")) {
				return trailSvc.findAllOrderByHighestElevationAsc();
			} else if (order.equals("desc")){
				return trailSvc.findAllOrderByHighestElevationDesc();
			} else 
				res.setStatus(400);
				return null;
		} else if (field.equals("date")) {
			if (order.equals("asc")) {
				return trailSvc.findAllByOrderByDateCompletedAsc();
			} else if (order.equals("desc")){
				return trailSvc.findAllByOrderByDateCompletedDesc();
			} else 
				res.setStatus(400);
				return null;
		} else if (field.equals("length")) {
			if (order.equals("asc")) {
				return trailSvc.findAllByOrderByLengthAsc();
			} else if (order.equals("desc")){
				return trailSvc.findAllByOrderByLengthDesc();
			} else 
				res.setStatus(400);
				return null;		
		} else
			res.setStatus(400);
			return null;
	}

	
	@GetMapping("trails/search/{keyword}")
	public List <Trail> listTrailsByKeyWord(@PathVariable String keyword){
		return trailSvc.findByNameLikeOrNotesLike(keyword);
	}
}
