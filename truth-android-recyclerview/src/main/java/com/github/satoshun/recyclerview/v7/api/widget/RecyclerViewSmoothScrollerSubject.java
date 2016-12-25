package com.github.satoshun.recyclerview.v7.api.widget;

import android.support.v7.widget.RecyclerView;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class RecyclerViewSmoothScrollerSubject extends BaseSubject<RecyclerViewSmoothScrollerSubject, RecyclerView.SmoothScroller> {

  public static final RecyclerViewSmoothScrollerSubjectFactory FACTORY = new RecyclerViewSmoothScrollerSubjectFactory();

  public RecyclerViewSmoothScrollerSubject(FailureStrategy failureStrategy, RecyclerView.SmoothScroller actual) {
    super(failureStrategy, actual);
  }

  public RecyclerViewSmoothScrollerSubject isPendingInitialRun() {
    isNotNull();
    check().withFailureMessage("is pending initial run")
        .that(actual().isPendingInitialRun())
        .isTrue();
    return myself();
  }

  public RecyclerViewSmoothScrollerSubject isNotPendingInitialRun() {
    isNotNull();
    check().withFailureMessage("is not pending initial run")
        .that(actual().isPendingInitialRun())
        .isFalse();
    return myself();
  }

  public RecyclerViewSmoothScrollerSubject isRunning() {
    isNotNull();
    check().withFailureMessage("is running")
        .that(actual().isRunning())
        .isTrue();
    return myself();
  }

  public RecyclerViewSmoothScrollerSubject isNotRunning() {
    isNotNull();
    check().withFailureMessage("is not running")
        .that(actual().isRunning())
        .isFalse();
    return myself();
  }

  public RecyclerViewSmoothScrollerSubject isTargetPosition(int position) {
    isNotNull();
    check().withFailureMessage("is target position")
        .that(position)
        .isEqualTo(actual().getTargetPosition());
    return myself();
  }

  public RecyclerViewSmoothScrollerSubject isChildCount(int count) {
    isNotNull();
    check().withFailureMessage("is target position")
        .that(count)
        .isEqualTo(actual().getChildCount());
    return myself();
  }

  private static class RecyclerViewSmoothScrollerSubjectFactory extends SubjectFactory<RecyclerViewSmoothScrollerSubject, RecyclerView.SmoothScroller> {
    @Override
    public RecyclerViewSmoothScrollerSubject getSubject(FailureStrategy fs, RecyclerView.SmoothScroller that) {
      return new RecyclerViewSmoothScrollerSubject(fs, that);
    }
  }
}
