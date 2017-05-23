package com.disney.studios.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.disney.studios.rest.model.ApplicationMessage;
import com.disney.studios.rest.model.Dog;
import com.disney.studios.rest.model.VoteUpDown;
import com.disney.studios.rest.util.DogRestApiConstant;
import com.disney.studios.service.DogService;

@RequestMapping(DogRestApiConstant.REST_API_VERSION)
@RestController
public class DogRestController {
	
	@Autowired
	private DogService dogService;
	
	@RequestMapping(value="/dogsbreed",method=
			RequestMethod.GET,	produces={MediaType.APPLICATION_JSON_VALUE})
	public List<Dog> findDogsGroupsBreed(){
		return dogService.findDogsGroupByBreed();
	}
	@RequestMapping(value="/dogs/{breedName}",method=
			RequestMethod.GET,	produces={MediaType.APPLICATION_JSON_VALUE})
	public List<Dog> findDogsBreedName(@PathVariable String breedName){
		List<Dog> dogs=dogService.findDogsByBreed(breedName);
		return dogs;
	}
	
	@RequestMapping(value="/dog/{did}",method=
			RequestMethod.GET,	produces={MediaType.APPLICATION_JSON_VALUE})
	public Dog findDogByDid(@PathVariable("did") long did){
		return dogService.findDogDetail(did);
	}
	
	@RequestMapping(value="/voteUpDown",method=
			RequestMethod.POST,	produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
	public ApplicationMessage voteUpDown(@RequestBody VoteUpDown voteUpDown){
		 String result=dogService.voteUpDown(voteUpDown);
		 ApplicationMessage applicationMessage=new ApplicationMessage();
		 applicationMessage.setMessage(result);
		 applicationMessage.setStatus("success");
		 return applicationMessage;
	}

}
