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
	
	
	//부모와 자식간의 순환 참조를 끊는 방법
	// 1. @JsonIgnore <- 자식을 아예 끊어내는 방법
	// 2. 부모 : @JsonManagedReference 자식 : @JsonBackReference <- 단방향
	private List<Photo> photos = new ArrayList<Photo>();
	
	public void setPhotos(List<Photo> list) {
		for (Photo p : list) {
			p.setBbs(null); // 3. 자식객체내의 부모객체를 삭제하여 서로 바라보지 못하게 만든다.
			this.photos.add(p);
		}
	}
	

}
