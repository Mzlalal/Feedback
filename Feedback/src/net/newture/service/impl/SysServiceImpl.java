package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.newture.dao.SysDao;
import net.newture.domain.User;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.SysService;

@Service
public class SysServiceImpl extends ServiceBase implements SysService {
	@Autowired
	private SysDao sysDao;

	@Override
	public void getLoginUserMenuInfo() {
		// 获取登录用户信息
		User loginUser = getLoginUser();
		// 获取登陆用户的角色 获取对应角色的菜单
		List<Object[]> menus = sysDao.getSysMenuByRoleId(loginUser.getRole().getRoleId());
		// 处理系统菜单信息为HTML代码，传给jsp页面使用
		StringBuffer menu_1 = new StringBuffer(), menu_2 = new StringBuffer(), menu_3 = new StringBuffer(),
				menu_4 = new StringBuffer();
		int parentMenuId;
		// menu_1_order = 0, menu_2_order = 0, menu_3_order = 0, menu_4_order = 0;
		String menuName, menuUrl, liId;
		for (int i = 0; i < menus.size(); i++) {
			Object[] menu = menus.get(i);
			// 获取菜单信息
			parentMenuId = Integer.parseInt(menu[3].toString());
			if (parentMenuId == 0) {
				continue;
			}
			// 第6列 menu_name
			menuName = menu[5].toString();
			// 第7列 menu_url
			menuUrl = menu[6].toString();

			switch (parentMenuId) {
			case 1:
				menu_1.append("<li><a href=\"");
				menu_1.append(menuUrl);
				menu_1.append("\" target=\"main\">");
				menu_1.append(menuName);
				menu_1.append("</a></li>");
				break;
			case 2:
				menu_2.append("<li><a href=\"");
				menu_2.append(menuUrl);
				menu_2.append("\" target=\"main\">");
				menu_2.append(menuName);
				menu_2.append("</a></li>");
				break;
			case 3:
				// 格式化字符 老师的框架是例子 onclick(1,2) 传入参数打开的下拉列表
				// liId = String.format("li%1$1d%2$02d", parentMenuId, ++menu_3_order);
				menu_3.append("<li><a href=\"");
				menu_3.append(menuUrl);
				menu_3.append("\" target=\"main\">");
				menu_3.append(menuName);
				menu_3.append("</a></li>");
				break;
			case 4:
				menu_4.append("<li><a href=\"");
				menu_4.append(menuUrl);
				menu_4.append("\" target=\"main\">");
				menu_4.append(menuName);
				menu_4.append("</a></li>");
				break;
			}
		}
		// 将菜单信息放入请求对象中，以便jsp使用
		Struts2Utils.setAttribute("menu_1", menu_1.toString());
		Struts2Utils.setAttribute("menu_2", menu_2.toString());
		Struts2Utils.setAttribute("menu_3", menu_3.toString());
		Struts2Utils.setAttribute("menu_4", menu_4.toString());
	}

}
