package net.newture.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.ClassCourseDao;
import net.newture.dao.ClassDao;
import net.newture.dao.CourseDao;
import net.newture.dao.UserDao;
import net.newture.domain.ClassCourse;
import net.newture.domain.Course;
import net.newture.domain.User;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.ClassCourseService;

@Service
public class ClassCourseServiceImpl implements ClassCourseService {
	@Autowired
	private ClassCourseDao classCourseDao;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ClassDao classDao;

	@Override
	public boolean findAllClassCourse() {
		// 这只是一种获取全部信息的方式
		// 第二种可以使用 obj[] 数组进行保存 在 jsp 进行遍历
		if (classCourseDao.findAll() != null) {
			List list = classCourseDao.findAll();

			List<ClassCourse> classCourses = new ArrayList<ClassCourse>();
			// 循环输出集合中的对象
			for (int i = 0; i < list.size(); i++) {
				// 将输出对象放入数组中
				Object[] obj = (Object[]) list.get(i);
				// 班级课程
				ClassCourse cc = new ClassCourse();
				// 辅导员
				User counselor = new User();
				// 教师
				User teacher = new User();
				// 课程
				Course course = new Course();
				// 班级
				net.newture.domain.Class classes = new net.newture.domain.Class();
				// 班级课程id
				classes.setClassId(Integer.parseInt(obj[0].toString()));
				// 班级名
				classes.setClassName(obj[1].toString());
				// 辅导员
				counselor.setName(obj[2].toString());
				classes.setUsers(counselor);
				// 课程id
				course.setCourseId(Integer.parseInt(obj[3].toString()));
				// 课程名
				course.setCourseName(obj[4].toString());
				// 课程类型
				course.setCourseType(Byte.parseByte(obj[5].toString()));
				// 教师
				teacher.setName(obj[7].toString());
				teacher.setUserId(Integer.parseInt(obj[10].toString()));
				cc.setCcId(Integer.parseInt(obj[11].toString()));
				cc.setUsers(teacher);
				cc.setSchoolYear(Short.parseShort(obj[8].toString()));
				cc.setSemester(Byte.parseByte(obj[9].toString()));
				cc.setClasses(classes);
				cc.setCourse(course);
				// 添加到数组
				classCourses.add(cc);
			}
			// 数据表格列
			Struts2Utils.getSession().setAttribute("classCourses", classCourses);
			return true;
		}
		return false;
	}

	/**
	 * 获取更新课程下拉框的信息
	 */
	@Override
	public void getTableInfo() {
		Struts2Utils.setAttribute("classes", classDao.findAllClass());
		Struts2Utils.setAttribute("courses", courseDao.findAll());
		Struts2Utils.setAttribute("teachers", userDao.findAllTeacher());
		Struts2Utils.setAttribute("counselors", userDao.findAllCounselor());

	}

	@Override
	@Transactional
	public int save(ClassCourse classCourse) {
		classCourseDao.save(classCourse);
		return 1;
	}

	@Override
	@Transactional
	public int update(ClassCourse classCourse) {
		classCourseDao.update(classCourse);
		return 1;
	}

	@Override
	@Transactional
	public int deleteClassCourse(Integer id) {
		// 查询 id 的班级课程
		ClassCourse classCourse = findClassCourseById(id);
		if (classCourse == null) {
			Struts2Utils.setAttribute("msg", "删除班级课程出错：找不到指定班级课程");
			return -1;
		} else {
			deleteClassCourse(classCourse);
			return 1;
		}
	}

	@Override
	@Transactional
	public void deleteClassCourse(ClassCourse classCourse) {
		classCourseDao.delete(classCourse);
	}

	@Override
	@Transactional
	public ClassCourse findClassCourseById(Integer id) {
		// 根据 id 查找 可以为 deleteClassCourse 服务
		return this.classCourseDao.findById(id);
	}

	@Override
	public Object[] findByCond(String condName, String condValue) {
		// 处理查询条件
		Object condValueObj = condValue;
		if (condName.equals("ccId")) {
			Integer i;
			try {
				i = Integer.valueOf(condValue);
			} catch (Exception e) {
				Struts2Utils.setAttribute("msg", "查询班级课程信息失败：输入的用户编号 " + condValue + " 不是正确的数字格式！");
				return null;
			}
			condValueObj = i;
		}
		// 执行查询
		List list = classCourseDao.findByCond(condName, condValueObj);
		if (list == null || list.size() == 0) {
			Struts2Utils.setAttribute("msg", "查询班级课程信息失败：没有找到指定的用户");
			return null;
		} else if (list.size() > 1) {
			Struts2Utils.setAttribute("msg", "查询班级课程信息失败：查找到多个用户");
			return null;
		} else {
			Struts2Utils.setAttribute("cc",list.get(0));
			return (Object[]) list.get(0);
		}
	}
}
