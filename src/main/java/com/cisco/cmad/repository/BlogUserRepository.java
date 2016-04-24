package com.cisco.cmad.repository;

import java.util.List;

import com.cisco.cmad.model.BlogUser;

public interface BlogUserRepository {

	List<BlogUser> findAllUsers();

	void create(BlogUser blogUser);

}
