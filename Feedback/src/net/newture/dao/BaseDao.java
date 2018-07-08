package net.newture.dao;

import java.util.List;
import net.newture.domain.TeachingBase;

public interface BaseDao {
	/**
	 * 查询所有基地列表
	 * @return
	 */
	public List<TeachingBase> findAllTeachingBase();
	
	/**
	 * 保存指定基地信息
	 * @param teachingBase 待保存基地
	 */
	public void save(TeachingBase base);
	
	/**
	 * 更新指定基地信息
	 * @param teachingBase 待更新基地
	 */
	public void update(TeachingBase base);

	/**
	 * 删除指定基地信息
	 * @param teachingBase 待删除基地
	 */
	public void delete(TeachingBase base);
	
	/**
	 * 通过Id搜索指定基地信息
	 * @param id 待搜索id
	 */
	public TeachingBase findId(Integer id);
}
