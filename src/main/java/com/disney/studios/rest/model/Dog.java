package com.disney.studios.rest.model;

import java.util.List;

public class Dog {

	private long did;
	private String breed;
	private String imgUrl;
	private String description;
	private List<UserFavorited> users;

	public long getDid() {
		return did;
	}

	public void setDid(long did) {
		this.did = did;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserFavorited> getUsers() {
		return users;
	}

	public void setUsers(List<UserFavorited> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Dog [did=" + did + ", breed=" + breed + ", imgUrl=" + imgUrl + ", description=" + description + "]";
	}

}
