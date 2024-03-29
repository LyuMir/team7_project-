package com.team7.vo;

public class ZZIMBean {

	private int id;	//찜의 고유번호
	private String person;	//찜하는 사람 (아이디)
	private int gym;	//헬스장(고유번호) < team7_zzim1
	private int trainer; //트레이너(고유번호)	<team7_zzim2
	private int club;	//소모임(고유번호)	<team7_zzim3
	
	private int gpost;	// 헬스장에 달린 댓글 고유번호
	private int tpost;	// 트레이너에 달린 댓글 고유번호
	private int cpost;	// 소모임에 달린 댓글의 고유번호 <team7_cpost_zzim
	
	private int count;
	private int zzimed;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
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
	public int getClub() {
		return club;
	}
	public void setClub(int club) {
		this.club = club;
	}
	public int getGpost() {
		return gpost;
	}
	public void setGpost(int gpost) {
		this.gpost = gpost;
	}
	public int getTpost() {
		return tpost;
	}
	public void setTpost(int tpost) {
		this.tpost = tpost;
	}
	public int getCpost() {
		return cpost;
	}
	public void setCpost(int cpost) {
		this.cpost = cpost;
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
