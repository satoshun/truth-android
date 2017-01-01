package com.github.satoshun.truth.android.api.database.sqlite;

import android.annotation.TargetApi;
import android.database.sqlite.SQLiteDatabase;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public class SQLiteDatabaseSubject extends BaseSubject<SQLiteDatabaseSubject, SQLiteDatabase> {

  public static final SQLiteDatabaseSubjectFactory FACTORY = new SQLiteDatabaseSubjectFactory();

  public SQLiteDatabaseSubject(FailureStrategy failureStrategy, SQLiteDatabase actual) {
    super(failureStrategy, actual);
  }

  public SQLiteDatabaseSubject isMaximumSize(long size) {
    isNotNull();
    check().withFailureMessage("is maximum size")
        .that(actual().getMaximumSize())
        .isEqualTo(size);
    return this;
  }

  public SQLiteDatabaseSubject isPageSize(long size) {
    isNotNull();
    check().withFailureMessage("is page size")
        .that(actual().getPageSize())
        .isEqualTo(size);
    return this;
  }

  public SQLiteDatabaseSubject isPath(String path) {
    isNotNull();
    check().withFailureMessage("is path")
        .that(actual().getPath())
        .isEqualTo(path);
    return this;
  }

  public SQLiteDatabaseSubject isVersion(int version) {
    isNotNull();
    check().withFailureMessage("is version")
        .that(actual().getVersion())
        .isEqualTo(version);
    return this;
  }

  public SQLiteDatabaseSubject isInTransaction() {
    isNotNull();
    check().withFailureMessage("is in transaction")
        .that(actual().inTransaction())
        .isTrue();
    return this;
  }

  public SQLiteDatabaseSubject isNotInTransaction() {
    isNotNull();
    check().withFailureMessage("is not in transaction")
        .that(actual().inTransaction())
        .isFalse();
    return this;
  }

  @TargetApi(HONEYCOMB)
  public SQLiteDatabaseSubject isDatabaseIntegrityOk() {
    isNotNull();
    check().withFailureMessage("is database integrity ok")
        .that(actual().isDatabaseIntegrityOk())
        .isTrue();
    return this;
  }

  @TargetApi(HONEYCOMB)
  public SQLiteDatabaseSubject isDatabaseIntegrityNotOk() {
    isNotNull();
    check().withFailureMessage("is database integrity not ok")
        .that(actual().isDatabaseIntegrityOk())
        .isFalse();
    return this;
  }

  public SQLiteDatabaseSubject isLockedByCurrentThread() {
    isNotNull();
    check().withFailureMessage("is locked by current thread")
        .that(actual().isDbLockedByCurrentThread())
        .isTrue();
    return this;
  }

  public SQLiteDatabaseSubject isNotLockedByCurrentThread() {
    isNotNull();
    check().withFailureMessage("is not locked by current thread")
        .that(actual().isDbLockedByCurrentThread())
        .isFalse();
    return this;
  }

  public SQLiteDatabaseSubject isOpen() {
    isNotNull();
    check().withFailureMessage("is open")
        .that(actual().isOpen())
        .isTrue();
    return this;
  }

  public SQLiteDatabaseSubject isNotOpen() {
    isNotNull();
    check().withFailureMessage("is not open")
        .that(actual().isOpen())
        .isFalse();
    return this;
  }

  public SQLiteDatabaseSubject isReadOnly() {
    isNotNull();
    check().withFailureMessage("is read only")
        .that(actual().isReadOnly())
        .isTrue();
    return this;
  }

  public SQLiteDatabaseSubject isNotReadOnly() {
    isNotNull();
    check().withFailureMessage("is not read only")
        .that(actual().isReadOnly())
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SQLiteDatabaseSubject isWriteAheadLoggingEnabled() {
    isNotNull();
    check().withFailureMessage("is write ahead logging enabled")
        .that(actual().isWriteAheadLoggingEnabled())
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SQLiteDatabaseSubject isWriteAheadLoggingDisabled() {
    isNotNull();
    check().withFailureMessage("is write ahead logging disbled")
        .that(actual().isWriteAheadLoggingEnabled())
        .isFalse();
    return this;
  }

  private static class SQLiteDatabaseSubjectFactory extends SubjectFactory<SQLiteDatabaseSubject, SQLiteDatabase> {
    @Override
    public SQLiteDatabaseSubject getSubject(FailureStrategy fs, SQLiteDatabase that) {
      return new SQLiteDatabaseSubject(fs, that);
    }
  }
}
