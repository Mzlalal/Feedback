package net.newture.service;

import net.newture.domain.Menu;
import net.newture.domain.User;

public interface MenuService {
	/**
	 * 添加系统菜单
	 * @param 待添加的系统菜单栏
	 * @return 1：成功 -1：失败
	 */
	public int saveMenu(Menu menu);
	/**
	 * 获取系统菜单列表
	 * 
	 */
	public void findAllmenu();
	/**
	 * 删除指定菜单
	 * 
	 * @param menu
	 *            待删除菜单
	 */
	public void deleteMenu(Menu menu);
	/**
	 * 删除指定菜单
	 * 
	 * @param Id
	 *            待删除菜单
	 * @return 1：成功 -1：失败
	 */
	public int deleteMenu(Integer id);
	
	public Menu findMenuById(Integer id);
	/**
	 * 修改系统菜单
	 *
	 * @param menu
	 * @return flag 失败:-1 成功:1
	 */
	public int updateMenu(Menu menu);
	
	/**
	 * 条件查询
	 * @param condName
	 * @param condValue
	 * @return
	 */
	public Menu findByCond(String condName,String condValue);
}
