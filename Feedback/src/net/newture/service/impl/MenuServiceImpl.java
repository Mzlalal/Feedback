package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.MenuDao;
import net.newture.domain.Menu;
import net.newture.domain.User;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.MenuService;
@Service
public class MenuServiceImpl extends ServiceBase implements MenuService {
	@Autowired
	private MenuDao menuDao;
	
	@Override
	@Transactional
	public int saveMenu(Menu menu) {
		//获取菜单 
		this.menuDao.save(menu);
		return 1;
	}

	@Override
	public void findAllmenu() {
		//查询所有的系统菜单列表
		List<Menu> menus = this.menuDao.findAll();
		Struts2Utils.getSession().setAttribute("menus", menus);
	}

	@Override
	@Transactional
	public int deleteMenu(Integer id) {
		// 根据主键编号查找系统菜单
		Menu menu = menuDao.findMenuById(id);
		// 查找对象后进行删除
		if (menu == null) {
			Struts2Utils.setAttribute("msg", "删除菜单信息出错：找不到指定菜单");
			return -1;
		} else {
			// 删除该对象
			menuDao.delete(menu);
			return 1;
		}
	}

	@Override
	@Transactional
	public void deleteMenu(Menu menu) {
		this.menuDao.delete(menu);
		Struts2Utils.setAttribute("msg", "删除菜单成功！");
	}

	@Override
	@Transactional
	public int updateMenu(Menu menu) {
		return menuDao.updateMenu(menu);
	}

	@Override
	public Menu findMenuById(Integer id) {
		return this.menuDao.findMenuById(id);
	}

	@Override
	public Menu findByCond(String condName, String condValue) {

		// 处理查询条件
		Object condValueObj = condValue;
		if (condName.equals("menuId")) {
			Integer i;
			try {
				i = Integer.valueOf(condValue);
			} catch (Exception e) {
				Struts2Utils.setAttribute("msg", "查询菜单信息失败：输入的菜单编号 " + condValue + " 不是正确的数字格式！");
				return null;
			}
			condValueObj = i;
		}
		// 执行查询
		List<Menu> list = menuDao.findByCond(condName, condValueObj);
		if (list == null || list.size() == 0) {
			Struts2Utils.setAttribute("msg", "查询菜单信息失败：没有找到指定的菜单");
			return null;
		} else if (list.size() > 1) {
			Struts2Utils.setAttribute("msg", "查询菜单信息失败：查找到多个菜单");
			return null;
		} else {
			return list.get(0);
		}
	
	}

}
