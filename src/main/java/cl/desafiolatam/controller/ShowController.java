package cl.desafiolatam.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.security.Principal;

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


import cl.desafiolatam.mapper.UsersMapper;
import cl.desafiolatam.model.Rating;
import cl.desafiolatam.model.Show;
import cl.desafiolatam.model.User;
import cl.desafiolatam.service.RatingService;
import cl.desafiolatam.service.ShowService;

@Controller
public class ShowController {

	@Autowired
	UsersMapper userMapper;
	
	@Autowired
	ShowService showService;
	
	@Autowired
	RatingService ratingService;
	
	@PostMapping("/registerShow")
	public RedirectView agregaUsuario(@Valid @ModelAttribute Show show) {
		showService.saveShow(show);
		RedirectView rv = new RedirectView("home");
		return rv;
	}
	
	@GetMapping("/home")
	public ModelAndView home(Principal principal,HttpSession http) {
		ModelAndView mav = new ModelAndView("home");
		String auth = http.getAttribute("auth").toString();
		mav.addObject("listaShows",showService.listaShows());
		mav.addObject("idUsuario",principal.getName());
		mav.addObject("userRole",auth);
		//System.out.println(auth);
		return mav;
	}
	
	@GetMapping("/new")
	public ModelAndView registrarShow() {
	ModelAndView mav = new ModelAndView("new");
	return mav;
	}
	
	@GetMapping("/editar")
	public ModelAndView editarShow(@RequestParam("id") Long id) {
		Show showWithId = showService.editShow(id);
		ModelAndView mav = new ModelAndView("edit");
		mav.addObject("showId",showWithId);
		return mav;
	}
	
	@GetMapping("/show")
	public ModelAndView unShow(@RequestParam("id") Long id,Principal principal) {
		
		Show showWithId = showService.editShow(id);
		ModelAndView mav = new ModelAndView("show");
		User user = userMapper.findByEmail(principal.getName());
		
		List<Rating> ratingFiltro = ratingService.allRating()
				.stream()
				.filter(e -> e.getIdPelicula().getId()==showWithId.getId())
				.collect(Collectors.toList());
		for (Rating rating : ratingFiltro) {
			if(rating.getIdUsuario().getId()==(user.getId())) {
				mav.addObject("laId",rating.getId());
			}
		}
		mav.addObject("ratingList",ratingFiltro);		
		mav.addObject("showId",showWithId);
		mav.addObject("userId",user);
		return mav;
	}
	
	@PostMapping("/update")
	public ModelAndView updateShow(@Valid @ModelAttribute Show show) {
		showService.saveShow(show);
		ModelAndView mav = new ModelAndView("redirect:/home");
		return mav;
	}
	@PostMapping("/makeRating")
	public RedirectView updateShow(@Valid @ModelAttribute Rating rating) {
		if (rating.getRatings()==0) {
			System.out.println("No valido");
		}else {
			ratingService.addRating(rating);
		}
		RedirectView rv = new RedirectView("show/?id="+rating.getIdPelicula().getId());
		return rv;
	}
	
	@GetMapping("/delete")
	public ModelAndView updateShow(@RequestParam("id") Long id) {
		showService.deleteShow(id);
		ModelAndView mav = new ModelAndView("redirect:/home");
		return mav;
	}
	
	
	
}
