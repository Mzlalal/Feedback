package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.FeedBackDao;
import net.newture.domain.Feedback;
import net.newture.framework.DaoBase;

@Repository
public class FeedBackDaoImpl extends DaoBase implements FeedBackDao {

	@Override
	public List<Object> getFeedBack() {
		return queryBySql("select feedback_id,feedback_name,begin_tiime,end_time,status from feedback");
	}

	@Override
	public void startfeedback(Feedback feedback) {
		hibernateTemplate.save(feedback);

	}

	@Override
	public void delete(Feedback feedback) {
		hibernateTemplate.delete(feedback);

	}

	@Override
	public Feedback findById(Long id) {
		return hibernateTemplate.get(Feedback.class, id);
	}

	@Override
	public void update(Feedback feedback) {
		hibernateTemplate.update(feedback);

	}

	@Override
	public List<Object> getEndFeedBack() {
		return queryBySql("select feedback_id,feedback_name,begin_tiime,end_time,status from feedback where status = 1");
	}

	@Override
	public List findFeedbackYear() {
		return queryBySql("select distinct school_year from feedback");
	}

}
