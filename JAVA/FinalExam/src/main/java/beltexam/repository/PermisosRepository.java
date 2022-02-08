package beltexam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import beltexam.models.Permisos;


public interface PermisosRepository extends CrudRepository<Permisos, Long> {
	List<Permisos> findByName(String name);
	
	List<Permisos> findAll();


}
