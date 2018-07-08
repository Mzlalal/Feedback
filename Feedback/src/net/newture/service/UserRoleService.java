package net.newture.service;

import net.newture.domain.Role;
import net.newture.domain.User;

public interface UserRoleService {
	/**
	 * 获取用户角色列表
	 */
	public void findAllUserRole();
	
	/**
	 * 获取指定角色
	 */
	public Role findRoleById(int roleId);
	
	/**
	 * 获取指定用户
	 */
	public User findUserById(int userId);
	
	/**
	 * 获取所有角色
	 */
	public void findAllRole();
	
	/**
	 * 修改用户角色
	 */
	public int updateUserRole(int userId,int roleId);
}
