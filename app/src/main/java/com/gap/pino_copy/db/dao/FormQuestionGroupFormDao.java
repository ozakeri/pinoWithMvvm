package com.gap.pino_copy.db.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.gap.pino_copy.db.objectmodel.FormQuestionGroupForm;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "FORM_QUESTION_GROUP_FORM".
*/
public class FormQuestionGroupFormDao extends AbstractDao<FormQuestionGroupForm, Long> {

    public static final String TABLENAME = "FORM_QUESTION_GROUP_FORM";

    /**
     * Properties of entity FormQuestionGroupForm.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property GroupName = new Property(1, String.class, "groupName", false, "GROUP_NAME");
        public final static Property FormId = new Property(2, long.class, "formId", false, "FORM_ID");
        public final static Property FormQuestionGroupId = new Property(3, long.class, "formQuestionGroupId", false, "FORM_QUESTION_GROUP_ID");
    };

    private Query<FormQuestionGroupForm> form_FormQuestionGroupFormIdQuery;
    private Query<FormQuestionGroupForm> formQuestionGroup_FormQuestionGroupFormIdQuery;

    public FormQuestionGroupFormDao(DaoConfig config) {
        super(config);
    }
    
    public FormQuestionGroupFormDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FORM_QUESTION_GROUP_FORM\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"GROUP_NAME\" TEXT," + // 1: groupName
                "\"FORM_ID\" INTEGER NOT NULL ," + // 2: formId
                "\"FORM_QUESTION_GROUP_ID\" INTEGER NOT NULL );"); // 3: formQuestionGroupId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FORM_QUESTION_GROUP_FORM\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, FormQuestionGroupForm entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String groupName = entity.getGroupName();
        if (groupName != null) {
            stmt.bindString(2, groupName);
        }
        stmt.bindLong(3, entity.getFormId());
        stmt.bindLong(4, entity.getFormQuestionGroupId());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public FormQuestionGroupForm readEntity(Cursor cursor, int offset) {
        FormQuestionGroupForm entity = new FormQuestionGroupForm( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // groupName
            cursor.getLong(offset + 2), // formId
            cursor.getLong(offset + 3) // formQuestionGroupId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, FormQuestionGroupForm entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setGroupName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFormId(cursor.getLong(offset + 2));
        entity.setFormQuestionGroupId(cursor.getLong(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(FormQuestionGroupForm entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(FormQuestionGroupForm entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "formQuestionGroupFormId" to-many relationship of Form. */
    public List<FormQuestionGroupForm> _queryForm_FormQuestionGroupFormId(long formId) {
        synchronized (this) {
            if (form_FormQuestionGroupFormIdQuery == null) {
                QueryBuilder<FormQuestionGroupForm> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.FormId.eq(null));
                form_FormQuestionGroupFormIdQuery = queryBuilder.build();
            }
        }
        Query<FormQuestionGroupForm> query = form_FormQuestionGroupFormIdQuery.forCurrentThread();
        query.setParameter(0, formId);
        return query.list();
    }

    /** Internal query to resolve the "formQuestionGroupFormId" to-many relationship of FormQuestionGroup. */
    public List<FormQuestionGroupForm> _queryFormQuestionGroup_FormQuestionGroupFormId(long formQuestionGroupId) {
        synchronized (this) {
            if (formQuestionGroup_FormQuestionGroupFormIdQuery == null) {
                QueryBuilder<FormQuestionGroupForm> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.FormQuestionGroupId.eq(null));
                formQuestionGroup_FormQuestionGroupFormIdQuery = queryBuilder.build();
            }
        }
        Query<FormQuestionGroupForm> query = formQuestionGroup_FormQuestionGroupFormIdQuery.forCurrentThread();
        query.setParameter(0, formQuestionGroupId);
        return query.list();
    }

}
