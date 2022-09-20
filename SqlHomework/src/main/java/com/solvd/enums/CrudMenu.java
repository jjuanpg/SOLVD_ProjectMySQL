package com.solvd.enums;

public enum CrudMenu {
    INSERT("Insert."),
    UPDATE("Update."),
    DELETE("Delete."),
    GET_ALL("Get all."),
    GET_BY_ID("Get by ID.");

    private final String description;

    CrudMenu(String s) {
        this.description = s;
    }
    @Override
    public String toString(){
        return description;
    }
}
