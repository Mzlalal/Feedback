package net.newture.service.impl;

import java.util.List;

import net.newture.dao.FeedbackTypeDao;
import net.newture.domain.FeedbackItemType;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.FeedbackTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackTypeServiceImpl implements FeedbackTypeService {
	@Autowired
	FeedbackTypeDao feedbackTypeDao;

	@Override
	public List<FeedbackItemType> findAllType() {
		return feedbackTypeDao.findAllType();
	}

	@Override
	public int insertFeedbackItemType(FeedbackItemType type) {
		return feedbackTypeDao.insertFeedbackItemType(type);
	}

	@Override
	public int updateFeedbackItemType(FeedbackItemType type) {
		return feedbackTypeDao.updateFeedbackItemType(type);
	}

	@Override
	public FeedbackItemType findByCond(String condName, String condValue) {
		// 处理查询条件
		Object condValueObj = condValue;
		if (condName.equals("fitId")) {
			Integer i;
			try {
				i = Integer.parseInt(condValue);
			} catch (Exception e) {
				Struts2Utils.setAttribute("msg", "查询反馈类别信息失败：输入的反馈类别编号 " + condValue + " 不是正确的数字格式！");
				return null;
			}
			condValueObj = i;
		}
		// 执行查询
		List<FeedbackItemType> list = feedbackTypeDao.findByCond(condName, condValueObj);
		if (list == null || list.size() == 0) {
			Struts2Utils.setAttribute("msg", "查询反馈类别信息失败：没有找到指定的反馈类别");
			return null;
		} else if (list.size() > 1) {
			Struts2Utils.setAttribute("msg", "查询反馈类别信息失败：查找到多个反馈类别");
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public int deleteFeedbackItemType(Integer id) {
		// 根据主键编号查找反馈类别对象
		FeedbackItemType type = feedbackTypeDao.findById(id);
		// 如果根据 id 查找不到则返回 null , get 直接报错呢
		if (type == null) {
			Struts2Utils.setAttribute("msg", "删除反馈类别信息出错：找不到指定反馈类别");
			return -1;
		} else {
			// 删除该对象
			feedbackTypeDao.deleteFeedbackItemType(type);
			return 1;
		}
	}

	@Override
	public FeedbackItemType findTypeById(Integer id) {
		return feedbackTypeDao.findById(id);
	}

	@Override
	public void getTableInfo() {

	}
}
