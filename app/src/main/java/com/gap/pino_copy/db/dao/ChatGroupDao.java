package com.gap.pino_copy.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.gap.pino_copy.db.objectmodel.ChatGroup;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CHAT_GROUP".
*/
public class ChatGroupDao extends AbstractDao<ChatGroup, Long> {

    public static final String TABLENAME = "CHAT_GROUP";

    /**
     * Properties of entity ChatGroup.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ServerGroupId = new Property(1, Long.class, "serverGroupId", false, "SERVER_GROUP_ID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property MaxMember = new Property(3, Integer.class, "maxMember", false, "MAX_MEMBER");
        public final static Property NotifyAct = new Property(4, Boolean.class, "notifyAct", false, "NOTIFY_ACT");
        public final static Property PrivateIs = new Property(5, Boolean.class, "privateIs", false, "PRIVATE_IS");
        public final static Property StatusEn = new Property(6, Integer.class, "statusEn", false, "STATUS_EN");
    }

    private DaoSession daoSession;


    public ChatGroupDao(DaoConfig config) {
        super(config);
    }
    
    public ChatGroupDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CHAT_GROUP\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"SERVER_GROUP_ID\" INTEGER," + // 1: serverGroupId
                "\"NAME\" TEXT," + // 2: name
                "\"MAX_MEMBER\" INTEGER," + // 3: maxMember
                "\"NOTIFY_ACT\" INTEGER," + // 4: notifyAct
                "\"PRIVATE_IS\" INTEGER," + // 4: PrivateIs
                "\"STATUS_EN\" INTEGER);"); // 5: statusEn
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CHAT_GROUP\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ChatGroup entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long serverGroupId = entity.getServerGroupId();
        if (serverGroupId != null) {
            stmt.bindLong(2, serverGroupId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        Integer maxMember = entity.getMaxMember();
        if (maxMember != null) {
            stmt.bindLong(4, maxMember);
        }
 
        Boolean notifyAct = entity.getNotifyAct();
        if (notifyAct != null) {
            stmt.bindLong(5, notifyAct ? 1L: 0L);
        }

        Boolean privateIs = entity.getPrivateIs();
        if (privateIs != null) {
            stmt.bindLong(6, privateIs ? 1L: 0L);
        }
 
        Integer statusEn = entity.getStatusEn();
        if (statusEn != null) {
            stmt.bindLong(7, statusEn);
        }
    }

    @Override
    protected void attachEntity(ChatGroup entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ChatGroup readEntity(Cursor cursor, int offset) {
        ChatGroup entity = new ChatGroup( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // serverGroupId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // maxMember
            cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0, // notifyAct
            cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0, // PrivateIs
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6) // statusEn
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ChatGroup entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setServerGroupId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMaxMember(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setNotifyAct(cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0);
        entity.setPrivateIs(cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0);
        entity.setStatusEn(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ChatGroup entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ChatGroup entity) {
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
