package net.newture.dao;

import java.util.List;

import net.newture.domain.Menu;

public interface RoleMenuDao {
	/**
	 * 查询父级菜单信息
	 */
	public List findAllParentMenu();
	
	/**
	 * 查询相应父菜单下的子菜单1
	 */
	public List findAllSonMenuOne();
	/**
	 * 查询相应父菜单下的子菜单2
	 */
	public List findAllSonMenuTwo();
	/**
	 * 查询相应父菜单下的子菜单3
	 */
	public List findAllSonMenuThree();
	/**
	 * 查询相应父菜单下的子菜单4
	 */
	public List findAllSonMenuFore();
	/**
	 * 查询指定的菜单项
	 */
	public Menu findMenuById(int MenuId);
	/**
	 * 保存操作
	 */
	public void saveMenu(Menu menu);
}
