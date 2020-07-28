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
		
		request.setCharacterEncoding("UTF-8");	//내가 추가함
		String RequestURI=request.getRequestURI();	//req 가져옴 :http://localhost:8080/WebProject0724_MVC2/boardList.bo
		String contextPath=request.getContextPath(); //http://localhost:8080/WebProject0724_MVC2/
		String command=RequestURI.substring(contextPath.length()); //앞에 글자 지움 : boardList.bo
		//즉 '/'이후 맨 마지막만. 
		ActionForward forward=null;	//forward : 갈 곳 지정 
		act.Action action=null;			//action : 할 일 지정  정확히는 action.execute()로. (인터페이스로 구성함)
		
		if(command.equals("/login.log")){	// 그 일 요청받은 거면 다음을 해라.
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
		
		if(forward != null){	//가야할 곳이 있다면 보냄. 
			
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
		response.setContentType("text/html; charset=utf-8"); //내가 추가함
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //내가 추가함
		doProcess(request,response);
	}   
	
}