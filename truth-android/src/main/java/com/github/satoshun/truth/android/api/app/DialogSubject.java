package com.github.satoshun.truth.android.api.app;


import android.app.Dialog;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class DialogSubject<S extends DialogSubject<S, T>, T extends Dialog>
    extends BaseSubject<S, T> {

  public static final DialogSubjectFactory FACTORY = new DialogSubjectFactory();

  public DialogSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isShowing() {
    isNotNull();
    check().withFailureMessage("is showing")
        .that(actual().isShowing())
        .isTrue();
    return myself();
  }

  public S isNotShowing() {
    isNotNull();
    check().withFailureMessage("is not showing")
        .that(actual().isShowing())
        .isFalse();
    return myself();
  }

  private static class DialogSubjectImpl extends DialogSubject<DialogSubjectImpl, Dialog> {
    DialogSubjectImpl(FailureStrategy failureStrategy, Dialog actual) {
      super(failureStrategy, actual);
    }
  }

  private static class DialogSubjectFactory extends SubjectFactory<DialogSubjectImpl, Dialog> {
    @Override
    public DialogSubjectImpl getSubject(FailureStrategy fs, Dialog that) {
      return new DialogSubjectImpl(fs, that);
    }
  }
}
