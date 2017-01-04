package com.github.satoshun.truth.android.api.gesture;

import android.gesture.GestureStroke;
import android.graphics.RectF;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class GestureStrokeSubject extends BaseSubject<GestureStrokeSubject, GestureStroke> {

  public static final GestureStrokeSubjectFactory FACTORY = new GestureStrokeSubjectFactory();

  public GestureStrokeSubject(FailureStrategy failureStrategy, GestureStroke actual) {
    super(failureStrategy, actual);
  }

  public GestureStrokeSubject isBoundingBox(RectF rect) {
    isNotNull();
    check().withFailureMessage("is bounding box")
        .that(actual().boundingBox)
        .isEqualTo(rect);
    return this;
  }

  public GestureStrokeSubject isLength(float length) {
    isNotNull();
    check().withFailureMessage("is length")
        .that(actual().length)
        .isEqualTo(length);
    return this;
  }

  public GestureStrokeSubject isPoints(float[] points) {
    isNotNull();
    check().withFailureMessage("is points")
        .that(actual().points)
        .isEqualTo(points);
    return this;
  }

  private static class GestureStrokeSubjectFactory extends SubjectFactory<GestureStrokeSubject, GestureStroke> {
    @Override
    public GestureStrokeSubject getSubject(FailureStrategy fs, GestureStroke that) {
      return new GestureStrokeSubject(fs, that);
    }
  }
}
