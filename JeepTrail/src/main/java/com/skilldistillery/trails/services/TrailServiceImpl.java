package com.skilldistillery.trails.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.trails.entities.Trail;
import com.skilldistillery.trails.repositories.TrailRepository;

@Service
public class TrailServiceImpl implements TrailService {

	@Autowired
	private TrailRepository trailRepo;

	@Override
	public List<Trail> listAllTrails() {
		return trailRepo.findAll();

	}

	@Override
	public Trail showTrail(int trailId) {
		if (!trailRepo.existsById(trailId)) {
			return null;
		}
		return trailRepo.findById(trailId);

	}

	@Override
	public Trail create(Trail trail) {
		return trailRepo.saveAndFlush(trail);

	}

	@Override
	public Trail update(int trailId, Trail trail) {
		Trail managed = null;
		managed = trailRepo.findById(trailId);
		if (managed != null) {
			managed.setName(trail.getName());
			managed.setLength(trail.getLength());
			managed.setDateCompleted(trail.getDateCompleted());
			managed.setImageUrl(trail.getImageUrl());
			managed.setEntranceLatitude(trail.getEntranceLatitude());
			managed.setEntranceLongitude(trail.getEntranceLongitude());
			managed.setHighestElevation(trail.getHighestElevation());

			return trailRepo.save(managed);
		}
		return managed;
	}

	@Override
	public boolean delete(int trailId) {
		trailRepo.deleteById(trailId);
		
		return !trailRepo.existsById(trailId);
	}

}
