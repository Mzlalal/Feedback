package net.newture.framework;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.components.If;

import net.newture.domain.User;
import net.newture.framework.util.Struts2Utils;
import net.newture.framework.util.WebUtil;

public class ServiceBase {
	/**
	 * 获取当前登录用户信息
	 * @return User对象
	 */
	public User getLoginUser() {
		HttpServletRequest request = Struts2Utils.getRequest();
		return WebUtil.getUser(request);
	}
}
