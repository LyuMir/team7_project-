package com.team7.vo;

public class PostBean {
	private int club, no;
	private String title,writer,contents, pkind, pcon;
	
	private int gym, trainer;	// 포스트 통합 빈이 되었습니다. 
	
	private int count, zzimed;	// 같이 넣어버리자
	
	public int getClub() {
		return club;
	}
	public void setClub(int club) {
		this.club = club;
	}
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPkind() {
		return pkind;
	}
	public void setPkind(String pkind) {
		this.pkind = pkind;
	}
	public String getPcon() {
		return pcon;
	}
	public void setPcon(String pcon) {
		this.pcon = pcon;
	}
	public int getGym() {
		return gym;
	}
	public void setGym(int gym) {
		this.gym = gym;
	}
	public int getTrainer() {
		return trainer;
	}
	public void setTrainer(int trainer) {
		this.trainer = trainer;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getZzimed() {
		return zzimed;
	}
	public void setZzimed(int zzimed) {
		this.zzimed = zzimed;
	}
	
}
