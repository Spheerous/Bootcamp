package beltexam.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="users_cursos")
public class UsersCursos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private Date fechaDeIngreso;

	
    
    public Date getFechaDeIngreso() {
		return fechaDeIngreso;
	}
	public void setFechaDeIngreso(Date fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
	@PrePersist
    protected void onCreate(){
        this.fechaDeIngreso = new Date();
    }
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="curso_id")
    private Cursos curso;
    

    

	public UsersCursos() {
    	
    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Cursos getCurso() {
		return curso;
	}
	public void setCurso(Cursos curso) {
		this.curso = curso;
	}
    
    
}
