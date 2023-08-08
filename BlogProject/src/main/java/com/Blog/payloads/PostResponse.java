package com.Blog.payloads;

import java.util.List;

public class PostResponse {
	private List<PostDto> content;
	private int pagesize;
	private int pagenumber;
	private long totalelements;
	private int toalpages;
	private boolean islastpage;
	public List<PostDto> getContent() {
		return content;
	}
	public void setContent(List<PostDto> content) {
		this.content = content;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagenumber() {
		return pagenumber;
	}
	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}
	public long getTotalelements() {
		return totalelements;
	}
	public void setTotalelements(long totalelements) {
		this.totalelements = totalelements;
	}
	public int getToalpages() {
		return toalpages;
	}
	public void setToalpages(int toalpages) {
		this.toalpages = toalpages;
	}
	public boolean isIslastpage() {
		return islastpage;
	}
	public void setIslastpage(boolean islastpage) {
		this.islastpage = islastpage;
	}
	
}
