package com.css.app.base.common.file.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.css.app.base.common.file.service.FileService;
import com.css.core.configuration.Environment;
import com.css.core.model.tree.AbstractTree;
import com.css.db.query.QueryCache;

@SuppressWarnings("serial")
public class FileMain extends AbstractTree implements Serializable {
	private String uuid;
	private String fileMd5;
	private String parentId;
	private Date createTime;
	private Integer orderNum;
	private String isFolder;
	private String name;
	private String category;
	private String fileType;
	private String fileExt;
	private Long fileSize;
	private String userId;
	private String shareFromUserId;
	private String publicFlag;
	private String favourite;
	private String url;

	public FileMain() {
		this.favourite = Environment.FALSE;
		this.publicFlag = Environment.FALSE;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentId() {
		return this.parentId;
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

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setIsFolder(String isFolder) {
		this.isFolder = isFolder;
	}

	public String getIsFolder() {
		return this.isFolder;
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

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getFileMd5() {
		return fileMd5;
	}

	public void setFileMd5(String fileMd5) {
		this.fileMd5 = fileMd5;
	}

	public String getShareFromUserId() {
		return shareFromUserId;
	}

	public void setShareFromUserId(String shareFromUserId) {
		this.shareFromUserId = shareFromUserId;
	}

	public String getPublicFlag() {
		return publicFlag;
	}

	public void setPublicFlag(String publicFlag) {
		this.publicFlag = publicFlag;
	}

	public String getFavourite() {
		return favourite;
	}

	public void setFavourite(String favourite) {
		this.favourite = favourite;
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

	public String getUrl() {
		this.url = FileService.getFileUrl(this);
		return url;
	}

	/**
	 * 实现TreeType定义的接口，默认树型对象应至少包含id、parentId，对于orderNum, name等请根据实际定义类进行修改
	 */
	/*
	 * public List<String> getTreeList(String key) { return new
	 * QueryCache("select a.uuid from FileMain a where a.isFolder='1' and a.userId=:userId order by a.name"
	 * ).setParameter("userId", key).list(); }
	 */

	/**
	 * 实现AbstractTree定义的抽象方法，默认树型对象应至少包含nodeId, nodeParentId,
	 * nodeName等请根据实际定义类进行修改
	 */
	@Override
	public QueryCache getQuery() {
		return new QueryCache("select a.uuid from FileMain a where a.isFolder='1' and a.parentId=:parentId  and a.userId=:userId order by a.name").setParameter("userId", this.userId);
	}

	@Override
	public String getNodeId() {
		return this.uuid;
	}

	@Override
	public String getNodeParentId() {
		return this.parentId;
	}

	@Override
	public String getNodeName() {
		return this.name;
	}

	@Override
	public String getRootId() {
		return "0";
	}
}