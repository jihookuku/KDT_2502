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
@Data
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
