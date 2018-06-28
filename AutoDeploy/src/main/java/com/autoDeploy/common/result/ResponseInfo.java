package com.autoDeploy.common.result;

/**
 * 返回码接口
 *
 */
public interface ResponseInfo {
    /**
     * 获取返回码
     * @return
     */
    String getCode();

    /**
     * 获取返回信息
     * @return
     */
    String getMessage();
}
