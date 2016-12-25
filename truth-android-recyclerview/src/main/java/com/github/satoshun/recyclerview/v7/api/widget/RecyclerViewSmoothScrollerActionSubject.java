package com.github.satoshun.recyclerview.v7.api.widget;

import android.support.v7.widget.RecyclerView;
import android.view.animation.Interpolator;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class RecyclerViewSmoothScrollerActionSubject extends BaseSubject<RecyclerViewSmoothScrollerActionSubject, RecyclerView.SmoothScroller.Action> {

  public static final RecyclerViewSmoothScrollerActionSubjectFactory FACTORY = new RecyclerViewSmoothScrollerActionSubjectFactory();

  public RecyclerViewSmoothScrollerActionSubject(FailureStrategy failureStrategy, RecyclerView.SmoothScroller.Action actual) {
    super(failureStrategy, actual);
  }

  public RecyclerViewSmoothScrollerActionSubject isDx(int dx) {
    isNotNull();
    check().withFailureMessage("is dx")
        .that(dx)
        .isEqualTo(actual().getDx());
    return myself();
  }

  public RecyclerViewSmoothScrollerActionSubject isDy(int dy) {
    isNotNull();
    check().withFailureMessage("is dy")
        .that(dy)
        .isEqualTo(actual().getDy());
    return myself();
  }

  public RecyclerViewSmoothScrollerActionSubject isDuration(int duration) {
    isNotNull();
    check().withFailureMessage("is duration")
        .that(duration)
        .isEqualTo(actual().getDuration());
    return myself();
  }

  public RecyclerViewSmoothScrollerActionSubject isInterpolator(Interpolator interpolator) {
    isNotNull();
    check().withFailureMessage("is interpolator")
        .that(interpolator)
        .isEqualTo(actual().getInterpolator());
    return myself();
  }

  private static class RecyclerViewSmoothScrollerActionSubjectFactory extends SubjectFactory<RecyclerViewSmoothScrollerActionSubject, RecyclerView.SmoothScroller.Action> {
    @Override
    public RecyclerViewSmoothScrollerActionSubject getSubject(FailureStrategy fs, RecyclerView.SmoothScroller.Action that) {
      return new RecyclerViewSmoothScrollerActionSubject(fs, that);
    }
  }
}
