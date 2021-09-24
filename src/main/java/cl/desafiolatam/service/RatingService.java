package cl.desafiolatam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.dao.RatingRepository;
import cl.desafiolatam.model.Rating;

@Service
public class RatingService {

	@Autowired
	RatingRepository ratingRepo;
	
	public void addRating(Rating ratings) {
		//System.out.println(ratings.getId());
		ratingRepo.save(ratings);
	}
	public List<Rating> allRating(){
		return ratingRepo.findAll();
		
	}
}
