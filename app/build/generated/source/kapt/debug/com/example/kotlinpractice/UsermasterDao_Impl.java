package com.example.kotlinpractice;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unchecked")
public final class UsermasterDao_Impl implements UsermasterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUserEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUserEntity;

  public UsermasterDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserEntity = new EntityInsertionAdapter<UserEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `UserMaster`(`id`,`Email`,`Password`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
      }
    };
    this.__updateAdapterOfUserEntity = new EntityDeletionOrUpdateAdapter<UserEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `UserMaster` SET `id` = ?,`Email` = ?,`Password` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
        if (value.getId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getId());
        }
      }
    };
  }

  @Override
  public void insert(UserEntity userEntity) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserEntity.insert(userEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(UserEntity userEntity) {
    __db.beginTransaction();
    try {
      __updateAdapterOfUserEntity.handle(userEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }
}
