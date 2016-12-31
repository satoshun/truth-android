package com.github.satoshun.truth.android.api.widget;


import android.widget.ScrollView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class ScrollViewSubject extends FrameLayoutSubject<ScrollViewSubject, ScrollView> {

  public static final ScrollViewSubjectFactory FACTORY = new ScrollViewSubjectFactory();

  public ScrollViewSubject(FailureStrategy failureStrategy, ScrollView actual) {
    super(failureStrategy, actual);
  }

  public ScrollViewSubject isMaxScrollAmount(int amount) {
    isNotNull();
    check().withFailureMessage("is max scroll amount")
        .that(actual().getMaxScrollAmount())
        .isEqualTo(amount);
    return this;
  }

  public ScrollViewSubject isFillingViewport() {
    isNotNull();
    check().withFailureMessage("is filling viewport")
        .that(actual().isFillViewport())
        .isTrue();
    return this;
  }

  public ScrollViewSubject isNotFillingViewport() {
    isNotNull();
    check().withFailureMessage("is not filling viewport")
        .that(actual().isFillViewport())
        .isFalse();
    return this;
  }

  public ScrollViewSubject isSmoothScrollEnabled() {
    isNotNull();
    check().withFailureMessage("is smooth scroll enabled")
        .that(actual().isSmoothScrollingEnabled())
        .isTrue();
    return this;
  }

  public ScrollViewSubject isSmoothScrollDisabled() {
    isNotNull();
    check().withFailureMessage("is smooth scroll disabled")
        .that(actual().isSmoothScrollingEnabled())
        .isFalse();
    return this;
  }

  private static class ScrollViewSubjectFactory extends SubjectFactory<ScrollViewSubject, ScrollView> {
    @Override
    public ScrollViewSubject getSubject(FailureStrategy fs, ScrollView that) {
      return new ScrollViewSubject(fs, that);
    }
  }
}