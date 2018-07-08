package net.newture.action;

import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mzlalal 2018年6月13日 10:51:56
 */
public class ReportAction extends ActionBase {
	private short schoolYear;
	private byte time;
	private Integer type;
	private Integer id;

	@Autowired
	private ReportService reportService;

	// 按照班级查询报表
	public String classCheck() {
		try {
			reportService.getClassesTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "信息初始化出错出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return "class";
	}

	// 按照班级查询报表
	public String classReport() {
		try {
			reportService.findClassReport(schoolYear, time, type, id);
			reportService.getClassesTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "查询班级报表信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return "classReport";
	}

	// 按照教师查询报表
	public String teacherCheck() {
		try {
			reportService.getTeacherTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "信息初始化出错出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return "teacher";
	}

	// 按照班级查询报表
	public String teacherReport() {
		try {
			reportService.findTeacherReport(schoolYear, time, type, id);
			reportService.getTeacherTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "查询教师报表信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return "teacherReport";
	}

	// 按照教师查询报表
	public String baseCheck() {
		try {
			reportService.getBaseTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "信息初始化出错出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return "base";
	}

	// 按照班级查询报表
	public String baseReport() {
		try {
			reportService.findBaseReport(schoolYear, time, type, id);
			reportService.getBaseTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "查询教师报表信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return "baseReport";
	}

	// 按照教师查询报表
	public String itemCheck() {
		reportService.findItemReport();
		reportService.getClassesTable();
		return "item";
	}

	// 属性驱动
	public short getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(short schoolYear) {
		this.schoolYear = schoolYear;
	}

	public byte getTime() {
		return time;
	}

	public void setTime(byte time) {
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
