package com.team7.vo;

public class ClubBean {
private int no; 	//�Ҹ��� ������ȣ 
private 	String name;	//�Ҹ��� �̸�
private 	String admin; 	//�Ҹ��� ������ (������)
private 	String publicity;	//�Ҹ��� ���� : ���� , ��������, ģ������
private 	String memberJoin ;	//�Ҹ��� ������� : �������� / ���Ѹ��� / �ʴ���� / �����ߴ�
private int memberLimit ;	//�Ҹ��� ��� ���� �� ����Ʈ...	
private 	String e_type;	//�Ҹ��� �� � ����
//	String club_date = request.getParameter("club_date");
private 	String meetingDate;	//�Ҹ��� �ָ��ӳ� !!!!! < ���⿡ �� �־�� ��...
//	String club_Date_week; // �Ҹ��� �ָ��ӳ� : ����_���� ... �� 
//	String club_Date_hour; // �Ҹ��� �ָ��� �ð� : 00���� 00����.
//	String meetingDate_select ;	//
//	String meeting_week1;
//	String meeting_week2 ;
//	String club_hour1 ;
//	String club_hour2;
private 	String area;	//�Ҹ��� ��� 
private 	String profile ;	//�Ҹ��� �Ұ� 
private 	String photo1;
private 	String photo2;
private 	String photo; 	// �߰���.

//�߰� db�� ���� 
private		int memberNum;
private 	int zzimNum;
	
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
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getZzimNum() {
		return zzimNum;
	}
	public void setZzimNum(int zzimNum) {
		this.zzimNum = zzimNum;
	}
	
	

}
