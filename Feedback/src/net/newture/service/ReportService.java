package net.newture.service;


/**
 * 报表服务层
 *
 * @author Mzlalal
 *
 */
public interface ReportService {

	/**
	 * 查询班级反馈
	 *
	 * @return
	 */
	public void findClassReport(short schoolYear, byte time, Integer type, Integer classId);

	/**
	 * 查询班级反馈
	 *
	 * @return
	 */
	public void findTeacherReport(short schoolYear, byte time, Integer type, Integer techerId);

	/**
	 * 查询班级列表
	 */
	public void getClassesTable();

	/**
	 * 查询教师列表
	 */
	public void getTeacherTable();

	/**
	 * 查询基地列表
	 */
	public void getBaseTable();

	/**
	 * 查询指标反馈
	 *
	 * @return
	 */
	public void findItemReport();

	/**
	 * 查询基地报表
	 *
	 * @return
	 */
	public void findBaseReport(short schoolYear, byte time, Integer type, Integer baseId);
}
