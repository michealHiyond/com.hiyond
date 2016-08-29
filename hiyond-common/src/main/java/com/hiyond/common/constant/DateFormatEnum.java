package com.hiyond.common.constant;

/**
 * 日期格式化类型
 * @author hiyond
 *
 */
public enum DateFormatEnum {
	
	TYPE1("1","yyyy-MM-dd HH:mm:ss"),
	TYPE2("2","yyyyMMddHHmmss"),
	TYPE3("3","yyyyMMdd");
	
	
	DateFormatEnum(String index, String type) {
		this.index = index;
		this.type = type;
	}

	private String index;
	
	private String type;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public static Integer getOrdinal(DateFormatEnum dateFormatEnum){
		if(dateFormatEnum instanceof DateFormatEnum){
			return dateFormatEnum.ordinal()+1;
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(DateFormatEnum.getOrdinal(null));
	}

}
