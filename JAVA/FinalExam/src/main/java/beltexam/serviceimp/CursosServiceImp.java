package beltexam.serviceimp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beltexam.models.Cursos;
import beltexam.repository.CursosRepository;
import beltexam.services.CursosService;


@Service
public class CursosServiceImp implements CursosService {
	
	@Autowired
	@Lazy
	private CursosRepository cursoRepo;
	

	
	@Override
	public List<Cursos> todosLosCursos(){
		return(List<Cursos>) cursoRepo.findAll();
	}
	@Override
	public Cursos encontrarPorId(long id) {
		Optional<Cursos> otp = cursoRepo.findById(id);
		if(otp.isPresent()) {
			return otp.get();
			}
		return null;
		
	}
	@Override
	@Transactional
	public Cursos crear(Cursos curso) throws Exception {
		try {
			Cursos c = cursoRepo.save(curso);
			return c;
		} catch(Exception a) {
			a.printStackTrace();
			throw a;
		}
	}
	@Override
	@Transactional
	public Cursos actualizar(long id, Cursos curso) throws Exception {
		try {
			Cursos c = this.encontrarPorId(id);
			if(c!= null) {
				c.setName(curso.getName());
				c.setInstructor(curso.getInstructor());
				c.setCapacidad(curso.getCapacidad());
				cursoRepo.save(c);
				return c;
			}
			else {
				throw new Exception("no se puede actualizar un Usuario que no Existe!");
			}
		}catch (Exception b) {
			b.printStackTrace();
			throw b;
		}
	}
	@Override
	@Transactional
	public void eliminar(long id) {
		Cursos c = this.encontrarPorId(id);
		cursoRepo.delete(c);
	}
//	@Override
//	@Transactional
//	public Cursos añadirParticipante(long idUser, long idCurso) {
//		Cursos cursos = encontrarPorId(idCurso);
//		User user = userService.encontrarPorId(idUser);
//		cursos.getUsuarios().add(user);
//		return cursoRepo.save(cursos);
//		
//	}
	

}
