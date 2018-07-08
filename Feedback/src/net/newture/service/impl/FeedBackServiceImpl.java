package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.FeedBackDao;
import net.newture.domain.Feedback;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.FeedBackService;

@Service
public class FeedBackServiceImpl extends ServiceBase implements FeedBackService {
	@Autowired
	private FeedBackDao feedbackDao;

	@Override
	public void getFeedBack() {
		List<Object> list = feedbackDao.getFeedBack();
		Struts2Utils.setAttribute("list", list);
	}

	@Override
	@Transactional
	public int startfeedback(Feedback feedback) {
		if(feedback==null){
			return -1;
		}else{
		this.feedbackDao.startfeedback(feedback);
		return 1;
		}
	}

	@Override
	@Transactional
	public void deleteFeedBack(Feedback feedback) {
		this.feedbackDao.delete(feedback);
		Struts2Utils.setAttribute("msg", "删除反馈批次成功！");
	}

	@Override
	@Transactional
	public int deleteFeedBack(Long id) {
		Feedback feedback = feedbackDao.findById(id);
		if (feedback==null) {
			Struts2Utils.setAttribute("msg", "删除信息出错：找不到指定的反馈批次！");
			return -1;
		}else {
			feedbackDao.delete(feedback);
			return 1;
		}
	}

	@Override
	public Feedback findbyid(Long id) {
		return this.feedbackDao.findById(id);
	}

	@Override
	public int updatefeedback(Feedback feedback) {
			this.feedbackDao.update(feedback);
			return 1;
	}

	@Override
	public void getEndFeedBack() {
		List<Object> list = feedbackDao.getEndFeedBack();
		Struts2Utils.setAttribute("list", list);
		
	}

}
