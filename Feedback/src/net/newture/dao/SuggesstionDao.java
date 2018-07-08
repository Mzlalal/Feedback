package net.newture.dao;

import java.util.List;

import net.newture.domain.Suggestion;
import net.newture.domain.User;


public interface SuggesstionDao {
	/**
	 * 查询所有建议
	 *
	 * @return list<Class>
	 */
	public List<Suggestion> findAllSuggestion();
	
	/**
	 * 添加建议
	 *
	 * @param Suggestion
	 * @return flag 失败:-1 成功:1
	 */
	public int insertSuggestion(Suggestion suggestion);

	/**
	 * 修改建议
	 *
	 * @param Suggestion
	 * @return flag 失败:-1 成功:1
	 */
	public int updateSuggestion(Suggestion suggestion);

	/**
	 * 删除建议
	 *
	 * @param Suggestion
	 * @return flag 失败:-1 成功:1
	 */
	public int deleteSuggestion(Suggestion suggestion);

	/**
	 * 查找建议
	 * 
	 * @param id
	 * @return
	 */
	public Suggestion findById(Long id);
	
	/**
	 * 查询所有教师
	 *
	 * @return
	 */
	public List<User> findAllTeacher();
	
	/**
	 * 查询所有学生
	 *
	 * @return
	 */
	public List<User> findAllStudent();
	
	/**
	 * 查询所有反馈批次信息
	 * @return List
	 */
	public List<Object> getFeedBack();
}
