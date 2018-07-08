package net.newture.dao;

import java.util.List;

/**
 * 报表数据库类
 *
 * @author Mzlalal 2018年6月13日 10:51:40
 */
public interface ReportDao {

	/**
	 * 查询班级反馈
	 *
	 * @return
	 */
	public List findClassReport(short schoolYear, byte time, Integer fitId, Integer className);

	/**
	 * 查询教师反馈
	 *
	 * @return
	 */
	public List findTeacherReport(short schoolYear, byte time, Integer fitId, Integer teacherId);

	/**
	 * 查询指标反馈
	 *
	 * @return
	 */
	public List findItemReport();

	/**
	 * 查询基地报表
	 *
	 * @return
	 */
	public List findBaseReport(short schoolYear, byte time, Integer fitId, Integer baseId);

}
