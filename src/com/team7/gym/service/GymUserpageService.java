package com.team7.gym.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.team7.dao.Class_DAO;
import com.team7.vo.Gym_info;
import com.team7.vo.MemberInfo1;
import com.team7.vo.MemberLogInfo;
import com.team7.vo.PageInfo;

public class GymUserpageService {

	public List<Gym_info> getGymOneinfo(Gym_info info) {

		SqlSession sqlsession = new Class_DAO().get_conn().openSession();
		
		List<Gym_info> tser = sqlsession.selectList("selectOne_Gym",info);
		
//		System.out.println(tser.get(0).getId());
		
		
//		String imsimajors = tser.get(0).getTmajor() ;
//		String [] major = imsimajors.split(",");
//		
//		for (int i=0 ; i < major[i].length()-1 ; i ++) {
//
//			System.out.println(major[i]);
//			if(major[i].equals("filates")){
//				major[i] = "dd";
//			
//			}
//			else{
//			
//			}
//		
		

		System.out.print("¿©±â´Â?");

		sqlsession.close();
		
		return tser;
		
	}
	




	
	}

