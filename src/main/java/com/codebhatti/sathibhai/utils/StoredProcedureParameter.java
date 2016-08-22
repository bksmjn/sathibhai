package com.codebhatti.sathibhai.utils;

public class StoredProcedureParameter {

	private final String parameterName;
	private final Class type;
	private final ParamMode mode;
	private final Object paramValue;

	public enum ParamMode {
		IN, OUT
	}

	private StoredProcedureParameter(String parameterName, Class type, Object value, ParamMode paramMode) {
		this.parameterName = parameterName;
		this.type = type;
		this.mode = paramMode;
		this.paramValue = value;
	}

	public static StoredProcedureParameter newParam(String parameterName, Class type, Object value,
			ParamMode paramMode) {
		return new StoredProcedureParameter(parameterName, type, value, paramMode);
	}

	public String getParameterName() {
		return parameterName;
	}

	public Class getType() {
		return type;
	}

	public ParamMode getMode() {
		return mode;
	}

	public Object getParamValue() {
		return paramValue;
	}

}
