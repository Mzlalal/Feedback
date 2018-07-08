package net.newture.service;

import net.newture.domain.TeachingBase;

public interface BaseService {
	/**
	 * 删除指定基地
	 * @param teachingBase 待删除用户
	 * @return 1：成功 -1：失败
	 */
	public int deleteBase(Integer id);
	
	/**
	 * 保存基地信息
	 * @param role 待保存基地
	 * @return 1：成功 -1：失败
	 */
	public int saveBase(TeachingBase base);
	
	/**
	 * 更新指定基地
	 * @param teachingBase 待更新用户
	 * @return 1：成功 -1：失败
	 */
	public int updateBase(TeachingBase base);
	
	/**
	 * 获取所有基地列表
	 */
	public void findAllBase();
}
