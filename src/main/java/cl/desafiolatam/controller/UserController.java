package cl.desafiolatam.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.desafiolatam.model.User;
import cl.desafiolatam.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping({ "/", "/login" })
	public ModelAndView usuario() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@PostMapping("/register")
	public RedirectView agregaUsuario(@Valid @ModelAttribute User user) {
		String view = userService.saveUser(user);
		RedirectView rv = new RedirectView(view);
		return rv;
	}

	@GetMapping("/nuevo")
	public ModelAndView registrarNuevo(@RequestParam(required = false) String error) {
		ModelAndView mav = new ModelAndView("register");
		if (error != null) {
			if (error.equals("errorP")) {
				mav.addObject("errorPass", "Contraseñas no coinciden");
				// System.out.println("Error");
			}
			if (error.equals("errorM")) {
				mav.addObject("errorMail", "Usuario ya existe");
				// System.out.println("Error");
			}
		}
		return mav;
	}

	@GetMapping("/logout")
	public ModelAndView salir(HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/");
		session.invalidate();
		return mav;
	}
}
