package com.github.satoshun.recyclerview.v7.api.widget;

import android.support.v7.widget.RecyclerView;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class RecyclerViewItemAnimatorSubject extends BaseSubject<RecyclerViewItemAnimatorSubject, RecyclerView.ItemAnimator> {

  public static final RecyclerViewItemAnimatorSubjectFactory FACTORY = new RecyclerViewItemAnimatorSubjectFactory();

  public RecyclerViewItemAnimatorSubject(FailureStrategy failureStrategy, RecyclerView.ItemAnimator actual) {
    super(failureStrategy, actual);
  }

  public RecyclerViewItemAnimatorSubject isMoveDuration(long duration) {
    isNotNull();
    check().withFailureMessage("is move duration")
        .that(duration)
        .isEqualTo(actual().getMoveDuration());
    return myself();
  }

  public RecyclerViewItemAnimatorSubject isAddDuration(long duration) {
    isNotNull();
    check().withFailureMessage("is add duration")
        .that(duration)
        .isEqualTo(actual().getAddDuration());
    return myself();
  }

  public RecyclerViewItemAnimatorSubject isRemoveDuration(long duration) {
    isNotNull();
    check().withFailureMessage("is remove duration")
        .that(duration)
        .isEqualTo(actual().getRemoveDuration());
    return myself();
  }

  public RecyclerViewItemAnimatorSubject isRunning() {
    isNotNull();
    check().withFailureMessage("is running")
        .that(actual().isRunning())
        .isTrue();
    return this;
  }

  public RecyclerViewItemAnimatorSubject isNotRunning() {
    isNotNull();
    check().withFailureMessage("is not running")
        .that(actual().isRunning())
        .isFalse();
    return this;
  }

  private static class RecyclerViewItemAnimatorSubjectFactory extends SubjectFactory<RecyclerViewItemAnimatorSubject, RecyclerView.ItemAnimator> {
    @Override
    public RecyclerViewItemAnimatorSubject getSubject(FailureStrategy fs, RecyclerView.ItemAnimator that) {
      return new RecyclerViewItemAnimatorSubject(fs, that);
    }
  }
}
