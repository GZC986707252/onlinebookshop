package edu.hut.bookshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.hut.bookshop.dao.UserMapper;
import edu.hut.bookshop.pojo.User;
import edu.hut.bookshop.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
	@Override
	public int deleteByUserId(Integer userId) {
		// TODO Auto-generated method stub
		int users= userMapper.deleteByUserId(userId);
		return users;
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		int users = userMapper.insert(record);
		return users;
	}

	@Override
	public User selectByUserId(Integer userId) {
		// TODO Auto-generated method stub
		User users = userMapper.selectByUserId(userId);
		return users;
	}

	@Override
	public int updateByUserId(User record) {
		// TODO Auto-generated method stub
		int users= userMapper.updateByUserId(record);
		return users;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		List<User> users=userMapper.selectAll();
		return users;
	}

}
