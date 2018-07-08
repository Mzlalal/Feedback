package net.newture.dao.impl;

import java.util.List;

import net.newture.dao.ReportDao;
import net.newture.framework.DaoBase;

import org.springframework.stereotype.Repository;

@Repository
public class ReportDaoImpl extends DaoBase implements ReportDao {

	@Override
	public List findClassReport(short schoolYear, byte time, Integer fitId, Integer classId) {
		StringBuffer sql = new StringBuffer();

		sql.append(" select  ");
		sql.append("        cl.class_name, ");
		sql.append("        fb.feedback_name, ");
		sql.append("        fs.teacher_id, ");
		sql.append("        tch.name, ");
		sql.append("        fs.course_id, ");
		sql.append("        cr.course_name, ");
		sql.append("        fit.fit_id, ");
		sql.append("        fit.fit_name, ");
		sql.append("        fi.fi_id, ");
		sql.append("        fi.fi_name, ");
		sql.append("        fi.item_value, ");
		sql.append("        avg(fs.score) as score ");
		sql.append("   from feedback           fb, ");
		sql.append("        feedback_score     fs, ");
		sql.append("        feedback_item      fi, ");
		sql.append("        feedback_item_type fit, ");
		sql.append("        classes            cl, ");
		sql.append("        users              tch, ");
		sql.append("        course             cr ");
		sql.append("  where fs.feedback_id = fb.feedback_id ");
		sql.append("    and fb.class_id = cl.class_id ");
		sql.append("    and fs.teacher_id = tch.user_id ");
		sql.append("    and fs.course_id = cr.course_id ");
		sql.append("    and fs.fi_id = fi.fi_id ");
		sql.append("    and fi.fit_id = fit.fit_id ");
		sql.append("    and fb.status > 0 ");
		sql.append("    and fb.school_year = ? ");
		sql.append("    and fb.times = ? ");
		sql.append("    and fit.fit_id in (?) ");
		sql.append("    and cl.class_id = ? ");
		sql.append("  group by fb.feedback_id, ");
		sql.append("           cl.class_id, ");
		sql.append("           cl.class_name, ");
		sql.append("           fb.feedback_name, ");
		sql.append("           fb.school_year, ");
		sql.append("           fb.semester, ");
		sql.append("           fb.times, ");
		sql.append("           fs.teacher_id, ");
		sql.append("           tch.name, ");
		sql.append("           fs.course_id, ");
		sql.append("           cr.course_name, ");
		sql.append("           fit.fit_id, ");
		sql.append("           fit.fit_name, ");
		sql.append("           fi.fi_id, ");
		sql.append("           fi.fi_name, ");
		sql.append("           fi.item_value, ");
		sql.append("           fi.disp_order ");
		sql.append("  order by fb.feedback_id, ");
		sql.append("           cl.class_id, ");
		sql.append("           fb.school_year, ");
		sql.append("           fb.semester, ");
		sql.append("           fb.times, ");
		sql.append("           fs.teacher_id, ");
		sql.append("           fs.course_id, ");
		sql.append("           fit.fit_id, ");
		sql.append("           fi.disp_order ");

		return queryBySql(sql.toString(), new Object[] { schoolYear, time, fitId, classId });
	}

	@Override
	public List findTeacherReport(short schoolYear, byte time, Integer fitId, Integer teacherId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select  ");
		sql.append("        cl.class_name, ");
		sql.append("        fb.feedback_name, ");
		sql.append("        fs.teacher_id, ");
		sql.append("        tch.name, ");
		sql.append("        fs.course_id, ");
		sql.append("        cr.course_name, ");
		sql.append("        fit.fit_id, ");
		sql.append("        fit.fit_name, ");
		sql.append("        fi.fi_id, ");
		sql.append("        fi.fi_name, ");
		sql.append("        fi.item_value, ");
		sql.append("        avg(fs.score) as score ");
		sql.append("   from feedback           fb, ");
		sql.append("        feedback_score     fs, ");
		sql.append("        feedback_item      fi, ");
		sql.append("        feedback_item_type fit, ");
		sql.append("        classes            cl, ");
		sql.append("        users              tch, ");
		sql.append("        course             cr ");
		sql.append("  where fs.feedback_id = fb.feedback_id ");
		sql.append("    and fb.class_id = cl.class_id ");
		sql.append("    and fs.teacher_id = tch.user_id ");
		sql.append("    and fs.course_id = cr.course_id ");
		sql.append("    and fs.fi_id = fi.fi_id ");
		sql.append("    and fi.fit_id = fit.fit_id ");
		sql.append("    and fb.status > 0 ");
		sql.append("    and fb.school_year = ? ");
		sql.append("    and fb.times = ? ");
		sql.append("    and fit.fit_id in (?) ");
		sql.append("    and tch.user_id = ? ");
		sql.append("  group by fb.feedback_id, ");
		sql.append("           cl.class_id, ");
		sql.append("           cl.class_name, ");
		sql.append("           fb.feedback_name, ");
		sql.append("           fb.school_year, ");
		sql.append("           fb.semester, ");
		sql.append("           fb.times, ");
		sql.append("           fs.teacher_id, ");
		sql.append("           tch.name, ");
		sql.append("           fs.course_id, ");
		sql.append("           cr.course_name, ");
		sql.append("           fit.fit_id, ");
		sql.append("           fit.fit_name, ");
		sql.append("           fi.fi_id, ");
		sql.append("           fi.fi_name, ");
		sql.append("           fi.item_value, ");
		sql.append("           fi.disp_order ");
		sql.append("  order by fb.feedback_id, ");
		sql.append("           cl.class_id, ");
		sql.append("           fb.school_year, ");
		sql.append("           fb.semester, ");
		sql.append("           fb.times, ");
		sql.append("           fs.teacher_id, ");
		sql.append("           fs.course_id, ");
		sql.append("           fit.fit_id, ");
		sql.append("           fi.disp_order ");

		return queryBySql(sql.toString(), new Object[] { schoolYear, time, fitId, teacherId });
	}

	@Override
	public List findItemReport() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select fs.fi_id, ");
		sql.append(" ft.fit_id, ");
		sql.append(" ft.item_value, ");
		sql.append(" ft.fi_name, ");
		sql.append(" avg(fs.score) as score, ");
		sql.append(" fit.fit_name ");
		sql.append(" from feedback_score fs, ");
		sql.append(" feedback_item ft, ");
		sql.append(" feedback_item_type fit ");
		sql.append(" where fs.fi_id= ft.fi_id ");
		sql.append("       and fit.fit_id = ft.fit_id");
		sql.append(" group by fs.fi_id, ");
		sql.append("          ft.fit_id, ");
		sql.append("          ft.item_value, ");
		sql.append("          ft.fi_name, ");
		sql.append("          fit.fit_name ");
		sql.append(" order by fs.fi_id, ");
		sql.append("          ft.fit_id, ");
		sql.append("          ft.item_value, ");
		sql.append("          ft.fi_name, ");
		sql.append("          fit.fit_name ");

		return queryBySql(sql.toString());
	}

	@Override
	public List findBaseReport(short schoolYear, byte time, Integer fitId, Integer baseId) {
		StringBuffer sql = new StringBuffer();

		sql.append(" select  ");
		sql.append("        cl.class_name, ");
		sql.append("        fb.feedback_name, ");
		sql.append("        fs.teacher_id, ");
		sql.append("        tch.name, ");
		sql.append("        fs.course_id, ");
		sql.append("        tcb.base_name, ");
		sql.append("        fit.fit_id, ");
		sql.append("        fit.fit_name, ");
		sql.append("        fi.fi_id, ");
		sql.append("        fi.fi_name, ");
		sql.append("        fi.item_value, ");
		sql.append("        avg(fs.score) as score ");
		sql.append("   from feedback           fb, ");
		sql.append("        feedback_score     fs, ");
		sql.append("        feedback_item      fi, ");
		sql.append("        feedback_item_type fit, ");
		sql.append("        classes            cl, ");
		sql.append("        users              tch, ");
		sql.append("        teaching_base      tcb ");
		sql.append("  where fs.feedback_id = fb.feedback_id ");
		sql.append("    and fb.class_id = cl.class_id ");
		sql.append("    and fs.teacher_id = tch.user_id ");
		sql.append("    and cl.base_id = tcb.base_id ");
		sql.append("    and fs.fi_id = fi.fi_id ");
		sql.append("    and fi.fit_id = fit.fit_id ");
		sql.append("    and fb.status > 0 ");
		sql.append("    and fb.school_year = ? ");
		sql.append("    and fb.times = ? ");
		sql.append("    and fit.fit_id in (?) ");
		sql.append("    and tcb.base_id = ?  ");
		sql.append("  group by fb.feedback_id, ");
		sql.append("           cl.class_id, ");
		sql.append("           cl.class_name, ");
		sql.append("           fb.feedback_name, ");
		sql.append("           fb.school_year, ");
		sql.append("           fb.semester, ");
		sql.append("           fb.times, ");
		sql.append("           fs.teacher_id, ");
		sql.append("           tch.name, ");
		sql.append("           fs.course_id, ");
		sql.append(" tcb.base_name, ");
		sql.append("           fit.fit_id, ");
		sql.append("           fit.fit_name, ");
		sql.append("           fi.fi_id, ");
		sql.append("           fi.fi_name, ");
		sql.append("           fi.item_value, ");
		sql.append("           fi.disp_order ");
		sql.append("  order by fb.feedback_id, ");
		sql.append("           cl.class_id, ");
		sql.append("           fb.school_year, ");
		sql.append("           fb.semester, ");
		sql.append("           fb.times, ");
		sql.append("           fs.teacher_id, ");
		sql.append("           fs.course_id, ");
		sql.append("           fit.fit_id, ");
		sql.append("           fi.disp_order ");

		return queryBySql(sql.toString(), new Object[] { schoolYear, time, fitId, baseId });
	}

}
