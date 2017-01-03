package com.github.satoshun.truth.android.api.view.accessibility;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityEvent;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public class AccessibilityEventSubject extends BaseSubject<AccessibilityEventSubject, AccessibilityEvent> {

  public static final AccessibilityEventSubjectFactory FACTORY = new AccessibilityEventSubjectFactory();

  public AccessibilityEventSubject(FailureStrategy failureStrategy, AccessibilityEvent actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityEventSubject isAction(int action) {
    isNotNull();
    check().withFailureMessage("is action")
        .that(actual().getAction())
        .isEqualTo(action);
    return this;
  }

  public AccessibilityEventSubject isEventTime(long time) {
    isNotNull();
    check().withFailureMessage("is event time")
        .that(actual().getEventTime())
        .isEqualTo(time);
    return this;
  }

  public AccessibilityEventSubject isEventType(int type) {
    isNotNull();
    check().withFailureMessage("is event type")
        .that(actual().getEventType())
        .isEqualTo(type);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityEventSubject isMovementGranularity(int granularity) {
    isNotNull();
    check().withFailureMessage("is movement granularity")
        .that(actual().getMovementGranularity())
        .isEqualTo(granularity);
    return this;
  }

  public AccessibilityEventSubject isPackageName(CharSequence name) {
    isNotNull();
    check().withFailureMessage("is package name")
        .that(actual().getPackageName())
        .isEqualTo(name);
    return this;
  }

  private static class AccessibilityEventSubjectFactory extends SubjectFactory<AccessibilityEventSubject, AccessibilityEvent> {
    @Override
    public AccessibilityEventSubject getSubject(FailureStrategy fs, AccessibilityEvent that) {
      return new AccessibilityEventSubject(fs, that);
    }
  }
}
