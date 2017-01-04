package com.github.satoshun.truth.android.api.gesture;

import android.gesture.Gesture;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class GestureSubject extends BaseSubject<GestureSubject, Gesture> {

  public static final GestureSubjectFactory FACTORY = new GestureSubjectFactory();

  public GestureSubject(FailureStrategy failureStrategy, Gesture actual) {
    super(failureStrategy, actual);
  }

  public GestureSubject isId(long id) {
    isNotNull();
    check().withFailureMessage("is id")
        .that(actual().getID())
        .isEqualTo(id);
    return this;
  }

  public GestureSubject isLength(float length) {
    isNotNull();
    check().withFailureMessage("is length")
        .that(actual().getLength())
        .isEqualTo(length);
    return this;
  }

  public GestureSubject isStrokeCount(int count) {
    isNotNull();
    check().withFailureMessage("is stroke count")
        .that(actual().getStrokesCount())
        .isEqualTo(count);
    return this;
  }

  private static class GestureSubjectFactory extends SubjectFactory<GestureSubject, Gesture> {
    @Override
    public GestureSubject getSubject(FailureStrategy fs, Gesture that) {
      return new GestureSubject(fs, that);
    }
  }
}
