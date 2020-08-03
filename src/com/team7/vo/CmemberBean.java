package com.team7.vo;

import java.util.Date;

public class CmemberBean {

	private int id, club;
	private String cmember;
	private Date outatdate;

	public int getClub() {
		return club;
	}

	public void setClub(int club) {
		this.club = club;
	}

	public String getCmember() {
		return cmember;
	}

	public void setCmember(String cmember) {
		this.cmember = cmember;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOutatdate() {
		return outatdate;
	}

	public void setOutatdate(Date outatdate) {
		this.outatdate = outatdate;
	}
	
}
