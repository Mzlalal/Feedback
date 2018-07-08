package net.newture.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import net.newture.dao.ClassDao;
import net.newture.dao.FeedbackTypeDao;
import net.newture.domain.Class;
import net.newture.domain.FeedbackItemType;
import net.newture.framework.DaoBase;

@Repository
public class FeedbackTypeDaoImpl extends DaoBase implements FeedbackTypeDao {

	@Override
	public List<FeedbackItemType> findAllType() {
		return hibernateTemplate.find("from FeedbackItemType");
	}

	@Override
	public int insertFeedbackItemType(FeedbackItemType type) {
		int flag = 1;
		try {
			hibernateTemplate.save(type);
		} catch (DataAccessException e) {
			flag = -1;
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int updateFeedbackItemType(FeedbackItemType type) {
		int flag = 1;
		try {
			hibernateTemplate.update(type);
		} catch (DataAccessException e) {
			flag = -1;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteFeedbackItemType(FeedbackItemType type) {
		try {
			hibernateTemplate.delete(type);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	@Override
	public FeedbackItemType findById(Integer id) {
		return hibernateTemplate.get(FeedbackItemType.class, id);
	}

	@Override
	public List<FeedbackItemType> findByCond(String className, Object classValue) {
		String hql = "from FeedbackItemType where " + className + " = ?";
		return hibernateTemplate.find(hql, classValue);
	}
}
