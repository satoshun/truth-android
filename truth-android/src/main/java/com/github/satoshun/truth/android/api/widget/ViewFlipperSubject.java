package com.github.satoshun.truth.android.api.widget;

import android.widget.ViewFlipper;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class ViewFlipperSubject extends ViewAnimatorSubject<ViewFlipperSubject, ViewFlipper> {

  public static final ViewFlipperSubjectFactory FACTORY = new ViewFlipperSubjectFactory();

  public ViewFlipperSubject(FailureStrategy failureStrategy, ViewFlipper actual) {
    super(failureStrategy, actual);
  }

  public ViewFlipperSubject isAutoStarting() {
    isNotNull();
    check().withFailureMessage("is auto starting")
        .that(actual().isAutoStart())
        .isTrue();
    return this;
  }

  public ViewFlipperSubject isNotAutoStarting() {
    isNotNull();
    check().withFailureMessage("is not auto starting")
        .that(actual().isAutoStart())
        .isFalse();
    return this;
  }

  public ViewFlipperSubject isFlipping() {
    isNotNull();
    check().withFailureMessage("is flipping")
        .that(actual().isFlipping())
        .isTrue();
    return this;
  }

  public ViewFlipperSubject isNotFlipping() {
    isNotNull();
    check().withFailureMessage("is not flipping")
        .that(actual().isFlipping())
        .isFalse();
    return this;
  }

  private static class ViewFlipperSubjectFactory extends SubjectFactory<ViewFlipperSubject, ViewFlipper> {
    @Override
    public ViewFlipperSubject getSubject(FailureStrategy fs, ViewFlipper that) {
      return new ViewFlipperSubject(fs, that);
    }
  }
}
