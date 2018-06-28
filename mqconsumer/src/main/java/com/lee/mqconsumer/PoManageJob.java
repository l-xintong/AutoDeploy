package com.lee.mqconsumer;


import com.lee.mqconsumer.enums.JobTypeEnums;

public class PoManageJob {



	private Long id;
	private String jobName;
	private String version;
	private Integer jobType;
	private String packgeName;
	private String packgeUrl;
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getJobType() {
		return jobType;
	}

	public void setJobType(Integer jobType) {
		this.jobType = jobType;
	}

	public String getPackgeName() {
		return packgeName;
	}

	public void setPackgeName(String packgeName) {
		this.packgeName = packgeName;
	}

	public String getPackgeUrl() {
		return packgeUrl;
	}

	public void setPackgeUrl(String packgeUrl) {
		this.packgeUrl = packgeUrl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private String jobTypeName;

	public String getJobTypeName() {
		return JobTypeEnums.getDisplayName(getJobType());
	}

	public void setJobTypeName(String jobTypeName) {
		this.jobTypeName = jobTypeName;
	}
}
