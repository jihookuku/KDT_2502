package kr.co.himedia.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import kr.co.himedia.entity.key.TitlesKey;
import lombok.Data;

// emp_no, title, from_date 의 복합키를 사용 한다.
@Entity
@Data
public class Titles {

	/* 복합키는 따로 관리한다.
	private int empNo;	
	private String title;	
	private LocalDate fromDate;
	*/
	@EmbeddedId
	private TitlesKey key;
	
	@ Column(name="to_date")
	private LocalDate toDate;
	
	// 여기서 키의 어떤 부분에 사용 되는지 알려는 줘야 함
	@ManyToOne
	@MapsId("empNo") // @EmbeddedId 안의 어떤  필드의 역할인지
	@JoinColumn(name="emp_no")
	private Employees emp;
	
	

}
