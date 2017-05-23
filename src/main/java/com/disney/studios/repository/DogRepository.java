package com.disney.studios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.disney.studios.repository.entity.DogEntity;

public interface DogRepository extends CrudRepository<DogEntity, Long> {
	
	@Query("FROM DogEntity order by  breed")
	public List<DogEntity> findDogsGroupByBreed();
	
	
	@Query("FROM DogEntity  WHERE breed=:breed")
	 public List<DogEntity> findDogsByBreed(@Param("breed") String breed);
	

}
