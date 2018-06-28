package com.autoDeploy.util;
/**
 * 返回数据公用工具
 * @author mills
 *
 */
public class BaseResultUtil {
	/**
	 * 执行结果编号
	 */
	private String code;
	/**
	 * 执行结果返回信息
	 */
	private String msg;
	/**
	 * 执行结果返回数据
	 */
	private Object data;
	/**
	 * 总记录数
	 */
	private Integer count;
	
	/**
	 * 下一操作地址
	 */
	private String nextOperate;
	
	
	public String getNextOperate() {
		return nextOperate;
	}
	public void setNextOperate(String nextOperate) {
		this.nextOperate = nextOperate;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}


}
