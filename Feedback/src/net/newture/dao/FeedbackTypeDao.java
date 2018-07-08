package net.newture.dao;

import java.util.List;

import net.newture.domain.Class;
import net.newture.domain.FeedbackItemType;

public interface FeedbackTypeDao {
	/**
	 * 查询所有班级
	 *
	 * @return list<Class>
	 */
	public List<FeedbackItemType> findAllType();

	/**
	 * 添加课程
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
	public int deleteFeedbackItemType(FeedbackItemType type);

	/**
	 * 查找记录
	 *
	 * @param id
	 * @return
	 */
	public FeedbackItemType findById(Integer id);
	/**
	 * 条件查询
	 * @param className
	 * @param classValue
	 * @return
	 */
	public List<FeedbackItemType> findByCond(String className, Object classValue);
}
