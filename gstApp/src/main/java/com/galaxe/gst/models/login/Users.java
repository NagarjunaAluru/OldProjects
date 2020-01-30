package com.galaxe.gst.models.login;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author naluru
 *
 */
@Entity
@Table(name = "users")
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 30)
	private String username;

	@Column(name = "password", nullable = false, length = 60)
	private String password;
	
	@Column(name = "first_Name", nullable = false, length = 30)
	private String firstName;
	
	@Column(name = "middle_Name", nullable=true, length = 30)
	private String middleName;
	
	@Column(name = "phone_No", nullable=true, length = 15)
	private String phoneNo;
	
	@Column(name = "dob", nullable=true, length = 15)
	private Date dob;
	
	@Column(name = "last_Name", nullable = false, length = 30)
	private String lastName;
	
	@Column(name = "email", nullable = false, length = 30)
	private String email;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_roles", 
				joinColumns={@JoinColumn(name="username")}, 
				inverseJoinColumns={@JoinColumn(name="role_id")})
	private Set<Roles> userRole = new HashSet<Roles>(0);
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name="UserTestMapping", 
				joinColumns={@JoinColumn(name="username")}, 
				inverseJoinColumns={@JoinColumn(name="TestId")})
	private TestForm testForm;

	
	public String getUsername() {
		return username;
	}

	public TestForm getTestForm() {
		return testForm;
	}

	public void setTestForm(TestForm testForm) {
		this.testForm = testForm;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Roles> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<Roles> userRole) {
		this.userRole = userRole;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getDob() throws ParseException {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
