package net.newture.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import net.newture.dao.MenuDao;
import net.newture.domain.Menu;
import net.newture.framework.DaoBase;
@Repository
public class MenuDaoImpl extends DaoBase implements MenuDao {

	@Override
	public void save(Menu menu) {
		hibernateTemplate.save(menu);
	}

	@Override
	public List<Menu> findAll() {
		return hibernateTemplate.find("from Menu");
	}

	@Override
	public void delete(Menu menu) {
		hibernateTemplate.delete(menu);
	}

	@Override
	public Menu findMenuById(Integer id) {
		return hibernateTemplate.get(Menu.class, id);
	}

	@Override
	public int updateMenu(Menu menu) {
		int flag = 1;
		try {
			hibernateTemplate.update(menu);
		} catch (DataAccessException e) {
			flag = -1;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Menu> findByCond(String condName, Object condValue) {
		String hql = "from Menu where " + condName + "=?";
		return hibernateTemplate.find(hql, condValue);
	}
	
}
