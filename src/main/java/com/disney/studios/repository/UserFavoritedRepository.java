package com.disney.studios.repository;

import org.springframework.data.repository.CrudRepository;

import com.disney.studios.repository.entity.UserFavoritedEntity;

public interface UserFavoritedRepository extends CrudRepository<UserFavoritedEntity, String> {
	

}
