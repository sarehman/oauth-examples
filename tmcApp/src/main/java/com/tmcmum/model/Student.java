/**
 * 
 */
package com.tmcmum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;




/**
 * @author abdurrehman
 *
 */
@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="GR_NO", nullable=false)
	private Long grNo;

	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="MOTHER_NAME", nullable=true)
	private String motherName;
	
	@Column(name="UID", nullable=true)
	private String uid;
	
	@Column(name="NATIONALITY", nullable=true)
	private String nationality;

	@Column(name="MOTHER_TONGUE", nullable=true)
	private String motherTongue;

	@Column(name="RELIGION", nullable=true)
	private String religion;

	@Column(name="CASTE", nullable=true)
	private String caste;

	@Column(name="SUB_CASTE", nullable=true)
	private String subCaste;

	@Column(name="BIRTH_PLACE", nullable=true)
	private String birthPlace;
	
	@Column(name="TALUKA", nullable=true)
	private String taluka;
	
	@Column(name="DISTRICT", nullable=true)
	private String district;
	
	@Column(name="STATE", nullable=true)
	private String state;
	
	@Column(name="COUNTRY", nullable=true)
	private String country;
	
	@Column(name="DOB", nullable=true)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	
	@Column(name="DOB_LETTERS", nullable=true)
	private String dob_letters;
	
	@Column(name="PREVIOUS_SCHOOL", nullable=true)
	private String previousSchool;
	
	@Column(name="STANDARD", nullable=true)
	private String standard;
	
	@Column(name="DATE_ADMISSION", nullable=true)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateAdmission;
	
	@Column(name="STUDY_PROGRESS", nullable=true)
	private String studyProgress;
	
	@Column(name="DATE_OF_LEAVING", nullable=true)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfLeaving;
	
	@Column(name="STANDARD_AT_LEAVING", nullable=true)
	private String standardAtLeaving;

	@Column(name="REASON_OF_LEAVING", nullable=true)
	private String reasonOfLeaving;
	

	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	

	/**
	 * @return the grNo
	 */
	public Long getGrNo() {
		return grNo;
	}

	/**
	 * @param grNo the grNo to set
	 */
	public void setGrNo(Long grNo) {
		this.grNo = grNo;
	}

	/**
	 * @return the motherName
	 */
	public String getMotherName() {
		return motherName;
	}

	/**
	 * @param motherName the motherName to set
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the motherTongue
	 */
	public String getMotherTongue() {
		return motherTongue;
	}

	/**
	 * @param motherTongue the motherTongue to set
	 */
	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * @return the caste
	 */
	public String getCaste() {
		return caste;
	}

	/**
	 * @param caste the caste to set
	 */
	public void setCaste(String caste) {
		this.caste = caste;
	}

	/**
	 * @return the subCaste
	 */
	public String getSubCaste() {
		return subCaste;
	}

	/**
	 * @param subCaste the subCaste to set
	 */
	public void setSubCaste(String subCaste) {
		this.subCaste = subCaste;
	}

	/**
	 * @return the birthPlace
	 */
	public String getBirthPlace() {
		return birthPlace;
	}

	/**
	 * @param birthPlace the birthPlace to set
	 */
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	/**
	 * @return the taluka
	 */
	public String getTaluka() {
		return taluka;
	}

	/**
	 * @param taluka the taluka to set
	 */
	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the dob_letters
	 */
	public String getDob_letters() {
		return dob_letters;
	}

	/**
	 * @param dob_letters the dob_letters to set
	 */
	public void setDob_letters(String dob_letters) {
		this.dob_letters = dob_letters;
	}

	/**
	 * @return the previousSchool
	 */
	public String getPreviousSchool() {
		return previousSchool;
	}

	/**
	 * @param previousSchool the previousSchool to set
	 */
	public void setPreviousSchool(String previousSchool) {
		this.previousSchool = previousSchool;
	}

	/**
	 * @return the standard
	 */
	public String getStandard() {
		return standard;
	}

	/**
	 * @param standard the standard to set
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}

	/**
	 * @return the dateAdmission
	 */
	public Date getDateAdmission() {
		return dateAdmission;
	}

	/**
	 * @param dateAdmission the dateAdmission to set
	 */
	public void setDateAdmission(Date dateAdmission) {
		this.dateAdmission = dateAdmission;
	}

	/**
	 * @return the studyProgress
	 */
	public String getStudyProgress() {
		return studyProgress;
	}

	/**
	 * @param studyProgress the studyProgress to set
	 */
	public void setStudyProgress(String studyProgress) {
		this.studyProgress = studyProgress;
	}

	/**
	 * @return the dateOfLeaving
	 */
	public Date getDateOfLeaving() {
		return dateOfLeaving;
	}

	/**
	 * @param dateOfLeaving the dateOfLeaving to set
	 */
	public void setDateOfLeaving(Date dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}

	/**
	 * @return the standardAtLeaving
	 */
	public String getStandardAtLeaving() {
		return standardAtLeaving;
	}

	/**
	 * @param standardAtLeaving the standardAtLeaving to set
	 */
	public void setStandardAtLeaving(String standardAtLeaving) {
		this.standardAtLeaving = standardAtLeaving;
	}

	/**
	 * @return the reasonOfLeaving
	 */
	public String getReasonOfLeaving() {
		return reasonOfLeaving;
	}

	/**
	 * @param reasonOfLeaving the reasonOfLeaving to set
	 */
	public void setReasonOfLeaving(String reasonOfLeaving) {
		this.reasonOfLeaving = reasonOfLeaving;
	}
	
	
}
