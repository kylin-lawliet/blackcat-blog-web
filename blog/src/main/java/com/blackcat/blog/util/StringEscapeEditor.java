package com.blackcat.blog.util;

import java.beans.PropertyEditorSupport;

/**
 * <p> : 防止XSS攻击 && 特殊字符转义和方法入参检测工具类
 * @author : blackcat
 * @date : 2020/1/20 21:56
*/
public class StringEscapeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {
		if (text == null) {
			setValue(null);
		} else {
			String value = text;
			value=cleanXSS(value);
			setValue(value);
		}
	}
	private String cleanXSS(String value) {
		value = value.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;");
		return value;
	}
}
