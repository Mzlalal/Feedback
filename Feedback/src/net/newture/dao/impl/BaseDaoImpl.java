package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.BaseDao;
import net.newture.domain.Course;
import net.newture.domain.TeachingBase;
import net.newture.framework.DaoBase;

@Repository
public class BaseDaoImpl extends DaoBase implements BaseDao{

	@Override
	public List<TeachingBase> findAllTeachingBase() {
		return hibernateTemplate.find("from TeachingBase");
	}

	@Override
	public void update(TeachingBase base) {
		hibernateTemplate.update(base);
	}
	@Override
	public void delete(TeachingBase base) {
		hibernateTemplate.delete(base);
	}

	@Override
	public TeachingBase findId(Integer id) {
		return hibernateTemplate.get(TeachingBase.class, id);
	}

	@Override
	public void save(TeachingBase base) {
		hibernateTemplate.save(base);
	}

}
