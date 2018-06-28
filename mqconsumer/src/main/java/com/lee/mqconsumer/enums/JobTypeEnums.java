package com.lee.mqconsumer.enums;

public enum JobTypeEnums implements BaseEnums{
	/**
	 * 0.首发
	 */
	FIRST(0,"首发"),
	/**
	 * 1.更新
	 */
	UPDATE(1,"更新")
	;

	private Integer value;
	/**
	 * 页面显示的值
	 */
	private String displayName;

	public static String getDisplayName(Integer value){
		for (JobTypeEnums enums : JobTypeEnums.values()) {
			if(enums.value == value){
				return enums.displayName;
			}
		}
		return "";
	}

	private JobTypeEnums(Integer value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public Integer getValue() {
		return value;
	}
}
