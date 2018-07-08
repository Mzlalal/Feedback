package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.ClassDao;
import net.newture.dao.DepartmentDao;
import net.newture.dao.SysDao;
import net.newture.dao.UserDao;
import net.newture.domain.Role;
import net.newture.domain.User;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.MD532;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.UserService;

@Service
public class UserServiceImpl extends ServiceBase implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private SysDao sysDao;
	@Autowired
	private ClassDao classDao;
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	@Transactional
	public int saveUser(User user) {
		// 校验用户名是否存在
		User findUser = userDao.findByLoginName(user.getLoginName());
		if (findUser != null) {
			Struts2Utils.setAttribute("msg1", "用户名已经被注册!");
			return -1;
		}
		user.setPassword(new MD532().getMD5(user.getPassword()));
		// 保存
		this.userDao.save(user);
		return 1;
	}

	@Override
	@Transactional
	public int updateUser(User user) {
		// 可进行必要的校验与处理
		// 例如密码，如果与原密码相同，说明用户没有修改，则不进行MD5加密；否则要进行加密处理
		if (!userDao.findById(user.getUserId()).getPassword().equals(user.getPassword())) {
			// 密码不同进入加密阶段
			user.setPassword(new MD532().getMD5(user.getPassword()));
		}
		// 更新用户信息
		this.userDao.update(user);
		return 1;
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		this.userDao.delete(user);
		Struts2Utils.setAttribute("msg", "删除用户信息成功！");
	}

	@Override
	@Transactional
	public int deleteUser(Integer id) {
		// 根据主键编号查找用户对象
		User user = userDao.findById(id);
		// 查找对象后进行删除
		if (user == null) {
			Struts2Utils.setAttribute("msg", "删除用户信息出错：找不到指定用户");
			return -1;
		} else {
			// 删除该对象
			userDao.delete(user);
			return 1;
		}
	}

	@Override
	public User findUserById(Integer id) {
		// 根据 id 查找 可以为 deleteUser 服务
		return this.userDao.findById(id);
	}

	@Override
	public void findAllUser() {
		// 查询所有的用户
		List<User> users = this.userDao.findAll();
		Struts2Utils.getSession().setAttribute("users", users);
	}

	@Override
	public boolean isValidLoginUser(User user) {
		// 获取登录名 密码
		String loginName = user.getLoginName().trim();
		String pwd = user.getPassword();
		if (!loginName.equals("") && !pwd.equals("")) {
			// 密码进行MD5加密
			pwd = new MD532().getMD5(user.getPassword());
			// 登陆返回统计数量 只有一条记录才能进入
			int count = userDao.countByLoginNameAndPwd(loginName, pwd);
			if (count == 1) {
				Struts2Utils.getSession().setAttribute("user", userDao.findByLoginName(loginName));
				return true;
			}
			Struts2Utils.setAttribute("msg", "用户名或密码有误!");
			return false;
		} else {
			Struts2Utils.setAttribute("msg", "用户名与密码不能为空!");
			return false;
		}
	}

	@Override
	public void getCodeTable() {
		// userAction add edit 调用 -- > 获取菜单信息
		// 获取用户角色列表
		List<Role> roles = sysDao.findAllRoles();
		// 保存准备遍历
		Struts2Utils.setAttribute("roles", roles);
		// 获取用户角色列表
		List<net.newture.domain.Class> classes = classDao.findAllClass();
		// 保存准备遍历
		Struts2Utils.setAttribute("classes", classes);
		// 获取用户角色列表
		List<net.newture.domain.Department> departments = departmentDao.findAllDepartments();
		// 保存准备遍历
		Struts2Utils.setAttribute("departments", departments);

	}

	@Override
	public User findByCond(String condName, String condValue) {
		// 处理查询条件
		Object condValueObj = condValue;
		if (condName.equals("userId")) {
			Integer i;
			try {
				i = Integer.valueOf(condValue);
			} catch (Exception e) {
				Struts2Utils.setAttribute("msg", "查询用户信息失败：输入的用户编号 " + condValue + " 不是正确的数字格式！");
				return null;
			}
			condValueObj = i;
		}
		// 执行查询
		List<User> list = userDao.findByCond(condName, condValueObj);
		if (list == null || list.size() == 0) {
			Struts2Utils.setAttribute("msg", "查询用户信息失败：没有找到指定的用户");
			return null;
		} else if (list.size() > 1) {
			Struts2Utils.setAttribute("msg", "查询用户信息失败：查找到多个用户");
			return null;
		} else {
			return list.get(0);
		}
	}
	/**
	 * 修改密码
	 */
	public int updateing(int userId){
		String newPwd = Struts2Utils.getParameter("input2");
		String oldPwd = Struts2Utils.getParameter("pwd");
		//对旧密码进行加密，以便于验证
		String oldPwd1 = new MD532().getMD5(oldPwd);
		System.out.println("新密码："+newPwd);
		System.out.println("旧密码："+oldPwd);
		User user =userDao.findById(userId);
		System.out.println("数据库中的密码！"+user.getPassword());
		if(oldPwd1.equals(user.getPassword())){
			user.setPassword(new MD532().getMD5(newPwd));
			userDao.update(user);
			System.out.println("修改成功！");
			return 1;
		}else{
			Struts2Utils.setAttribute("message", "旧密码输入错误！有可能用户登录过期！");
			return 0;
		}
	
		
	}

}
