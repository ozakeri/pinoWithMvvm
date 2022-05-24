package com.gap.pino_copy.db.objectmodel;

import com.gap.pino_copy.db.dao.DaoSession;
import com.gap.pino_copy.db.dao.FormAnswerDao;
import com.gap.pino_copy.db.dao.FormDao;
import com.gap.pino_copy.db.dao.FormQuestionDao;
import com.gap.pino_copy.db.dao.FormQuestionGroupDao;
import com.gap.pino_copy.db.dao.FormQuestionGroupFormDao;
import com.gap.pino_copy.db.dao.FormTempDao;

import java.util.List;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "FORM".
 */
public class Form {

    private Long id;
    private String name;
    private Integer minScore;
    private Integer maxScore;
    private java.util.Date startDate;
    private java.util.Date endDate;
    private Integer statusEn;
    private Integer formStatus;
    private java.util.Date statusDate;
    private Integer sendingStatusEn;
    private java.util.Date sendingStatusDate;
    private String xLatitude;
    private String yLongitude;
    private Long serverAnswerInfoId;
    private String inputValuesDefault;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient FormDao myDao;

    private List<FormQuestion> formQuestionList;
    private List<FormAnswer> formAnswerList;
    private List<FormQuestionGroup> formQuestionGroupList;
    private List<FormTemp> formTempList;
    private List<FormQuestionGroupForm> formQuestionGroupFormId;

    public Form() {
    }

    public Form(Long id) {
        this.id = id;
    }

    public Form(Long id, String name, Integer minScore, Integer maxScore, java.util.Date startDate, java.util.Date endDate, Integer statusEn, Integer formStatus, java.util.Date statusDate, Integer sendingStatusEn, java.util.Date sendingStatusDate, String xLatitude, String yLongitude, Long serverAnswerInfoId, String inputValuesDefault) {
        this.id = id;
        this.name = name;
        this.minScore = minScore;
        this.maxScore = maxScore;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statusEn = statusEn;
        this.formStatus = formStatus;
        this.statusDate = statusDate;
        this.sendingStatusEn = sendingStatusEn;
        this.sendingStatusDate = sendingStatusDate;
        this.xLatitude = xLatitude;
        this.yLongitude = yLongitude;
        this.serverAnswerInfoId = serverAnswerInfoId;
        this.inputValuesDefault = inputValuesDefault;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getFormDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatusEn() {
        return statusEn;
    }

    public void setStatusEn(Integer statusEn) {
        this.statusEn = statusEn;
    }

    public Integer getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(Integer formStatus) {
        this.formStatus = formStatus;
    }

    public java.util.Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(java.util.Date statusDate) {
        this.statusDate = statusDate;
    }

    public Integer getSendingStatusEn() {
        return sendingStatusEn;
    }

    public void setSendingStatusEn(Integer sendingStatusEn) {
        this.sendingStatusEn = sendingStatusEn;
    }

    public java.util.Date getSendingStatusDate() {
        return sendingStatusDate;
    }

    public void setSendingStatusDate(java.util.Date sendingStatusDate) {
        this.sendingStatusDate = sendingStatusDate;
    }

    public String getXLatitude() {
        return xLatitude;
    }

    public void setXLatitude(String xLatitude) {
        this.xLatitude = xLatitude;
    }

    public String getYLongitude() {
        return yLongitude;
    }

    public void setYLongitude(String yLongitude) {
        this.yLongitude = yLongitude;
    }

    public Long getServerAnswerInfoId() {
        return serverAnswerInfoId;
    }

    public void setServerAnswerInfoId(Long serverAnswerInfoId) {
        this.serverAnswerInfoId = serverAnswerInfoId;
    }

    public String getInputValuesDefault() {
        return inputValuesDefault;
    }

    public void setInputValuesDefault(String inputValuesDefault) {
        this.inputValuesDefault = inputValuesDefault;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<FormQuestion> getFormQuestionList() {
        if (formQuestionList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FormQuestionDao targetDao = daoSession.getFormQuestionDao();
            List<FormQuestion> formQuestionListNew = targetDao._queryForm_FormQuestionList(id);
            synchronized (this) {
                if(formQuestionList == null) {
                    formQuestionList = formQuestionListNew;
                }
            }
        }
        return formQuestionList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetFormQuestionList() {
        formQuestionList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<FormAnswer> getFormAnswerList() {
        if (formAnswerList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FormAnswerDao targetDao = daoSession.getFormAnswerDao();
            List<FormAnswer> formAnswerListNew = targetDao._queryForm_FormAnswerList(id);
            synchronized (this) {
                if(formAnswerList == null) {
                    formAnswerList = formAnswerListNew;
                }
            }
        }
        return formAnswerList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetFormAnswerList() {
        formAnswerList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<FormQuestionGroup> getFormQuestionGroupList() {
        if (formQuestionGroupList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FormQuestionGroupDao targetDao = daoSession.getFormQuestionGroupDao();
            List<FormQuestionGroup> formQuestionGroupListNew = targetDao._queryForm_FormQuestionGroupList(id);
            synchronized (this) {
                if(formQuestionGroupList == null) {
                    formQuestionGroupList = formQuestionGroupListNew;
                }
            }
        }
        return formQuestionGroupList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetFormQuestionGroupList() {
        formQuestionGroupList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<FormTemp> getFormTempList() {
        if (formTempList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FormTempDao targetDao = daoSession.getFormTempDao();
            List<FormTemp> formTempListNew = targetDao._queryForm_FormTempList(id);
            synchronized (this) {
                if(formTempList == null) {
                    formTempList = formTempListNew;
                }
            }
        }
        return formTempList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetFormTempList() {
        formTempList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<FormQuestionGroupForm> getFormQuestionGroupFormId() {
        if (formQuestionGroupFormId == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FormQuestionGroupFormDao targetDao = daoSession.getFormQuestionGroupFormDao();
            List<FormQuestionGroupForm> formQuestionGroupFormIdNew = targetDao._queryForm_FormQuestionGroupFormId(id);
            synchronized (this) {
                if(formQuestionGroupFormId == null) {
                    formQuestionGroupFormId = formQuestionGroupFormIdNew;
                }
            }
        }
        return formQuestionGroupFormId;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetFormQuestionGroupFormId() {
        formQuestionGroupFormId = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
