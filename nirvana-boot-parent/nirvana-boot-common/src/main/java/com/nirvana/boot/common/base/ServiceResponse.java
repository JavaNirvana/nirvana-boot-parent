package com.nirvana.boot.common.base;

import com.nirvana.boot.common.enums.IEnum;
import com.nirvana.boot.common.enums.ResultEnum;

/**
 * 服务响应对象.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/24 16:42
 */
public class ServiceResponse<T> extends BaseBean {

	/**
	 * 返回编码
	 */
	private String code;
	/**
	 * 返回消息
	 */
	private String msg;

	/**
	 * 消息内容
	 */
	private T data;

	/**
	 * 构造函数
	 * 
	 * @param code
	 *            数据
	 * @param msg
	 *            消息头
	 */
	public ServiceResponse(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 构造函数
	 * 
	 * @param data
	 *            数据
	 * @param enums
	 *            消息枚举
	 */
	public ServiceResponse(T data, IEnum enums) {
		this.code = enums.getKey();
		this.msg = enums.getValue();
		this.data = data;
	}

	/**
	 * 构造函数(成功)
	 * 
	 * @param data
	 *            数据
	 */
	public ServiceResponse(T data) {
		this(data, ResultEnum.SUCCESS);
	}

	public ServiceResponse() {

	}

	public ServiceResponse(IEnum errorCode, String msg) {
		this.code = errorCode.getKey();
		this.msg = msg;
	}

	public void setServiceResponse(IEnum errorCode) {
		this.code = errorCode.getKey();
		this.msg = errorCode.getValue();
	}

	/**
	 * 构造函数(失败)
	 * 
	 * @param errorCode
	 */
	public ServiceResponse(IEnum errorCode) {
		this(null, errorCode);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 是否成功
	 * 
	 * @return true成功，false失败
	 */
	public boolean isSuccess() {
		return ResultEnum.SUCCESS.getKey().equals(this.code);
	}

	/**
	 * 是否错误
	 * 
	 * @return true 失败，false成功
	 */
	public boolean isError() {
		return !isSuccess();
	}

	/**
	 * 是什么类型错误
	 * 
	 * @param error
	 *            具体错误
	 * @return
	 */
	public boolean isError(ResultEnum error) {
		if (error == null) {
			return isError();
		}
		return this.code.equals(error.getKey());
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
}
