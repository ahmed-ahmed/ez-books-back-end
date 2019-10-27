package io.ezbook.api.model;

import io.ezbook.api.entity.Account;
import io.ezbook.api.entity.AccountType;

import java.util.List;

public class AccountPost {
    private String name;
    private long parentId;
    private String description;

//    private

    public AccountPost() {
    }

    public AccountPost(String name, long parentId, AccountType accountType) {
        this.name = name;
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
