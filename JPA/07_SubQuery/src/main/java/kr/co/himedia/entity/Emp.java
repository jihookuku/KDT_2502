package kr.co.himedia.entity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Emp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empno;
	
	private String ename;
	
	private int deptno;
	
	private Date hiredate; // JPA 에서는 str_to_date() 를 지원하지 않는다.
	
	private String job;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	// 문자열 형태로 들어온 날짜를 java.sql.Date 형태로 변경해 준다.
	public void setHiredate(String hiredate) {		
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");		
		try {			
			java.util.Date date = format.parse(hiredate); //문자열 -> java.util.Date			
			this.hiredate = new Date(date.getTime());// java.util.Date -> java.sql.Date 로 변환 후 저장
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}	
		
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public Date getHiredate() {
		return hiredate;
	}



}
