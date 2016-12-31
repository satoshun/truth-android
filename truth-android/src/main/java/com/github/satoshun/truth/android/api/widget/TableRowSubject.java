package com.github.satoshun.truth.android.api.widget;

import android.widget.TableRow;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class TableRowSubject extends LinearLayoutSubject<TableRowSubject, TableRow> {

  public static final TableRowSubjectFactory FACTORY = new TableRowSubjectFactory();

  public TableRowSubject(FailureStrategy failureStrategy, TableRow actual) {
    super(failureStrategy, actual);
  }

  public TableRowSubject isVirtualChildCount(int count) {
    isNotNull();
    check().withFailureMessage("is virtual child count")
        .that(actual().getVirtualChildCount())
        .isEqualTo(count);
    return this;
  }

  private static class TableRowSubjectFactory extends SubjectFactory<TableRowSubject, TableRow> {
    @Override
    public TableRowSubject getSubject(FailureStrategy fs, TableRow that) {
      return new TableRowSubject(fs, that);
    }
  }
}
