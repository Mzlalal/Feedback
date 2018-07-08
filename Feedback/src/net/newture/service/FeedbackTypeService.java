package net.newture.service;

import java.util.List;

import net.newture.domain.FeedbackItemType;

public interface FeedbackTypeService {
	public List<FeedbackItemType> findAllType();

	/**
	 * 插入课程
	 *
	 * @param Class
	 * @return flag 失败:-1 成功:1
	 */
	public int insertFeedbackItemType(FeedbackItemType type);

	/**
	 * 修改课程
	 *
	 * @param Class
	 * @return flag 失败:-1 成功:1
	 */
	public int updateFeedbackItemType(FeedbackItemType type);

	/**
	 * 删除课程
	 *
	 * @param Class
	 * @return flag 失败:-1 成功:1
	 */
	public int deleteFeedbackItemType(Integer id);

	/**
	 * 通过id查找课程
	 *
	 * @param id
	 * @return
	 */
	public FeedbackItemType findTypeById(Integer id);

	public void getTableInfo();

	/**
	 * 条件查询课程
	 *
	 * @param condName
	 * @param condValue
	 * @return
	 */
	public FeedbackItemType findByCond(String className, String classValue);
}
