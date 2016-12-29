package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.view.ScaleGestureDetector;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.KITKAT;

public class ScaleGestureDetectorSubject extends BaseSubject<ScaleGestureDetectorSubject, ScaleGestureDetector> {

  public static final ScaleGestureDetectorSubjectFactory FACTORY = new ScaleGestureDetectorSubjectFactory();

  public ScaleGestureDetectorSubject(FailureStrategy failureStrategy, ScaleGestureDetector actual) {
    super(failureStrategy, actual);
  }

  public ScaleGestureDetectorSubject isCurrentSpan(float span) {
    isNotNull();
    check().withFailureMessage("is current span")
        .that(actual().getCurrentSpan())
        .isEqualTo(span);
    return this;
  }

  @TargetApi(HONEYCOMB)
  public ScaleGestureDetectorSubject isCurrentSpanX(float span) {
    isNotNull();
    check().withFailureMessage("is current span x")
        .that(actual().getCurrentSpanX())
        .isEqualTo(span);
    return this;
  }

  @TargetApi(HONEYCOMB)
  public ScaleGestureDetectorSubject isCurrentSpanY(float span) {
    isNotNull();
    check().withFailureMessage("is current span y")
        .that(actual().getCurrentSpanY())
        .isEqualTo(span);
    return this;
  }

  public ScaleGestureDetectorSubject isEventTime(long time) {
    isNotNull();
    check().withFailureMessage("is event time")
        .that(actual().getEventTime())
        .isEqualTo(time);
    return this;
  }

  public ScaleGestureDetectorSubject isFocusX(float focus) {
    isNotNull();
    check().withFailureMessage("is focus x")
        .that(actual().getFocusX())
        .isEqualTo(focus);
    return this;
  }

  public ScaleGestureDetectorSubject isFocusY(float focus) {
    isNotNull();
    check().withFailureMessage("is focus y")
        .that(actual().getFocusY())
        .isEqualTo(focus);
    return this;
  }

  public ScaleGestureDetectorSubject isPreviousSpan(float span) {
    isNotNull();
    check().withFailureMessage("is previous span")
        .that(actual().getPreviousSpan())
        .isEqualTo(span);
    return this;
  }

  @TargetApi(HONEYCOMB)
  public ScaleGestureDetectorSubject isreviousSpanX(float span) {
    isNotNull();
    check().withFailureMessage("is previous span x")
        .that(actual().getPreviousSpanX())
        .isEqualTo(span);
    return this;
  }

  @TargetApi(HONEYCOMB)
  public ScaleGestureDetectorSubject hasPreviousSpanY(float span) {
    isNotNull();
    check().withFailureMessage("is previous span y")
        .that(actual().getPreviousSpanY())
        .isEqualTo(span);
    return this;
  }

  public ScaleGestureDetectorSubject isScaleFactor(float factor) {
    isNotNull();
    check().withFailureMessage("is scale factor")
        .that(actual().getScaleFactor())
        .isEqualTo(factor);
    return this;
  }

  public ScaleGestureDetectorSubject isTimeDelta(long delta) {
    isNotNull();
    check().withFailureMessage("is time delta")
        .that(actual().getTimeDelta())
        .isEqualTo(delta);
    return this;
  }

  public ScaleGestureDetectorSubject isInProgress() {
    isNotNull();
    check().withFailureMessage("is in progress")
        .that(actual().isInProgress())
        .isTrue();
    return this;
  }

  public ScaleGestureDetectorSubject isNotInProgress() {
    isNotNull();
    check().withFailureMessage("is not in progress")
        .that(actual().isInProgress())
        .isFalse();
    return this;
  }

  @TargetApi(KITKAT)
  public ScaleGestureDetectorSubject isQuickScaleEnabled() {
    isNotNull();
    check().withFailureMessage("is quick scale enabled")
        .that(actual().isQuickScaleEnabled())
        .isTrue();
    return this;
  }

  @TargetApi(KITKAT)
  public ScaleGestureDetectorSubject isQuickScaleDisabled() {
    isNotNull();
    check().withFailureMessage("is quick scale disabled")
        .that(actual().isQuickScaleEnabled())
        .isFalse();
    return this;
  }

  private static class ScaleGestureDetectorSubjectFactory extends SubjectFactory<ScaleGestureDetectorSubject, ScaleGestureDetector> {
    @Override
    public ScaleGestureDetectorSubject getSubject(FailureStrategy fs, ScaleGestureDetector that) {
      return new ScaleGestureDetectorSubject(fs, that);
    }
  }
}
