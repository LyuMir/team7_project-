package com.team7.gym.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.Gym_info;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;
import com.team7.vo.PageInfo;

public class GymShowAllService {

	public List<Gym_info> getGyminfo() {

		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		
		List<Gym_info> gser = sqlsession.selectList("selectall_Gym");
		
		
		
		
				
		
		 
		sqlsession.close();
		
		
		return gser;
		
	}
	

}
