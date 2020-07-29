package com.team7.member.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;

public class LogMatchService {

	public boolean Login(MemberLogInfo loginfo) {
		boolean ok = false;
		
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<MemberInfo1> rlist= sqlsession.selectList("select_login", loginfo); 
		sqlsession.close();
		
		if(rlist.size()>0)	ok =true;
		
		return ok;
	}
}
