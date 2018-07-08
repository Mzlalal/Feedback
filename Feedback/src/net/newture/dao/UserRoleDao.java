package net.newture.dao;

import java.util.List;


import net.newture.domain.Role;
import net.newture.domain.User;

public interface UserRoleDao {
	/**
	 * 查询所有用户角色信息
	 */
	public List findAllUserRole();
	
	/**
	 * 根据roleid查询指定Role
	 */
	public Role findRoleById(int roleId);
	
	/**
	 * 根据userid查询指定User
	 */
	public User findUserById(int userId);
	
	/**
	 * 查询所有角色
	 */
	public List<Role> findAllRole();
	
	/**
	 * 修改用户信息
	 */
	public void updateUserRole(User user);
}
