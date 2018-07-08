package net.newture.dao;

import java.util.List;

import net.newture.domain.Course;

/**
 *
 * @author Mzlalal 2018年6月13日 10:51:31
 */
public interface CourseDao {
	/**
	 * 查询所有课程
	 *
	 * @return list
	 */
	public List<Course> findAll();

	/**
	 * 添加课程
	 *
	 * @param course
	 * @return flag 失败:-1 成功:1
	 */
	public int insertCourse(Course course);

	/**
	 * 修改课程
	 *
	 * @param course
	 * @return flag 失败:-1 成功:1
	 */
	public int updateCourse(Course course);

	/**
	 * 删除课程
	 *
	 * @param course
	 * @return flag 失败:-1 成功:1
	 */
	public int deleteCourse(Course course);

	/**
	 * 查找记录
	 *
	 * @param id
	 * @return
	 */
	public Course findById(Integer id);
	/**
	 * 条件查询
	 * @param condName
	 * @param condValue
	 * @return
	 */
	public List<Course> findByCond(String condName, Object condValue);
}
