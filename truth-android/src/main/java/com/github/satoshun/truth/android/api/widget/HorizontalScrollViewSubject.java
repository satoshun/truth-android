package com.github.satoshun.truth.android.api.widget;

import android.widget.HorizontalScrollView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class HorizontalScrollViewSubject<S extends HorizontalScrollViewSubject<S, T>, T extends HorizontalScrollView>
    extends FrameLayoutSubject<S, T> {

  public static final HorizontalScrollViewSubjectFactory FACTORY = new HorizontalScrollViewSubjectFactory();

  public HorizontalScrollViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isMaximumScrollAmount(int amount) {
    isNotNull();
    check().withFailureMessage("is maximum scroll amount")
        .that(actual().getMaxScrollAmount())
        .isEqualTo(amount);
    return myself();
  }

  public S isFillingViewport() {
    isNotNull();
    check().withFailureMessage("is filling viewport")
        .that(actual().isFillViewport())
        .isTrue();
    return myself();
  }

  public S isNotFillingViewport() {
    isNotNull();
    check().withFailureMessage("is not filling viewport")
        .that(actual().isFillViewport())
        .isFalse();
    return myself();
  }

  public S isSmoothScrollingEnabled() {
    isNotNull();
    check().withFailureMessage("is smooth scrolling enabled")
        .that(actual().isSmoothScrollingEnabled())
        .isTrue();
    return myself();
  }

  public S isSmoothScrollingDisabled() {
    isNotNull();
    check().withFailureMessage("is smooth scrolling disabled")
        .that(actual().isSmoothScrollingEnabled())
        .isFalse();
    return myself();
  }

  private static class HorizontalScrollViewSubjectImpl extends HorizontalScrollViewSubject<HorizontalScrollViewSubjectImpl, HorizontalScrollView> {
    HorizontalScrollViewSubjectImpl(FailureStrategy failureStrategy, HorizontalScrollView actual) {
      super(failureStrategy, actual);
    }
  }

  private static class HorizontalScrollViewSubjectFactory extends SubjectFactory<HorizontalScrollViewSubjectImpl, HorizontalScrollView> {
    @Override
    public HorizontalScrollViewSubjectImpl getSubject(FailureStrategy fs, HorizontalScrollView that) {
      return new HorizontalScrollViewSubjectImpl(fs, that);
    }
  }
}
