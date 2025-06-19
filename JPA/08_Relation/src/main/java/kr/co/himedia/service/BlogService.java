package kr.co.himedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.himedia.entity.Post;
import kr.co.himedia.entity.Reply;
import kr.co.himedia.entity.User;
import kr.co.himedia.repo.PostRepo;
import kr.co.himedia.repo.ReplyRepo;
import kr.co.himedia.repo.UserRepo;

@Service
public class BlogService {
	
	@Autowired UserRepo userRepo;
	@Autowired PostRepo postRepo;
	@Autowired ReplyRepo replyRepo;
	
	public User join(User user) {
		return userRepo.save(user);
	}

	public Post write(Post post) {
		return postRepo.save(post);
	}

	public List<Reply> addReply(List<Reply> list) {
		return replyRepo.saveAll(list);
	}

	public List<User> userList() {
		return userRepo.findAll();
	}

}
