package com.github.satoshun.truth.android.api.widget;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class ArrayAdapterSubject extends ListAdapterSubject<ArrayAdapterSubject, ArrayAdapter> {

  public static final ArrayAdapterSubjectFactory FACTORY = new ArrayAdapterSubjectFactory();

  public ArrayAdapterSubject(FailureStrategy failureStrategy, ArrayAdapter actual) {
    super(failureStrategy, actual);
  }

  public ArrayAdapterSubject isContext(Context context) {
    isNotNull();
    check().withFailureMessage("is context")
        .that(actual().getContext())
        .isSameAs(context);
    return this;
  }

  public ArrayAdapterSubject isFilter(Filter filter) {
    isNotNull();
    check().withFailureMessage("is filter")
        .that(actual().getFilter())
        .isSameAs(filter);
    return this;
  }

  private static class ArrayAdapterSubjectFactory extends SubjectFactory<ArrayAdapterSubject, ArrayAdapter> {
    @Override
    public ArrayAdapterSubject getSubject(FailureStrategy fs, ArrayAdapter that) {
      return new ArrayAdapterSubject(fs, that);
    }
  }
}
