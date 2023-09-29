package com.mini.entity;
import java.time.LocalDate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_Accounts")
public class UserAccounts {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer userId;
	private String FullName;
	private String email;
	private Long phoneNumber;
	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")// form backing pupose we are using it ex :-if we are not write this date won't populate 
	private LocalDate dob;
	private long ssn;
	private String activeSW;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdDate;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updatedDate;
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	
	
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public String getActiveSW() {
		return activeSW;
	}
	public void setActiveSW(String activeSW) {
		this.activeSW = activeSW;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	public UserAccounts() {
		super();
	}
	public Integer getUserId() {
		return userId;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	@Override
	public String toString() {
		return "UserAccounts [userId=" + userId + ", FullName=" + FullName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", gender=" + gender + ", dob=" + dob + ", ssn=" + ssn + ", ActiveSW=" + activeSW
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

	
}
