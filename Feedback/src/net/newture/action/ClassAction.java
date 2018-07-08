package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Class;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.ClassService;

public class ClassAction extends ActionBase {
	private Class classes;
	private Integer id;
	private String className;
	private String classValue;
	@Autowired
	private ClassService classService;

	public String findAllClass() {
		if (classService.findAllClass() != null) {
			System.out.println("保存classes");
			Struts2Utils.getSession().setAttribute("classes", classService.findAllClass());
			classService.getTableInfo();
			return "findAll";
		} else {
			return ERROR;
		}
	}

	public String update() {
		if (("1").equals(Struts2Utils.getParameter("type"))) {
			try {
				if (classService.insertClass(classes) == 1) {
					Struts2Utils.setAttribute("msg", "添加班级:	" + classes.getClassName() + "	成功");
				}
			} catch (Exception e) {
				Struts2Utils.setAttribute("msg",
						"插入班级:"
								+ classes.getClassName()
								+ "失败<br/>"
								+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause()
										: "") : ""));
				return ERROR;
			}
		} else {
			try {
				if (classService.updateClass(classes) == 1) {
					Struts2Utils.setAttribute("msg", "修改班级:	" + classes.getClassName() + "	成功");
				}
			} catch (Exception e) {
				Struts2Utils.setAttribute("msg",
						"修改班级:"
								+ classes.getClassName()
								+ "失败<br/>"
								+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause()
										: "") : ""));
				return ERROR;
			}
		}
		return SUCCESS;
	}

	// 删除班级
	public String delete() {
		String className = classService.findClassById(id).getClassName();
		try {
			if (classService.deleteClass(id) == 1) {
				Struts2Utils.setAttribute("msg", "删除班级: " + className + "	成功");
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除班级:	" + className + "	失败<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return SUCCESS;
	}

	// 批量删除班级
	public String batchDelete() {
		try {
			// 获取 复选框选中状态
			String ids[] = Struts2Utils.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				classService.deleteClass(Integer.parseInt(ids[i]));
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除班级信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除班级信息成功！");
		return SUCCESS;
	}

	// 跳转 insert 添加页面
	public String insert() {
		if (id != null) {
			// 保存班级信息
			Struts2Utils.setAttribute("classes", classService.findClassById(id));
		}
		classService.getTableInfo();
		return "insert";
	}

	// 查询课程跳转
	public String query() {
		return "query";
	}

	// 条件查询
	public String queryByCond() {
		try {
			if (classValue == null || classValue.trim().equals("")) {
				Struts2Utils.setAttribute("msg", "必须输入查询条件值！");
				return "queryCheckError";
			}
			classes = classService.findByCond(className, classValue);
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg",
					"查询用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		if (classes == null) {
			return ERROR;
		} else {
			return "query";
		}
	}

	// 属性驱动

	public Class getClasses() {
		return classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassValue() {
		return classValue;
	}

	public void setClassValue(String classValue) {
		this.classValue = classValue;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
