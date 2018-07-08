package net.newture.service;

import java.util.List;

import net.newture.domain.Course;

/**
 *
 * @author Mzlalal 2018年6月13日 10:51:22
 */
public interface CourseService {
	/**
	 * 查询所有课程
	 *
	 * @return List<Course>
	 */
	public List<Course> findAllCourse();

	/**
	 * 插入课程
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
	public int deleteCourse(Integer id);

	/**
	 * 通过id查找课程
	 * @param id
	 * @return
	 */
	public Course findCourseById(Integer id);

	/**
	 * 条件查询课程
	 * @param condName
	 * @param condValue
	 * @return
	 */
	public Course findByCond(String condName, String condValue);
}
