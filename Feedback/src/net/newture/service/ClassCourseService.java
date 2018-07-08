package net.newture.service;

import net.newture.domain.ClassCourse;

/**
 * @author Mzlalal 2018年6月13日 10:52:21
 */
public interface ClassCourseService {

	/**
	 * 查看所有班级课程
	 *
	 * @return boolean
	 */
	public boolean findAllClassCourse();

	/**
	 * 获取下拉框菜单信息
	 */
	public void getTableInfo();

	/**
	 * 保存班级课程方法
	 *
	 * @return
	 */
	public int save(ClassCourse classCourse);

	/**
	 * 更新班级课程
	 *
	 * @param classCourse
	 * @return
	 */
	public int update(ClassCourse classCourse);

	/**
	 * 删除指定用户
	 *
	 * @param classCourse
	 *            待删除用户
	 * @return 1：成功 -1：失败
	 */
	public void deleteClassCourse(ClassCourse classCourse);

	/**
	 * 根据 id 查找班级课程
	 *
	 * @param id
	 * @return
	 */
	public ClassCourse findClassCourseById(Integer id);

	/**
	 * 先使用 id 的方法调用findById 查询到结果后 调用 classcourse 删除班级课程
	 *
	 * @param id
	 * @return
	 */
	public int deleteClassCourse(Integer id);


	/**
	 * 条件查询班级课程
	 * @param condName
	 * @param condValue
	 * @returnss
	 */
	public Object[] findByCond(String condName,String condValue);
}
