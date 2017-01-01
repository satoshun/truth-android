package com.github.satoshun.truth.android.api.database;

import android.database.CursorWindow;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class CursorWindowSubject extends BaseSubject<CursorWindowSubject, CursorWindow> {

  public static final CursorWindowSubjectFactory FACTORY = new CursorWindowSubjectFactory();

  public CursorWindowSubject(FailureStrategy failureStrategy, CursorWindow actual) {
    super(failureStrategy, actual);
  }

  public CursorWindowSubject isRowCount(int count) {
    isNotNull();
    check().withFailureMessage("is row count")
        .that(actual().getNumRows())
        .isEqualTo(count);
    return this;
  }

  public CursorWindowSubject isStartPosition(int position) {
    isNotNull();
    check().withFailureMessage("is start position")
        .that(actual().getStartPosition())
        .isEqualTo(position);
    return this;
  }

  private static class CursorWindowSubjectFactory extends SubjectFactory<CursorWindowSubject, CursorWindow> {
    @Override
    public CursorWindowSubject getSubject(FailureStrategy fs, CursorWindow that) {
      return new CursorWindowSubject(fs, that);
    }
  }
}
