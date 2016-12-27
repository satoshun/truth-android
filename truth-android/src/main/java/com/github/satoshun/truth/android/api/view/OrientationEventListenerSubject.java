package com.github.satoshun.truth.android.api.view;

import android.view.OrientationEventListener;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class OrientationEventListenerSubject extends BaseSubject<OrientationEventListenerSubject, OrientationEventListener> {

  public static final OrientationEventListenerSubjectFactory FACTORY = new OrientationEventListenerSubjectFactory();

  public OrientationEventListenerSubject(FailureStrategy failureStrategy, OrientationEventListener actual) {
    super(failureStrategy, actual);
  }

  public OrientationEventListenerSubject canDetectOrientation() {
    isNotNull();
    check().withFailureMessage("can detect orientation")
        .that(actual().canDetectOrientation())
        .isTrue();
    return myself();
  }

  public OrientationEventListenerSubject cannotDetectOrientation() {
    isNotNull();
    check().withFailureMessage("can detect orientation")
        .that(actual().canDetectOrientation())
        .isFalse();
    return myself();
  }

  private static class OrientationEventListenerSubjectFactory extends SubjectFactory<OrientationEventListenerSubject, OrientationEventListener> {
    @Override
    public OrientationEventListenerSubject getSubject(FailureStrategy fs, OrientationEventListener that) {
      return new OrientationEventListenerSubject(fs, that);
    }
  }
}
