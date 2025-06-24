package kr.co.himedia.entity.key;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable // 특정 엔티티에 내장될 객체라는 거...
@Data
public class TitlesKey implements Serializable{
	// 복합키 클래스는 필히 직렬화 인터페이스를 구현해야 한다.
	
	// Titles 의 emp 에서 가지고 있기 때문에 제외
	@Column(name="emp_no")	
	private int empNo;	
	
	private String title;	
	
	@Column(name="from_date")
	private LocalDate fromDate;

}
