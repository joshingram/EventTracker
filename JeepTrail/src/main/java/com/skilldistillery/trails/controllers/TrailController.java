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
	
	@GetMapping("trails/sort/elev/asc")
	public List<Trail> listTrailsByHighestElevation() {
		return trailSvc.findAllOrderByHighestElevationAsc();
	}
	
	@GetMapping("trails/sort/elev/desc")
	public List<Trail> listTrailsByHighestElevationDesc() {
		return trailSvc.findAllOrderByHighestElevationDesc();
	}
}
