package cl.desafiolatam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cl.desafiolatam.dao.RatingRepository;
import cl.desafiolatam.dao.ShowRepository;
import cl.desafiolatam.model.Rating;
import cl.desafiolatam.model.Show;

@Service
public class ShowService {

	@Autowired
	ShowRepository showRepo;
	
	@Autowired
	RatingRepository ratingRepo;
	
	public List<Show> listaShows(){
		return showRepo.findAll(Sort.by(Sort.Direction.ASC,"showTitle"));
	}
	
	public void saveShow(Show show) {
		showRepo.save(show);
	}
	
	public Show editShow(Long id) {
		Show showId = showRepo.findById(id).get();
		return showId;
	}
	
	public void deleteShow(Long id) {
		List<Rating> listR = ratingRepo.findAll();
		for (Rating rating : listR) {
			if (rating.getIdPelicula().getId()==id) {
				ratingRepo.deleteById(rating.getId());
			}
		}
		showRepo.deleteById(id);
	}
}
