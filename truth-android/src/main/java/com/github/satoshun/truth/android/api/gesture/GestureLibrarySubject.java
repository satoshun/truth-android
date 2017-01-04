package com.github.satoshun.truth.android.api.gesture;

import android.gesture.GestureLibrary;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class GestureLibrarySubject extends BaseSubject<GestureLibrarySubject, GestureLibrary> {

  public static final GestureLibrarySubjectFactory FACTORY = new GestureLibrarySubjectFactory();

  public GestureLibrarySubject(FailureStrategy failureStrategy, GestureLibrary actual) {
    super(failureStrategy, actual);
  }

  public GestureLibrarySubject isOrientationStyle(int style) {
    isNotNull();
    check().withFailureMessage("is orientation style")
        .that(actual().getOrientationStyle())
        .isEqualTo(style);
    return this;
  }

  public GestureLibrarySubject isSequenceType(int type) {
    isNotNull();
    check().withFailureMessage("is sequence type")
        .that(actual().getSequenceType())
        .isEqualTo(type);
    return this;
  }

  public GestureLibrarySubject isReadOnly() {
    isNotNull();
    check().withFailureMessage("is read only")
        .that(actual().isReadOnly())
        .isTrue();
    return this;
  }

  public GestureLibrarySubject isNotReadOnly() {
    isNotNull();
    check().withFailureMessage("is not read only")
        .that(actual().isReadOnly())
        .isFalse();
    return this;
  }

  private static class GestureLibrarySubjectFactory extends SubjectFactory<GestureLibrarySubject, GestureLibrary> {
    @Override
    public GestureLibrarySubject getSubject(FailureStrategy fs, GestureLibrary that) {
      return new GestureLibrarySubject(fs, that);
    }
  }
}
