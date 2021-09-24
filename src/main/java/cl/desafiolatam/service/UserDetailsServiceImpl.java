package cl.desafiolatam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.desafiolatam.mapper.UsersMapper;
import cl.desafiolatam.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UsersMapper userMapper;
	

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		
		User user = userMapper.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		//System.out.println(user.getPassword());
		authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), authorities);
		
	}
}
