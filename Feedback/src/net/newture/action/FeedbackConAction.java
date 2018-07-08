package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Suggestion;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.SuggesstionService;

/**
 *
 * @author HELIN 2018年6月22日 13:05:50
 */
public class FeedbackConAction extends ActionBase {
	private Suggestion suggestion;
	private Long id;

	public Suggestion getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	@Autowired
	private SuggesstionService sService;

	// 查看所有建议
	public String findAllSuggestion() {
		if (sService.findAllSuggestion() != null) {
			Struts2Utils.getSession().setAttribute("suggestion",
					sService.findAllSuggestion());
			sService.getCodeTable();
			return "findAll";
		} else {
			return ERROR;
		}
	}

	// 添加
	public String insert() {
		// 添加建议
		try {
			if (sService.insertSuggestion(suggestion) == 1) {
				Struts2Utils.setAttribute("msg", "添加建议成功");
			}
		} catch (Exception e) {
			Struts2Utils
					.setAttribute("msg",
							"添加建议失败<br/>"
									+ (e.getCause() != null ? (e.getCause()
											.getCause() != null ? e.getCause()
											.getCause() : "") : ""));
			return ERROR;
		}
		return SUCCESS;
	}

	// 修改建议
	public String update() {
		try {
			if (sService.updateSuggestion(suggestion) == 1) {
				Struts2Utils.setAttribute("msg", "修改建议成功");
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg","修改建议失败<br/>"
									+ (e.getCause() != null ? (e.getCause()
											.getCause() != null ? e.getCause()
											.getCause() : "") : ""));
					return ERROR;
		}
		return SUCCESS;
	}
	//跳转至修改页面
	public String toupdate(){
		return "update";
	}

	// 删除建议
	public String delete() {
		try {
			if (sService.deleteSuggestion(id) == 1) {
				Struts2Utils.setAttribute("msg", "删除建议	成功");
			}
		} catch (Exception e) {
			Struts2Utils
					.setAttribute("msg",
							"删除建议失败<br/>"
									+ (e.getCause() != null ? (e.getCause()
											.getCause() != null ? e.getCause()
											.getCause() : "") : ""));
			return ERROR;
		}
		return SUCCESS;
	}

	// 批量删除建议
	public String batchDelete() {
		try {
			// 获取 复选框选中状态
			String ids[] = Struts2Utils.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				sService.deleteSuggestion(Long.parseLong(ids[i]));
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute(
							"msg",
							"删除建议出错："
									+ "<br/>"
									+ (e.getMessage() != null ? e.getMessage()
											: "")
									+ "<br/>"
									+ (e.getCause() != null ? (e.getCause()
											.getCause() != null ? e.getCause()
											.getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除建议成功！");
		return SUCCESS;
	}

	// 跳转 insert 添加页面
	public String suggesstion() {
		if (id != null) {
			// 保存建议信息
			Struts2Utils.setAttribute("suggestion",
					sService.findSuggestionById(id));
		}
		sService.getCodeTable();
		return "suggesstion";
	}
}
