package team7.com;

import javax.servlet.http.*;

import team7.com.vo.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
