package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(length = 30)
	@NotBlank(message = "Please Enter Your Name ")
	private String userName;
	@Column(length = 30, unique = true)
	@NotBlank(message = "Please Enter Your Email ")
	@Email(message = "Invalid Email format ")
	@Length(min = 5, max = 30, message = "Invalid email length ")
	private String email;
	@Column(length = 30, nullable = false)
	@NotBlank(message = "Password can't be blank ")
	private String password;
	@Transient
	private String confirmPassword;
	private Long contactNo;
	@Column(length = 30)
	@NotBlank(message = "Please Enter Your Address ")
	private String address;
	@Column(length = 20)
	@NotBlank(message = "Please Enter Your City ")
	private String city;
	@Column(length = 20)
	@NotBlank(message = "Please Enter Your District ")
	private String district;
	@Column(length = 20)
	@NotBlank(message = "Please Enter Your State ")
	private String state;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private LocalDate dateOfBirth;
	@Column(length = 20)
	private String gender;
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private Role role;

	public User() {
		System.out.println("in constructor of " + getClass().getName());
	}

	public User(String userName, String email, String password, String confirmPassword, Long contactNo, String address,
			String city, String district, String state, LocalDate dateOfBirth, String gender, Role role) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.contactNo = contactNo;
		this.address = address;
		this.city = city;
		this.district = district;
		this.state = state;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", contactNo=" + contactNo + ", address=" + address + ", city=" + city + ", district=" + district
				+ ", state=" + state + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", role=" + role + "]";
	}

}
