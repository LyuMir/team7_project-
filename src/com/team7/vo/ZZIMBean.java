package com.team7.vo;

public class ZZIMBean {

	private int id;	//���� ������ȣ
	private String person;	//���ϴ� ��� (���̵�)
	private int gym;	//�ｺ��(������ȣ) < team7_zzim1
	private int trainer; //Ʈ���̳�(������ȣ)	<team7_zzim2
	private int club;	//�Ҹ���(������ȣ)	<team7_zzim3
	
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
