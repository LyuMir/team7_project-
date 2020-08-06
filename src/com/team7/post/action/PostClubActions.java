package com.team7.post.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.team7.photo.service.PhotoService;
import com.team7.post.service.PostClubService;
import com.team7.vo.CPostBean;

public class PostClubActions {

	public void posts(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

		request.setCharacterEncoding("utf-8");
		String writer = (String) request.getSession().getAttribute("LOG_ID");
		int clubid = Integer.parseInt(request.getParameter("clubid"));
//		int cpostid = Integer.parseInt(request.getParameter("mypostnumber"));  //너는 여기서 필요 없다. 
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String pkind = request.getParameter("pkind");
		String pcon = request.getParameter("pcon");
		
		CPostBean pbean = new CPostBean();
		pbean.setClub(clubid);
		pbean.setContents(contents);
		pbean.setPcon(pcon);
		pbean.setPkind(pkind);
		pbean.setTitle(title);
		pbean.setWriter(writer);
		
		new PostClubService().cpostPOST(pbean);
		
		// refresh 시킬것. 
	}
	
	
	public void photoposts(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        MultipartRequest multi=new MultipartRequest(request,"C:\\Users\\Administrator\\Desktop\\NEW_PROJECTS\\PROJECT00\\.metadata\\");
        //이러한 꼼수가 먹힐것인가? // 아뇨...
        HttpSession session = request.getSession();
		int clubid = (Integer) session.getAttribute("clubid");
		int cpostid = (Integer) session.getAttribute("mypostnumber");
		String bywhom = (String) session.getAttribute("LOG_ID");	//이걸 안 쓰게 되는 겁니다...
		
		
		PhotoService pser = new PhotoService();
		pser.upload_post_photo(request, "clubpost/club_"+clubid+"/"+cpostid, clubid+"_clubpost_"+cpostid);
		// 네 . 경로는 Files clubpost club_클럽넘버 포스트넘버  고요,  아이디는  클럽아이디 _ clubpost _ 번째 입니다. 

//		session.removeAttribute("clubid");
//		session.removeAttribute("mypostnumber");
		// 지워버리면 다시 못함 ㅋㅋ...ㅋㅋㅋㅋ...
	}
}
