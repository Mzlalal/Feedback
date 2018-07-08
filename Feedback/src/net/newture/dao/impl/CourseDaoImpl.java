package net.newture.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import net.newture.dao.CourseDao;
import net.newture.domain.Course;
import net.newture.framework.DaoBase;

@Repository
public class CourseDaoImpl extends DaoBase implements CourseDao {

	@Override
	public List<Course> findAll() {
		return hibernateTemplate.find("from Course");
	}

	@Override
	public int insertCourse(Course course) {
		int flag = 1;
		try {
			hibernateTemplate.save(course);
		} catch (DataAccessException e) {
			flag = -1;
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int updateCourse(Course course) {
		int flag = 1;
		try {
			hibernateTemplate.update(course);
		} catch (DataAccessException e) {
			flag = -1;
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int deleteCourse(Course course) {
		try {
			hibernateTemplate.delete(course);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	@Override
	public Course findById(Integer id) {
		return hibernateTemplate.get(Course.class, id);
	}

	@Override
	public List<Course> findByCond(String condName, Object condValue) {
		String hql = "from Course where " + condName + " = ?";
		return hibernateTemplate.find(hql, condValue);
	}

}
