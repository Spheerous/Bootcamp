package beltexam.services;

import beltexam.models.User;

public interface UserService {


	public void createUser(User user);
	public User findByEmail(String email);
	public User encontrarPorId(long id);
	User eliminarCurso(long idCurso, long idUser);
	User añadirCurso(long id, long idUser);

//	List<User> usuariosEnElCurso();

}
