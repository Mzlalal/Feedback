package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.GradeDao;
import net.newture.domain.FeedbackScore;
import net.newture.framework.DaoBase;
@Repository
public class GradeDaoImpl extends DaoBase implements GradeDao{
	@Override
	public List<FeedbackScore> findAllScore() {
		return hibernateTemplate.find("from  FeedbackScore order by fs_id");
	}

	@Override
	public void update(FeedbackScore feedbackScore) {
		hibernateTemplate.update(feedbackScore);
	}

	@Override
	public List findById(Long fsId) {
		return this.hibernateTemplate.find("from FeedbackScore where fs_id = ?", new Object[]{fsId});
	}
}
