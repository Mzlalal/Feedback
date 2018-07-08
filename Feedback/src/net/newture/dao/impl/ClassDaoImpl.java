package net.newture.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import net.newture.dao.ClassDao;
import net.newture.domain.Class;
import net.newture.framework.DaoBase;

@Repository
public class ClassDaoImpl extends DaoBase implements ClassDao {

	@Override
	public List<Class> findAllClass() {
		return hibernateTemplate.find("from Class");
	}

	@Override
	public int insertClass(Class classes) {
		int flag = 1;
		try {
			hibernateTemplate.save(classes);
		} catch (DataAccessException e) {
			flag = -1;
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int updateClass(Class classes) {
		int flag = 1;
		try {
			hibernateTemplate.update(classes);
		} catch (DataAccessException e) {
			flag = -1;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteClass(Class classes) {
		try {
			hibernateTemplate.delete(classes);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	@Override
	public Class findById(Integer id) {
		return hibernateTemplate.get(Class.class, id);
	}

	@Override
	public List<Class> findByCond(String className, Object classValue) {
		String hql = "from Class where " + className + " = ?";
		return hibernateTemplate.find(hql, classValue);
	}
}
