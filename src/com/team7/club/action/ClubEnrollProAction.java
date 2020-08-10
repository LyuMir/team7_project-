package com.team7.club.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team7.club.service.CEnrollService;
import com.team7.club.service.CMemberService;
import com.team7.club.service.ClubService;
import com.team7.dao.Class_DAO;
import com.team7.photo.service.PhotoClubService;
import com.team7.vo.ActionForward;
import com.team7.vo.C_enroll_Bean;
import com.team7.vo.ClubBean;
import com.team7.vo.CmemberBean;
import com.team7.vo.PhotoBean;

public class ClubEnrollProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String[] joks = request.getParameterValues("jok");
		String[] jnos = request.getParameterValues("jno");
//		ArrayList<String> oks = new ArrayList<String>();
//		ArrayList<String> nos = new ArrayList<String>();
		String ok,no;
		CEnrollService ser = new CEnrollService();
		C_enroll_Bean enroll = new C_enroll_Bean();
		CMemberService ser2 = new CMemberService();
		CmemberBean memberBean = new CmemberBean();
		
		HttpSession session = request.getSession();
		int clubno = (Integer)session.getAttribute("clubid");
		session.removeAttribute("clubid");
		//System.out.println("이거 나오긴 하나"+joks[0]+"..");
		enroll.setClub(clubno);
		memberBean.setClub(clubno);
		
		if(joks !=null) {
		for(int i = 0 ; i<joks.length; i ++) {
			if(joks[i].contains("YouJoin:")) {
				ok = (joks[i].substring(8));
				enroll.setWanttobe(ok);

				memberBean.setCmember(ok);
				
				ser2.member_toCLUB(memberBean);//cmember 추가.
				ser.cEnrollRemove(enroll);//club_enroll 가입서 삭제. 
				// 가입 축하 메세지 ㄱ
			}
		}
		}
		if(jnos !=null) {
		for(int i = 0 ; i<jnos.length; i ++) {
			if(jnos[i].contains("Decline:")) {
				no = (jnos[i].substring(8));
				enroll.setWanttobe(no);
				// 거절 메세지...?
				// 일주일 유예...?
				ser.cEnrollRemove(enroll);//club_enroll 가입서 삭제. 
			}
		}
		}

		ActionForward forward= new ActionForward();
//		forward.setPath("_FORWHERE.jsp?forwhere=3club/club_manage.jsp");
		forward.setPath("manage.club?clubid="+clubno);
//		ActionForward forward = null;
		return forward;
	}

}
