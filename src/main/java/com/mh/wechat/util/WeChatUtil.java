package com.mh.wechat.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.lang3.StringUtils;

import com.mh.wechat.constants.Const;
import com.mh.wechat.entity.AccessToken;
import com.mh.wechat.entity.WeChatResponse;
import com.mh.wechat.web.util.SystemConfig;

public class WeChatUtil {

	/**
	 * check the signature send by the wechat server
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce) {
		String wechatToken = SystemConfig.getWeChatToken();
		String[] arr = new String[] { wechatToken, timestamp, nonce };
		// sequence the signature, timestamp, nonce as the dictionary sort.
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
			// summary the 3 parameter with SHA-1 algorithms
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		content = null;
		// compare the summarized value with the signature which send my wechat
		// server
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}

	/**
	 * calculate the SHA1 summary
	 * @param value
	 * @return
	 */
	public static String genSHA1Summary(String value) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(value.toString().getBytes());
			return byteToStr(digest);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * convert the bytes to the hex string
	 * 
	 * @param byteArray
	 * @return
	 */
	public static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * convert hex to string
	 * 
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];
		String s = new String(tempArr);
		return s;
	}

	public static String getGlobalAccessToken() {
		return AccessToken.getInstance().getAccessToken();
	}

	public static WeChatResponse sendHttpsRequest(String requestUrl, String method, String data) {
		return parseWeChatResponseJson(httpsRequest(requestUrl, method, data));
	}

	public static WeChatResponse parseWeChatResponseJson(String json) {
		try {
			return new WeChatResponse().parseJson(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * call the https URL to get the response string
	 * 
	 * @param requestUrl
	 * @param method
	 * @param data
	 * @return
	 */
	public static String httpsRequest(String requestUrl, String method, String data) {
		StringBuilder sb = new StringBuilder("");
		try {
			URL url = new URL(requestUrl);
			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setUseCaches(false);
			urlConnection.setRequestMethod(method);
			if (Const.RequestMethod.GET.equals(method)) {
				urlConnection.connect();
			} else {
				if (StringUtils.isNotBlank(data)) {
					OutputStream outputStream = urlConnection.getOutputStream();
					outputStream.write(data.getBytes("UTF-8"));
					outputStream.close();
				}
			}
			InputStream inputStream = urlConnection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				sb.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			urlConnection.disconnect();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return "";
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getGlobalAccessToken());
	}
}
