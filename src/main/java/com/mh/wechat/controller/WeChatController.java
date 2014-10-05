package com.mh.wechat.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mh.wechat.service.WeChatServiceImpl;
import com.mh.wechat.util.WeChatUtil;

@Controller
@RequestMapping("/wechat/authen")
public class WeChatController {
	private WeChatServiceImpl weChatService = WeChatServiceImpl.getInstance();

	/**
	 * this method will invoked by the wechat server. wechat server will send 3
	 * parameters
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void weChatServerAuthentication(HttpServletRequest request, HttpServletResponse response) {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			// check the signature by the token configure inside the wechat
			// backend console
			if (WeChatUtil.checkSignature(signature, timestamp, nonce)) {
				out.print(echostr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
			out = null;
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public void testMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		InputStream is = request.getInputStream();
		SAXReader reader = new SAXReader();
		Document document = reader.read(is);
		Element eRoot = document.getRootElement();
		String respMsg = this.weChatService.processRequest(eRoot);
		this.returnMsg2WeChat(response, respMsg);
	}

	private void returnMsg2WeChat(HttpServletResponse response, String respMsg) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(respMsg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
				out = null;
			}
		}
	}

}
