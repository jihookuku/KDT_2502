package kr.co.himedia.dto;

import java.sql.Date;

/*
select current_date(); -- 날짜
select current_timestamp(); -- 시간까지(서버위치에 맞는 시간대로 변경)
select now(); -- 날짜+시간 

select * from member;

create table todo_list(
	idx int(8) primary key auto_increment
	,id varchar(50)
	,content varchar(500)
	,done boolean
	,reg_date datetime default now()
	, constraint todo_fk_id foreign key(id) references member(id)
	on delete cascade
);
 */

public class TodoDTO {
	
	private int idx;
	private String id;
	private String content;
	private boolean done;
	private Date reg_date;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}	

}
