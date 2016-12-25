package com.github.satoshun.recyclerview.v7.api.widget;

import android.support.v7.widget.RecyclerView;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class RecyclerViewLayoutSubject extends BaseSubject<RecyclerViewLayoutSubject, RecyclerView.LayoutParams> {

  public static final RecyclerViewLayoutSubjectFactory FACTORY = new RecyclerViewLayoutSubjectFactory();

  public RecyclerViewLayoutSubject(FailureStrategy failureStrategy, RecyclerView.LayoutParams actual) {
    super(failureStrategy, actual);
  }

  public RecyclerViewLayoutSubject viewNeedsUpdate() {
    isNotNull();
    check().withFailureMessage("view needs update")
        .that(actual().viewNeedsUpdate())
        .isTrue();
    return myself();
  }

  public RecyclerViewLayoutSubject viewDoesNotNeedUpdate() {
    isNotNull();
    check().withFailureMessage("view does not needs update")
        .that(actual().viewNeedsUpdate())
        .isFalse();
    return myself();
  }

  public RecyclerViewLayoutSubject isViewInvalid() {
    isNotNull();
    check().withFailureMessage("is view invalid")
        .that(actual().isViewInvalid())
        .isTrue();
    return myself();
  }

  public RecyclerViewLayoutSubject isViewValid() {
    isNotNull();
    check().withFailureMessage("is view valid")
        .that(actual().isViewInvalid())
        .isFalse();
    return myself();
  }

  public RecyclerViewLayoutSubject isItemRemoved() {
    isNotNull();
    check().withFailureMessage("is item removed")
        .that(actual().isItemRemoved())
        .isTrue();
    return myself();
  }

  public RecyclerViewLayoutSubject isItemNotRemoved() {
    isNotNull();
    check().withFailureMessage("is item not removed")
        .that(actual().isItemRemoved())
        .isFalse();
    return myself();
  }

  public RecyclerViewLayoutSubject isViewPosition(int position) {
    isNotNull();
    check().withFailureMessage("is view position")
        .that(actual().getViewPosition())
        .isEqualTo(position);
    return myself();
  }

  private static class RecyclerViewLayoutSubjectFactory extends SubjectFactory<RecyclerViewLayoutSubject, RecyclerView.LayoutParams> {
    @Override
    public RecyclerViewLayoutSubject getSubject(FailureStrategy fs, RecyclerView.LayoutParams that) {
      return new RecyclerViewLayoutSubject(fs, that);
    }
  }
}
