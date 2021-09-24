package cl.desafiolatam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>{
	@Query("SELECT c FROM Rating c")
	public List<Rating> findAll();

}
