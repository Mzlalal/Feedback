package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.FeedbackScore;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.GradeService;

public class GradeAction extends ActionBase{
	private FeedbackScore feedbackScore;
	private Long id;

	@Autowired
	private GradeService gradeService;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FeedbackScore getFeedbackScore() {
		return feedbackScore;
	}

	public void setFeedbackScore(FeedbackScore feedbackScore) {
		this.feedbackScore = feedbackScore;
	}

	/**
	 * 遍历评分信息
	 * @return
	 */
	public String manage() {
		try {
			gradeService.getScoreTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "查找评分失败<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return "manage";
	}
	
	/**
	 * 更新评分
	 *
	 * @return
	 */
	public String update() {
		try {
			if (gradeService.updateGrade(feedbackScore) != 1) 
				return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			Struts2Utils.setAttribute("msg", "更新评分信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "更新评分信息成功！");
		return SUCCESS;
	}
	
	public String add() {
		gradeService.getScoreTable();
		return "add";
	}
	
	public String grade() {
		try {
			gradeService.getScoreTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "查找信息失败<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return "grade";
	}
}

