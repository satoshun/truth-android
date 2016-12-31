package com.github.satoshun.truth.android.api.widget;


import android.widget.AbsSpinner;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class AbsSpinnerSubject<S extends AbsSpinnerSubject<S, T>, T extends AbsSpinner>
    extends AdapterViewSubject<S, T> {

  public static final SpinnerSubjectFactory FACTORY = new SpinnerSubjectFactory();

  public AbsSpinnerSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isAdapter(SpinnerAdapter adapter) {
    isNotNull();
    check().withFailureMessage("is adapter")
        .that(actual().getAdapter())
        .isSameAs(adapter);
    return myself();
  }

  private static class SpinnerSubjectImpl extends AbsSpinnerSubject<SpinnerSubjectImpl, Spinner> {
    SpinnerSubjectImpl(FailureStrategy failureStrategy, Spinner actual) {
      super(failureStrategy, actual);
    }
  }

  private static class SpinnerSubjectFactory extends SubjectFactory<SpinnerSubjectImpl, Spinner> {
    @Override
    public SpinnerSubjectImpl getSubject(FailureStrategy fs, Spinner that) {
      return new SpinnerSubjectImpl(fs, that);
    }
  }
}
