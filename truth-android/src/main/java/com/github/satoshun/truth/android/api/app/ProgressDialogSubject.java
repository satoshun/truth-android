package com.github.satoshun.truth.android.api.app;

import android.app.ProgressDialog;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class ProgressDialogSubject extends DialogSubject<ProgressDialogSubject, ProgressDialog> {

  public static final ProgressDialogSubjectFactory FACTORY = new ProgressDialogSubjectFactory();

  public ProgressDialogSubject(FailureStrategy failureStrategy, ProgressDialog actual) {
    super(failureStrategy, actual);
  }

  public ProgressDialogSubject isMax(int max) {
    isNotNull();
    check().withFailureMessage("is max")
        .that(actual().getMax())
        .isEqualTo(max);
    return this;
  }

  public ProgressDialogSubject isProgress(int progress) {
    isNotNull();
    check().withFailureMessage("is progress")
        .that(actual().getProgress())
        .isEqualTo(progress);
    return this;
  }

  public ProgressDialogSubject isSecondaryProgress(int progress) {
    isNotNull();
    check().withFailureMessage("is secondary progress")
        .that(actual().getSecondaryProgress())
        .isEqualTo(progress);
    return this;
  }

  public ProgressDialogSubject isIndeterminate() {
    isNotNull();
    check().withFailureMessage("is indeterminate")
        .that(actual().isIndeterminate())
        .isTrue();
    return this;
  }

  public ProgressDialogSubject isDeterminate() {
    isNotNull();
    check().withFailureMessage("is determinate")
        .that(actual().isIndeterminate())
        .isFalse();
    return this;
  }

  private static class ProgressDialogSubjectFactory extends SubjectFactory<ProgressDialogSubject, ProgressDialog> {
    @Override
    public ProgressDialogSubject getSubject(FailureStrategy fs, ProgressDialog that) {
      return new ProgressDialogSubject(fs, that);
    }
  }
}
