package beltexam.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import beltexam.models.Cursos;

@Repository
public interface CursosRepository extends CrudRepository<Cursos,Long>{
	
}
