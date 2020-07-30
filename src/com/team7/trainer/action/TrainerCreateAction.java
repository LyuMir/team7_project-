package com.team7.trainer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.trainer.action.Action;
import com.team7.trainer.service.TrainerService;
import com.team7.vo.ActionForward;
import com.team7.vo.Trainer_info;

public class TrainerCreateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		HttpSession session = request.getSession(true);
		String id= (String)session.getAttribute("LOG_ID"); //오브젝트형식으로있다
		
		
//		int no = Integer.parseInt(request.getParameter("no"));
		String tname = request.getParameter("coachname");
		String sex = request.getParameter("sex"); //라디오버튼
		String tphone = request.getParameter("coachphone");
		String tbirth = request.getParameter("coachbirth");
		String temail = request.getParameter("coachemail");
		String ttime = request.getParameter("aavailabletime"); //값이 어떻게넘어올까?
		
		String tmajor="";//체크박스 이것도많음
		String [] majorimsi = request.getParameterValues("major");
		for(int i=0 ; i<=3 ; i++) {
			tmajor = tmajor+","+majorimsi[i];
		}// 스플릿으로 빼온다. 자동으로 나온 배열 i 넣는다. 
		
		String twhere = request.getParameter("trainerarea"+" "+"contry"); //셀렉트박스
		String bigtext =request.getParameter("bigtext");
		String smalltext =request.getParameter("smalltext");
		String tcareer = request.getParameter("coachcareer");
		String tcerti = request.getParameter("coachcerti");
		String tprofile = request.getParameter("coachprofile");
		String tstory = request.getParameter("coachstroy");
		String tsns = request.getParameter("coachsns");
		String thowjoin = request.getParameter("coachhowjoin");
		String tphoto = request.getParameter("photos");
		
		
		
		Trainer_info trainer = new Trainer_info();
		
	
		trainer.setId(id);
		trainer.setTname(tname);
		trainer.setSex(sex);
		trainer.setTphone(tphone);
		trainer.setTemail(temail);
		trainer.setTwhere(twhere);
		trainer.setBigtext(bigtext);
		trainer.setTsmalltext(smalltext);
		trainer.setTmajor(tmajor);
		trainer.setTcareer(tcareer);
		trainer.setTprofile(tprofile);
		trainer.setTcerti(tcerti);
		trainer.setTstory(tstory);
		trainer.setThowjoin(thowjoin);
		trainer.setTphone(tphone);
		
//		
//		notice.setContent(content);
//		notice.setTitle(title);
//		notice.setWriter(writer); //다 셋해주고 
//		
		
		//서비스로 가서 인서트를하고
		
		TrainerService tser = new TrainerService();
		tser.insert(trainer);;
		
		
		ActionForward forward= new ActionForward();
		forward.setPath("메인으로가면됨");
		return forward;
	} 

}
