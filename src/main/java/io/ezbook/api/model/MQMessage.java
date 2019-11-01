package io.ezbook.api.model;

import io.ezbook.api.entity.JournalEntity;

import java.io.Serializable;

public class MQMessage {//implements Serializable {
//    private static final long serialVersionUID = 1714010091805070070L;
//
    String tenantId;

    JournalEntity payload;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public JournalEntity getPayload() {
        return payload;
    }

    public void setPayload(JournalEntity payload) {
        this.payload = payload;
    }
}
