package net.newture.action;

import net.newture.domain.FeedbackItem;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.FeedbackItemService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mzlalal 2018年6月13日 10:51:50
 */
public class ItemAction extends ActionBase {
	private FeedbackItem feedbackItem;
	private Integer id;
	private String condName;
	private String condValue;

	@Autowired
	private FeedbackItemService feedbackItemService;

	// 查看所有班级反馈条目
	public String findAllFeedbackItem() {
		if (feedbackItemService.findAllFeedbackItem() != null) {
			Struts2Utils.setAttribute("feedbackItem", feedbackItemService.findAllFeedbackItem());
			return "findAll";
		} else {
			return ERROR;
		}
	}

	// 保存指标
	public String save() {
		try {
			if (feedbackItemService.insertFeedbackItem(feedbackItem) == 1) {
				Struts2Utils.setAttribute("msg", "添加反馈条目:	" + feedbackItem.getFiName() + "	成功");
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "插入反馈条目:" + feedbackItem.getFiName() + "失败<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return SUCCESS;
	}

	// 添加/修改班级
	public String update() {
		// 添加班级
		System.out.println(feedbackItem);

		try {
			if (feedbackItemService.updateFeedbackItem(feedbackItem) == 1) {
				Struts2Utils.setAttribute("msg", "修改反馈条目:	" + feedbackItem.getFiName() + "	成功");
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "修改反馈条目:" + feedbackItem.getFiName() + "失败<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return SUCCESS;
	}

	// 删除反馈条目
	public String delete() {
		try {
			if (feedbackItemService.deleteFeedbackItem(id) == 1) {
				Struts2Utils.setAttribute("msg", "删除反馈条目: " + id + "	成功");
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除反馈条目:	" + id + "	失败<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return SUCCESS;
	}

	// 批量删除反馈条目
	public String batchDelete() {
		try {
			// 获取 复选框选中状态
			String ids[] = Struts2Utils.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				feedbackItemService.deleteFeedbackItem(Integer.parseInt(ids[i]));
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除反馈条目信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除反馈条目信息成功！");
		return SUCCESS;
	}

	// 跳转 insert 添加页面
	public String modify() {
		// 保存反馈条目信息
		Struts2Utils.setAttribute("feedbackItem", feedbackItemService.findFeedbackItemById(id));
		return "modify";
	}

	// 跳转 insert 添加页面
	public String insert() {
		return "insert";
	}

	// 查询反馈条目跳转
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
			feedbackItem = feedbackItemService.findByCond(condName, condValue);
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "查询反馈条目信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		if (feedbackItem == null) {
			return ERROR;
		} else {
			return "query";
		}
	}

	// 属性驱动
	public FeedbackItem getFeedbackItem() {
		return feedbackItem;
	}

	public void setFeedbackItem(FeedbackItem feedbackItem) {
		this.feedbackItem = feedbackItem;
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
