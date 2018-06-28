package com.autoDeploy.util;


/**
 * 加强版 公用返回对象
 * @author mills
 *
 */
public class EnhanceBaseResultUtil {
	/**
	 * 处理失败返回方法-
	 * @param msg
	 * @return 返回信息和失败代码
	 */
	public static BaseResultUtil FailedResult(String msg) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("00000");
		//失败提示信息
		baseResultUtil.setMsg(msg);
		return baseResultUtil;
	}
	/**
	 * 失败返回
	 * @param msg  提示信息
	 * @param nextOperate  下一跳地址
	 * @return 提示信息、下一跳地址
	 */
	public static BaseResultUtil FailedResult(String msg,String nextOperate) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("00000");
		//失败提示信息
		baseResultUtil.setMsg(msg);
		//下一跳地址
		baseResultUtil.setNextOperate(nextOperate);
		return baseResultUtil;
	}
	/**
	 * 处理失败返回方法
	 * @param msg 失败提示信息
	 * @param object 存放对象信息
	 * @return 失败提示信息和对象信息
	 */
	public static BaseResultUtil FailedResult(String msg,Object object) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("00000");
		//失败提示信息
		baseResultUtil.setMsg(msg);
		//对象信息
		baseResultUtil.setData(object);
		return baseResultUtil;
	}
	/**
	 * 处理失败返回
	 * @param object  对象信息
	 * @param nextOperate  下一跳地址
	 * @return  对象信息、下一跳地址信息
	 */
	public static BaseResultUtil FailedResult(Object object,String nextOperate) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("00000");
		//对象信息
		baseResultUtil.setData(object);
		//下一跳处理地址
		baseResultUtil.setNextOperate(nextOperate);
		return baseResultUtil;
	}
	/**
	 * 处理失败返回
	 * @param object  数据对象
	 * @param nextOperate  下一跳地址
	 * @param count  数据大小
	 * @return 数据对象、下一跳、数据大小
	 */
	public static BaseResultUtil FailedResult(Object object,String nextOperate,Integer count) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("00000");
		//对象信息
		baseResultUtil.setData(object);
		//下一跳处理地址
		baseResultUtil.setNextOperate(nextOperate);
		//总记录数
		baseResultUtil.setCount(count);;
		return baseResultUtil;
	}
	/**
	 * 失败返回
	 * @param object  数据对象
	 * @param count  数据大小
	 * @return 数据对象、数据大小
	 */
	public static BaseResultUtil FailedResult(Object object,Integer count) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("00000");
		//对象信息
		baseResultUtil.setData(object);
		//总记录数
		baseResultUtil.setCount(count);;
		return baseResultUtil;
	}
	/**
	 * 处理失败方法
	 * @param msg 失败提示信息
	 * @param object 对象信息
	 * @param nextOperate  下一跳地址
	 * @return 失败提示信息、对象信息、下一跳地址
	 */
	public static BaseResultUtil FailedResult(String msg,Object object,String nextOperate) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("00000");
		//失败提示信息
		baseResultUtil.setMsg(msg);
		//对象信息
		baseResultUtil.setData(object);
		//下一跳处理地址
		baseResultUtil.setNextOperate(nextOperate);
		return baseResultUtil;
	}
	/**
	 * 成功返回
	 * @param msg  提示信息
	 * @return 提示信息
	 */
	public static BaseResultUtil SucceeResult(String msg) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("10000");
		//失败提示信息
		baseResultUtil.setMsg(msg);
		return baseResultUtil;
	}
	/**
	 * 处理成功返回
	 * @param msg  提示信息
	 * @param nextOperate  下一跳地址
	 * @return 提示信息、下一跳地址信息
	 */
	public static BaseResultUtil SucceeResult(String msg,String nextOperate) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("10000");
		//失败提示信息
		baseResultUtil.setMsg(msg);
		//下一跳处理地址
		baseResultUtil.setNextOperate(nextOperate);
		return baseResultUtil;
	}
	/**
	 * 处理成功返回方法
	 * @param msg 成功提示信息
	 * @param object 成功对象信息
	 * @return 成功提示信息和对象信息
	 */
	public static BaseResultUtil SucceeResult(String msg,Object object) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("10000");
		//失败提示信息
		baseResultUtil.setMsg(msg);
		//对象信息
		baseResultUtil.setData(object);
		return baseResultUtil;
	}
	/**
	 * 成功返回
	 * @param object 对象信息
	 * @param nextOperate  下一跳信息
	 * @return 对象信息、下一跳信息
	 */
	public static BaseResultUtil SucceeResult(Object object,String nextOperate) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("10000");
		//对象信息
		baseResultUtil.setData(object);
		//下一跳处理地址
		baseResultUtil.setNextOperate(nextOperate);
		return baseResultUtil;
	}
	/**
	 * 处理成功方法
	 * @param msg 成功提示信息
	 * @param object 对象信息
	 * @param nextOperate  下一跳地址
	 * @return 成功提示信息、对象信息、下一跳地址
	 */
	public static BaseResultUtil SucceeResult(String msg,Object object,String nextOperate) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("10000");
		//失败提示信息
		baseResultUtil.setMsg(msg);
		//对象信息
		baseResultUtil.setData(object);
		//下一跳处理地址
		baseResultUtil.setNextOperate(nextOperate);
		return baseResultUtil;
	}
	/**
	 * 成功返回
	 * @param msg  提示信息
	 * @param object  数据对象
	 * @param nextOperate  下一跳地址
	 * @param count  数据大小
	 * @return 提示信息、数据对象、下一跳地址、数据大小对象
	 */
	public static BaseResultUtil SucceeResult(String msg,Object object,String nextOperate,Integer count) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("10000");
		//失败提示信息
		baseResultUtil.setMsg(msg);
		//对象信息
		baseResultUtil.setData(object);
		//下一跳处理地址
		baseResultUtil.setNextOperate(nextOperate);
		//数据大小
		baseResultUtil.setCount(count);
		return baseResultUtil;
	}
	/**
	 * 成功返回
	 * @param msg  提示信息
	 * @param object  数据对象
	 * @param count  数据大小
	 * @return 提示信息、数据对象、下一跳地址、数据大小对象
	 */
	public static BaseResultUtil SucceeResult(String msg,Object object,Integer count) {
		BaseResultUtil baseResultUtil = new BaseResultUtil();
		//失败代码 00000
		baseResultUtil.setCode("10000");
		//失败提示信息
		baseResultUtil.setMsg(msg);
		//对象信息
		baseResultUtil.setData(object);
		//数据大小
		baseResultUtil.setCount(count);
		return baseResultUtil;
	}
}
