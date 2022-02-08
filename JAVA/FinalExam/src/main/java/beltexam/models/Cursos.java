package beltexam.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="curso")
public class Cursos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Size(min=3, message = "el Nombre debe tener al menos 3 caracteres")
	private String name;
	@Size(min=10, message = "el Instructor debe tener al menos 10 caracteres")
	private String instructor;
	
	@Min(value = 1, message = "el Curso debe tener al menos 1 participante")
	private int capacidad;
	
	@ManyToMany( fetch = FetchType.LAZY)
	@JoinTable(
			name="users_cursos",
			joinColumns = @JoinColumn(name="curso_id"),
			inverseJoinColumns= @JoinColumn(name="user_id")
			)
	private List<User> usuarios;
	
	public void eliminarUsuarios(User user) {
		this.usuarios.remove(user);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public List<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	

}
