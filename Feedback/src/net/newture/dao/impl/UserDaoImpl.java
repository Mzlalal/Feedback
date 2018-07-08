package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.UserDao;
import net.newture.domain.User;
import net.newture.framework.DaoBase;

@Repository
public class UserDaoImpl extends DaoBase implements UserDao {

	@Override
	public void save(User user) {
		hibernateTemplate.save(user);
	}

	@Override
	public void update(User user) {
		hibernateTemplate.merge(user);
	}

	@Override
	public void delete(User user) {
		hibernateTemplate.delete(user);
	}

	@Override
	public User findById(Integer id) {
		return hibernateTemplate.get(User.class, id);
	}

	@Override
	public User findByLoginName(String loginName) {
		List list = hibernateTemplate.find("from User where loginName = ?", loginName);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return (User) list.get(0);
		}
	}

	// 查询所有状态为 1(在校) 的用户
	@Override
	public List<User> findAll() {
		return hibernateTemplate.find("from User where status=1 order by name");
	}

	// 查询所有老师
	@Override
	public List<User> findAllTeacher() {
		return hibernateTemplate.find("from User where role.roleId = 4");
	}

	@Override
	public int countByLoginNameAndPwd(String loginName, String pwd) {
		// 只需要一条登陆记录
		String hql = "select count(*) from User where loginName = ? and password = ?";
		return ((Long) getSingleResult(hql, new Object[] { loginName, pwd })).intValue();
	}

	@Override
	public List<User> findAllCounselor() {
		return hibernateTemplate.find("from User where role.roleId = 5");
	}

	@Override
	public List<User> findByCond(String condName, Object condValue) {
		String hql = "from User where " + condName + "=?";
		return hibernateTemplate.find(hql, condValue);
	}

}
