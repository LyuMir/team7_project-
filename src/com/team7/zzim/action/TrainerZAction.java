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
		int trainerid = Integer.parseInt(request.getParameter("trainerid")); //�̰� �� �ڲ� ���̵� �Ѿ���ڤ�
		ZZIMBean zzim = new ZZIMBean();
		zzim.setTrainer(trainerid);
		zzim.setPerson(id);
		System.out.println("���Ϸ� ���� ��Ƽ������");
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
