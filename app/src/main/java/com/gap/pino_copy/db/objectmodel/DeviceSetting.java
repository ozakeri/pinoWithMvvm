package com.gap.pino_copy.db.objectmodel;

import java.util.Date;
// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "DEVICE_SETTING".
 */
public class DeviceSetting {

    private Long id;
    private String key;
    private String value;
    private Date dateLastChange;

    private transient Date beforeSyncDate;

    public DeviceSetting() {
    }

    public DeviceSetting(Long id) {
        this.id = id;
    }

    public DeviceSetting(Long id, String key, String value, java.util.Date dateLastChange) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.dateLastChange = dateLastChange;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public java.util.Date getDateLastChange() {
        return dateLastChange;
    }

    public void setDateLastChange(java.util.Date dateLastChange) {
        this.dateLastChange = dateLastChange;
    }

    public Date getBeforeSyncDate() {
        return beforeSyncDate;
    }

    public void setBeforeSyncDate(Date beforeSyncDate) {
        this.beforeSyncDate = beforeSyncDate;
    }
}
