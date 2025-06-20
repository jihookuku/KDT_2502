package kr.co.himedia.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="bbs")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idx;
	
	@Column(name="user_name")
	private String userName;
	
	private String subject;
	
	@Lob
	@Column(columnDefinition = "longtext")
	@Basic(fetch = FetchType.LAZY)
	private String content;
	
	@Column(name="b_hit")
	private long bHit = 0;
	
	@CreationTimestamp // 테이블 생성시currdate 를 추가
	private LocalDate reg_date;
	
	@OneToMany(mappedBy = "bbs", cascade = CascadeType.ALL)
	private List<Photo> photos;

}



















