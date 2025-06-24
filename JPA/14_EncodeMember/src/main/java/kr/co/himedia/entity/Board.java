package kr.co.himedia.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="bbs")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idx;
	
	private String subject;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="b_hit")
	private long bHit = 0;
	
	@CreationTimestamp
	private LocalDate reg_date;

}
