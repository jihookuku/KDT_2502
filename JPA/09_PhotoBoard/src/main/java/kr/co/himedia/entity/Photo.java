package kr.co.himedia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data //Getter, Setter, ToString 등이 통합된 어노테이션
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="file_idx")
	private long fileIdx;
	
	@Column(name="ori_filename")
	private String oriFileName;
	
	@Column(name="new_filename")
	private String newFileName;
	
	@ManyToOne
	@JoinColumn(name="idx")
	private Board bbs;

}






