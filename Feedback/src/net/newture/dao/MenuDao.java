package net.newture.dao;

import java.util.List;

import net.newture.domain.Menu;

/**
 * 
 * @author huwang 2018年6月15日16:15:21
 *		系统功能实现
 */
public interface MenuDao {
	/**
	 * 添加系统菜单
	 * @param menu
	 */
	public void save(Menu menu);
	/**
	 *询所有用户列表
	 *
	 * @return
	 */
	public List<Menu> findAll();
	/**
	 * 删除系统菜单
	 * @param menu
	 */
	public void delete(Menu menu);
	/**
	 * 根据主键编号查找菜单
	 *
	 * @param id
	 *            主键编号
	 * @return
	 */
	public Menu findMenuById(Integer id);
	/**
	 * 修改系统菜单信息
	 * @param
	 * @return flag 失败：-1，成功：1
	 */
	public int updateMenu(Menu menu);
	
	
	/**
	 * 条件查询
	 * @param condName
	 * @param condValue
	 * @return
	 */
	  public List<Menu> findByCond(String condName,Object condValue);
	 
	
}
