package org.guo.mybatis.modle;

import java.sql.Timestamp;

public class Item {
	private Integer id;
	private String name;
	private String detail;
	private Integer price;
	private Timestamp createtime;
	private String note;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Timestamp getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", detail=" + detail + ", price=" + price + ", createtime="
				+ createtime + ", note=" + note + "]";
	}
	
	
	
}
