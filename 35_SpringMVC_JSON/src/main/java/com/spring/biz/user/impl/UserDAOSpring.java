package com.spring.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.biz.user.UserVO;

@Repository
public class UserDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private final String USER_GET
	= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	public UserVO getUser(UserVO vo) {
		Object[] args = {vo.getId(), vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}
	
}
