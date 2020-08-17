package com.team7.vo;

public class ClubBean {
private int no; 	//소모임 고유번호 
private 	String name;	//소모임 이름
private 	String admin; 	//소모임 관리자 (개설자)
private 	String publicity;	//소모임 공개 : 공개 , 지역공개, 친구공개
private 	String memberJoin ;	//소모임 멤버모집 : 공개모집 / 제한모집 / 초대모집 / 모집중단
private int memberLimit ;	//소모임 멤버 모집 시 리미트...	
private 	String e_type;	//소모임 주 운동 종류
//	String club_date = request.getParameter("club_date");
private 	String meetingDate;	//소모임 주모임날 !!!!! < 여기에 다 넣어야 함...
//	String club_Date_week; // 소모임 주모임날 : 매주_요일 ... 등 
//	String club_Date_hour; // 소모임 주모임 시간 : 00부터 00까지.
//	String meetingDate_select ;	//
//	String meeting_week1;
//	String meeting_week2 ;
//	String club_hour1 ;
//	String club_hour2;
private 	String area;	//소모임 장소 
private 	String profile ;	//소모임 소개 
private 	String photo1;
private 	String photo2;
private 	String photo; 	// 추가됨.

//추가 db적 요인 
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
