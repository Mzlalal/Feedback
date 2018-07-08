package net.newture.dao.impl;

import java.util.List;

import net.newture.dao.FeedbackItemDao;
import net.newture.domain.FeedbackItem;
import net.newture.framework.DaoBase;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class FeedbackItemDaoImpl extends DaoBase implements FeedbackItemDao {

	@Override
	public List<FeedbackItem> findAll() {
		return hibernateTemplate.find("from FeedbackItem");
	}

	@Override
	public int insertFeedbackItem(FeedbackItem item) {
		int flag = 1;
		try {
			hibernateTemplate.save(item);
		} catch (DataAccessException e) {
			flag = -1;
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int updateFeedbackItem(FeedbackItem item) {
		int flag = 1;
		try {
			hibernateTemplate.update(item);
		} catch (DataAccessException e) {
			flag = -1;
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int deleteFeedbackItem(FeedbackItem item) {
		try {
			hibernateTemplate.delete(item);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	@Override
	public FeedbackItem findById(Integer id) {
		return hibernateTemplate.get(FeedbackItem.class, id);
	}

	@Override
	public List<FeedbackItem> findByCond(String condName, Object condValue) {
		String hql = "from FeedbackItem where " + condName + " = ?";
		return hibernateTemplate.find(hql, condValue);
	}

}
