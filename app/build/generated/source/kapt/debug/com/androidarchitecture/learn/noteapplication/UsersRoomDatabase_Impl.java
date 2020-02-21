package com.androidarchitecture.learn.noteapplication;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.kotlinpractice.UsermasterDao;
import com.example.kotlinpractice.UsermasterDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class UsersRoomDatabase_Impl extends UsersRoomDatabase {
  private volatile UsermasterDao _usermasterDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `UserMaster` (`id` TEXT NOT NULL, `Email` TEXT NOT NULL, `Password` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"a2aa8fae21753e9842d6fff142cd673e\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `UserMaster`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUserMaster = new HashMap<String, TableInfo.Column>(3);
        _columnsUserMaster.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsUserMaster.put("Email", new TableInfo.Column("Email", "TEXT", true, 0));
        _columnsUserMaster.put("Password", new TableInfo.Column("Password", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserMaster = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserMaster = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserMaster = new TableInfo("UserMaster", _columnsUserMaster, _foreignKeysUserMaster, _indicesUserMaster);
        final TableInfo _existingUserMaster = TableInfo.read(_db, "UserMaster");
        if (! _infoUserMaster.equals(_existingUserMaster)) {
          throw new IllegalStateException("Migration didn't properly handle UserMaster(com.example.kotlinpractice.UserEntity).\n"
                  + " Expected:\n" + _infoUserMaster + "\n"
                  + " Found:\n" + _existingUserMaster);
        }
      }
    }, "a2aa8fae21753e9842d6fff142cd673e", "90d8565233b90b373439a9e3e81d6456");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "UserMaster");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `UserMaster`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public UsermasterDao usermasterDao() {
    if (_usermasterDao != null) {
      return _usermasterDao;
    } else {
      synchronized(this) {
        if(_usermasterDao == null) {
          _usermasterDao = new UsermasterDao_Impl(this);
        }
        return _usermasterDao;
      }
    }
  }
}
