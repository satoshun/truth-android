package com.github.satoshun.truth.android.api.widget;


import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class WrapperListAdapterSubject<S extends WrapperListAdapterSubject<S, T>, T extends WrapperListAdapter>
    extends ListAdapterSubject<S, T> {

  public static final WrapperListAdapterSubjectFactory FACTORY = new WrapperListAdapterSubjectFactory();

  public WrapperListAdapterSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isWrappedAdapter(ListAdapter adapter) {
    isNotNull();
    check().withFailureMessage("is wrapped adapter")
        .that(actual().getWrappedAdapter())
        .isSameAs(adapter);
    return myself();
  }

  private static class WrapperListAdapterSubjectImpl extends WrapperListAdapterSubject<WrapperListAdapterSubjectImpl, WrapperListAdapter> {
    WrapperListAdapterSubjectImpl(FailureStrategy failureStrategy, WrapperListAdapter actual) {
      super(failureStrategy, actual);
    }
  }

  private static class WrapperListAdapterSubjectFactory extends SubjectFactory<WrapperListAdapterSubjectImpl, WrapperListAdapter> {
    @Override
    public WrapperListAdapterSubjectImpl getSubject(FailureStrategy fs, WrapperListAdapter that) {
      return new WrapperListAdapterSubjectImpl(fs, that);
    }
  }
}
