package com.autoDeploy.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lee
 * @since 2018-05-23
 */
@TableName("manage_job")
public class ManageJob extends Model<ManageJob> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("job_name")
	private String jobName;
	private String version;
	@TableField("job_type")
	private Integer jobType;
	@TableField("packge_name")
	private String packgeName;
	@TableField("packge_url")
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


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ManageJob{" +
			"id=" + id +
			", jobName=" + jobName +
			", version=" + version +
			", jobType=" + jobType +
			", packgeName=" + packgeName +
			", packgeUrl=" + packgeUrl +
			", remark=" + remark +
			"}";
	}



}
