package com.github.satoshun.truth.android.api.accessibilityservice;


import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

public class AccessibilityServiceInfoSubject extends BaseSubject<AccessibilityServiceInfoSubject, AccessibilityServiceInfo> {

  public static final AccessibilityServiceInfoSubjectFactory FACTORY = new AccessibilityServiceInfoSubjectFactory();

  public AccessibilityServiceInfoSubject(FailureStrategy failureStrategy, AccessibilityServiceInfo actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityServiceInfoSubject isCapabilities(int capabilities) {
    isNotNull();
    check().withFailureMessage("is capabilities")
        .that(actual().getCapabilities())
        .isEqualTo(capabilities);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityServiceInfoSubject isDescription(String description) {
    isNotNull();
    check().withFailureMessage("is description")
        .that(actual().getDescription())
        .isEqualTo(description);
    return this;
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public AccessibilityServiceInfoSubject isId(String id) {
    isNotNull();
    check().withFailureMessage("is id")
        .that(actual().getId())
        .isEqualTo(id);
    return this;
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public AccessibilityServiceInfoSubject isSettingsActivityName(String name) {
    isNotNull();
    check().withFailureMessage("is settings activity name")
        .that(actual().getSettingsActivityName())
        .isEqualTo(name);
    return this;
  }

  private static class AccessibilityServiceInfoSubjectFactory extends SubjectFactory<AccessibilityServiceInfoSubject, AccessibilityServiceInfo> {
    @Override
    public AccessibilityServiceInfoSubject getSubject(FailureStrategy fs, AccessibilityServiceInfo that) {
      return new AccessibilityServiceInfoSubject(fs, that);
    }
  }
}
