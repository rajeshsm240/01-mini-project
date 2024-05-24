package in.ashokit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserAccount {
	
	@Id
	@GeneratedValue
	private Integer userId;
	
	private String fullName;
	
	private String 	email;
	
	private String phNo;
	
	private String gender;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private LocalDate dob;
	
	private Long ssn;
	
	private String activeSwitch="Y";
	
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(insertable=false)
	private LocalDate updatedDate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getActiveSwitch() {
		return activeSwitch;
	}

	public void setActiveSwitch(String activeSwitch) {
		this.activeSwitch = activeSwitch;
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

	public UserAccount(Integer userId, String fullName, String email, String phNo, String gender, LocalDate dob,
			Long ssn, String activeSwitch, LocalDate createdDate, LocalDate updatedDate) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.phNo = phNo;
		this.gender = gender;
		this.dob = dob;
		this.ssn = ssn;
		this.activeSwitch = activeSwitch;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserAccount [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", phNo=" + phNo
				+ ", gender=" + gender + ", dob=" + dob + ", ssn=" + ssn + ", activeSwitch=" + activeSwitch
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
	
	
}
