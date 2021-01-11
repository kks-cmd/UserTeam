package com.css.app.base.common.attachconfig.model;
import java.io.Serializable;
@SuppressWarnings("serial")
public class Attachconfig implements Serializable{
	/**
	 * uuid
	 */
	private String uuid;
	/**
	 * 业务名称
	 */
	private String name;
	/**
	 * 排序
	 */
	private Integer ordernum;
	/**
	 * 业务表名
	 */
	private String tableName;
	/**
	 * 业务关键字
	 */
	private String tableKey;
	/**
	 * 附件最大(KB)
	 */
	private Integer fileLength;
	/**
	 * 最大附件数
	 */
	private Integer fileNumber;
	/**
	 * 允许附件类型
	 */
	private String fileExt;
	/**
	 * 扩展参数
	 */
	private String extraPara;
	
	public Attachconfig() {
	}

	
	
  public void setUuid(String uuid) {
  	this.uuid = uuid;
  }
    
  public String getUuid() {
  	return this.uuid;
  }
  public void setName(String name) {
  	this.name = name;
  }
    
  public String getName() {
  	return this.name;
  }
  public void setOrdernum(Integer ordernum) {
  	this.ordernum = ordernum;
  }
    
  public Integer getOrdernum() {
  	return this.ordernum;
  }
  public void setTableName(String tableName) {
  	this.tableName = tableName;
  }
    
  public String getTableName() {
  	return this.tableName;
  }
  public void setTableKey(String tableKey) {
  	this.tableKey = tableKey;
  }
    
  public String getTableKey() {
  	return this.tableKey;
  }
  public void setFileLength(Integer fileLength) {
  	this.fileLength = fileLength;
  }
    
  public Integer getFileLength() {
  	return this.fileLength;
  }
  public void setFileNumber(Integer fileNumber) {
  	this.fileNumber = fileNumber;
  }
    
  public Integer getFileNumber() {
  	return this.fileNumber;
  }
  public void setFileExt(String fileExt) {
  	this.fileExt = fileExt;
  }
    
  public String getFileExt() {
  	return this.fileExt;
  }
  public void setExtraPara(String extraPara) {
  	this.extraPara = extraPara;
  }
    
  public String getExtraPara() {
  	return this.extraPara;
  }
}