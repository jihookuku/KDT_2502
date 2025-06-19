package kr.co.himedia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.himedia.entity.Post;
import kr.co.himedia.entity.Reply;
import kr.co.himedia.entity.User;
import kr.co.himedia.service.BlogService;

@RestController
public class BlogController {
	
	@Autowired BlogService service;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	//회원가입
	@PostMapping(value="/join")
	public User join(@RequestBody User user) {		
		logger.info(user.getId()+"/"+user.getName());				
		return service.join(user);
	}
	
	// 글쓰기
	@PostMapping(value="/write")
	public Post write(@RequestBody Map<String, String> param) {

		Post post = new Post();
		post.setTitle(param.get("title"));
		post.setContent(param.get("content"));
		
		// Post 의 userNo 는 User형태이므로 맞춰서 넣어줘야 한다.
		User user = new User();
		user.setUserNo(Long.parseLong(param.get("user_no")));		
		post.setUser(user);		
		
		return service.write(post);
	}
	
	
	// 댓글쓰기
	//user_no, idx, text
	/*POST http://localhost:8080/reply
		Content-Type: application/json
		
		[
		  {"text": "1번째 댓글", "idx": 3,"user_no": 1},
		  {"text": "2번째 댓글", "idx": 3,"user_no": 1}
		]
	 */
	@PostMapping(value="reply")
	public List<Reply> reply(
			@RequestBody List<Map<String, String>> params){
		
		List<Reply> list = new ArrayList<Reply>();
		Reply re = null;
		
		for (Map<String, String> map : params) {
			re = new Reply();
			re.setText(map.get("text"));
			
			User user = new User();
			user.setUserNo(Long.parseLong(map.get("user_no")));
			re.setUser(user);
			
			Post post = new Post();
			post.setIdx(Long.parseLong(map.get("idx")));
			re.setPost(post);
			
			list.add(re);			
		}
				
		return service.addReply(list);
	}
	
	//회원 리스트(java.lang.StackOverflowError)
	// 이 경우 User 안에 Post 가 있어서 Post 를 불러온다.
	// 그런데 Post 안에 User 가 있이서 User 를 볼러온다.
	// 이런식으로 순환참조가 이루어지면서 문제가 발생한다.
	@GetMapping(value="/user/list")
	public List<User> userList(){
		
		// 해결방법 1. 직렬화 무시(자식 요소를 완전히 배제)
		// 리스트 같은것을 불러올때 유용
		// 부모 필드에 @JsonIgnore 추가
		
		// 해결방법 2. 직렬화를 한방향으로 설정
		// 부모 필드에 @JsonManagedReference
		// 자식 필드에 @JosonBackReference
		
		return service.userList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
