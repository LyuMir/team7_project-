package com.team7.vo;

public class DTO_ClubProperties {
	private int no;	// ������ȣ
	String club_name;	//�Ҹ��� �̸�
	String club_admin; 	//�Ҹ��� ������ (������)
	String club_publicity;	//�Ҹ��� ���� : ���� , ��������, ģ������
	String club_memberJoin ;	//�Ҹ��� ������� : �������� / ���Ѹ��� / �ʴ���� / �����ߴ�
int club_memLimit ;	//�Ҹ��� ��� ���� �� ����Ʈ...	
	String club_exc_type;	//�Ҹ��� �� � ����
//	String club_date = request.getParameter("club_date");
	String club_Date_week; // �Ҹ��� �ָ��ӳ� : ����_���� ... �� 
	String club_Date_hour; // �Ҹ��� �ָ��� �ð� : 00���� 00����.
//	String meetingDate_select ;	//
//	String meeting_week1;
//	String meeting_week2 ;
//	String club_hour1 ;
//	String club_hour2;
	String club_area;	//�Ҹ��� ��� 
	String club_profileText ;	//�Ҹ��� �Ұ� 
	String club_profile_photo1;
	String club_profile_photo2;
	
	
	public String getClub_name() {
		return club_name;
	}
	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}
	public String getClub_publicity() {
		return club_publicity;
	}
	public void setClub_publicity(String club_publicity) {
		this.club_publicity = club_publicity;
	}
	public String getClub_memberJoin() {
		return club_memberJoin;
	}
	public void setClub_memberJoin(String club_memberJoin) {
		this.club_memberJoin = club_memberJoin;
	}
	public String getClub_exc_type() {
		return club_exc_type;
	}
	public void setClub_exc_type(String club_exc_type) {
		this.club_exc_type = club_exc_type;
	}
	public String getClub_Date_week() {
		return club_Date_week;
	}
	public void setClub_Date_week(String club_Date_week) {
		this.club_Date_week = club_Date_week;
	}
	public String getClub_Date_hour() {
		return club_Date_hour;
	}
	public void setClub_Date_hour(String club_Date_hour) {
		this.club_Date_hour = club_Date_hour;
	}
	public String getClub_area() {
		return club_area;
	}
	public void setClub_area(String club_area) {
		this.club_area = club_area;
	}
	public String getClub_profileText() {
		return club_profileText;
	}
	public void setClub_profileText(String club_profileText) {
		this.club_profileText = club_profileText;
	}
	public String getClub_profile_photo1() {
		return club_profile_photo1;
	}
	public void setClub_profile_photo1(String club_profile_photo1) {
		this.club_profile_photo1 = club_profile_photo1;
	}
	public String getClub_profile_photo2() {
		return club_profile_photo2;
	}
	public void setClub_profile_photo2(String club_profile_photo2) {
		this.club_profile_photo2 = club_profile_photo2;
	}
	public String getClub_admin() {
		return club_admin;
	}
	public void setClub_admin(String club_admin) {
		this.club_admin = club_admin;
	}
	public int getClub_memLimit() {
		return club_memLimit;
	}
	public void setClub_memLimit(int club_memLimit) {
		this.club_memLimit = club_memLimit;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

	

}
