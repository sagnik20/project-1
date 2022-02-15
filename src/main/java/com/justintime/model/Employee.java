package com.justintime.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sagnik
 *
 */

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable= false)
	private Integer id;
	
	@Column(nullable= false)
	private String name;
	
	@Column(nullable= false,unique=true)
	private String email;
	
	@Column(nullable= false)
	private Integer manager;
	
	@Column(nullable= false)
	private Integer active;
	
	@Column
	private String dept;
	
	@Column
	private String password;
	
	public Employee() {}
	public Employee( String name, String email, Integer manager, Integer active, String dept, String password) {
		this.name = name;
		this.email = email;
		this.manager = manager;
		this.active = active;
		this.dept = dept;
		this.password = password;
	}
	
	public Employee(String name, String email, Integer active, String dept, String password) {
		this.name = name;
		this.email = email;
		this.manager = 0;
		this.active = active;
		this.password = password;
		this.dept = dept;
	}


	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public Integer getManager() {
		return manager;
	}


	public Integer getActive() {
		return active;
	}


	public String getDept() {
		return dept;
	}
	
	public String getPassword() {
		return password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}
	
	public void setManager(Integer manager) {
		this.manager = manager;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Integer active) {
		this.active = active;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
