package com.disney.studios.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.disney.studios.repository.DogRepository;
import com.disney.studios.repository.UserFavoritedRepository;
import com.disney.studios.repository.entity.DogEntity;
import com.disney.studios.repository.entity.UserFavoritedEntity;
import com.disney.studios.rest.model.Dog;
import com.disney.studios.rest.model.UserFavorited;
import com.disney.studios.rest.model.VoteUpDown;
import com.disney.studios.service.DogService;

@Service("DogServiceImpl")
@Scope("singleton")
public class DogServiceImpl implements DogService {
	
	@Autowired
    private DogRepository dogRepository;
	
	@Autowired
    private UserFavoritedRepository userFavoritedRepository;
	

	@Override
	public List<Dog> findDogsGroupByBreed() {
		 List<DogEntity> dogEntityList=dogRepository.findDogsGroupByBreed();
		 return convertDogEntityIntoDog(dogEntityList);
	}

	@Override
	public List<Dog> findDogsByBreed(String breedName) {
		 List<DogEntity> dogEntityList=dogRepository.findDogsByBreed(breedName);
		 return convertDogEntityIntoDog(dogEntityList);
	}

	@Override
	public String voteUpDown(VoteUpDown voteUpDown) {
		UserFavoritedEntity userFavoritedEntity=userFavoritedRepository.findOne(voteUpDown.getUserid());
		if(userFavoritedEntity==null) {
			DogEntity dogEntity=dogRepository.findOne(voteUpDown.getDid());
			UserFavoritedEntity favoritedEntity=new UserFavoritedEntity();
			favoritedEntity.setUserid(voteUpDown.getUserid());
			favoritedEntity.setVoted(voteUpDown.isVoted());
			favoritedEntity.setDoe(new Timestamp(new Date().getTime()));
			favoritedEntity.setDog(dogEntity);
			userFavoritedRepository.save(favoritedEntity);
			return "voted";
		}else{
			return "already voted";	
		}
	}

	@Override
	public Dog findDogDetail(long did) {
		DogEntity dogEntity=dogRepository.findOne(did);
		Dog dog=new Dog();
		List<UserFavorited> users=new ArrayList<>();
		BeanUtils.copyProperties(dogEntity, dog,"users");
		List<UserFavoritedEntity> favoritedEntities=dogEntity.getUsers();
		if(favoritedEntities!=null && favoritedEntities.size()>0){
		for(UserFavoritedEntity entity:favoritedEntities){
			UserFavorited favorited=new UserFavorited();
			BeanUtils.copyProperties(entity, favorited,"dog");
			users.add(favorited);
		}
		dog.setUsers(users);
		}
		return dog;
	}
	
	private List<Dog> convertDogEntityIntoDog(List<DogEntity> dogEntityList){
		 List<Dog> dogs=new ArrayList<>();
		 for(DogEntity dogEntity: dogEntityList){
			 Dog dog=new Dog();
			 BeanUtils.copyProperties(dogEntity, dog);
			 dogs.add(dog);
		 }
		return dogs;
	}

}
