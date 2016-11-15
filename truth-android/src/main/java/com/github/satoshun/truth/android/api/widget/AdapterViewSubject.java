package com.github.satoshun.truth.android.api.widget;

import android.widget.AdapterView;

import com.github.satoshun.truth.android.api.view.ViewGroupSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Propositions for AdapterView subject
 */
public abstract class AdapterViewSubject<S extends ViewGroupSubject<S, T>, T extends AdapterView> extends ViewGroupSubject<S, T> {

  public static final AdapterViewSubjectFactory FACTORY = new AdapterViewSubjectFactory();

  AdapterViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  private static class AdapterViewSubjectImpl extends AdapterViewSubject<AdapterViewSubjectImpl, AdapterView> {
    AdapterViewSubjectImpl(FailureStrategy failureStrategy, AdapterView actual) {
      super(failureStrategy, actual);
    }
  }

  private static class AdapterViewSubjectFactory extends SubjectFactory<AdapterViewSubjectImpl, AdapterView> {
    @Override
    public AdapterViewSubjectImpl getSubject(FailureStrategy fs, AdapterView that) {
      return new AdapterViewSubjectImpl(fs, that);
    }
  }
}
