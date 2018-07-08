package net.newture.service;

import net.newture.domain.Feedback;

public interface FeedBackService {
	/**
	 * 获取反馈信息
	 */
	public void getFeedBack();
	
	/**
	 * 保存反馈信息
	 * @param feedback
	 * @return 1：成功 -1：失败
	 */
	public int startfeedback(Feedback feedback );
	
	/**
	 * 删除反馈信息
	 * @param feedback
	 */
	public void deleteFeedBack(Feedback feedback);
	
	/**
	 * 删除反馈信息
	 * @param id
	 * @return 1:成功  -1:失败
	 */
	public int deleteFeedBack(Long id);
	public Feedback findbyid(Long id);
	
	/**
	 * 更新反馈信息
	 * @param feedback
	 * return 1:成功 -1:失败
	 */
	public int updatefeedback(Feedback feedback);
	
	/**
	 * 获取结束反馈信息
	 */
	public void getEndFeedBack();
}
