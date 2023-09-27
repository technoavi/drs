package com.as.drs.models;

public enum CustomerType {
    LOYAL, NEW, DISSATISFIED;
 
    public String getValue() {
        return this.toString();
    }
}