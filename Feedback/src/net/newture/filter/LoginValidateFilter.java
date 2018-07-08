package net.newture.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.newture.domain.User;
import net.newture.framework.util.WebUtil;

/**
 * 登录校验,未登录不允许进入系统
 */
public class LoginValidateFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException,
			ServletException {
		// 获取 request
		HttpServletRequest request = (HttpServletRequest) req;
		// 获取 user 对象
		User user = WebUtil.getUser(request);
		// 获取访问 uri
		String requestUri = WebUtil.getRequestURI(request);
		// 如果 user 为空, 不是以feedback/login开头 ,不是进入验证码的页面,不是进入资源目录的uri
		// 则重定向至登陆页面
		if (user == null && !requestUri.startsWith("/Feedback/login")
				&& !requestUri.equals("/Feedback/pages/util/rand.jsp") && !requestUri.startsWith("/Feedback/resource")) {
			// 获取响应对象response
			HttpServletResponse response = (HttpServletResponse) res;
			// 获取上下文路径
			String ctp = request.getSession().getServletContext().getContextPath();
			// 重定至登陆页面
			response.sendRedirect(ctp + "/login");
			return;
		}
		filterChain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
