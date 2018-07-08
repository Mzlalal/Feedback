package net.newture.service;

import java.util.List;

import net.newture.domain.Class;

public interface ClassService {
	public List<net.newture.domain.Class> findAllClass();
	/**
	 * 插入课程
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
	public int deleteClass(Integer id);

	/**
	 * 通过id查找课程
	 * @param id
	 * @return
	 */
	public Class findClassById(Integer id);

	public void getTableInfo();
	/**
	 * 条件查询课程
	 * @param condName
	 * @param condValue
	 * @return
	 */
	public Class findByCond(String className, String classValue);
}
