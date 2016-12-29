package com.github.satoshun.truth.android.api.view;

import android.view.Surface;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class SurfaceSubject extends BaseSubject<SurfaceSubject, Surface> {

  public static final SurfaceSubjectFactory FACTORY = new SurfaceSubjectFactory();

  public SurfaceSubject(FailureStrategy failureStrategy, Surface actual) {
    super(failureStrategy, actual);
  }

  public SurfaceSubject isValid() {
    isNotNull();
    check().withFailureMessage("is valid")
        .that(actual().isValid())
        .isTrue();
    return myself();
  }

  public SurfaceSubject isNotValid() {
    isNotNull();
    check().withFailureMessage("is not valid")
        .that(actual().isValid())
        .isFalse();
    return myself();
  }

  private static class SurfaceSubjectFactory extends SubjectFactory<SurfaceSubject, Surface> {
    @Override
    public SurfaceSubject getSubject(FailureStrategy fs, Surface that) {
      return new SurfaceSubject(fs, that);
    }
  }
}
