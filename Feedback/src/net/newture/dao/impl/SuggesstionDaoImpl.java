package net.newture.dao.impl;

import java.util.List;

import net.newture.dao.SuggesstionDao;
import net.newture.domain.Suggestion;
import net.newture.domain.User;
import net.newture.framework.DaoBase;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class SuggesstionDaoImpl extends DaoBase implements SuggesstionDao {

	@Override
	public List<Suggestion> findAllSuggestion() {
		return hibernateTemplate.find("from Suggestion");
	}

	@Override
	public int insertSuggestion(Suggestion suggestion) {
		int flag = 1;
		try {
			hibernateTemplate.save(suggestion);
		} catch (DataAccessException e) {
			flag = -1;
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int updateSuggestion(Suggestion suggestion) {
		int flag = 1;
		try {
			hibernateTemplate.update(suggestion);
		} catch (DataAccessException e) {
			flag = -1;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteSuggestion(Suggestion suggestion) {
		try {
			hibernateTemplate.delete(suggestion);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	@Override
	public Suggestion findById(Long id) {
		return hibernateTemplate.get(Suggestion.class, id);
	}

	@Override
	public List<User> findAllTeacher() {
		return hibernateTemplate.find("from User where role.roleId = 4");
	}

	@Override
	public List<User> findAllStudent() {
		return hibernateTemplate.find("from User where role.roleId = 6");
	}

	@Override
	public List<Object> getFeedBack() {
		return queryBySql("select feedback_id,feedback_name,begin_tiime,end_time,status from feedback");
	}
}
