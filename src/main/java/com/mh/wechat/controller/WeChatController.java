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

import com.mh.wechat.entity.message.req.TextMessage;
import com.mh.wechat.entity.message.resp.RespTextMessage;
import com.mh.wechat.util.RequestMessageUtil;
import com.mh.wechat.util.ResponseMessageUtil;
import com.mh.wechat.util.WeChatUtil;

@Controller
@RequestMapping("/wechat/authen")
public class WeChatController {

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
		TextMessage requestMessage = RequestMessageUtil.genTextMessage(eRoot);
		RespTextMessage responseMessage = new RespTextMessage();
		responseMessage.setContent("This is a auto reply message");
		responseMessage.setFromUserName(requestMessage.getToUserName());
		responseMessage.setFuncFlag(0);
		responseMessage.setToUserName(requestMessage.getFromUserName());
		String respMsg = ResponseMessageUtil.genTextMessage(responseMessage);
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
