package com.github.satoshun.truth.android.api.view;

import android.view.ViewConfiguration;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class ViewConfigurationSubject extends BaseSubject<ViewConfigurationSubject, ViewConfiguration> {

  public static final ViewConfigurationSubjectFactory FACTORY = new ViewConfigurationSubjectFactory();

  public ViewConfigurationSubject(FailureStrategy failureStrategy, ViewConfiguration actual) {
    super(failureStrategy, actual);
  }

  public ViewConfigurationSubject hasScaledDoubleTapSlop(int slop) {
    isNotNull();
    check().withFailureMessage("is scaled double tap slop")
        .that(actual().getScaledDoubleTapSlop())
        .isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject isScaledEdgeSlop(int slop) {
    isNotNull();
    check().withFailureMessage("is scaled edge slop")
        .that(actual().getScaledEdgeSlop())
        .isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject isScaledFadingEdgeLength(int length) {
    isNotNull();
    check().withFailureMessage("is scaled fading edge length")
        .that(actual().getScaledFadingEdgeLength())
        .isEqualTo(length);
    return this;
  }

  public ViewConfigurationSubject isScaledMaximumDrawingCacheSize(int size) {
    isNotNull();
    check().withFailureMessage("is scaled maximum drawing cache size")
        .that(actual().getScaledMaximumDrawingCacheSize())
        .isEqualTo(size);
    return this;
  }

  public ViewConfigurationSubject isScaledMaximumFlingVelocity(int velocity) {
    isNotNull();
    check().withFailureMessage("is scaled maximum fling velocity")
        .that(actual().getScaledMaximumFlingVelocity())
        .isEqualTo(velocity);
    return this;
  }

  public ViewConfigurationSubject isScaledMinimumFlingVelocity(int velocity) {
    isNotNull();
    check().withFailureMessage("is scaled minimum fling velocity")
        .that(actual().getScaledMinimumFlingVelocity())
        .isEqualTo(velocity);
    return this;
  }

  public ViewConfigurationSubject isScaledOverflingDistance(int distance) {
    isNotNull();
    check().withFailureMessage("is scaled overfling distance")
        .that(actual().getScaledOverflingDistance())
        .isEqualTo(distance);
    return this;
  }

  public ViewConfigurationSubject isScaledOverscrollDistance(int distance) {
    isNotNull();
    check().withFailureMessage("is scaled overscroll distance")
        .that(actual().getScaledOverscrollDistance())
        .isEqualTo(distance);
    return this;
  }

  public ViewConfigurationSubject isScaledPagingTouchSlop(int slop) {
    isNotNull();
    check().withFailureMessage("is scaled paging touch slop")
        .that(actual().getScaledPagingTouchSlop())
        .isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject isScaledScrollBarSize(int size) {
    isNotNull();
    check().withFailureMessage("is scaled scroll bar size")
        .that(actual().getScaledScrollBarSize())
        .isEqualTo(size);
    return this;
  }

  public ViewConfigurationSubject isScaledTouchSlop(int slop) {
    isNotNull();
    check().withFailureMessage("is scaled touch slop")
        .that(actual().getScaledTouchSlop())
        .isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject isScaledWindowTouchSlop(int slop) {
    isNotNull();
    check().withFailureMessage("is scaled window touch slop")
        .that(actual().getScaledWindowTouchSlop())
        .isEqualTo(slop);
    return this;
  }

  private static class ViewConfigurationSubjectFactory extends SubjectFactory<ViewConfigurationSubject, ViewConfiguration> {
    @Override
    public ViewConfigurationSubject getSubject(FailureStrategy fs, ViewConfiguration that) {
      return new ViewConfigurationSubject(fs, that);
    }
  }
}
