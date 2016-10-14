package com.hiyond.redis;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.hiyond.common.constant.Constant;
import com.hiyond.common.cookies.CookieUtils;
import com.hiyond.common.redis.RedisUtils;
import com.hiyond.common.utils.UuidUtils;
import com.hiyond.entity.User;

import net.sf.json.JSONObject;

/**
 * 
 * @author Hiyond
 *
 */
public class RedisCookieKey {
	private static Logger log = Logger.getLogger(RedisCookieKey.class);

	/**
	 * 
	 * @param userName
	 * @return
	 */
	public static String getKey(String userName) {
		String key = userName + UuidUtils.getUUID();
		return key;
	}

	/**
	 * 在redis与cookie中存放用户信息
	 * 
	 * @param user
	 * @param response
	 * @param redisKey 如果不设置会生成一个key
	 * @return
	 */
	public static boolean setCookieRedis(User user, HttpServletResponse response, String redisKey) {
		try {
			String jsonUser = JSONObject.fromObject(user).toString();
			redisKey = StringUtils.isBlank(redisKey) ? RedisCookieKey.getKey(user.getName()) : redisKey;
			boolean setKey = RedisUtils.setKey(redisKey, jsonUser, Constant.REDIS_AUTH_NAME_EXPIRES);
			if(setKey == false){
				log.error("写入redis失败!停止cookie的设置！");
				return false;
			}
			// cookie操作
			CookieUtils.setCookie(response, Constant.COOKIE_AUTH_NAME, redisKey, Constant.COOKIE_PATH,
					Constant.COOKIE_AUTH_NAME_EXPIRES, Constant.COOKIE_DOMAIN);
			log.info("写入cookie与redis成功");
			return true;
		} catch (Exception e) {
			log.error("写入cookie与redis失败：" + e);
			return false;
		}
	}

}
