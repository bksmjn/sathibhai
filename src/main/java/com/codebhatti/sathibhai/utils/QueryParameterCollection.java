package com.codebhatti.sathibhai.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueryParameterCollection {
    private final List<QueryParameter> parameters;

    public static QueryParameterCollection newCollection() {
        return new QueryParameterCollection();
    }

    private QueryParameterCollection() {
        this.parameters = new ArrayList<>();
    }

    public void add(QueryParameter parameter) {
        this.parameters.add(parameter);
    }

    public List<QueryParameter> getParameters() {
        return Collections.unmodifiableList(parameters);
    }
}
