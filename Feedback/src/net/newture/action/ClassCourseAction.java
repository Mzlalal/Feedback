package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.ClassCourse;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.ClassCourseService;

/**
 *
 * @author Mzlalal 2018年6月13日 10:51:56
 */
public class ClassCourseAction extends ActionBase {
	private ClassCourse classCourse;
	private Integer id;
	private String condName;
	private String condValue;

	@Autowired
	private ClassCourseService classCourseService;

	// 查看所有班级课程
	public String findAllClassCourse() {
		try {
			classCourseService.findAllClassCourse();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "查找班级课程失败<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return "list";
	}

	// 添加/修改班级课程获取菜单信息
	public String insert() {
		// 获取菜单信息
		try {
			classCourseService.getTableInfo();
			if (id != null) {
				Struts2Utils.setAttribute("classCourse", classCourseService.findClassCourseById(id));
			}

		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return "insert";
	}

	// 添加班级课程
	public String update() {
		// 传过来类型为 null 的时候为添加班级课程
		if (!"1".equals(Struts2Utils.getParameter("type"))) {
			if (classCourseService.save(classCourse) != 1) {
				Struts2Utils.setAttribute("msg", "添加班级课程失败!");
				return ERROR;
			}
			Struts2Utils.setAttribute("msg", "添加课程课程成功!");
		} else {
			// 传过来类型为 1 的时候为修改班级课程
			if (classCourseService.update(classCourse) != 1) {
				Struts2Utils.setAttribute("msg", "修改班级课程失败!");
				return ERROR;
			}
			Struts2Utils.setAttribute("msg", "修改班级课程成功!");
		}
		return SUCCESS;
	}

	// 删除课程
	public String delete() {
		if (classCourseService.deleteClassCourse(id) != 1) {
			Struts2Utils.setAttribute("msg", "删除班级课程失败!");
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除班级课程成功!");
		return SUCCESS;
	}
	public String query() {
		return "query";
	}

	public String queryByCond() {
		try {
			if (condValue == null || condValue.trim().equals("")) {
				Struts2Utils.setAttribute("msg", "必须输入查询条件值！");
				return "queryCheckError";
			}
			classCourseService.findByCond(condName, condValue);
			classCourseService.getTableInfo();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg",
					"查询班级课程信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		return "query";
	}

	// 批量删除用户
	public String batchDelete() {
		try {
			// 获取 复选框选中状态
			String ids[] = Struts2Utils.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				classCourseService.deleteClassCourse(Integer.parseInt(ids[i]));
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除班级课程信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除班级课程信息成功！");
		return SUCCESS;
	}

	// 属性驱动
	public ClassCourse getClassCourse() {
		return classCourse;
	}

	public void setClassCourse(ClassCourse classCourse) {
		this.classCourse = classCourse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCondName() {
		return condName;
	}

	public void setCondName(String condName) {
		this.condName = condName;
	}

	public String getCondValue() {
		return condValue;
	}

	public void setCondValue(String condValue) {
		this.condValue = condValue;
	}

}
