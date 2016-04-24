package com.cisco.cmad.repository;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import com.cisco.cmad.model.BlogUser;

public interface BlogUserRepository {

	List<BlogUser> findAllUsers();

	void create(BlogUser blogUser);

	boolean authenticate(MultivaluedMap<String, String> formParam);

	String findByDescription(String description);

}
