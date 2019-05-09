package com.example.secondmodule.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Name: BaseEntity
 * @Description: 基础实体类，包含各实体公用属性
 * @Author: ywm
 * @Version: v0.0.1-2017-11-21
 * @See:
 * @Since:
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String createBy;
	private Date createTime = new Date();
	private String modifiedBy;	//
	private Date modifiedTime = new Date();
	private String remark;
	private Byte validState;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Byte getValidState() {
		return validState;
	}

	public void setValidState(Byte validState) {
		this.validState = validState;
	}
}
