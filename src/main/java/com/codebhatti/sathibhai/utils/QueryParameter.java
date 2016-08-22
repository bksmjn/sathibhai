package com.codebhatti.sathibhai.utils;

public class QueryParameter {
	private final String paramName;
	private final Object value;

	private QueryParameter(String paramName, Object value) {
		this.paramName = paramName;
		this.value = value;
	}

	public static QueryParameter newParam(String paramName, Object value) {
		return new QueryParameter(paramName, value);
	}

	public String getParamName() {
		return paramName;
	}

	public Object getValue() {
		return value;
	}
}
