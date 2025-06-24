package kr.co.himedia.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginChecker implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean pass = true;
		log.info("Inter Ceptor : {}",request.getRequestURI());
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		
		if(loginId == null || loginId.equals("")) {
			pass = false;
			String ctx = request.getContextPath();
			log.info("context path : "+ctx);
			response.sendRedirect(ctx); // context 경로도 같이 줘야 한다.
		}
			
		return pass;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("########controller 지나쳐서 view 로 이동!########");
	}
	
	

}









