package com.gap.pino_copy.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.gap.pino_copy.db.objectmodel.AttachFile;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ATTACH_FILE".
*/
public class AttachFileDao extends AbstractDao<AttachFile, Long> {

    public static final String TABLENAME = "ATTACH_FILE";

    /**
     * Properties of entity AttachFile.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property AttachFileLocalPath = new Property(1, String.class, "attachFileLocalPath", false, "ATTACH_FILE_LOCAL_PATH");
        public final static Property AttachFileUserFileName = new Property(2, String.class, "attachFileUserFileName", false, "ATTACH_FILE_USER_FILE_NAME");
        public final static Property AttachFileRemoteUrl = new Property(3, String.class, "attachFileRemoteUrl", false, "ATTACH_FILE_REMOTE_URL");
        public final static Property DateCreation = new Property(4, java.util.Date.class, "dateCreation", false, "DATE_CREATION");
        public final static Property SendingStatusEn = new Property(5, Integer.class, "sendingStatusEn", false, "SENDING_STATUS_EN");
        public final static Property SendingStatusDate = new Property(6, java.util.Date.class, "sendingStatusDate", false, "SENDING_STATUS_DATE");
        public final static Property AttachFileSize = new Property(7, Integer.class, "attachFileSize", false, "ATTACH_FILE_SIZE");
        public final static Property AttachFileSentSize = new Property(8, Integer.class, "attachFileSentSize", false, "ATTACH_FILE_SENT_SIZE");
        public final static Property AttachFileReceivedSize = new Property(9, Integer.class, "attachFileReceivedSize", false, "ATTACH_FILE_RECEIVED_SIZE");
        public final static Property EntityNameEn = new Property(10, Integer.class, "entityNameEn", false, "ENTITY_NAME_EN");
        public final static Property EntityId = new Property(11, Long.class, "entityId", false, "ENTITY_ID");
        public final static Property ServerAttachFileId = new Property(12, Long.class, "serverAttachFileId", false, "SERVER_ATTACH_FILE_ID");
        public final static Property ServerEntityId = new Property(13, Long.class, "serverEntityId", false, "SERVER_ENTITY_ID");
        public final static Property ServerAttachFileSettingId = new Property(14, Long.class, "serverAttachFileSettingId", false, "SERVER_ATTACH_FILE_SETTING_ID");
    };


    public AttachFileDao(DaoConfig config) {
        super(config);
    }
    
    public AttachFileDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ATTACH_FILE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ATTACH_FILE_LOCAL_PATH\" TEXT," + // 1: attachFileLocalPath
                "\"ATTACH_FILE_USER_FILE_NAME\" TEXT," + // 2: attachFileUserFileName
                "\"ATTACH_FILE_REMOTE_URL\" TEXT," + // 3: attachFileRemoteUrl
                "\"DATE_CREATION\" INTEGER," + // 4: dateCreation
                "\"SENDING_STATUS_EN\" INTEGER," + // 5: sendingStatusEn
                "\"SENDING_STATUS_DATE\" INTEGER," + // 6: sendingStatusDate
                "\"ATTACH_FILE_SIZE\" INTEGER," + // 7: attachFileSize
                "\"ATTACH_FILE_SENT_SIZE\" INTEGER," + // 8: attachFileSentSize
                "\"ATTACH_FILE_RECEIVED_SIZE\" INTEGER," + // 9: attachFileReceivedSize
                "\"ENTITY_NAME_EN\" INTEGER," + // 10: entityNameEn
                "\"ENTITY_ID\" INTEGER," + // 11: entityId
                "\"SERVER_ATTACH_FILE_ID\" INTEGER," + // 12: serverAttachFileId
                "\"SERVER_ENTITY_ID\" INTEGER," + // 13: serverEntityId
                "\"SERVER_ATTACH_FILE_SETTING_ID\" INTEGER);"); // 14: serverAttachFileSettingId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ATTACH_FILE\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, AttachFile entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String attachFileLocalPath = entity.getAttachFileLocalPath();
        if (attachFileLocalPath != null) {
            stmt.bindString(2, attachFileLocalPath);
        }
 
        String attachFileUserFileName = entity.getAttachFileUserFileName();
        if (attachFileUserFileName != null) {
            stmt.bindString(3, attachFileUserFileName);
        }
 
        String attachFileRemoteUrl = entity.getAttachFileRemoteUrl();
        if (attachFileRemoteUrl != null) {
            stmt.bindString(4, attachFileRemoteUrl);
        }
 
        java.util.Date dateCreation = entity.getDateCreation();
        if (dateCreation != null) {
            stmt.bindLong(5, dateCreation.getTime());
        }
 
        Integer sendingStatusEn = entity.getSendingStatusEn();
        if (sendingStatusEn != null) {
            stmt.bindLong(6, sendingStatusEn);
        }
 
        java.util.Date sendingStatusDate = entity.getSendingStatusDate();
        if (sendingStatusDate != null) {
            stmt.bindLong(7, sendingStatusDate.getTime());
        }
 
        Integer attachFileSize = entity.getAttachFileSize();
        if (attachFileSize != null) {
            stmt.bindLong(8, attachFileSize);
        }
 
        Integer attachFileSentSize = entity.getAttachFileSentSize();
        if (attachFileSentSize != null) {
            stmt.bindLong(9, attachFileSentSize);
        }
 
        Integer attachFileReceivedSize = entity.getAttachFileReceivedSize();
        if (attachFileReceivedSize != null) {
            stmt.bindLong(10, attachFileReceivedSize);
        }
 
        Integer entityNameEn = entity.getEntityNameEn();
        if (entityNameEn != null) {
            stmt.bindLong(11, entityNameEn);
        }
 
        Long entityId = entity.getEntityId();
        if (entityId != null) {
            stmt.bindLong(12, entityId);
        }
 
        Long serverAttachFileId = entity.getServerAttachFileId();
        if (serverAttachFileId != null) {
            stmt.bindLong(13, serverAttachFileId);
        }
 
        Long serverEntityId = entity.getServerEntityId();
        if (serverEntityId != null) {
            stmt.bindLong(14, serverEntityId);
        }
 
        Long serverAttachFileSettingId = entity.getServerAttachFileSettingId();
        if (serverAttachFileSettingId != null) {
            stmt.bindLong(15, serverAttachFileSettingId);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public AttachFile readEntity(Cursor cursor, int offset) {
        AttachFile entity = new AttachFile( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // attachFileLocalPath
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // attachFileUserFileName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // attachFileRemoteUrl
            cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)), // dateCreation
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // sendingStatusEn
            cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)), // sendingStatusDate
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // attachFileSize
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // attachFileSentSize
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9), // attachFileReceivedSize
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // entityNameEn
            cursor.isNull(offset + 11) ? null : cursor.getLong(offset + 11), // entityId
            cursor.isNull(offset + 12) ? null : cursor.getLong(offset + 12), // serverAttachFileId
            cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13), // serverEntityId
            cursor.isNull(offset + 14) ? null : cursor.getLong(offset + 14) // serverAttachFileSettingId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, AttachFile entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAttachFileLocalPath(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAttachFileUserFileName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAttachFileRemoteUrl(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDateCreation(cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)));
        entity.setSendingStatusEn(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setSendingStatusDate(cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)));
        entity.setAttachFileSize(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setAttachFileSentSize(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
        entity.setAttachFileReceivedSize(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
        entity.setEntityNameEn(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setEntityId(cursor.isNull(offset + 11) ? null : cursor.getLong(offset + 11));
        entity.setServerAttachFileId(cursor.isNull(offset + 12) ? null : cursor.getLong(offset + 12));
        entity.setServerEntityId(cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13));
        entity.setServerAttachFileSettingId(cursor.isNull(offset + 14) ? null : cursor.getLong(offset + 14));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(AttachFile entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(AttachFile entity) {
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
    
}
