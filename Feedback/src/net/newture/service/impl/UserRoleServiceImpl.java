package net.newture.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.newture.dao.UserRoleDao;
import net.newture.domain.Role;
import net.newture.domain.User;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public void findAllUserRole() {
		List list = userRoleDao.findAllUserRole();
		List<Role> userRole = new ArrayList<Role>();
		for(int i =0;i<list.size();i++){
			// 将输出对象放入数组中
			Object[] obj = (Object[]) list.get(i);
			User user = new User();
			net.newture.domain.Role roles = new net.newture.domain.Role();
			user.setUserId(Integer.parseInt(obj[0].toString()));
			user.setLoginName(obj[1].toString());
			user.setName(obj[2].toString());
			roles.setRoleId(Integer.parseInt(obj[3].toString()));
			roles.setRoleName(obj[4].toString());
			roles.setUser(user);
			userRole.add(roles);
		}
		Struts2Utils.setAttribute("userRole", userRole);
	}

	@Override
	public Role findRoleById(int roleId) {
		Role r = userRoleDao.findRoleById(roleId);
		Struts2Utils.setAttribute("r", r);
		return r;
	}

	@Override
	public User findUserById(int userId) {
		User u = userRoleDao.findUserById(userId);
		Struts2Utils.setAttribute("u", u);
		return u;
	}

	@Override
	public void findAllRole() {
		List<Role> role = userRoleDao.findAllRole();
		Struts2Utils.setAttribute("role", role);
	}

	@Override
	public int updateUserRole(int userId,int roleId) {
		int rId = roleId;
		//获取userId的用户
		User user = userRoleDao.findUserById(userId);
		System.out.println(roleId);
		if(rId!=6){
			user.setUserType((byte) 1);
		}else{
			user.setUserType((byte)2);
		}
		//获取roleId的角色
		Role role = userRoleDao.findRoleById(roleId);
		user.setRole(role);
		userRoleDao.updateUserRole(user);
		return 1;
	}
}
