package cl.desafiolatam.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long>{
	@Query("SELECT c FROM Show c")
	public List<Show> findAll(Sort sort);
}
