package com.team7.vo;

public class DTO_ClubProperties2 {
int no; 	//�Ҹ��� ������ȣ 
	String name;	//�Ҹ��� �̸�
	String admin; 	//�Ҹ��� ������ (������)
	String publicity;	//�Ҹ��� ���� : ���� , ��������, ģ������
	String memberJoin ;	//�Ҹ��� ������� : �������� / ���Ѹ��� / �ʴ���� / �����ߴ�
int memberLimit ;	//�Ҹ��� ��� ���� �� ����Ʈ...	
	String e_type;	//�Ҹ��� �� � ����
//	String club_date = request.getParameter("club_date");
	String meetingDate;	//�Ҹ��� �ָ��ӳ� !!!!! < ���⿡ �� �־�� ��...
//	String club_Date_week; // �Ҹ��� �ָ��ӳ� : ����_���� ... �� 
//	String club_Date_hour; // �Ҹ��� �ָ��� �ð� : 00���� 00����.
//	String meetingDate_select ;	//
//	String meeting_week1;
//	String meeting_week2 ;
//	String club_hour1 ;
//	String club_hour2;
	String area;	//�Ҹ��� ��� 
	String profile ;	//�Ҹ��� �Ұ� 
	String photo1;
	String photo2;

	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getPublicity() {
		return publicity;
	}
	public void setPublicity(String publicity) {
		this.publicity = publicity;
	}
	public String getMemberJoin() {
		return memberJoin;
	}
	public void setMemberJoin(String memberJoin) {
		this.memberJoin = memberJoin;
	}
	public int getMemberLimit() {
		return memberLimit;
	}
	public void setMemberLimit(int memberLimit) {
		this.memberLimit = memberLimit;
	}
	public String getE_type() {
		return e_type;
	}
	public void setE_type(String e_type) {
		this.e_type = e_type;
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getPhoto1() {
		return photo1;
	}
	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}
	public String getPhoto2() {
		return photo2;
	}
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	
	

}