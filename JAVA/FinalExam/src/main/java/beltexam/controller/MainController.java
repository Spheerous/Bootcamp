package beltexam.controller;


import java.security.Principal;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beltexam.Validator.UserValidator;
import beltexam.models.Cursos;
import beltexam.models.User;
import beltexam.serviceimp.UserServiceImp;
import beltexam.services.CursosService;
import beltexam.services.PermisosService;
import beltexam.services.UserService;

@Controller
public class MainController {
	@Autowired
	@Lazy
	private UserService userService;
	@Autowired
	@Lazy
	private PermisosService permisosService;
	@Autowired
	@Lazy
	private CursosService cursoService;
	@Autowired
	@Lazy
	private UserValidator userValidator;
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required= false)String error, @RequestParam(value="logout", required=false)String logout,Model model) {
		if(error != null) {
			model.addAttribute("error", "Error, usuario o  Contraseña Erroneo, Intente de nuevo.");
		}
		if(logout != null) {
			model.addAttribute("logout", "Se cerro Su session de forma Exitosa!");
			return"redirect:/registration";
		}
		else {
			return"redirect:/registration";
		}
	}
	@GetMapping("/registration")
	public String register(@Valid @ModelAttribute("user")User user, Model model) {
		model.getAttribute("errorMessage");
		return"register.jsp";
	}
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return"register.jsp";
		}
		else {
			userService.createUser(user);
			return"redirect:/registration";
		}
	}
	@GetMapping("/dashboard")
	public String dashboard(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByEmail(username));
		model.addAttribute("cursos", cursoService.todosLosCursos());
		return"dashboard.jsp";
	}
	@GetMapping("/show/{id}")
	public String mostrarCurso(Principal principal,@PathVariable("id")long id, Model model) {
		String username = principal.getName();
		model.addAttribute("curso", cursoService.encontrarPorId(id));
		model.addAttribute("currentUser", userService.findByEmail(username));
		return"mostrarCurso.jsp";
	}	
	@GetMapping("/añadirUser/{idCurso}/{userId}")
	public String añadirUsuarioACurso(@PathVariable("idCurso")long id, @PathVariable("userId")long idUser) {
		userService.añadirCurso(id, idUser);
		return "redirect:/dashboard";
	}
	@GetMapping("/eliminarCurso/{idCurso}/{userId}")
	public String eliminarCursoAUsuario(@PathVariable("idCurso")long id, @PathVariable("userId")long idUser) throws Exception {
		User user = userService.encontrarPorId(idUser);
		Cursos curso = cursoService.encontrarPorId(id);
		curso.eliminarUsuarios(user);
		cursoService.crear(curso);
		return"redirect:/show/"+id;
	}
	@GetMapping("/crear")
	public String nuevoCurso(@ModelAttribute("curso")Cursos curso) {
		return"nuevoCurso.jsp";
	}
	@PostMapping("/crearCurso")
	public String crearCurso(@Valid @ModelAttribute("curso")Cursos curso, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return"nuevoCurso.jsp";
		}
		else {
			cursoService.crear(curso);
			return"redirect:/dashboard";
		}
	}
	@GetMapping("/editar/{id}")
	public String nuevaEdicion(@PathVariable("id")long id, Model model) {
		Cursos cur = cursoService.encontrarPorId(id);
		model.addAttribute("curso", cur);
		return "editarCurso.jsp";
	}
	@PutMapping("/{id}")
	public String editar(@Valid @ModelAttribute("curso")Cursos curso, @PathVariable("id")long id, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return"redirect:/editar/"+id;
		}
		else {
			this.cursoService.actualizar(id, curso);
			return"redirect:/show/"+id;
		}
	}
	@DeleteMapping("delete/{id}")
	public String eliminar(@PathVariable("id")long id) throws Exception {
		cursoService.eliminar(id);
		return"redirect:/dashboard";
	}
	

}
