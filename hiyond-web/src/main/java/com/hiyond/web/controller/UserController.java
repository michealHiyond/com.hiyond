package com.hiyond.web.controller;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hiyond.constant.Passwd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hiyond.common.utils.TimeUtils;
import com.hiyond.common.utils.UuidUtils;
import com.hiyond.entity.User;
import com.hiyond.redis.RedisCookieKey;
import com.hiyond.service.UserService;
import com.hiyond.session.SessionUtils;
import com.hiyond.web.controller.base.BaseController;


/**
 * 
 * @author Hiyond
 * 
 */

@Controller
@RequestMapping("/user")
public class UserController extends BaseController implements Serializable {

	private static final long serialVersionUID = 2816016507764283394L;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/gotologin", method = { RequestMethod.POST, RequestMethod.GET })
	public String gotologin(Model model, HttpServletRequest request, HttpServletResponse response) {
		String rebackUrl = request.getHeader("referer");
		model.addAttribute("rebackUrl", rebackUrl);
		return "user/user";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public String login(Model model, HttpServletRequest request, HttpServletResponse response, User user,
			String rebackUrl) throws Exception {
		// String refererUrl = rebackUrl;
		user.setPassword(Passwd.createPasswd(user.getPassword()));
		User userNum = userService.loginUser(user);
		if (userNum != null) {
			Date lastLoginTime = new Date();
			user.setLastLoginTime(lastLoginTime);
			userService.updateUserLoginTime(user);
			SessionUtils.addUserToSession(request, user);
			model.addAttribute(user);

			RedisCookieKey.setCookieRedis(user, response, "");
			return "common/home";
		} else {
			return "common/error";
		}
	}

	@RequestMapping(value = "/register", method = { RequestMethod.POST })
	public String register(HttpServletRequest request, HttpServletResponse response, User user, Model model)
			throws Exception {
		int userNum = userService.findUserByName(user.getName());
		if (userNum > 0) {
			request.setAttribute("errorInfo", "已经注册");
			return request.getRequestURI();
		}
		Date lastLoginTime = new Date();
		String dateType = "yyyy-MM-dd HH:mm:ss";
		lastLoginTime = TimeUtils.util_timeFormat(TimeUtils.util_timeFormat(lastLoginTime, dateType), dateType);
		user.setLastLoginTime(lastLoginTime);
		user.setUUID(UuidUtils.getUUID());
		user.setPassword(Passwd.createPasswd(user.getPassword()));
		userService.insertUser(user);
		SessionUtils.addUserToSession(request, user);
		model.addAttribute("user", user);

		RedisCookieKey.setCookieRedis(user, response, "");

		return "common/home";
	}
}
