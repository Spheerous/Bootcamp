package beltexam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



@Entity
@Table(name="permiso")
public class Permisos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	private Date createdAt;
	
	private Date updatedAt;
	
//	@ManyToMany( fetch = FetchType.LAZY)
//	@JoinTable(
//			name="users_permisos",
//			joinColumns = @JoinColumn(name="permiso_id"),
//			inverseJoinColumns= @JoinColumn(name="user_id")
//			)
//	private List<User> usuarios;
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
//	public List<User> getUsuarios() {
//		return usuarios;
//	}
//	public void setUsuarios(List<User> usuarios) {
//		this.usuarios = usuarios;
//	}
    
    
}
