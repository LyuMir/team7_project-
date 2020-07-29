package com.team7.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.vo.ActionForward;
import com.team7.member.service.*;

public class PlzLogIn{

	void plzlogin(HttpServletRequest request, HttpServletResponse response) {
		
		
		HttpSession session = request.getSession(true);
		//session.getAttribute("Log_ID");

	    Integer log_st = (Integer) session.getAttribute("LOG_STATUS");
	    
	    if(log_st ==1) {
	    	
	    }
	    else{
	    	System.out.println("로그인하세요 기능 활성화");
	    }
	    
	}

}