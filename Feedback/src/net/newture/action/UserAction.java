package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.User;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.UserService;

public class UserAction extends ActionBase {
	private User user;
	private Integer id;
	private String condName;
	private String condValue;

	@Autowired
	private UserService userService;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// 新增用户
	public String add() {
		try {
			// 获取菜单信息 比如 角色权限
			userService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}

		return "add";
	}

	// 修改用户
	public String edit() {
		try {
			// 第一次加载时，根据ID号获取用户信息
			if (user == null) {
				if ((user = userService.findUserById(id)) == null) {
					Struts2Utils.setAttribute("msg", "修改用户信息初始化出错：找不到指定用户");
					return ERROR;
				}
			}
			userService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "修改用户信息初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return "edit";
	}

	// 保存用户
	public String save() {
		// 校验必录信息项
		if (checkFormInput() != 1) {
			return "saveCheckError";
		}
		// 保存用户信息
		try {
			if (userService.saveUser(user) != 1) {
				return "saveCheckError";
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "保存用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "保存用户信息成功！");
		return SUCCESS;
	}

	// 更新用户
	public String update() {
		// 校验必录信息项
		if (checkFormInput() != 1) {
			return "updateCheckError";
		}
		// 保存用户信息
		try {
			if (userService.updateUser(user) != 1) {
				return "updateCheckError";
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "更新用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "更新用户信息成功！");
		return SUCCESS;
	}

	// 删除用户
	public String delete() {
		try {
			if (userService.deleteUser(id) != 1) {
				return ERROR;
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除用户信息成功！");
		return SUCCESS;
	}

	// 批量删除用户
	public String batchDelete() {
		try {
			// 获取 复选框选中状态
			String ids[] = Struts2Utils.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				userService.deleteUser(Integer.parseInt(ids[i]));
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除用户信息成功！");
		return SUCCESS;
	}

	/**
	 * 校验表单录入的信息项<br>
	 * 主要是校验必录信息项
	 *
	 * @return 1：成功 -1：失败
	 */
	private int checkFormInput() {
		if (user.getLoginName() == null || user.getLoginName().trim().equals("")) {
			Struts2Utils.setAttribute("msg1", "用户名不能为空！");
			return -1;
		}
		if (user.getPassword() == null || user.getPassword().equals("")) {
			Struts2Utils.setAttribute("msg2", "密码不能为空!");
			return -1;
		}
		return 1;
	}

	// 查询所有用户 返回
	public String query() {
		try {
			userService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg",
					"初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}

		return "query";
	}

	public String queryByCond() {
		try {
			if (condValue == null || condValue.trim().equals("")) {
				Struts2Utils.setAttribute("msg", "必须输入查询条件值！");
				return "queryCheckError";
			}
			user = userService.findByCond(condName, condValue);
			userService.getCodeTable();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg",
					"查询用户信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		if (user == null) {
			return ERROR;
		} else {
			return "query";
		}
	}
	/**
	 * 系统登录
	 *
	 * @return
	 */
	public String login() {
		if (isLogined()) {
			return "logined";
		} else {
			return SUCCESS;
		}
	}

	/**
	 * 查找拥户角色列表
	 */
	public String list(){
		userService.findAllUser();
		return "list";
	}

	/**
	 * 系统注销
	 *
	 * @return
	 */
	public String logout() {
		if (isLogined()) {
			Struts2Utils.getSession().removeAttribute("user");
			return "logout";
		} else {
			return SUCCESS;
		}
	}
	/**
	 * 修改密碼界面
	 */
	public String updatePwd(){
        Struts2Utils.setAttribute("userId", id);
		return "updatePwd";
	}
	/**
	 * 修改密碼
	 */
	public String updatePwding(){
		int userId = Integer.parseInt(Struts2Utils.getParameter("uId"));
		if(userService.updateing(userId)==1){
			Struts2Utils.setAttribute("msg", "修改成功！");
			return SUCCESS;
		}else{
			Struts2Utils.setAttribute("msg", "您输入的旧密码不正确！,修改失败");
			return ERROR;
		}
	}
	/**
	 * 用户登录校验
	 *
	 * @return
	 */
	public String loginCheck() {
		String code = Struts2Utils.getParameter("code") == null ? "" : Struts2Utils.getParameter("code");
		String rand = (String) Struts2Utils.getSession().getAttribute("rand");
		if (user.getLoginName() == null || user.getLoginName().trim().equals("")) {
			Struts2Utils.setAttribute("msg", "用户名不能为空！");
			return ERROR;
		}
		if (user.getPassword() == null || user.getPassword().equals("")) {
			Struts2Utils.setAttribute("msg", "密码不能为空!");
			return ERROR;
		}
		if (code.equals(rand)) {
			if (userService.isValidLoginUser(user)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} else {
			Struts2Utils.setAttribute("msg", "验证码有误!");
			return ERROR;
		}
	}

	public String getCondName() {
		return condName;
	}

	public void setCondName(String condName) {
		this.condName = condName;
	}

	public String getCondValue() {
		return condValue;
	}

	public void setCondValue(String condValue) {
		this.condValue = condValue;
	}
}
