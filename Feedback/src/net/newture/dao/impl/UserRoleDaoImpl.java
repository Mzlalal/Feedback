package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import net.newture.dao.UserRoleDao;
import net.newture.domain.Role;
import net.newture.domain.TeachingBase;
import net.newture.domain.User;
import net.newture.framework.DaoBase;
@Repository
public class UserRoleDaoImpl extends DaoBase implements UserRoleDao{

	@Override
	public List<User> findAllUserRole(){
		StringBuffer sql = new StringBuffer();
		sql.append(" select u.user_id, u.login_name,  ");
		sql.append(" u.name, r.role_id, r. role_name ");
		sql.append("   from users u, role r ");
		sql.append("  where u.role_id = r.role_id ");
		return queryBySql(sql.toString());
	}

	@Override
	public Role findRoleById(int roleId) {
		return hibernateTemplate.get(Role.class, roleId);
	}

	@Override
	public User findUserById(int userId) {
		return hibernateTemplate.get(User.class, userId);
	}

	@Override
	public List<Role> findAllRole() {
		return hibernateTemplate.find("from Role order by roleName");
	}

	@Override
	public void updateUserRole(User user) {
		hibernateTemplate.update(user);	
	}
}
