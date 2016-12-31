package com.github.satoshun.truth.android.api.widget;

import android.widget.SimpleCursorAdapter;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.widget.SimpleCursorAdapter.CursorToStringConverter;
import static android.widget.SimpleCursorAdapter.ViewBinder;

public class SimpleCursorAdapterSubject extends CursorAdapterSubject<SimpleCursorAdapterSubject, SimpleCursorAdapter> {

  public static final SimpleCursorAdapterSubjectFactory FACTORY = new SimpleCursorAdapterSubjectFactory();

  public SimpleCursorAdapterSubject(FailureStrategy failureStrategy, SimpleCursorAdapter actual) {
    super(failureStrategy, actual);
  }

  public SimpleCursorAdapterSubject isCursorToStringConverter(CursorToStringConverter converter) {
    isNotNull();
    check().withFailureMessage("is cursor to string converter")
        .that(actual().getCursorToStringConverter())
        .isSameAs(converter);
    return this;
  }

  public SimpleCursorAdapterSubject isStringConversionColumn(int column) {
    isNotNull();
    check().withFailureMessage("is string conversion column")
        .that(actual().getStringConversionColumn())
        .isEqualTo(column);
    return this;
  }

  public SimpleCursorAdapterSubject isViewBinder(ViewBinder binder) {
    isNotNull();
    check().withFailureMessage("is view binder")
        .that(actual().getViewBinder())
        .isSameAs(binder);
    return this;
  }

  private static class SimpleCursorAdapterSubjectFactory extends SubjectFactory<SimpleCursorAdapterSubject, SimpleCursorAdapter> {
    @Override
    public SimpleCursorAdapterSubject getSubject(FailureStrategy fs, SimpleCursorAdapter that) {
      return new SimpleCursorAdapterSubject(fs, that);
    }
  }
}
