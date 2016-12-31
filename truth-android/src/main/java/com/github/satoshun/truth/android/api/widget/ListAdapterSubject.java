package com.github.satoshun.truth.android.api.widget;

import android.widget.ListAdapter;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class ListAdapterSubject<S extends ListAdapterSubject<S, T>, T extends ListAdapter>
    extends AdapterSubject<S, T> {

  public static final ListAdapterSubjectFactory FACTORY = new ListAdapterSubjectFactory();

  public ListAdapterSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isAllItemsEnabled() {
    isNotNull();
    check().withFailureMessage("is all items enabled")
        .that(actual().areAllItemsEnabled())
        .isTrue();
    return myself();
  }

  public S isAllItemsDisabled() {
    isNotNull();
    check().withFailureMessage("is all items disabled")
        .that(actual().areAllItemsEnabled())
        .isFalse();
    return myself();
  }

  private static class ListAdapterSubjectImpl extends ListAdapterSubject<ListAdapterSubjectImpl, ListAdapter> {
    ListAdapterSubjectImpl(FailureStrategy failureStrategy, ListAdapter actual) {
      super(failureStrategy, actual);
    }
  }

  private static class ListAdapterSubjectFactory extends SubjectFactory<ListAdapterSubjectImpl, ListAdapter> {
    @Override
    public ListAdapterSubjectImpl getSubject(FailureStrategy fs, ListAdapter that) {
      return new ListAdapterSubjectImpl(fs, that);
    }
  }
}
