package com.mh.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mh.wechat.web.util.SystemConfig;

@Controller
@RequestMapping("/admin")
public class ConfigureController {

	@RequestMapping("/syscfg")
	public @ResponseBody
	Object getSystemConfig() {
		return SystemConfig.getHmConfig();
	}

}
