package net.newture.dao;

import java.util.List;

import net.newture.domain.Class;

public interface ClassDao {
	/**
	 * 查询所有班级
	 *
	 * @return list<Class>
	 */
	public List<Class> findAllClass();

	/**
	 * 添加课程
	 *
	 * @param Class
	 * @return flag 失败:-1 成功:1
	 */
	public int insertClass(Class classes);

	/**
	 * 修改课程
	 *
	 * @param Class
	 * @return flag 失败:-1 成功:1
	 */
	public int updateClass(Class classes);

	/**
	 * 删除课程
	 *
	 * @param Class
	 * @return flag 失败:-1 成功:1
	 */
	public int deleteClass(Class classes);

	/**
	 * 查找记录
	 *
	 * @param id
	 * @return
	 */
	public Class findById(Integer id);
	/**
	 * 条件查询
	 * @param className
	 * @param classValue
	 * @return
	 */
	public List<Class> findByCond(String className, Object classValue);
}
