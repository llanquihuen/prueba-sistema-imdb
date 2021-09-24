package cl.desafiolatam.config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		if(roles.contains("ADMIN")) {		
			//System.out.println(roles);
		}else {
			//System.out.println(roles);
			//response.sendRedirect("/home");
		}
        HttpSession session = request.getSession();
        session.setAttribute("nombre",authentication.getName());
        session.setAttribute("auth",authentication.getAuthorities());
		//System.out.println(authentication.getName());
		response.sendRedirect("/home");
	}
	
}
