package com.gap.pino_copy.db.objectmodel;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "FORM_QUESTION_GROUP_FORM".
 */
public class FormQuestionGroupForm {

    private Long id;
    private String groupName;
    private long formId;
    private long formQuestionGroupId;

    public FormQuestionGroupForm() {
    }

    public FormQuestionGroupForm(Long id) {
        this.id = id;
    }

    public FormQuestionGroupForm(Long id, String groupName, long formId, long formQuestionGroupId) {
        this.id = id;
        this.groupName = groupName;
        this.formId = formId;
        this.formQuestionGroupId = formQuestionGroupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public long getFormQuestionGroupId() {
        return formQuestionGroupId;
    }

    public void setFormQuestionGroupId(long formQuestionGroupId) {
        this.formQuestionGroupId = formQuestionGroupId;
    }

}