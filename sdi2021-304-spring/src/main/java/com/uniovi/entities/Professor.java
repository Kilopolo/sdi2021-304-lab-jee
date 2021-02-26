package com.uniovi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {

	
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String dni;
	private String name;
	private String lastName;
	private String role;
	public Professor() {}
	public Professor(String dni, String name, String lastName, String role) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Professor [id=" + id + ", dni=" + dni + ", name=" + name + ", lastName=" + lastName + ", role=" + role
				+ "]";
	}
	
	
	
	
}
