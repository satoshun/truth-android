package com.github.satoshun.truth.android.api.view.accessibility;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityManager;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;

public class AccessibilityManagerSubject extends BaseSubject<AccessibilityManagerSubject, AccessibilityManager> {

  public static final AccessibilityManagerSubjectFactory FACTORY = new AccessibilityManagerSubjectFactory();

  public AccessibilityManagerSubject(FailureStrategy failureStrategy, AccessibilityManager actual) {
    super(failureStrategy, actual);
  }

  public AccessibilityManagerSubject isEnabled() {
    isNotNull();
    check().withFailureMessage("is enabled")
        .that(actual().isEnabled())
        .isTrue();
    return this;
  }

  public AccessibilityManagerSubject isDisabled() {
    isNotNull();
    check().withFailureMessage("is disabled")
        .that(actual().isEnabled())
        .isFalse();
    return this;
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public AccessibilityManagerSubject isTouchExplorationEnabled() {
    isNotNull();
    check().withFailureMessage("is touch exploration enabled")
        .that(actual().isTouchExplorationEnabled())
        .isTrue();
    return this;
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public AccessibilityManagerSubject isTouchExplorationDisabled() {
    isNotNull();
    check().withFailureMessage("is touch exploration disabled")
        .that(actual().isTouchExplorationEnabled())
        .isFalse();
    return this;
  }

  private static class AccessibilityManagerSubjectFactory extends SubjectFactory<AccessibilityManagerSubject, AccessibilityManager> {
    @Override
    public AccessibilityManagerSubject getSubject(FailureStrategy fs, AccessibilityManager that) {
      return new AccessibilityManagerSubject(fs, that);
    }
  }
}
