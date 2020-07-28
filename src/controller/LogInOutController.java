package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;

@WebServlet("*.log")
public class LogInOutController extends javax.servlet.http.HttpServlet 
{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");	//���� �߰���
		String RequestURI=request.getRequestURI();	//req ������ :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //�տ� ���� ���� : boardList.bo
		//�� '/'���� �� ��������. 
		ActionForward forward=null;	//forward : �� �� ���� 
		act.Action action=null;			//action : �� �� ����  ��Ȯ���� action.execute()��. (�������̽��� ������)
		
		if(command.equals("/login.log")){	// �� �� ��û���� �Ÿ� ������ �ض�.
			action  = new act.member.LoginAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		else if(command.equals("/boardWritePro.bo")){
//			action  = new BoardWriteProAction();
//			try {
//				forward=action.execute(request, response );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		else if(command.equals("/boardList.bo")){
//			action = new BoardListAction();
//			try{
//				forward=action.execute(request, response);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//		else if(command.equals("/boardDetail.bo")){
//			action = new BoardDetailAction();
//			try{
//				forward=action.execute(request, response);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//		else if(command.equals("/boardReplyForm.bo")){
//			action = new BoardReplyFormAction();
//			try{
//				forward=action.execute(request, response);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//		else if(command.equals("/boardReplyPro.bo")){
//			action = new BoardReplyProAction();
//			try{
//				forward=action.execute(request, response);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//		else if(command.equals("/boardModifyForm.bo")){
//			action = new BoardModifyFormAction();
//			try{
//				forward=action.execute(request, response);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}else if(command.equals("/boardModifyPro.bo")){
//			action = new BoardModifyProAction();
//			try{
//				forward=action.execute(request, response);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}else if(command.equals("/boardDeleteForm.bo")){
//			String nowPage = request.getParameter("page");
//			String BOARD_NAME = request.getParameter("BOARD_NAME");
//			request.setAttribute("page", nowPage);
//			int board_num=Integer.parseInt(request.getParameter("board_num"));
//			request.setAttribute("board_num",board_num);
//			request.setAttribute("BOARD_NAME",BOARD_NAME);
////			forward=new ActionForward();
////			forward.setPath("/qna_board_delete.jsp");
//			action = new BoardDeleteProAction();
//			try{
//				forward=action.execute(request, response);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//		else if(command.equals("/boardDeletePro.bo")){
//			action = new BoardDeleteProAction();
//			try{
//				forward=action.execute(request, response);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
		
		if(forward != null){	//������ ���� �ִٸ� ����. 
			
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //���� �߰���
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //���� �߰���
		doProcess(request,response);
	}   
	
}