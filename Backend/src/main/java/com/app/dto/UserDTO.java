package com.app.dto;



import java.time.LocalDate;

import com.app.pojos.Role;

public class UserDTO {
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	private Long contactNo;
	private String address;
	private String city;
	private String district;
	private String state;
	private LocalDate dateOfBirth;
	private String gender;
	private Role role;
	
	public UserDTO() {
		System.out.println("in constructor of "+getClass().getName());
	}

	public UserDTO(String userName, String email, String password,	Long contactNo, String address,
			String city, String district, String state, LocalDate dateOfBirth, String gender, Role role) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
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
