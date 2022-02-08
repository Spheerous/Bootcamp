package beltexam.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beltexam.models.Permisos;
import beltexam.repository.PermisosRepository;
import beltexam.services.PermisosService;

@Service
public class PermisosServiceImp implements PermisosService {
	
	@Autowired 
	private PermisosRepository permiRepo;
	
	public List<Permisos> allPermisos() {
		return(List<Permisos>) permiRepo.findAll();
	}
	
	

}
