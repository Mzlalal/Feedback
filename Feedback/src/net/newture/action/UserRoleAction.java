package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Role;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.UserRoleService;

public class UserRoleAction extends ActionBase{
	private Role role;
	private int rId;
	private int uId;
	
	@Autowired
	private UserRoleService userRoleService;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	/**
	 * 查找拥户角色列表
	 */
	public String list(){
		userRoleService.findAllUserRole();
		return "list";
	}
	
	/**
	 * 修改用户角色前初始化界面
	 */
	public String updating(){
		try {
				if ((userRoleService.findRoleById(rId)) == null) {
					Struts2Utils.setAttribute("msg", "修改用户角色信息初始化出错：找不到指定用户或角色");
					return ERROR;
				}
				if ((userRoleService.findUserById(uId)) == null) {
					Struts2Utils.setAttribute("msg", "修改用户角色信息初始化出错：找不到指定用户或角色");
					return ERROR;
				}
				userRoleService.findAllRole();
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "修改用户角色信息初始化出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return "updating";
	}
	
	/**
	 * 修改用户
	 */
	public String update(){
		try {
			Integer userId = Integer.valueOf(Struts2Utils.getParameter("userId"));
			Integer roleId = Integer.valueOf(Struts2Utils.getParameter("role.roleName"));
			System.out.println("获取的userId为" +userId);
			System.out.println("获取的userId为" +roleId);
			if (userRoleService.updateUserRole(userId, roleId)==1) {
				Struts2Utils.setAttribute("msg", "修改成功");
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "修改失败<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return SUCCESS;
	}
}
