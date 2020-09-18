package com.team7.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.trainer.action.Action;
import com.team7.trainer.action.Trainer_mng_mainAction;
import com.team7.vo.ActionForward;


@WebServlet("*.trainer")
public class TrainerController extends javax.servlet.http.HttpServlet  {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	//�궡媛� 異붽��븿
		String RequestURI=request.getRequestURI();	//req 媛��졇�샂 :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); 
		String command=RequestURI.substring(contextPath.length()); 


		ActionForward forward=null;	
		Action action=null;


		HttpSession session = request.getSession(true);
		int logined =0;
		if(session.getAttribute("LOG_STATUS") ==null) {}
		else {
			logined=(Integer) session.getAttribute("LOG_STATUS");
		}

		if(command.startsWith("/id_") && logined !=1) {
			String referer = request.getHeader("Referer");
			if(referer.contains("/id_")) {
				referer = "index.jsp";
			}
			else {
				request.getSession().setAttribute("fail", "로그인이 필요한 서비스입니다, 로그인해주세요.");
			}
			response.sendRedirect(referer);
			return;
		}
		else if(command.equals("/id_Introtrainerapply.trainer")){
			forward = new Trainer_mng_mainAction().toMngpage(request, response);
		}
		else if(command.equals("/id_coachapply.trainer")){
			forward = new ActionForward();
			forward.setPath("_FORWHERE.jsp?forwhere=2trainer/trainerapply.jsp");
		}
		else if(command.equals("/id_editform.trainer")){
			action  = new com.team7.trainer.action.TrainerEditFormAction();
			try {
				forward=action.execute(request, response); //硫붿꽌�뱶�떎�뻾�븿
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/id_trainerapply.trainer")) {
			action  = new com.team7.trainer.action.TrainerCreateAction();
			try {
				forward=action.execute(request, response); //硫붿꽌�뱶�떎�뻾�븿
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/id_traineredit.trainer")) {
			action  = new com.team7.trainer.action.TrainerEditAction();
			try {
				forward=action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/Search.trainer")){
			action  = new com.team7.trainer.action.TrainerShowAllAction();
			try {
				forward=action.execute(request, response); //硫붿꽌�뱶�떎�뻾�븿
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/trainerUserpage.trainer")){
				action  = new com.team7.trainer.action.TrainerUserpageAction();
				try {
					forward=action.execute(request, response); //硫붿꽌�뱶�떎�뻾�븿
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		else if(command.equals("/id_mypage.trainer")) {
				action  = new com.team7.trainer.action.TrainerMypageAction();
				try {
					forward=action.execute(request, response); 
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

		if(forward != null){

			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher= request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}

		}


	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //�궡媛� 異붽��븿
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //�궡媛� 異붽��븿
		doProcess(request,response);
	}
}
