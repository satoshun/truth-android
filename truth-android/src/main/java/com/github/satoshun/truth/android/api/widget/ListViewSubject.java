package com.github.satoshun.truth.android.api.widget;

import android.widget.ListView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Propositions for ListView subject
 */
public class ListViewSubject<S extends ListViewSubject<S, T>, T extends ListView> extends AbsListViewSubject<S, T> {

  public static final ListViewSubjectFactory FACTORY = new ListViewSubjectFactory();

  ListViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  private static class ListViewSubjectImpl extends ListViewSubject<ListViewSubjectImpl, ListView> {
    ListViewSubjectImpl(FailureStrategy failureStrategy, ListView actual) {
      super(failureStrategy, actual);
    }
  }

  private static class ListViewSubjectFactory extends SubjectFactory<ListViewSubjectImpl, ListView> {
    @Override
    public ListViewSubjectImpl getSubject(FailureStrategy fs, ListView that) {
      return new ListViewSubjectImpl(fs, that);
    }
  }
}
