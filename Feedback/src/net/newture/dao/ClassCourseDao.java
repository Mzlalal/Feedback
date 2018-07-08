package net.newture.dao;

import java.util.List;

import net.newture.domain.ClassCourse;

/**
 *
 * @author Mzlalal 2018年6月13日 10:51:40
 */
public interface ClassCourseDao {
	/**
	 * 查询所有班级课程
	 *
	 * @return list<ClassCourse>
	 */
	public List<ClassCourse> findAll();

	/**
	 * 添加班级课程
	 *
	 * @param ClassCourse
	 */
	public void save(ClassCourse classCourse);

	/**
	 * 更新班级课程
	 *
	 * @param ClassCourse
	 */
	public void update(ClassCourse classCourse);

	/**
	 * 删除班级课程
	 *
	 * @param classCourse
	 * @return
	 */
	public void delete(ClassCourse classCourse);

	/**
	 * 根据主键编号查找班级课程
	 *
	 * @param id
	 *            主键编号
	 * @return
	 */
	public ClassCourse findById(Integer id);

	/**
	 * 根据主键编号查找班级课程
	 *
	 * @param classId
	 *            主键编号
	 * @return
	 */
	public List findByClassId(Integer classId);

	/**
	 * 根据主键编号查找教师课程
	 *
	 * @param classId
	 *            主键编号
	 * @return
	 */
	public List findByTeacherId(Integer teacherId);

	/**
	 * 查询班级课程
	 */
	public List findByCond(String condName,Object condValue);
}
