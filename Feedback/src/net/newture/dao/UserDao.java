package net.newture.dao;

import java.util.List;

import net.newture.domain.User;

public interface UserDao {
	/**
	 * 保存指定用户信息
	 *
	 * @param user
	 *            待保存用户
	 */
	public void save(User user);

	/**
	 * 更新指定用户信息
	 *
	 * @param user
	 *            待更新用户
	 */
	public void update(User user);

	/**
	 * 删除指定用户
	 *
	 * @param user
	 *            待删除用户
	 */
	public void delete(User user);

	/**
	 * 根据主键编号查找用户
	 *
	 * @param id
	 *            主键编号
	 * @return
	 */
	public User findById(Integer id);

	/**
	 * 查找是否有重复登录名
	 *
	 * @param loginName
	 *            登录名
	 * @return User对象
	 */
	public User findByLoginName(String loginName);

	/**
	 * 查询所有用户列表
	 *
	 * @return
	 */
	public List<User> findAll();

	/**
	 * 统计登录名与密码匹配的用户数量
	 *
	 * @param loginName
	 *            登录名
	 * @param pwd
	 *            密码
	 * @return int
	 */
	public int countByLoginNameAndPwd(String loginName, String pwd);

	/**
	 * 查询所有教师
	 *
	 * @return
	 */
	public List<User> findAllTeacher();

	/**
	 * 查询所有辅导员
	 *
	 * @return
	 */
	public List<User> findAllCounselor();
	
    public List<User> findByCond(String condName,Object condValue);
	
	/**
	 * 查询所有用户列表
	 * @return
	 */
}
