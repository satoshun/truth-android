package com.github.satoshun.truth.android.api.app;

import android.app.ExpandableListActivity;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class ExpandableListActivitySubject extends ActivitySubject<ExpandableListActivitySubject, ExpandableListActivity> {

  public static final ExpandableListActivitySubjectFactory FACTORY = new ExpandableListActivitySubjectFactory();

  public ExpandableListActivitySubject(FailureStrategy failureStrategy, ExpandableListActivity actual) {
    super(failureStrategy, actual);
  }

  public ExpandableListActivitySubject isSelectedId(long id) {
    isNotNull();
    check().withFailureMessage("is selected id")
        .that(actual().getSelectedId())
        .isEqualTo(id);
    return this;
  }

  public ExpandableListActivitySubject isSelectedPosition(long position) {
    isNotNull();
    check().withFailureMessage("is selected position")
        .that(actual().getSelectedPosition())
        .isEqualTo(position);
    return this;
  }

  private static class ExpandableListActivitySubjectFactory extends SubjectFactory<ExpandableListActivitySubject, ExpandableListActivity> {
    @Override
    public ExpandableListActivitySubject getSubject(FailureStrategy fs, ExpandableListActivity that) {
      return new ExpandableListActivitySubject(fs, that);
    }
  }
}
