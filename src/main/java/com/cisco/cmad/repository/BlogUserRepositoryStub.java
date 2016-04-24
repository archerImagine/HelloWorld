package com.cisco.cmad.repository;

import java.util.ArrayList;
import java.util.List;

import com.cisco.cmad.model.BlogUser;

public class BlogUserRepositoryStub implements BlogUserRepository {

	@Override
	public List<BlogUser> findAllUsers() {
		// TODO Auto-generated method stub
		List<BlogUser> blogUserList = new ArrayList<BlogUser>();
		
		BlogUser blogUser1 = new BlogUser();
		blogUser1.setEmail("animesh.bhadra@gmail.com");
		blogUser1.setPassword("123456");
		blogUser1.setUserName("animeshkbhadra");
		blogUserList.add(blogUser1);
		
		
		BlogUser blogUser2 = new BlogUser();
		blogUser2.setEmail("admin@admin.org");
		blogUser2.setPassword("admin");
		blogUser2.setUserName("admin");
		blogUserList.add(blogUser2);
		
		
		return blogUserList;
	}

	@Override
	public void create(BlogUser blogUser) {
		// TODO Auto-generated method stub
		System.out.println("BlogUserRepositoryStub.create() : " +blogUser.getEmail());
		System.out.println("BlogUserRepositoryStub.create() : " +blogUser.getPassword());
		System.out.println("BlogUserRepositoryStub.create() : " +blogUser.getUserName());
		
	}

}
