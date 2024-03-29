package com.csx.mybatis.dao;

import java.util.List;

import com.csx.mybatis.model.User;

public interface UserMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Mar 07 09:45:02 CST 2014
	 */
	int deleteByPrimaryKey(Integer id);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Mar 07 09:45:02 CST 2014
	 */
	int insert(User record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Mar 07 09:45:02 CST 2014
	 */
	int insertSelective(User record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Mar 07 09:45:02 CST 2014
	 */
	User selectByPrimaryKey(Integer id);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Mar 07 09:45:02 CST 2014
	 */
	int updateByPrimaryKeySelective(User record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Fri Mar 07 09:45:02 CST 2014
	 */
	int updateByPrimaryKey(User record);
	public User selectUserByID(int id);
    int deleteByID(int id);
    public List<User> selectUsers(String userName);   
    public int countAll();
    int updateUsers(int id,User user);
}