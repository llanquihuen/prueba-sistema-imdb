package cl.desafiolatam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT c FROM User c")
	public List<User> findAll();
}
