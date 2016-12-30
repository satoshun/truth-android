package com.github.satoshun.truth.android.api.widget;

import android.widget.CompoundButton;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class CompoundButtonSubject<S extends CompoundButtonSubject<S, T>, T extends CompoundButton>
    extends TextViewSubject<S, T> {

  public static final CompoundButtonSubjectFactory FACTORY = new CompoundButtonSubjectFactory();

  public CompoundButtonSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isChecked() {
    isNotNull();
    check().withFailureMessage("is checked")
        .that(actual().isChecked())
        .isTrue();
    return myself();
  }

  public S isNotChecked() {
    isNotNull();
    check().withFailureMessage("is not checked")
        .that(actual().isChecked())
        .isFalse();
    return myself();
  }

  private static class CompoundButtonSubjectImpl extends CompoundButtonSubject<CompoundButtonSubjectImpl, CompoundButton> {
    CompoundButtonSubjectImpl(FailureStrategy failureStrategy, CompoundButton actual) {
      super(failureStrategy, actual);
    }
  }

  private static class CompoundButtonSubjectFactory extends SubjectFactory<CompoundButtonSubjectImpl, CompoundButton> {
    @Override
    public CompoundButtonSubjectImpl getSubject(FailureStrategy fs, CompoundButton that) {
      return new CompoundButtonSubjectImpl(fs, that);
    }
  }
}
