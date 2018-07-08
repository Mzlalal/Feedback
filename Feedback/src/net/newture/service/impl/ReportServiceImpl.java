package net.newture.service.impl;

import net.newture.dao.BaseDao;
import net.newture.dao.ClassDao;
import net.newture.dao.FeedBackDao;
import net.newture.dao.FeedbackTypeDao;
import net.newture.dao.ReportDao;
import net.newture.dao.UserDao;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl extends ServiceBase implements ReportService {
	@Autowired
	private ReportDao reportDao;
	@Autowired
	private FeedBackDao feedBackDao;
	@Autowired
	private ClassDao classDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private FeedbackTypeDao feedbackTypeDao;
	@Autowired
	private BaseDao baseDao;

	@Override
	public void getClassesTable() {
		Struts2Utils.setAttribute("classes", classDao.findAllClass());
		Struts2Utils.setAttribute("feedbacks", feedBackDao.findFeedbackYear());
		Struts2Utils.setAttribute("type", feedbackTypeDao.findAllType());
	}

	@Override
	public void getTeacherTable() {
		Struts2Utils.setAttribute("teachers", userDao.findAllTeacher());
		Struts2Utils.setAttribute("feedbacks", feedBackDao.findFeedbackYear());
		Struts2Utils.setAttribute("type", feedbackTypeDao.findAllType());
	}

	@Override
	public void getBaseTable() {
		Struts2Utils.setAttribute("bases", baseDao.findAllTeachingBase());
		Struts2Utils.setAttribute("feedbacks", feedBackDao.findFeedbackYear());
		Struts2Utils.setAttribute("type", feedbackTypeDao.findAllType());
	}

	@Override
	public void findClassReport(short schoolYear, byte time, Integer type, Integer classId) {
		Struts2Utils.setAttribute("reports", reportDao.findClassReport(schoolYear, time, type, classId));
	}

	@Override
	public void findTeacherReport(short schoolYear, byte time, Integer type, Integer techerId) {
		Struts2Utils.setAttribute("reports", reportDao.findTeacherReport(schoolYear, time, type, techerId));
	}

	@Override
	public void findItemReport() {
		Struts2Utils.setAttribute("reports", reportDao.findItemReport());
	}

	@Override
	public void findBaseReport(short schoolYear, byte time, Integer type, Integer baseId) {
		// List reports = new ArrayList();
		Struts2Utils.setAttribute("reports", reportDao.findBaseReport(schoolYear, time, type, baseId));
	}
}
