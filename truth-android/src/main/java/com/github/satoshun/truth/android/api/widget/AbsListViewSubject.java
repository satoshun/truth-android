package com.github.satoshun.truth.android.api.widget;

import android.widget.AbsListView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Propositions for AbsListView subject
 */
public abstract class AbsListViewSubject<S extends AbsListViewSubject<S, T>, T extends AbsListView> extends AdapterViewSubject<S, T> {

  public static final AbsListViewSubjectFactory FACTORY = new AbsListViewSubjectFactory();

  AbsListViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  private static class AbsListViewSubjectImpl extends AbsListViewSubject<AbsListViewSubjectImpl, AbsListView> {
    AbsListViewSubjectImpl(FailureStrategy failureStrategy, AbsListView actual) {
      super(failureStrategy, actual);
    }
  }

  private static class AbsListViewSubjectFactory extends SubjectFactory<AbsListViewSubjectImpl, AbsListView> {
    @Override
    public AbsListViewSubjectImpl getSubject(FailureStrategy fs, AbsListView that) {
      return new AbsListViewSubjectImpl(fs, that);
    }
  }
}
