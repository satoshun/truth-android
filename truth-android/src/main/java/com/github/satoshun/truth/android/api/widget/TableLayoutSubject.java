package com.github.satoshun.truth.android.api.widget;

import android.widget.TableLayout;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class TableLayoutSubject extends LinearLayoutSubject<TableLayoutSubject, TableLayout> {

  public static final TableLayoutSubjectFactory FACTORY = new TableLayoutSubjectFactory();

  public TableLayoutSubject(FailureStrategy failureStrategy, TableLayout actual) {
    super(failureStrategy, actual);
  }

  public TableLayoutSubject isCollapsedColumn(int index) {
    isNotNull();
    check().withFailureMessage("is collapsed column")
        .that(actual().isColumnCollapsed(index))
        .isTrue();
    return this;
  }

  public TableLayoutSubject isNotCollapsedColumn(int index) {
    isNotNull();
    check().withFailureMessage("is not collapsed column")
        .that(actual().isColumnCollapsed(index))
        .isFalse();
    return this;
  }

  public TableLayoutSubject isShrinkableColumn(int index) {
    isNotNull();
    check().withFailureMessage("is shrinkable column")
        .that(actual().isColumnShrinkable(index))
        .isTrue();
    return this;
  }

  public TableLayoutSubject isNotShrinkableColumn(int index) {
    isNotNull();
    check().withFailureMessage("is not shrinkable column")
        .that(actual().isColumnShrinkable(index))
        .isFalse();
    return this;
  }

  public TableLayoutSubject isStretchableColumn(int index) {
    isNotNull();
    check().withFailureMessage("is stretchable column")
        .that(actual().isColumnStretchable(index))
        .isTrue();
    return this;
  }

  public TableLayoutSubject isNotStretchableColumn(int index) {
    isNotNull();
    check().withFailureMessage("is not stretchable column")
        .that(actual().isColumnStretchable(index))
        .isFalse();
    return this;
  }

  private static class TableLayoutSubjectFactory extends SubjectFactory<TableLayoutSubject, TableLayout> {
    @Override
    public TableLayoutSubject getSubject(FailureStrategy fs, TableLayout that) {
      return new TableLayoutSubject(fs, that);
    }
  }
}
