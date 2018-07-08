package net.newture.service.impl;

import java.util.List;

import net.newture.dao.FeedbackItemDao;
import net.newture.domain.FeedbackItem;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.FeedbackItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mzlalal 2018年6月13日 10:52:31
 */
@Service
public class FeedbackItemServiceImpl implements FeedbackItemService {
	@Autowired
	private FeedbackItemDao itemDao;

	@Override
	public List<FeedbackItem> findAllFeedbackItem() {
		return itemDao.findAll();
	}

	@Override
	@Transactional
	public int insertFeedbackItem(FeedbackItem course) {
		return itemDao.insertFeedbackItem(course);
	}

	@Override
	@Transactional
	public int updateFeedbackItem(FeedbackItem course) {
		return itemDao.updateFeedbackItem(course);
	}

	@Override
	@Transactional
	public int deleteFeedbackItem(Integer id) {
		// 根据主键编号查找反馈条目对象
		FeedbackItem course = itemDao.findById(id);
		// 如果根据 id 查找不到则返回 null , get 直接报错呢
		if (course == null) {
			Struts2Utils.setAttribute("msg", "删除反馈条目信息出错：找不到指定反馈条目");
			return -1;
		} else {
			// 删除该对象
			itemDao.deleteFeedbackItem(course);
			return 1;
		}
	}

	@Override
	public FeedbackItem findFeedbackItemById(Integer id) {
		return itemDao.findById(id);
	}

	@Override
	public FeedbackItem findByCond(String condName, String condValue) {
		// 处理查询条件
		Object condValueObj = condValue;
		if (condName.equals("fiId")) {
			Integer i;
			try {
				i = Integer.parseInt(condValue);
			} catch (Exception e) {
				Struts2Utils.setAttribute("msg", "查询反馈条目信息失败：输入的反馈条目编号 " + condValue + " 不是正确的数字格式！");
				return null;
			}
			condValueObj = i;
		}
		// 执行查询
		List<FeedbackItem> list = itemDao.findByCond(condName, condValueObj);
		if (list == null || list.size() == 0) {
			Struts2Utils.setAttribute("msg", "查询反馈条目信息失败：没有找到指定的反馈条目");
			return null;
		} else if (list.size() > 1) {
			Struts2Utils.setAttribute("msg", "查询反馈条目信息失败：查找到多个反馈条目");
			return null;
		} else {
			return list.get(0);
		}
	}

}
