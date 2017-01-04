package com.github.satoshun.truth.android.api.gesture;

import android.gesture.GesturePoint;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class GesturePointSubject extends BaseSubject<GesturePointSubject, GesturePoint> {

  public static final GesturePointSubjectFactory FACTORY = new GesturePointSubjectFactory();

  public GesturePointSubject(FailureStrategy failureStrategy, GesturePoint actual) {
    super(failureStrategy, actual);
  }

  public GesturePointSubject isTimestamp(long timestamp) {
    isNotNull();
    check().withFailureMessage("is timestamp")
        .that(actual().timestamp)
        .isEqualTo(timestamp);
    return this;
  }

  public GesturePointSubject isX(float x) {
    isNotNull();
    check().withFailureMessage("is x")
        .that(actual().x)
        .isEqualTo(x);
    return this;
  }

  public GesturePointSubject isY(float y) {
    isNotNull();
    check().withFailureMessage("is y")
        .that(actual().y)
        .isEqualTo(y);
    return this;
  }

  private static class GesturePointSubjectFactory extends SubjectFactory<GesturePointSubject, GesturePoint> {
    @Override
    public GesturePointSubject getSubject(FailureStrategy fs, GesturePoint that) {
      return new GesturePointSubject(fs, that);
    }
  }
}
