package com.autoDeploy.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lee
 * @since 2018-05-18
 */
public class Syslog extends Model<Syslog> {

    private static final long serialVersionUID = 1L;

	private String type;
	private String title;
	@TableField("remote_addr")
	private String remoteAddr;
	private String username;
	@TableField("request_uri")
	private String requestUri;
	@TableField("http_method")
	private String httpMethod;
	@TableField("class_method")
	private String classMethod;
	private String params;
	@TableField("session_id")
	private String sessionId;
	private String response;
	@TableField("user_time")
	private Long userTime;
	private String browser;
	private String area;
	private String province;
	private String city;
	private String isp;
	private String exception;


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getClassMethod() {
		return classMethod;
	}

	public void setClassMethod(String classMethod) {
		this.classMethod = classMethod;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Long getUserTime() {
		return userTime;
	}

	public void setUserTime(Long userTime) {
		this.userTime = userTime;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	@Override
	protected Serializable pkVal() {
		return null;
	}

	@Override
	public String toString() {
		return "Syslog{" +
			"type=" + type +
			", title=" + title +
			", remoteAddr=" + remoteAddr +
			", username=" + username +
			", requestUri=" + requestUri +
			", httpMethod=" + httpMethod +
			", classMethod=" + classMethod +
			", params=" + params +
			", sessionId=" + sessionId +
			", response=" + response +
			", userTime=" + userTime +
			", browser=" + browser +
			", area=" + area +
			", province=" + province +
			", city=" + city +
			", isp=" + isp +
			", exception=" + exception +
			"}";
	}
}
