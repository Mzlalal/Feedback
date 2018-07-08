package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.newture.dao.ClassCourseDao;
import net.newture.dao.ClassDao;
import net.newture.dao.CourseDao;
import net.newture.dao.FeedBackDao;
import net.newture.dao.FeedbackItemDao;
import net.newture.dao.FeedbackTypeDao;
import net.newture.dao.GradeDao;
import net.newture.dao.UserDao;
import net.newture.domain.FeedbackScore;
import net.newture.framework.ServiceBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.GradeService;

@Service
public class GradeServiceImpl extends ServiceBase implements GradeService{
	@Autowired
	private GradeDao gradeDao;
	@Autowired
	private ClassDao classDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private FeedBackDao feedBackDao;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private FeedbackItemDao feedbackItemDao;
	@Autowired
	private FeedbackTypeDao feedbackTypeDao;
	@Autowired
	private ClassCourseDao classCourseDao;
	
	@Override
	public void getScoreTable() {
			// 获取用户角色列表
			List<FeedbackScore> feedbackScores=gradeDao.findAllScore();
			// 保存准备遍历
			Struts2Utils.setAttribute("feedbackScores", feedbackScores);
			
			Struts2Utils.setAttribute("teachers", userDao.findAllTeacher());
			Struts2Utils.setAttribute("feedbacks", feedBackDao.getEndFeedBack());
			Struts2Utils.setAttribute("Course", courseDao.findAll());
			Struts2Utils.setAttribute("classes", classDao.findAllClass());
			Struts2Utils.setAttribute("user", userDao.findAll());
			Struts2Utils.setAttribute("feedbackItem", feedbackItemDao.findAll());
			Struts2Utils.setAttribute("feedbackType", feedbackTypeDao.findAllType());
			Struts2Utils.setAttribute("classCourse", classCourseDao.findAll());
	}
	@Override
	public int updateGrade(FeedbackScore feedbackScore) {
		List<FeedbackScore> objects = findById(feedbackScore.getFsId());
		for (int i = 0; i < objects.size(); i++) {
			feedbackScore.setStudent(objects.get(i).getStudent());
			feedbackScore.setFeedback(objects.get(i).getFeedback());
			feedbackScore.setCourse(objects.get(i). getCourse());
			feedbackScore.setFeedbackItem(objects.get(i).getFeedbackItem());
			feedbackScore.setFsId(objects.get(i).getFsId());
			feedbackScore.setTeacher(objects.get(i).getTeacher());
		}
		this.gradeDao.update(feedbackScore);	
		return 1;
	}
	
	@Override
	public List findById(Long fsId) {
		List feedbackScores = gradeDao.findById(fsId);
		return feedbackScores;
	}
}
