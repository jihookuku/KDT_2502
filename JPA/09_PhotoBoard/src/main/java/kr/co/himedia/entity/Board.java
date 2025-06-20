package kr.co.himedia.entity;

import java.time.LocalDate;
import java.util.ArrayList;
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
	private List<Photo> photos = new ArrayList<Photo>();
	
	// Photo 에 데이터를 넣으려고 하면 PhotoRepo 를 작성해야 한다.
	// 하지만 Board 안의 photos 에 직접 데이터를 넣으면 한번에 처리 가능 하다.
	public void addPhoto(Photo photo) {
		this.photos.add(photo); // 이 엔티티에 포토의 내용을 넣어주고
		photo.setBbs(this); // 자식요소 역시도 부모를 갖을 수 있도록 현재 엔티티를 넣어준다.
	}

}



















