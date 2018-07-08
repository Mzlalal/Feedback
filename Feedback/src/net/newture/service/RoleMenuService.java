package net.newture.service;

public interface RoleMenuService {
	/**
	 * 获取父级菜单列表
	 */
	public void findAllParentMenu();
	
	/**
	 * 获取子级菜单列表
	 */
	public int findSonMenu(int muenId);
	
	/**
	 * 保存操作
	 */
	public int saveMenu(int muenId,boolean bool);
}
