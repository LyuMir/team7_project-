package com.team7.vo;

import java.text.*;
import java.util.Date;

public class NoticeBean {
	private int	no;
	private String title,writer,content;
	private Date ndate;
	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
// ±×·± ±ÍÂúÀº È¯Àü... ÇØ....!
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getNdate() {
		return ndate;
	}
	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}
	
}
