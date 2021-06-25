package com.team7.zzim.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team7.vo.ZZIMBean;
import com.team7.zzim.service.ZzimService;

public class TrainerZAction {

	public void tz(HttpServletRequest request, HttpServletResponse response) {
		
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("LOG_ID");
		int trainerid = Integer.parseInt(request.getParameter("trainerid")); //이게 왜 자꾸 아이디가 넘어오자ㅣ
		ZZIMBean zzim = new ZZIMBean();
		zzim.setTrainer(trainerid);
		zzim.setPerson(id);
		System.out.println("찜하러 이제 바티스가요");
		new ZzimService().insert_Trainer(zzim);
		
	}
	
	
	public void tzC(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("LOG_ID");
		int trainerid = Integer.parseInt(request.getParameter("trainerid"));
		
		ZZIMBean zzim = new ZZIMBean();
		zzim.setTrainer(trainerid);
		zzim.setPerson(id);
		
		new ZzimService().delete_Trainer(zzim);
	}
}
