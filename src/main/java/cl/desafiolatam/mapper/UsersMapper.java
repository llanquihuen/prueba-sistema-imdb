package cl.desafiolatam.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cl.desafiolatam.model.User;

@Mapper
public interface UsersMapper {
	@Select("SELECT * FROM usuario WHERE email = #{email}")
	public User findByEmail(@Param("email") String email);
}