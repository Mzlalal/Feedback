package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Course;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.CourseService;

/**
 *
 * @author Mzlalal 2018年6月13日 10:51:50
 */
public class CourseAction extends ActionBase {
	private Course course;
	private Integer id;
	private String condName;
	private String condValue;

	@Autowired
	private CourseService courseService;

	// 查看所有班级课程
	public String findAllCourse() {
		if (courseService.findAllCourse() != null) {
			Struts2Utils.getSession().setAttribute("course", courseService.findAllCourse());
			return "findAll";
		} else {
			return ERROR;
		}
	}

	// 添加/修改班级
	public String update() {
		// 添加班级
		if (("1").equals(Struts2Utils.getParameter("type"))) {
			try {
				if (courseService.insertCourse(course) == 1) {
					Struts2Utils.setAttribute("msg", "添加课程:	" + course.getCourseName() + "	成功");
				}
			} catch (Exception e) {
				Struts2Utils.setAttribute("msg",
						"插入课程:" + course.getCourseName() + "失败<br/>"
								+ (e.getCause() != null
								? (e.getCause().getCause() != null ? e.getCause().getCause() : ""): ""));
				return ERROR;
			}
		} else {
			try {
				if (courseService.updateCourse(course) == 1) {
					Struts2Utils.setAttribute("msg", "修改课程:	" + course.getCourseName() + "	成功");
				}
			} catch (Exception e) {
				Struts2Utils.setAttribute("msg",
						"修改课程:" + course.getCourseName() + "失败<br/>"
								+ (e.getCause() != null? (e.getCause().getCause() != null ? e.getCause().getCause() : ""): ""));
				return ERROR;
			}
		}
		return SUCCESS;
	}

	// 删除课程
	public String delete() {
		try {
			if (courseService.deleteCourse(id) == 1) {
				Struts2Utils.setAttribute("msg", "删除课程: " + id + "	成功");
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除课程:	" + id + "	失败<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return SUCCESS;
	}

	// 批量删除课程
	public String batchDelete() {
		try {
			// 获取 复选框选中状态
			String ids[] = Struts2Utils.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				courseService.deleteCourse(Integer.parseInt(ids[i]));
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除课程信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除课程信息成功！");
		return SUCCESS;
	}

	// 跳转 insert 添加页面
	public String insert() {
		if (id != null) {
			// 保存课程信息
			Struts2Utils.setAttribute("course",courseService.findCourseById(id));
		}
		return "insert";
	}


	// 查询课程跳转
	public String query() {
		return "query";
	}

	// 条件查询
	public String queryByCond() {
		try {
			if (condValue == null || condValue.trim().equals("")) {
				Struts2Utils.setAttribute("msg", "必须输入查询条件值！");
				return "queryCheckError";
			}
			course = courseService.findByCond(condName, condValue);
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg",
					"查询课程信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		if (course == null) {
			return ERROR;
		} else {
			return "query";
		}
	}

	// 属性驱动
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
