package com.Blog.payloads;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CatgeoryDto {
	private int id;
	private String catDesc;
	private String catTitle;
	public CatgeoryDto(int id, String catDesc, String catTitle) {
		super();
		this.id = id;
		this.catDesc = catDesc;
		this.catTitle = catTitle;
	}
	public CatgeoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCatDesc() {
		return catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	public String getCatTitle() {
		return catTitle;
	}
	public void setCatTitle(String catTitle) {
		this.catTitle = catTitle;
	}
	
}
