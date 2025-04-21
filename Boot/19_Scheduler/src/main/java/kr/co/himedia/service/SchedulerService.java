package kr.co.himedia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// 스케쥴러는 프로그램과 생명주기를 함께 한다.
// 컨트롤러 등의 요청을 받지 않고 독립적으로 움직인다.
@EnableScheduling // 이제부터 이 클래스 안에서 스케쥴러가 실행 될거다.
@Component
public class SchedulerService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	//@Scheduled(fixedDelay = 1000)
	public void fixedDelay() throws InterruptedException {
		Thread.sleep(500);
		// 만약 설정한 시간보다 앞 작업이 딜레이될 경우 기자렸다가 실행 한다.
		logger.info("이전 작업 종료 후 1초마다 실행!");
	}
	
	//@Scheduled(fixedRate = 1000) // 이 어노테이션이 있어야 해당 메서드가 일정 주기로 실행할 수 있게 된다.
	public void fixedRate() {
		// 무조건 설정된 주기마다 실행 된다.
		logger.info("1초마다 실행!");
	}
	
	// 가장 많이 사용!! -> 주기 설정이 자유롭다.
	//초 분 시 일 월 요일 년도(생략)
	@Scheduled(cron = "0/5 * * * * MON-FRI")
	public void cron() {
		logger.info("5초 마다 실행");
	}
	

}







