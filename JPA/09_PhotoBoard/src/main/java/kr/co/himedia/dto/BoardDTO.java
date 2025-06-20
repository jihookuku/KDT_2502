package kr.co.himedia.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import kr.co.himedia.entity.Photo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	
	private long img;
	private long idx;
	private String subject;
	private String userName;
	private String content;
	private long bHit;
	private LocalDate reg_date;
	private List<Photo> photos = new ArrayList<Photo>();

}
