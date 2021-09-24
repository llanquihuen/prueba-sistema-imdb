package cl.desafiolatam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cl.desafiolatam.model.Rating;

@Mapper
public interface RatingMapper {
	@Select("SELECT * FROM rating WHERE id_pelicula = #{pelicula}")
	public List<Rating> findByIdMovie(@Param("pelicula") Integer idPeli);

}
