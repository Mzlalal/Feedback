package net.newture.dao;

import java.util.List;

import net.newture.domain.FeedbackItem;

/**
 *
 * @author Mzlalal 2018年6月13日 10:51:31
 */
public interface FeedbackItemDao {
	/**
	 * 查询所有课程
	 *
	 * @return list
	 */
	public List<FeedbackItem> findAll();

	/**
	 * 添加课程
	 *
	 * @param item
	 * @return flag 失败:-1 成功:1
	 */
	public int insertFeedbackItem(FeedbackItem item);

	/**
	 * 修改课程
	 *
	 * @param item
	 * @return flag 失败:-1 成功:1
	 */
	public int updateFeedbackItem(FeedbackItem item);

	/**
	 * 删除课程
	 *
	 * @param item
	 * @return flag 失败:-1 成功:1
	 */
	public int deleteFeedbackItem(FeedbackItem item);

	/**
	 * 查找记录
	 *
	 * @param id
	 * @return
	 */
	public FeedbackItem findById(Integer id);

	/**
	 * 条件查询
	 *
	 * @param condName
	 * @param condValue
	 * @return
	 */
	public List<FeedbackItem> findByCond(String condName, Object condValue);
}
