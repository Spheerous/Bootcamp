package beltexam.serviceimp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import beltexam.models.Cursos;
import beltexam.models.User;
import beltexam.repository.UserRepository;
import beltexam.services.CursosService;
import beltexam.services.UserService;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	@Autowired
	@Lazy
	private UserRepository userRepository;
	@Autowired
	@Lazy
	private CursosService cursoService;

	@Override
	@Transactional
	public void createUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	public User encontrarPorId(long id) {
		Optional<User> otp = userRepository.findById(id);
		if(otp.isPresent()) {
			return otp.get();
		}
		return null;
	}
	@Transactional
	public User añadirCurso(long idCurso, long idUser) {
		User usuario = encontrarPorId(idUser);
		Cursos curso = cursoService.encontrarPorId(idCurso);
		usuario.getCursos().add(curso);
		
		return this.userRepository.save(usuario); 
		
	}
	@Override
	@Transactional
	public User eliminarCurso(long idCurso, long idUser) {
		User usuario = encontrarPorId(idUser);
		Cursos curso = cursoService.encontrarPorId(idCurso);
		usuario.getCursos().remove(curso);
		return userRepository.save(usuario);
	}
}
