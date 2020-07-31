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
		String id= (String)session.getAttribute("LOG_ID"); //������Ʈ���������ִ�
		
		
//		int no = Integer.parseInt(request.getParameter("no"));
		String tname = request.getParameter("coachname");
		String sex = request.getParameter("sex"); //������ư
		String tphone = request.getParameter("coachphone");
		String tbirth = request.getParameter("coachbirth");
		String temail = request.getParameter("coachemail");
		String ttime = request.getParameter("aavailabletime"); //���� ��ԳѾ�ñ�?
		
		String tmajor="";//üũ�ڽ� �̰͵�����
		String [] majorimsi = request.getParameterValues("major");
		for(int i=0 ; i<=3 ; i++) {
			tmajor = tmajor+","+majorimsi[i];
		}// ���ø����� ���´�. �ڵ����� ���� �迭 i �ִ´�. 
		
		String twhere = request.getParameter("trainerarea"+" "+"contry"); //����Ʈ�ڽ�
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
//		notice.setWriter(writer); //�� �����ְ� 
//		
		
		//���񽺷� ���� �μ�Ʈ���ϰ�
		
		TrainerService tser = new TrainerService();
		tser.insert(trainer);;
		
		
		ActionForward forward= new ActionForward();
		forward.setPath("�������ΰ����");
		return forward;
	} 

}