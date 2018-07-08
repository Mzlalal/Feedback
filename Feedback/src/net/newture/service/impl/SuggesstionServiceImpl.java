package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.SuggesstionDao;
import net.newture.domain.Role;
import net.newture.domain.Suggestion;
import net.newture.domain.User;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.SuggesstionService;

/**
 *
 * @author HELIN 2018-6-22-14：58
 */
@Service
public class SuggesstionServiceImpl implements SuggesstionService {
	@Autowired
	private SuggesstionDao suggesstionDao;

	@Override
	public List<Suggestion> findAllSuggestion() {
		return suggesstionDao.findAllSuggestion();
	}

	@Override
	@Transactional
	public int insertSuggestion(Suggestion suggestion) {
		return suggesstionDao.insertSuggestion(suggestion);
	}

	@Override
	@Transactional
	public int updateSuggestion(Suggestion suggestion) {
		return suggesstionDao.updateSuggestion(suggestion);
	}

	@Override
	@Transactional
	public int deleteSuggestion(Long id) {
		// 根据主键编号查找对象
		Suggestion suggestion = suggesstionDao.findById(id);
		// 如果根据 id 查找不到则返回-1
		if (suggestion == null) {
			Struts2Utils.setAttribute("msg", "删除建议出错：找不到指定建议");
			return -1;
		} else {
			// 删除该对象
			return suggesstionDao.deleteSuggestion(suggestion);
		}
	}

	@Override
	public Suggestion findSuggestionById(Long id) {
		return suggesstionDao.findById(id);
	}

	@Override
	public void getCodeTable() {
		List<User> list = suggesstionDao.findAllTeacher();
		Struts2Utils.setAttribute("teacher", list);
		
		List<User> list2 = suggesstionDao.findAllStudent();
		Struts2Utils.setAttribute("student", list2);
		
		List<Object> list3 = suggesstionDao.getFeedBack();
		Struts2Utils.setAttribute("feedback", list3);
		
	}

}
