package net.newture.service;

import java.util.List;

import net.newture.domain.FeedbackItem;

/**
 *
 * @author Mzlalal 2018年6月13日 10:51:22
 */
public interface FeedbackItemService {
	/**
	 * 查询所有课程
	 *
	 * @return List<FeedbackItem>
	 */
	public List<FeedbackItem> findAllFeedbackItem();

	/**
	 * 插入课程
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
	public int deleteFeedbackItem(Integer id);

	/**
	 * 通过id查找课程
	 *
	 * @param id
	 * @return
	 */
	public FeedbackItem findFeedbackItemById(Integer id);

	/**
	 * 条件查询课程
	 *
	 * @param condName
	 * @param condValue
	 * @return
	 */
	public FeedbackItem findByCond(String condName, String condValue);
}
