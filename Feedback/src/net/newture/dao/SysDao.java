package net.newture.dao;

import java.util.List;

import net.newture.domain.Role;

public interface SysDao {

	/**
	 * 查询所有角色列表
	 * 
	 * @return
	 */
	public List<Role> findAllRoles();

	/**
	 * 根据角色编号获取系统菜单
	 * 
	 * @param roleId
	 *            角色编号
	 * @return List
	 */
	public List<Object[]> getSysMenuByRoleId(int roleId);
}
