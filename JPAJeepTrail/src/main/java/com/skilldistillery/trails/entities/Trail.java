package com.skilldistillery.trails.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private Double length;
	
	@Column(name="date_completed")
	private LocalDate dateCompleted;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="entrance_latitude")
	private Double entranceLatitude;
	
	@Column(name="entrance_longitude")
	private Double entranceLongitude;
	
	@Column(name="highest_elevation")
	private Double highestElevation;
	
	private String notes;
	

	// METHODS

	public Trail() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public LocalDate getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(LocalDate dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Double getEntranceLatitude() {
		return entranceLatitude;
	}

	public void setEntranceLatitude(Double entranceLatitude) {
		this.entranceLatitude = entranceLatitude;
	}

	public Double getEntranceLongitude() {
		return entranceLongitude;
	}

	public void setEntranceLongitude(Double entranceLongitude) {
		this.entranceLongitude = entranceLongitude;
	}

	public Double getHighestElevation() {
		return highestElevation;
	}

	public void setHighestElevation(Double highestElevation) {
		this.highestElevation = highestElevation;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trail other = (Trail) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Trail [id=" + id + ", name=" + name + ", length=" + length + ", dateCompleted=" + dateCompleted
				+ ", imageUrl=" + imageUrl + ", entranceLatitude=" + entranceLatitude + ", entranceLongitude="
				+ entranceLongitude + ", highestElevation=" + highestElevation + ", notes=" + notes + "]";
	}

}
