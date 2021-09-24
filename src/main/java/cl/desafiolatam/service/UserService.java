package cl.desafiolatam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.desafiolatam.dao.UserRepository;
import cl.desafiolatam.mapper.UsersMapper;
import cl.desafiolatam.model.User;

@Service
public class UserService {
	@Autowired
	UsersMapper userMapper;
	@Autowired
	UserRepository userRepo;

	public String saveUser(User user) {
		User userMail = userMapper.findByEmail(user.getEmail());
		if (userMail == null) {

			if (user.getPassword().equals(user.getPasswordConfirmation())) {
				// System.out.println("son iguales");
				BCryptPasswordEncoder bCryp = new BCryptPasswordEncoder();
				user.setPassword(bCryp.encode(user.getPassword()));
				user.setPasswordConfirmation(bCryp.encode(user.getPasswordConfirmation()));
				userRepo.save(user);
				return "/";
			} else return "/nuevo/?error=errorP";
			
		} else {
			return "/nuevo/?error=errorM";
		}
	}

	public List<User> listaUsers() {
		return userRepo.findAll();
	}

	public User findById(Long id) {
		return userRepo.findById(id).get();
	}
}
