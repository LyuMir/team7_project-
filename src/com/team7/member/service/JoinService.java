package com.team7.member.service;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.MemberInfo1;

public class JoinService {

	public int joingo(MemberInfo1 info){

		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		int rs = sqlsession.insert("insert_JOIN",info);
		sqlsession.commit();
		sqlsession.close();
		return rs;
	}
}
