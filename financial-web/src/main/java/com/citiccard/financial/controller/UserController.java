/**
 * Project Name:docker-usermodel
 * File Name:UserController.java
 * Package Name:com.citiccard.faccount.controller
 *
*/

package com.citiccard.financial.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.citiccard.financial.common.Config;
import com.citiccard.financial.model.UserInfo;
import com.citiccard.financial.service.IUserService;

/**
 * ClassName:UserController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * 
 * @author wuweiwei
 * @version
 * 
 * @see
 */
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	public IUserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 
	 * @throws IOException
	 * @Title: showUser @Description: 查询用户信息 @param @param
	 *         userName @param @param request @param @return 参数 @return
	 *         JSONObject 返回类型 @throws
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public @ResponseBody JSONObject showUser(@RequestParam(value = "userName") String userName, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("showUser start userName="+userName);
		JSONObject result = new JSONObject();
		UserInfo user = userService.getUserByUseName(userName);
		if (user != null) {
			result.put(Config.codeFlag, Config.successCode);
			result.put(Config.messageFlag, Config.successMes);
			result.put("result", user);
		} else {
			result.put(Config.codeFlag, Config.successCode);
			result.put(Config.messageFlag, "没有相关信息");
		}
		logger.info("showUser end result="+result);
		return result;

	}
}
