package kr.co.himedia.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Emp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empno;
	
	private String ename;
	
	private LocalDate hiredate;
	
	private String job;
	
	@ManyToOne
	@JoinColumn(name="deptno")
	private Dept dept;

}








