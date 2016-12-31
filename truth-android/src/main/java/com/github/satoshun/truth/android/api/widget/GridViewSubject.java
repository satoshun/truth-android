package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.widget.GridView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public class GridViewSubject extends AbsListViewSubject<GridViewSubject, GridView> {

  public static final GridViewSubjectFactory FACTORY = new GridViewSubjectFactory();

  public GridViewSubject(FailureStrategy failureStrategy, GridView actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(JELLY_BEAN)
  public GridViewSubject isColumnWidth(int width) {
    isNotNull();
    check().withFailureMessage("is column width")
        .that(actual().getColumnWidth())
        .isEqualTo(width);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public GridViewSubject isGravity(int gravity) {
    isNotNull();
    check().withFailureMessage("is gravity")
        .that(actual().getGravity())
        .isEqualTo(gravity);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public GridViewSubject isHorizontalSpacing(int spacing) {
    isNotNull();
    check().withFailureMessage("is horizontal spacing")
        .that(actual().getHorizontalSpacing())
        .isEqualTo(spacing);
    return this;
  }

  @TargetApi(HONEYCOMB)
  public GridViewSubject isColumnCount(int count) {
    isNotNull();
    check().withFailureMessage("is column count")
        .that(actual().getNumColumns())
        .isEqualTo(count);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public GridViewSubject isRequestedColumnWidth(int width) {
    isNotNull();
    check().withFailureMessage("is requested column width")
        .that(actual().getRequestedColumnWidth())
        .isEqualTo(width);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public GridViewSubject isRequestedHorizontalSpacing(int spacing) {
    isNotNull();
    check().withFailureMessage("is requested horizontal spacing")
        .that(actual().getRequestedHorizontalSpacing())
        .isEqualTo(spacing);
    return this;
  }

  public GridViewSubject isStretchMode(int mode) {
    isNotNull();
    check().withFailureMessage("is stretch mode")
        .that(actual().getStretchMode())
        .isEqualTo(mode);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public GridViewSubject isVerticalSpacing(int spacing) {
    isNotNull();
    check().withFailureMessage("is vertical spacing")
        .that(actual().getVerticalSpacing())
        .isEqualTo(spacing);
    return this;
  }

  private static class GridViewSubjectFactory extends SubjectFactory<GridViewSubject, GridView> {
    @Override
    public GridViewSubject getSubject(FailureStrategy fs, GridView that) {
      return new GridViewSubject(fs, that);
    }
  }
}
