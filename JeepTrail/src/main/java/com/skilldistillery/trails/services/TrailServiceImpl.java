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

	@Override
	public List<Trail> findAllOrderByHighestElevationAsc() {
		return trailRepo.findAllByOrderByHighestElevationAsc();
	}

	@Override
	public List<Trail> findAllOrderByHighestElevationDesc() {
		return trailRepo.findAllByOrderByHighestElevationDesc();
	}

	@Override
	public List<Trail> findAllByOrderByDateCompletedAsc() {
		return trailRepo.findAllByOrderByDateCompletedAsc();
	}

	@Override
	public List<Trail> findAllByOrderByDateCompletedDesc() {
		return trailRepo.findAllByOrderByDateCompletedDesc();
	}
	
	@Override
	public List<Trail> findAllByOrderByLengthAsc() {
		return trailRepo.findAllByOrderByLengthAsc();
	}
	
	@Override
	public List<Trail> findAllByOrderByLengthDesc() {
		return trailRepo.findAllByOrderByLengthDesc();
	}

	@Override
	public List<Trail> findByNameLikeOrNotesLike(String keyword) {
		keyword = "%" + keyword + "%";
		return trailRepo.findByNameLikeOrNotesLike(keyword, keyword);
	}


}
