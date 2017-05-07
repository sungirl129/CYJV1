package com.cyj.excel;

import java.util.ArrayList;
import java.util.List;

public class SimpleImportStatus<T> {

	private boolean success;
	private int totalCount;
	private int successCount;
	private int failCount;
	private List<T> batchAddList  = new ArrayList<T>();
	private List<String> msg  = new ArrayList<String>();
	private String errorMsg;

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getSuccessCount() {
		return successCount;
	}
	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}
	public int getFailCount() {
		return failCount;
	}
	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}
	public List<T> getBatchAddList() {
		return batchAddList;
	}
	public void setBatchAddList(List<T> batchAddList) {
		this.batchAddList = batchAddList;
	}
	public List<String> getMsg() {
		return msg;
	}
	public void setMsg(List<String> msg) {
		this.msg = msg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
