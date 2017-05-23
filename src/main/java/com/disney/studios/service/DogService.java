package com.disney.studios.service;

import java.util.List;

import com.disney.studios.rest.model.Dog;
import com.disney.studios.rest.model.VoteUpDown;

/**
 * 
 * @author ppaos
 *
 */
public interface DogService {
	public List<Dog> findDogsByBreed(String breedName);
	public String voteUpDown(VoteUpDown voteUpDown);
	public List<Dog> findDogsGroupByBreed();
	public Dog findDogDetail(long did);
	
}
