package com.gsmayya.services.code.java;

import com.gsmayya.services.code.data.TypeFileProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaClassProperties extends TypeFileProperties {
    private final Map<String, String>  classNames = new HashMap<>();
    private final Map<String, String> fields = new HashMap<>();
    private final Map<String, String>  methods = new HashMap<>();


    public Map<String, String>  getClassNames() {
        return classNames;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public Map<String, String>  getMethods() {
        return methods;
    }

    public void addClass(String className, String parentClass) {
        classNames.put(className, parentClass);
    }

    public void addMethod(String name, String returnType) {
        methods.put(name, returnType);
    }

    public void addVariables(String name, String type) {
        fields.put(name, type);
    }
}
