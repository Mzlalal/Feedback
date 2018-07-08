package net.newture.service;

import java.util.List;

import net.newture.domain.FeedbackScore;

public interface GradeService {
	/**
	 * 获取评分代码表信息
	 * @return 
	 */
	public void getScoreTable();
	
	/**
	 * 更新指定评分信息
	 * @param role 待更新评分信息
	 * @return 1：成功 -1：失败
	 */
	public int updateGrade(FeedbackScore feedbackScore);
	
	public List findById(Long fsId);
}
