package com.hiyond.interceptor;

import com.hiyond.common.constant.Constant;
import com.hiyond.common.cookies.CookieUtils;
import com.hiyond.common.redis.RedisUtils;
import com.hiyond.entity.User;
import com.hiyond.redis.RedisCookieKey;
import com.hiyond.session.SessionUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义用户登录拦截器
 * 
 * @author Hiyond
 *
 */
public class ConstantInterceptor implements HandlerInterceptor {

	private Logger logger = Logger.getLogger(ConstantInterceptor.class);


	/**
	 * 执行完handler之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
	}

	/**
	 * 执行完handler之后，未返回视图
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String staticResourcesPath = "http://pic.hiyond.com";
		String jsPath = staticResourcesPath+"/js";
		String cssPath = staticResourcesPath+"/css";
		request.setAttribute("jsPath",jsPath);
		request.setAttribute("cssPath",cssPath);
		request.setAttribute("staticResourcesPath",staticResourcesPath);
	}

	/**
	 * 执行handler之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("IP(x-forwarded-for):"+request.getHeader("x-forwarded-for"));
		System.out.println("IP(RemoteAddr):"+request.getRemoteAddr());
		return true;

	}


}
