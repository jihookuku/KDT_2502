package kr.co.himedia.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.co.himedia.entity.Member;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginChecker implements HandlerInterceptor {
	
	
	// 컨트롤러에 가기전에 체크
	// 만약 false 가 반환되면 어디에도 가지 못하고 하얀 화면이 나타난다.
	// 그래서 일반적으로 response 객체를 이용해 다른 페이지나 요청으로 이동시킨다.
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {	
		boolean pass = true;	
		log.info("====PRE HANDLER CHECK====");
		log.info("요청 주소 : "+request.getRequestURI());
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("info");
		log.info("로그인 여부 : {}",member);
		
		if(member ==null) { // 로그인을 하지 않고 접근했을 경우...
			pass = false;
			RequestDispatcher dis = request.getRequestDispatcher("/");
			request.setAttribute("msg", "로그인이 필요한 서비스 입니다.");
			dis.forward(request, response);			
			
			//ajax 의 경우 로그인을 하지 ㅇ낳음으로 메시지를 내려보내거나
			// response.getWriter().write("{\"loginYN\":false}");
			//다른 페이지로 강제 이동
			// response.sendRedirect("/");			
		}
		
		return pass;
	}
	

	//컨트롤러를 지나서 체크
	// 로그인에 성공 해서 컨트롤러르르 지나 뷰로 가기전에 만나는 곳
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
		log.info("====POST HANDLER CHECK====");
		// 로그인 후 전달할 내용이있다면..
		
		//request 나 mav 에 담아서 보낼 수 있다.
		// ajax 의 경우는 response 에 담아서 보낸다.

	}
	
	

}
