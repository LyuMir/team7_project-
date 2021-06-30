package com.team7.my.action;

import javax.servlet.http.*;

import com.team7.vo.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
