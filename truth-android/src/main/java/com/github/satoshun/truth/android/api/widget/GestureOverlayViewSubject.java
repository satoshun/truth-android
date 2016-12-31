package com.github.satoshun.truth.android.api.widget;

import android.gesture.GestureOverlayView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class GestureOverlayViewSubject extends FrameLayoutSubject<GestureOverlayViewSubject, GestureOverlayView> {

  public static final GestureOverlayViewSubjectFactory FACTORY = new GestureOverlayViewSubjectFactory();

  public GestureOverlayViewSubject(FailureStrategy failureStrategy, GestureOverlayView actual) {
    super(failureStrategy, actual);
  }

  public GestureOverlayViewSubject isFadeOffset(long offset) {
    isNotNull();
    check().withFailureMessage("is fade offset")
        .that(actual().getFadeOffset())
        .isEqualTo(offset);
    return this;
  }

  public GestureOverlayViewSubject isGestureColor(int color) {
    isNotNull();
    check().withFailureMessage("is gesture color")
        .that(actual().getGestureColor())
        .isEqualTo(color);
    return this;
  }

  public GestureOverlayViewSubject isGestureStrokeAngleThreshold(float threshold) {
    isNotNull();
    check().withFailureMessage("is gesture stroke angle threshold")
        .that(actual().getGestureStrokeAngleThreshold())
        .isEqualTo(threshold);
    return this;
  }

  public GestureOverlayViewSubject isGestureStrokeLengthThreshold(float threshold) {
    isNotNull();
    check().withFailureMessage("is gesture stroke length threshold")
        .that(actual().getGestureStrokeLengthThreshold())
        .isEqualTo(threshold);
    return this;
  }

  public GestureOverlayViewSubject isGestureStrokeSquarenessThreshold(float threshold) {
    isNotNull();
    check().withFailureMessage("is gesture stroke squareness threshold")
        .that(actual().getGestureStrokeSquarenessTreshold())
        .isEqualTo(threshold);
    return this;
  }

  public GestureOverlayViewSubject isGestureStrokeType(int type) {
    isNotNull();
    check().withFailureMessage("is gesture stroke type")
        .that(actual().getGestureStrokeType())
        .isEqualTo(type);
    return this;
  }

  public GestureOverlayViewSubject isGestureStrokeWidth(float width) {
    isNotNull();
    check().withFailureMessage("is gesture stroke width")
        .that(actual().getGestureStrokeWidth())
        .isEqualTo(width);
    return this;
  }

  public GestureOverlayViewSubject isOrientation(int orientation) {
    isNotNull();
    check().withFailureMessage("is orientation")
        .that(actual().getOrientation())
        .isEqualTo(orientation);
    return this;
  }

  public GestureOverlayViewSubject isUncertainGestureColor(int color) {
    isNotNull();
    check().withFailureMessage("is uncertain gesture color")
        .that(actual().getUncertainGestureColor())
        .isEqualTo(color);
    return this;
  }

  public GestureOverlayViewSubject isInterceptingEvents() {
    isNotNull();
    check().withFailureMessage("is intercepting events")
        .that(actual().isEventsInterceptionEnabled())
        .isTrue();
    return this;
  }

  public GestureOverlayViewSubject isNotInterceptingEvents() {
    isNotNull();
    check().withFailureMessage("is not intercepting events")
        .that(actual().isEventsInterceptionEnabled())
        .isFalse();
    return this;
  }

  public GestureOverlayViewSubject isFadeEnabled() {
    isNotNull();
    check().withFailureMessage("is fade enabled")
        .that(actual().isFadeEnabled())
        .isTrue();
    return this;
  }

  public GestureOverlayViewSubject isFadeDisabled() {
    isNotNull();
    check().withFailureMessage("is fade disbled")
        .that(actual().isFadeEnabled())
        .isFalse();
    return this;
  }

  public GestureOverlayViewSubject isGestureVisible() {
    isNotNull();
    check().withFailureMessage("is gesture visible")
        .that(actual().isGestureVisible())
        .isTrue();
    return this;
  }

  public GestureOverlayViewSubject isGestureNotVisible() {
    isNotNull();
    check().withFailureMessage("is gesture not visible")
        .that(actual().isGestureVisible())
        .isFalse();
    return this;
  }

  public GestureOverlayViewSubject isGesturing() {
    isNotNull();
    check().withFailureMessage("is gesturing")
        .that(actual().isGesturing())
        .isTrue();
    return this;
  }

  public GestureOverlayViewSubject isNotGesturing() {
    isNotNull();
    check().withFailureMessage("is not gesturing")
        .that(actual().isGesturing())
        .isFalse();
    return this;
  }

  private static class GestureOverlayViewSubjectFactory extends SubjectFactory<GestureOverlayViewSubject, GestureOverlayView> {
    @Override
    public GestureOverlayViewSubject getSubject(FailureStrategy fs, GestureOverlayView that) {
      return new GestureOverlayViewSubject(fs, that);
    }
  }
}
