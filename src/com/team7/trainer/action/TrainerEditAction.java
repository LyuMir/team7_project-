package com.team7.trainer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.trainer.action.Action;
import com.team7.trainer.service.TrainerService;
import com.team7.vo.ActionForward;
import com.team7.vo.Trainer_info;

public class TrainerEditAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		HttpSession session = request.getSession(true);
		String id= (String)session.getAttribute("LOG_ID"); 
		
		
//		int no = Integer.parseInt(request.getParameter("no"));
//		String tname = request.getParameter("coachname");
//		String sex = request.getParameter("sex"); //������ư
		String tphone = request.getParameter("coachphone");
//		String tbirth = request.getParameter("coachbirth");
		String temail = request.getParameter("coachemail");
		String ttime ="";
		String [] ttimeimsi = request.getParameterValues("availabeltime");
		if(ttimeimsi !=null)
		{
			for(int i=0 ; i<ttimeimsi.length; i++) {
			ttime = ttimeimsi[i]+","+ttime;
			}
		}
		
		String tmajor="";
		String [] majorimsi = request.getParameterValues("major");
		if(majorimsi !=null)
		for(int i=0 ; i<=majorimsi.length-1 ; i++) {
			tmajor = majorimsi[i]+","+tmajor;
		}// ���ø����� ���´�. �ڵ����� ���� �迭 i �ִ´�. 
		;
		
		
		String twhere = request.getParameter("trainerarea"); //����Ʈ�ڽ�
		String bigtext =request.getParameter("bigtext");
		String smalltext =request.getParameter("smalltext");
		String tcareer = request.getParameter("coachcareer");
		String tcerti = request.getParameter("coachcerti");
		String tprofile = request.getParameter("coachprofile");
		String tstory = request.getParameter("coachstroy");
		String tsns = request.getParameter("coachsns");
		String thowjoin = request.getParameter("coachhowjoin");
		String tphoto = request.getParameter("photos");
		
		System.out.println(tsns+" ��ϱ�??");
		
		Trainer_info trainer = new Trainer_info();
		
		
		trainer.setId(id); 
//		trainer.setTname(tname);
//		trainer.setSex(sex);
		trainer.setTtime(ttime);
		trainer.setTemail(temail == null ? "" : temail); 
		trainer.setTwhere(twhere== null ? "" : twhere);
		trainer.setTbigtext(bigtext== null ? "" : bigtext);
		trainer.setTsmalltext(smalltext== null ? "" : smalltext);
		trainer.setTmajor(tmajor== null ? "" : tmajor);
		trainer.setTcareer(tcareer== null ? "" : tcareer);
		trainer.setTprofile(tprofile== null ? "" : tprofile);
		trainer.setTcerti(tcerti== null ? "" : tcerti);
		trainer.setTstory(tstory== null ? "" : tstory);
		trainer.setTsns(tsns== null ? "" : tsns);//
		trainer.setThowjoin(thowjoin== null ? "" : thowjoin);
		trainer.setTphone(tphone== null ? "" : tphone); 
		
		
//		
//		notice.setContent(content);
//		notice.setTitle(title);
//		notice.setWriter(writer); //�� �����ְ� 
//		
		
		//���񽺷� ���� �μ�Ʈ���ϰ�
		
		TrainerService tser = new TrainerService();
//		tser.insert(trainer);;
		tser.edit(trainer);
		
		
		ActionForward forward= new ActionForward();
		forward.setPath("id_Introtrainerapply.trainer");
		return forward;
	} 

}
