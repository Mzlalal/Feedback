package net.newture.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.newture.dao.ClassCourseDao;
import net.newture.domain.ClassCourse;
import net.newture.framework.DaoBase;

@Repository
public class ClassCourseDaoImpl extends DaoBase implements ClassCourseDao {

	@Override
	public List<ClassCourse> findAll() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select cl.class_id, ");
		sql.append("       cl.class_name, ");
		sql.append("       u1.name as counselor_name,");
		sql.append("       cr.course_id, ");
		sql.append("       cr.course_name, ");
		sql.append("       cr.course_type, ");
		sql.append("       decode(cr.course_type, 1, '纯理论', 2, '理论加上机', 3, '纯上机') as course_type_name, ");
		sql.append("       u2.name as teacher_name, ");
		sql.append("   	   cc.school_year, ");
		sql.append("       cc.semester, ");
		sql.append("       u2.user_id as teacher_id, ");
		sql.append("       cc.cc_id ");
		sql.append("    from classes cl, course cr, class_course cc, users u1, users u2 ");
		sql.append("    where cc.class_id = cl.class_id ");
		sql.append("    and cc.course_id = cr.course_id ");
		sql.append("    and cl.counselor_id = u1.user_id ");
		sql.append("  and cc.teacher_id = u2.user_id ");
		sql.append("  and cl.status = 1 ");
		sql.append("  order by  ");
		sql.append("  cr.course_id ");

		return queryBySql(sql.toString());
	}

	@Override
	public void save(ClassCourse classCourse) {
		hibernateTemplate.save(classCourse);
	}

	@Override
	public void update(ClassCourse classCourse) {
		hibernateTemplate.update(classCourse);
	}

	@Override
	public void delete(ClassCourse classCourse) {
		hibernateTemplate.delete(classCourse);
	}

	@Override
	public ClassCourse findById(Integer id) {
		return hibernateTemplate.get(ClassCourse.class, id);
	}

	@Override
	public List findByClassId(Integer classId) {
		String sql = "select course_id from class_course where class_id = ? order by course_id";
		return queryBySql(sql,new Object[] {classId});
	}

	@Override
	public List findByTeacherId(Integer teacherId) {
		String sql = "select course_id from class_course where teacher_id = ? order by course_id";
		return queryBySql(sql,new Object[] {teacherId});
	}

	@Override
	public List findByCond(String condName, Object condValue) {
		StringBuffer sql = new StringBuffer();

		sql.append(" select cl.class_id, ");
		sql.append("       cl.class_name, ");
		sql.append("       u1.name as counselor_name,");
		sql.append("       cr.course_id, ");
		sql.append("       cr.course_name, ");
		sql.append("       cr.course_type, ");
		sql.append("       decode(cr.course_type, 1, '纯理论', 2, '理论加上机', 3, '纯上机') as course_type_name, ");
		sql.append("       u2.name as teacher_name, ");
		sql.append("   	   cc.school_year, ");
		sql.append("       cc.semester, ");
		sql.append("       u2.user_id as teacher_id, ");
		sql.append("       cc.cc_id ");
		sql.append("    from classes cl, course cr, class_course cc, users u1, users u2 ");
		sql.append("    where cc.class_id = cl.class_id ");
		sql.append("    and cc.course_id = cr.course_id ");
		sql.append("    and cl.counselor_id = u1.user_id ");
		sql.append("  and cc.teacher_id = u2.user_id ");
		sql.append("  and cl.status = 1 ");
		sql.append("  and cc.cc_id = ? ");
		sql.append("  order by  ");
		sql.append("  cr.course_id ");

		return queryBySql(sql.toString(),new Object[] {condValue});
	}

}
