package net.newture.action;

import net.newture.domain.FeedbackItemType;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.FeedbackTypeService;

import org.springframework.beans.factory.annotation.Autowired;

public class FeedbackItemTypeAction extends ActionBase {
	private FeedbackItemType type;
	private Integer id;
	private String condName;
	private String condValue;

	@Autowired
	private FeedbackTypeService feedbackTypeService;

	/**
	 * 查看所有反馈类别
	 *
	 * @return
	 */
	public String list() {
		if (feedbackTypeService.findAllType() != null) {
			Struts2Utils.setAttribute("types", feedbackTypeService.findAllType());
			feedbackTypeService.getTableInfo();
			return "list";
		} else {
			return ERROR;
		}
	}

	/**
	 * 保存反馈类别
	 *
	 * @return
	 */
	public String save() {
		// 校验必录信息项
		if (type.getFitName() == null || type.getFitName().trim().equals("")) {
			Struts2Utils.setAttribute("msg", "角色名不能为空！");
			return ERROR;
		}
		// 保存角色信息
		try {
			if (feedbackTypeService.insertFeedbackItemType(type) != 1) {
				return ERROR;
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "保存反馈类别信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "保存反馈类别信息成功！");
		return SUCCESS;
	}

	/**
	 * 删除反馈类别
	 *
	 * @return
	 */
	public String delete() {
		try {
			feedbackTypeService.deleteFeedbackItemType(type.getFitId());
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除反馈类别信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除反馈类别信息成功！");
		return SUCCESS;
	}

	// 批量删除反馈类别
	public String batchDelete() {
		try {
			// 获取 复选框选中状态
			String ids[] = Struts2Utils.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				feedbackTypeService.deleteFeedbackItemType(Integer.parseInt(ids[i]));
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除反馈类别信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除反馈类别信息成功！");
		return SUCCESS;
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
			type = feedbackTypeService.findByCond(condName, condValue);
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "查询用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		if (type == null) {
			return ERROR;
		} else {
			return "query";
		}
	}

	// 属性驱动

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public FeedbackItemType getType() {
		return type;
	}

	public void setType(FeedbackItemType type) {
		this.type = type;
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
