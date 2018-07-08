package net.newture.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.newture.dao.RoleMenuDao;
import net.newture.domain.Menu;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.RoleMenuService;
@Service
public class RoleMenuServiceImpl implements RoleMenuService{
	@Autowired
	private RoleMenuDao roleMenuDao;

	@Override
	public void findAllParentMenu() {
		List<Menu> parentMenu = roleMenuDao.findAllParentMenu();
		Struts2Utils.setAttribute("parentMenu", parentMenu);
		
	}
	
	/**
	 * 封装获取子菜单的方法
	 * @param list
	 * @return
	 */
	public List<Menu> sonMenu(List list){
		List<Menu> sonMenu = new ArrayList<Menu>();
		for(int i=0;i<list.size();i++){
			Object[] obj = (Object[]) list.get(i);
			Menu m = new Menu();
			m.setMenuId(Integer.parseInt(obj[0].toString()));
			m.setMenuName(obj[1].toString());
			m.setParentMenuId(Integer.parseInt(obj[2].toString()));
			m.setValidFlag(Integer.parseInt(obj[3].toString()));
			sonMenu.add(m);
		}
		return sonMenu;
	}
	
	@Override
	public int findSonMenu(int menuId) {
		if(menuId>3){
			List list4 = roleMenuDao.findAllSonMenuFore();
			List<Menu> sonMenufour = sonMenu(list4);
			Struts2Utils.setAttribute("sonMenufour", sonMenufour);
			return 4;
		}else if(menuId>2){
			List list3 = roleMenuDao.findAllSonMenuThree();
			List<Menu> sonMenuThree = sonMenu(list3);
			Struts2Utils.setAttribute("sonMenuThree", sonMenuThree);
			return 3;
		}else if(menuId>1){
			List list2 = roleMenuDao.findAllSonMenuTwo();
			List<Menu> sonMenuTwo = sonMenu(list2);
			Struts2Utils.setAttribute("sonMenuTwo", sonMenuTwo);
			return 2;
		}else{
			List list1 = roleMenuDao.findAllSonMenuOne();
			List<Menu> sonMenuOne = sonMenu(list1);
			Struts2Utils.setAttribute("sonMenuOne", sonMenuOne);
			return 1;
		}
	}

	@Override
	public int saveMenu(int menuId,boolean bool) {
		Menu m = roleMenuDao.findMenuById(menuId);
		if(bool){
			m.setValidFlag(0);
			roleMenuDao.saveMenu(m);
			return 1;
		}else{
			m.setValidFlag(1);
			roleMenuDao.saveMenu(m);
			return 1;
		}
	}
}
