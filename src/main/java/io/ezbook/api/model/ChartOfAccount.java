package io.ezbook.api.model;

public class   ChartOfAccount {
    private final long id;
    private final String name;
    private final String parentName;

    public ChartOfAccount(long id, String name, String parentName) {
        this.id = id;
        this.name = name;
        this.parentName = parentName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getParentName() {
        return parentName;
    }
}
