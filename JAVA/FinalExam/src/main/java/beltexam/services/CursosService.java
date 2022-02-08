package beltexam.services;

import java.util.List;

import org.springframework.stereotype.Service;

import beltexam.models.Cursos;

@Service
public interface CursosService {
	
	public List<Cursos> todosLosCursos();

	Cursos encontrarPorId(long id);

	Cursos crear(Cursos curso) throws Exception;

	Cursos actualizar(long id, Cursos curso) throws Exception;

	void eliminar(long id);

//	Cursos añadirParticipante(long idUser, long idCurso);

}
