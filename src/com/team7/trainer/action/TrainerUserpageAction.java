package com.team7.trainer.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.trainer.service.*;
import com.team7.trainer.service.TrainerUserpageService;
import com.team7.vo.ActionForward;
import com.team7.vo.Trainer_info;
import com.team7.vo.PageInfo;
import com.team7.vo.Trainer_info;


public class TrainerUserpageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
//		DTO_Notice notice = new DTO_Notice();
//		notice.setNo(no);
		System.out.println("���������� �׼Ǳ����������?");
		String number = request.getParameter("number");
		
		System.out.println(number);
		

		int no = Integer.parseInt(request.getParameter("number")); //������������ �ѹ���������! 
		System.out.println(no);
		TrainerUserpageService tser = new TrainerUserpageService();
		List<Trainer_info> traineronelist = new ArrayList<Trainer_info>();
		
		
	
		

		ActionForward forward= new ActionForward();
		request.setAttribute("tser", traineronelist);
		forward.setPath("/_FORWHERE.jsp?forwhere=2trainer/trainer_userpage.jsp");
		return forward;
		
	}

}
