package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Feedback;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.FeedBackService;

public class FeedBackAction extends ActionBase {
	private Feedback feedback;
	private Long id;

	@Autowired
	private FeedBackService feedBackService;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	/**
	 * 获取反馈批次信息
	 *
	 * @return
	 */
	public String query() {
		feedBackService.getFeedBack();
		return "query";
	}

	/**
	 * 开启反馈批次
	 */
	public String start() {
		return "start";
	}

	public String save() {
		try {
			if (feedBackService.startfeedback(feedback) != 1) {
				return "saveError";
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "开启反馈出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "开启反馈成功！");
		return SUCCESS;
	}

	/**
	 * 删除反馈批次
	 *
	 * @return
	 */
	public String delete() {
		try {
			if (feedBackService.deleteFeedBack(id) != 1) {
				return ERROR;
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除反馈批次出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除反馈批次成功！");
		return SUCCESS;
	}

	/**
	 * 批量删除
	 *
	 * @return
	 */
	public String batchDelete() {
		try {
			// 获取 复选框选中状态
			String ids[] = Struts2Utils.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				feedBackService.deleteFeedBack(Long.parseLong(ids[i]));
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除反馈批次出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除反馈批次成功！");
		return SUCCESS;
	}

	/**
	 * 更新反馈批次
	 *
	 * return
	 */
	public String update() {
		try {
			// 第一次加载时，根据ID号获取反馈信息
			if (feedback == null) {
				if ((feedback = feedBackService.findbyid(id)) == null) {
					Struts2Utils.setAttribute("msg", "修改反馈信息初始化出错：找不到指定反馈批次");
					return ERROR;
				}
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "修改反馈信息初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return "edit";
	}

	public String updatefd() {
		try {
			if (feedBackService.updatefeedback(feedback) != 1) {
				return ERROR;
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "修改反馈出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "修改反馈成功！");
		feedBackService.updatefeedback(feedback);
		return "update";
	}

	/**
	 * 获取结束反馈批次信息
	 *
	 * @return
	 */
	public String end() {
		feedBackService.getEndFeedBack();
		return "end";
	}

	public String endstatus() {

		feedback = feedBackService.findbyid(id);
		feedback.setFeedbackId(id);
		feedback.setStatus(Byte.parseByte("3"));
		feedBackService.updatefeedback(feedback);
		Struts2Utils.setAttribute("msg", "结束反馈成功！");
		return "endstatus";

	}
}
