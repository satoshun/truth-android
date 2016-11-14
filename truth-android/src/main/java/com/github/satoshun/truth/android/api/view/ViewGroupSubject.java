package com.github.satoshun.truth.android.api.view;

import android.view.ViewGroup;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Propositions for ViewGroup subject
 */
public abstract class ViewGroupSubject<S extends ViewGroupSubject<S, T>, T extends ViewGroup> extends ViewSubject<S, T> {

  public static final ViewGroupSubjectFactory FACTORY = new ViewGroupSubjectFactory();

  public ViewGroupSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  private static class ViewGroupSubjectImpl extends ViewGroupSubject<ViewGroupSubjectImpl, ViewGroup> {
    ViewGroupSubjectImpl(FailureStrategy failureStrategy, ViewGroup actual) {
      super(failureStrategy, actual);
    }
  }

  private static class ViewGroupSubjectFactory extends SubjectFactory<ViewGroupSubjectImpl, ViewGroup> {
    @Override
    public ViewGroupSubjectImpl getSubject(FailureStrategy fs, ViewGroup that) {
      return new ViewGroupSubjectImpl(fs, that);
    }
  }
}
