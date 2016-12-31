package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.widget.LinearLayout;

import com.github.satoshun.truth.android.api.view.ViewGroupSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.widget.LinearLayout.HORIZONTAL;
import static android.widget.LinearLayout.VERTICAL;

public abstract class LinearLayoutSubject<S extends LinearLayoutSubject<S, T>, T extends LinearLayout>
    extends ViewGroupSubject<S, T> {

  public static final LinearLayoutSubjectFactory FACTORY = new LinearLayoutSubjectFactory();

  public LinearLayoutSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public S isDividerPadding(int padding) {
    isNotNull();
    check().withFailureMessage("is divider padding")
        .that(actual().getDividerPadding())
        .isEqualTo(padding);
    return myself();
  }

  public S isOrientation(int orientation) {
    isNotNull();
    check().withFailureMessage("is orientation")
        .that(actual().getOrientation())
        .isEqualTo(orientation);
    return myself();
  }

  public S isVertical() {
    return isOrientation(VERTICAL);
  }

  public S isHorizontal() {
    return isOrientation(HORIZONTAL);
  }

  @TargetApi(HONEYCOMB)
  public S isShowDividers(int dividers) {
    isNotNull();
    check().withFailureMessage("is show dividers")
        .that(actual().getShowDividers())
        .isEqualTo(dividers);
    return myself();
  }

  public S isWeightSum(float sum) {
    isNotNull();
    check().withFailureMessage("is weight sum")
        .that(actual().getWeightSum())
        .isEqualTo(sum);
    return myself();
  }

  public S isBaselineAligned() {
    isNotNull();
    check().withFailureMessage("is baseline aligned")
        .that(actual().isBaselineAligned())
        .isTrue();
    return myself();
  }

  public S isNotBaselineAligned() {
    isNotNull();
    check().withFailureMessage("is not baseline aligned")
        .that(actual().isBaselineAligned())
        .isFalse();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isMeasuringWithLargestChild() {
    isNotNull();
    check().withFailureMessage("is measuring with largest child")
        .that(actual().isMeasureWithLargestChildEnabled())
        .isTrue();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isNotMeasuringWithLargestChild() {
    isNotNull();
    check().withFailureMessage("is not measuring with largest child")
        .that(actual().isMeasureWithLargestChildEnabled())
        .isFalse();
    return myself();
  }

  private static class LinearLayoutSubjectImpl extends LinearLayoutSubject<LinearLayoutSubjectImpl, LinearLayout> {
    LinearLayoutSubjectImpl(FailureStrategy failureStrategy, LinearLayout actual) {
      super(failureStrategy, actual);
    }
  }

  private static class LinearLayoutSubjectFactory extends SubjectFactory<LinearLayoutSubjectImpl, LinearLayout> {
    @Override
    public LinearLayoutSubjectImpl getSubject(FailureStrategy fs, LinearLayout that) {
      return new LinearLayoutSubjectImpl(fs, that);
    }
  }
}
