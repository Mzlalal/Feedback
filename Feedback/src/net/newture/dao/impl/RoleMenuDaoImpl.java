package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.RoleMenuDao;
import net.newture.domain.Menu;
import net.newture.framework.DaoBase;

@Repository
public class RoleMenuDaoImpl extends DaoBase implements RoleMenuDao{

	@Override
	public List<Menu> findAllParentMenu() {
		return hibernateTemplate.find("from Menu where parentMenuId = 0");
	}

	@Override
	public List findAllSonMenuOne() {
		StringBuffer sql = new StringBuffer();

		sql.append("  select m2.menu_id,m2.menu_name, ");
		sql.append("  m2.parent_menu_id,m2.valid_flag  ");
		sql.append("  from menu m1,menu m2  ");
		sql.append("  where m1.menu_id=m2.parent_menu_id and m1.menu_id=1 ");

		return queryBySql(sql.toString());
	}

	@Override
	public List<Menu> findAllSonMenuTwo() {
		StringBuffer sql = new StringBuffer();

		sql.append("  select m2.menu_id,m2.menu_name, ");
		sql.append("  m2.parent_menu_id,m2.valid_flag  ");
		sql.append("  from menu m1,menu m2  ");
		sql.append("  where m1.menu_id=m2.parent_menu_id and m1.menu_id=2 ");

		return queryBySql(sql.toString());
	}

	@Override
	public List<Menu> findAllSonMenuThree() {
		StringBuffer sql = new StringBuffer();

		sql.append("  select m2.menu_id,m2.menu_name, ");
		sql.append("  m2.parent_menu_id,m2.valid_flag  ");
		sql.append("  from menu m1,menu m2  ");
		sql.append("  where m1.menu_id=m2.parent_menu_id and m1.menu_id=3 ");

		return queryBySql(sql.toString());
	}

	@Override
	public List<Menu> findAllSonMenuFore() {
		StringBuffer sql = new StringBuffer();

		sql.append("  select m2.menu_id,m2.menu_name, ");
		sql.append("  m2.parent_menu_id,m2.valid_flag  ");
		sql.append("  from menu m1,menu m2  ");
		sql.append("  where m1.menu_id=m2.parent_menu_id and m1.menu_id=4 ");

		return queryBySql(sql.toString());
	}

	@Override
	public Menu findMenuById(int MenuId) {
		return hibernateTemplate.get(Menu.class,MenuId);
	}

	@Override
	public void saveMenu(Menu menu) {
		hibernateTemplate.update(menu);
		
	}
	
}
