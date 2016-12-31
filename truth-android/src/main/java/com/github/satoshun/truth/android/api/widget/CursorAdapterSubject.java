package com.github.satoshun.truth.android.api.widget;

import android.database.Cursor;
import android.widget.CursorAdapter;
import android.widget.Filter;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class CursorAdapterSubject<S extends CursorAdapterSubject<S, T>, T extends CursorAdapter>
    extends ListAdapterSubject<S, T> {

  public static final CursorAdapterSubjectFactory FACTORY = new CursorAdapterSubjectFactory();

  public CursorAdapterSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isCursor(Cursor cursor) {
    isNotNull();
    check().withFailureMessage("is cursor")
        .that(actual().getCursor())
        .isSameAs(cursor);
    return myself();
  }

  public S isFilter(Filter filter) {
    isNotNull();
    check().withFailureMessage("is filter")
        .that(actual().getFilter())
        .isSameAs(filter);
    return myself();
  }

  private static class CursorAdapterSubjectImpl extends CursorAdapterSubject<CursorAdapterSubjectImpl, CursorAdapter> {
    CursorAdapterSubjectImpl(FailureStrategy failureStrategy, CursorAdapter actual) {
      super(failureStrategy, actual);
    }
  }

  private static class CursorAdapterSubjectFactory extends SubjectFactory<CursorAdapterSubjectImpl, CursorAdapter> {
    @Override
    public CursorAdapterSubjectImpl getSubject(FailureStrategy fs, CursorAdapter that) {
      return new CursorAdapterSubjectImpl(fs, that);
    }
  }
}
