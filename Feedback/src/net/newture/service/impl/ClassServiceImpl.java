package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.BaseDao;
import net.newture.dao.ClassDao;
import net.newture.dao.UserDao;
import net.newture.domain.Class;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private ClassDao classDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BaseDao baseDao;


	@Override
	public List<Class> findAllClass() {
		return classDao.findAllClass();
	}

	@Override
	@Transactional
	public int insertClass(Class classes) {
		return classDao.insertClass(classes);
	}

	@Override
	@Transactional
	public int updateClass(Class classes) {
		return classDao.updateClass(classes);
	}

	@Override
	@Transactional
	public int deleteClass(Integer id) {
		// 根据主键编号查找用户对象
		Class classes = classDao.findById(id);
		// 如果根据 id 查找不到则返回 null , get 直接报错呢
		if (classes == null) {
			Struts2Utils.setAttribute("msg", "删除用户信息出错：找不到指定用户");
			return -1;
		} else {
			// 删除该对象
			classDao.deleteClass(classes);
			return 1;
		}
	}

	@Override
	public Class findClassById(Integer id) {
		return classDao.findById(id);
	}

	@Override
	public void getTableInfo() {
		Struts2Utils.setAttribute("counselors", userDao.findAllCounselor());
		Struts2Utils.setAttribute("bases", baseDao.findAllTeachingBase());
	}

	@Override
	public Class findByCond(String className, String classValue) {
		// 处理查询条件
		Object condValueObj = classValue;
		if (className.equals("classId")) {
			Integer i;
			try {
				i = Integer.parseInt(classValue);
			} catch (Exception e) {
				Struts2Utils.setAttribute("msg", "查询班级信息失败：输入的用户编号 " + classValue + " 不是正确的数字格式！");
				return null;
			}
			condValueObj = i;
		}
		// 执行查询
		List<Class> list = classDao.findByCond(className, condValueObj);
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

}
