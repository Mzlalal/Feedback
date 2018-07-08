package net.newture.dao;

import java.util.List;

import net.newture.domain.Feedback;

public interface FeedBackDao {

	/**
	 * 查询所有反馈批次信息
	 * @return List
	 */
	public List<Object> getFeedBack();

	/**
	 * 开启反馈批次
	 * @param feedback
	 */
	public void startfeedback(Feedback feedback);

	/**
	 * 删除反馈批次
	 * @param feedback
	 */
	public void delete(Feedback feedback);
	/**
	 * 根据ID查找反馈批次
	 * @param id
	 */
	public Feedback findById(Long id);

	/**
	 * 更新反馈批次
	 * @param feedback
	 */
	public void update(Feedback feedback);
	/**
	 * 查询结束反馈批次信息
	 * @return List
	 */
	public List<Object> getEndFeedBack();

	/**
	 * 查询所有反馈批次年份
	 * @return
	 */
	public List findFeedbackYear();
}
