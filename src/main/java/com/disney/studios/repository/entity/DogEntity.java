package com.disney.studios.repository.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dogs_tbl")
public class DogEntity {
	private long did;
	private String breed;
	private String imgUrl;
	private String description;
	private List<UserFavoritedEntity> users;
	
	
	public DogEntity(){
		
	}

	public DogEntity(String breed, String imgUrl, String description) {
		this.breed = breed;
		this.imgUrl = imgUrl;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getDid() {
		return did;
	}

	public void setDid(long did) {
		this.did = did;
	}

	@Column(length=150)
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	
	@Column(length=200)
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Column(length=200)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "dog", fetch = FetchType.EAGER, orphanRemoval = true)
	public List<UserFavoritedEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserFavoritedEntity> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "DogEntity [did=" + did + ", breed=" + breed + ", imgUrl=" + imgUrl + ", description=" + description
				+ "]";
	}

}
