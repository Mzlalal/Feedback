package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.CourseDao;
import net.newture.domain.Course;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.CourseService;

/**
 *
 * @author Mzlalal 2018年6月13日 10:52:31
 */
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Course> findAllCourse() {
		return courseDao.findAll();
	}

	@Override
	@Transactional
	public int insertCourse(Course course) {
		return courseDao.insertCourse(course);
	}

	@Override
	@Transactional
	public int updateCourse(Course course) {
		return courseDao.updateCourse(course);
	}

	@Override
	@Transactional
	public int deleteCourse(Integer id) {
		// 根据主键编号查找用户对象
		Course course = courseDao.findById(id);
		// 如果根据 id 查找不到则返回 null , get 直接报错呢
		if (course == null) {
			Struts2Utils.setAttribute("msg", "删除用户信息出错：找不到指定用户");
			return -1;
		} else {
			// 删除该对象
			courseDao.deleteCourse(course);
			return 1;
		}
	}

	@Override
	public Course findCourseById(Integer id) {
		return courseDao.findById(id);
	}

	@Override
	public Course findByCond(String condName, String condValue) {
		// 处理查询条件
		Object condValueObj = condValue;
		if (condName.equals("courseId")) {
			Integer i;
			try {
				i = Integer.parseInt(condValue);
			} catch (Exception e) {
				Struts2Utils.setAttribute("msg", "查询用户信息失败：输入的用户编号 " + condValue + " 不是正确的数字格式！");
				return null;
			}
			condValueObj = i;
		}
		// 执行查询
		List<Course> list = courseDao.findByCond(condName, condValueObj);
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
