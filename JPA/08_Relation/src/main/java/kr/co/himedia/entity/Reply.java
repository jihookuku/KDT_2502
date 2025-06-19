package kr.co.himedia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reple_idx")
	private long repleIdx;
	
	private String text;
	
	@ManyToOne
	@JoinColumn(name="idx")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="user_no")
	private User user;

	public long getRepleIdx() {
		return repleIdx;
	}

	public void setRepleIdx(long repleIdx) {
		this.repleIdx = repleIdx;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
