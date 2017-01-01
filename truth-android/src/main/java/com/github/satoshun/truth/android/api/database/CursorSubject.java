package com.github.satoshun.truth.android.api.database;

import android.database.Cursor;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.util.Arrays;

public class CursorSubject extends BaseSubject<CursorSubject, Cursor> {

  public static final CursorSubjectFactory FACTORY = new CursorSubjectFactory();

  public CursorSubject(FailureStrategy failureStrategy, Cursor actual) {
    super(failureStrategy, actual);
  }

  public CursorSubject isColumnCount(int count) {
    isNotNull();
    check().withFailureMessage("is column count")
        .that(actual().getColumnCount())
        .isEqualTo(count);
    return this;
  }

  public CursorSubject hasColumn(String name) {
    isNotNull();
    check().withFailureMessage("has column")
        .that(actual().getColumnNames())
        .asList().contains(name);
    return this;
  }

  public CursorSubject hasColumns(String... names) {
    isNotNull();
    check().withFailureMessage("has columns")
        .that(actual().getColumnNames())
        .isIn(Arrays.asList(names));
    return this;
  }

  public CursorSubject isCount(int count) {
    isNotNull();
    check().withFailureMessage("is count")
        .that(actual().getCount())
        .isEqualTo(count);
    return this;
  }

  public CursorSubject isPosition(int position) {
    isNotNull();
    check().withFailureMessage("is position")
        .that(actual().getPosition())
        .isEqualTo(position);
    return this;
  }

  public CursorSubject isAfterLast() {
    isNotNull();
    check().withFailureMessage("is after last")
        .that(actual().isAfterLast())
        .isTrue();
    return this;
  }

  public CursorSubject isNotAfterLast() {
    isNotNull();
    check().withFailureMessage("is not after last")
        .that(actual().isAfterLast())
        .isFalse();
    return this;
  }

  public CursorSubject isBeforeFirst() {
    isNotNull();
    check().withFailureMessage("is before first")
        .that(actual().isBeforeFirst())
        .isTrue();
    return this;
  }

  public CursorSubject isNotBeforeFirst() {
    isNotNull();
    check().withFailureMessage("is not before first")
        .that(actual().isBeforeFirst())
        .isFalse();
    return this;
  }

  public CursorSubject isClosed() {
    isNotNull();
    check().withFailureMessage("is closed")
        .that(actual().isClosed())
        .isTrue();
    return this;
  }

  public CursorSubject isNotClosed() {
    isNotNull();
    check().withFailureMessage("is not closed")
        .that(actual().isClosed())
        .isFalse();
    return this;
  }

  public CursorSubject isFirst() {
    isNotNull();
    check().withFailureMessage("is first")
        .that(actual().isFirst())
        .isTrue();
    return this;
  }

  public CursorSubject isNotFirst() {
    isNotNull();
    check().withFailureMessage("is not first")
        .that(actual().isFirst())
        .isFalse();
    return this;
  }

  public CursorSubject isLast() {
    isNotNull();
    check().withFailureMessage("is last")
        .that(actual().isLast())
        .isTrue();
    return this;
  }

  public CursorSubject isNotLast() {
    isNotNull();
    check().withFailureMessage("is not last")
        .that(actual().isLast())
        .isFalse();
    return this;
  }

  private static class CursorSubjectFactory extends SubjectFactory<CursorSubject, Cursor> {
    @Override
    public CursorSubject getSubject(FailureStrategy fs, Cursor that) {
      return new CursorSubject(fs, that);
    }
  }
}
