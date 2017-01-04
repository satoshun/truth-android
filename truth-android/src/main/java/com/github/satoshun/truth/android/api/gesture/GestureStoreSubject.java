package com.github.satoshun.truth.android.api.gesture;

import android.gesture.GestureStore;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class GestureStoreSubject extends BaseSubject<GestureStoreSubject, GestureStore> {

  public static final GestureStoreSubjectFactory FACTORY = new GestureStoreSubjectFactory();

  public GestureStoreSubject(FailureStrategy failureStrategy, GestureStore actual) {
    super(failureStrategy, actual);
  }

  public GestureStoreSubject isOrientationStyle(int style) {
    isNotNull();
    check().withFailureMessage("is orientation style")
        .that(actual().getOrientationStyle())
        .isEqualTo(style);
    return this;
  }

  public GestureStoreSubject isSequenceType(int type) {
    isNotNull();
    check().withFailureMessage("is sequence type")
        .that(actual().getSequenceType())
        .isEqualTo(type);
    return this;
  }

  public GestureStoreSubject isChanged() {
    isNotNull();
    check().withFailureMessage("is changed")
        .that(actual().hasChanged())
        .isTrue();
    return this;
  }

  public GestureStoreSubject isNotChanged() {
    isNotNull();
    check().withFailureMessage("is not changed")
        .that(actual().hasChanged())
        .isFalse();
    return this;
  }

  private static class GestureStoreSubjectFactory extends SubjectFactory<GestureStoreSubject, GestureStore> {
    @Override
    public GestureStoreSubject getSubject(FailureStrategy fs, GestureStore that) {
      return new GestureStoreSubject(fs, that);
    }
  }
}
