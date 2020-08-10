package com.team7.member.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;

public class MyInfoService {
	
	public List<MemberInfo1> myinfo(MemberLogInfo loginfo) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		List<MemberInfo1> minfo = sqlsession.selectList("select_log2",loginfo);
		sqlsession.close();
		
		if(minfo.size() >0) {
			minfo.get(0).setPw(null);
		}
		return minfo;
	}
	
	public void myinfoedit(MemberInfo1 minfo) {
		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		sqlsession.update("update_log2",minfo);
		sqlsession.commit();
		sqlsession.close();
	}
}
