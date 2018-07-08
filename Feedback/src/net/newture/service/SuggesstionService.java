package net.newture.service;

import java.util.List;

import net.newture.domain.Suggestion;

/**
 *
 * @author HELIN 2018年6月13日 10:51:22
 */
public interface SuggesstionService {
	/**
	 * 查询所有建议
	 *
	 * @return List<Suggestion>
	 */
	public List<Suggestion> findAllSuggestion();

	/**
	 * 插入建议
	 *
	 * @param Suggestion
	 * @return flag 失败:-1 成功:1
	 */
	public int insertSuggestion(Suggestion suggestion);

	/**
	 * 修改建议
	 *
	 * @param Suggesstion
	 * @return flag 失败:-1 成功:1
	 */
	public int updateSuggestion(Suggestion suggestion);

	/**
	 * 删除建议
	 *
	 * @param Suggestion
	 * @return flag 失败:-1 成功:1
	 */
	public int deleteSuggestion(Long id);

	/**
	 * 通过id查找建议
	 * @param id
	 * @return
	 */
	public Suggestion findSuggestionById(Long id);
	
	/**
	 * 获取用户代码表信息（如角色列表、部门列表等）
	 */
	public void getCodeTable();
}
