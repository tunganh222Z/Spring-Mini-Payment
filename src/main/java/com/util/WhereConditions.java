package com.util;

public class WhereConditions {
    private String condition;

    public WhereConditions(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return this.condition;
    }

    private String compare(String unit, Object object) {
        return String.format("'%s' %s '%s' ", condition, unit, object);
    }

    public static WhereConditions where(String condition){
        return new WhereConditions(condition);
    }

    public WhereConditions equal(Object object) {
        condition = compare("=", object);
        return this;
    }

    public WhereConditions lessThan(Object object) {
        this.condition = compare("<", object);
        return this;
    }

    public WhereConditions greater (Object object) {
        this.condition = compare(">", object);
        return this;
    }

    public WhereConditions greaterEqual(Object object) {
        this.condition = compare(">=", object);
        return this;
    }

    public WhereConditions lessThanEqual(Object object) {
        this.condition = compare("<=", object);
        return this;
    }
}
