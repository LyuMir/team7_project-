package com.team7.post.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.team7.photo.service.PhotoClubService;
import com.team7.post.service.PostService;
import com.team7.vo.PostBean;

public class PostActions {

	public void posts(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

		request.setCharacterEncoding("utf-8");
		String writer = (String) request.getSession().getAttribute("LOG_ID");
		int clubid =0, trainerid=0, gymid=0;
		String cid = request.getParameter("clubid");
		String tid = request.getParameter("trainerid");
		String gid = request.getParameter("gymid");
		System.out.println(gid+tid+"�� ����Ʈ ����Ʈ ����. ");
		if(cid !=null) {
			clubid = Integer.parseInt(cid);
		}
		else if(tid !=null) {
			trainerid = Integer.parseInt(tid);
		}
		else if(gid !=null) {
			gymid = Integer.parseInt(gid);
		}
//		int clubid = Integer.parseInt(request.getParameter("clubid"));
//		int cpostid = Integer.parseInt(request.getParameter("mypostnumber"));  //�ʴ� ���⼭ �ʿ� ����. 
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String pkind = request.getParameter("pkind");
		String pcon = request.getParameter("pcon");
		
		PostBean pbean = new PostBean();
		pbean.setClub(clubid);
		pbean.setGym(gymid);
		pbean.setTrainer(trainerid);
		pbean.setContents(contents);
		pbean.setPcon(pcon);
		pbean.setPkind(pkind);
		pbean.setTitle(title);
		pbean.setWriter(writer);
		
		if(clubid != 0)
			new PostService().cpostPOST(pbean);
		if(trainerid != 0)
			new PostService().tpostPOST(pbean);
		if(gymid != 0)
			new PostService().gpostPOST(pbean);
		
		// refresh ��ų��. 
	}
	
	
	public void photoposts(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        MultipartRequest multi=new MultipartRequest(request,"C:\\Users\\Administrator\\Desktop\\NEW_PROJECTS\\PROJECT00\\.metadata\\");
        //�̷��� �ļ��� �������ΰ�? // �ƴ�...
        HttpSession session = request.getSession();
		int clubid = (Integer) session.getAttribute("clubid");
		int cpostid = (Integer) session.getAttribute("mypostnumber");
		String bywhom = (String) session.getAttribute("LOG_ID");	//�̰� �� ���� �Ǵ� �̴ϴ�...
		
		
		PhotoClubService pser = new PhotoClubService();
		pser.upload_post_photo(request, "clubpost/club_"+clubid+"/"+cpostid, clubid+"_clubpost_"+cpostid);
		// �� . ��δ� Files clubpost club_Ŭ���ѹ� ����Ʈ�ѹ�  ���,  ���̵��  Ŭ�����̵� _ clubpost _ ��° �Դϴ�. 

//		session.removeAttribute("clubid");
//		session.removeAttribute("mypostnumber");
		// ���������� �ٽ� ���� ����...��������...
	}
}
