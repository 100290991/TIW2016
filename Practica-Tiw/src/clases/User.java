package clases;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="User")
@NamedQueries({
@NamedQuery(name="UserEmail", query="select a from User a where a.email=:email"),
@NamedQuery(name="UpdateName", query="update User a set a.name=:name where a.id=:id ")
})

public class User implements Serializable {

	public User(int id, String name, String surname, String email, String password, String city) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.city = city;
	}
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="ID",unique=true, nullable=false)
	private int id;
	
	@Column(name="Name")
	private String name;
	@Column(name="Surname")
	private String surname;
	@Column(name="Email", unique=true)
	private String email;
	@Column(name="Password")
	private String password;
	@Column(name="City")
	private String city;
	
	public User() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password="
				+ password + ", city=" + city + "]";
	}
	

}
