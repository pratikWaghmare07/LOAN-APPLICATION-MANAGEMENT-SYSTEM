package com.example.loanmanagement.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class LoanApplication {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String emailAddress;
    private String phoneNumber;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String panNumber;
    private String aadhaarNumber;
    private String employmentStatus;
    private String employerName;
    private String employerStreetAddress;
    private String employerCity;
    private String employerState;
    private String employerZipCode;
    private String jobTitle;
    private Double annualIncome;
    private Integer workExperience;
    private Double loanAmount;
    private String loanPurpose;
    private Integer loanTenure;
    private String bankName;
    private String accountNumber;
    private String ifscCode;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

	public LoanApplication(Long id, String fullName, LocalDate dateOfBirth, String gender, String maritalStatus,
			String emailAddress, String phoneNumber, String streetAddress, String city, String state, String zipCode,
			String panNumber, String aadhaarNumber, String employmentStatus, String employerName,
			String employerStreetAddress, String employerCity, String employerState, String employerZipCode,
			String jobTitle, Double annualIncome, Integer workExperience, Double loanAmount, String loanPurpose,
			Integer loanTenure, String bankName, String accountNumber, String ifscCode, LoanStatus status) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.panNumber = panNumber;
		this.aadhaarNumber = aadhaarNumber;
		this.employmentStatus = employmentStatus;
		this.employerName = employerName;
		this.employerStreetAddress = employerStreetAddress;
		this.employerCity = employerCity;
		this.employerState = employerState;
		this.employerZipCode = employerZipCode;
		this.jobTitle = jobTitle;
		this.annualIncome = annualIncome;
		this.workExperience = workExperience;
		this.loanAmount = loanAmount;
		this.loanPurpose = loanPurpose;
		this.loanTenure = loanTenure;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.status = status;
	}

	public LoanApplication(String fullName, LocalDate dateOfBirth, String gender, String maritalStatus,
			String emailAddress, String phoneNumber, String streetAddress, String city, String state, String zipCode,
			String panNumber, String aadhaarNumber, String employmentStatus, String employerName,
			String employerStreetAddress, String employerCity, String employerState, String employerZipCode,
			String jobTitle, Double annualIncome, Integer workExperience, Double loanAmount, String loanPurpose,
			Integer loanTenure, String bankName, String accountNumber, String ifscCode, LoanStatus status) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.panNumber = panNumber;
		this.aadhaarNumber = aadhaarNumber;
		this.employmentStatus = employmentStatus;
		this.employerName = employerName;
		this.employerStreetAddress = employerStreetAddress;
		this.employerCity = employerCity;
		this.employerState = employerState;
		this.employerZipCode = employerZipCode;
		this.jobTitle = jobTitle;
		this.annualIncome = annualIncome;
		this.workExperience = workExperience;
		this.loanAmount = loanAmount;
		this.loanPurpose = loanPurpose;
		this.loanTenure = loanTenure;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.status = status;
	}

	public LoanApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getEmployerStreetAddress() {
		return employerStreetAddress;
	}

	public void setEmployerStreetAddress(String employerStreetAddress) {
		this.employerStreetAddress = employerStreetAddress;
	}

	public String getEmployerCity() {
		return employerCity;
	}

	public void setEmployerCity(String employerCity) {
		this.employerCity = employerCity;
	}

	public String getEmployerState() {
		return employerState;
	}

	public void setEmployerState(String employerState) {
		this.employerState = employerState;
	}

	public String getEmployerZipCode() {
		return employerZipCode;
	}

	public void setEmployerZipCode(String employerZipCode) {
		this.employerZipCode = employerZipCode;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public Integer getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(Integer workExperience) {
		this.workExperience = workExperience;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public Integer getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(Integer loanTenure) {
		this.loanTenure = loanTenure;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public LoanStatus getStatus() {
		return status;
	}

	public void setStatus(LoanStatus status) {
		this.status = status;
	}

    // Constructors, Getters and Setters
    
    

}
