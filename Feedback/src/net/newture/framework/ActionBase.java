package net.newture.framework;

import net.newture.framework.util.Struts2Utils;

import com.opensymphony.xwork2.ActionSupport;

public class ActionBase extends ActionSupport {
	/**
	 * 判断系统是否已经登录
	 * 
	 * @return boolean
	 */
	public boolean isLogined() {
		// 获取用户信息 判断是否存在
		return Struts2Utils.getSession().getAttribute("user") != null;
	}
}
