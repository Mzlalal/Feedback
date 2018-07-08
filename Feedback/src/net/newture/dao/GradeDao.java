package net.newture.dao;

import java.util.List;

import net.newture.domain.FeedbackScore;

public interface GradeDao {
	/**
	 * 查询所有评分列表
	 * 
	 * @return
	 */
	public List<FeedbackScore> findAllScore();
	
	/**
	 * 更新指定评分信息
	 * @param role 待更新评分信息
	 */
	public void update(FeedbackScore feedbackScore);
	
	public List findById(Long fsId);
}
