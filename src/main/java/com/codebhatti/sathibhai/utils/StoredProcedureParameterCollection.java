package com.codebhatti.sathibhai.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoredProcedureParameterCollection {
	private final List<StoredProcedureParameter> parameters;

	public static StoredProcedureParameterCollection newCollection() {
		return new StoredProcedureParameterCollection();
	}

	private StoredProcedureParameterCollection() {
		this.parameters = new ArrayList<>();
	}

	public void add(StoredProcedureParameter parameter) {
		this.parameters.add(parameter);
	}

	public List<StoredProcedureParameter> getParameters() {
		return Collections.unmodifiableList(parameters);
	}
}
