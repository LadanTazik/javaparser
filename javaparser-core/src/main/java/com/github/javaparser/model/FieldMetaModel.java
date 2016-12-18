package com.github.javaparser.model;

import java.lang.reflect.Field;

import static com.github.javaparser.utils.Utils.capitalize;

/**
 * Meta-data about a field in a node in the AST.
 */
public class FieldMetaModel {
    private final NodeMetaModel nodeMetaModel;
    private final Field field;

    public FieldMetaModel(NodeMetaModel nodeMetaModel, Field field) {
        this.nodeMetaModel = nodeMetaModel;
        this.field = field;
    }
    
    void initialize() {
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldMetaModel that = (FieldMetaModel) o;

        if (!field.equals(that.field)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return field.hashCode();
    }

    public NodeMetaModel getNodeMetaModel() {
        return nodeMetaModel;
    }

    public Field getField() {
        return field;
    }

    public String getter() {
        String name = field.getName();
        if (name.startsWith("is")) {
            return name + "()";
        }
        if (field.getType().equals(Boolean.class)) {
            return "is" + capitalize(name) + "()";
        }
        return "get" + capitalize(name) + "()";
    }

    public Class<?> getType() {
        return field.getType();
    }
}
