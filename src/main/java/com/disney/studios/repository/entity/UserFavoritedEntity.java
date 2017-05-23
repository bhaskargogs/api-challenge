package com.disney.studios.repository.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_dogs_favorited_tbl")
public class UserFavoritedEntity {
	private String userid;
	private boolean voted;
	private Timestamp doe;
	
	private DogEntity dog;

	
	@ManyToOne
	@JoinColumn(name="fmid",nullable=true)
	public DogEntity getDog() {
		return dog;
	}

	public void setDog(DogEntity dog) {
		this.dog = dog;
	}

	@Id
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public boolean isVoted() {
		return voted;
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	@Override
	public String toString() {
		return "UserFavoritedEntity [userid=" + userid + ", voted=" + voted + ", doe=" + doe + "]";
	}

}
