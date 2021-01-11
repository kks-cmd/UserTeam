package com.css.app.base.common.attach.model;

import java.util.Date;

@SuppressWarnings("serial")
public class FileAttach implements java.io.Serializable {
	private String fileMd5;
	private String userId;
	private String name;
	private Date createTime;
	private String category;
	private Long fileSize;
	private String fileExt;
	private String fileType;
	private Integer complete;
	private String fileUrl;
	private String serverId;
	public FileAttach() {
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setFileMd5(String fileMd5) {
		this.fileMd5 = fileMd5;
	}
	public String getFileMd5() {
		return this.fileMd5;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileType() {
		return this.fileType;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public Long getFileSize() {
		return this.fileSize;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFileUrl() {
		return this.fileUrl;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public String getServerId() {
		return this.serverId;
	}
	public Integer getComplete() {
		return complete;
	}
	public void setComplete(Integer complete) {
		this.complete = complete;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}