package kr.co.himedia.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employees {
	
	@Id
	@Column(name="emp_no")
	private int empNo;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String gender;
	
	@Column(name="hire_date")
	private LocalDate hireDate;

}
