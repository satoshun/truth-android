package com.github.satoshun.truth.android.api.app;

import android.annotation.TargetApi;
import android.app.KeyguardManager;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public class KeyguardManagerSubject extends BaseSubject<KeyguardManagerSubject, KeyguardManager> {

  public static final KeyguardManagerSubjectFactory FACTORY = new KeyguardManagerSubjectFactory();

  public KeyguardManagerSubject(FailureStrategy failureStrategy, KeyguardManager actual) {
    super(failureStrategy, actual);
  }

  public KeyguardManagerSubject isRestrictedInputMode() {
    isNotNull();
    check().withFailureMessage("is restricted input mode")
        .that(actual().inKeyguardRestrictedInputMode())
        .isTrue();
    return this;
  }

  public KeyguardManagerSubject isUnrestrictedInputMode() {
    isNotNull();
    check().withFailureMessage("is unrestricted input mode")
        .that(actual().inKeyguardRestrictedInputMode())
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public KeyguardManagerSubject isLockedKeyguard() {
    isNotNull();
    check().withFailureMessage("is locked keyguard")
        .that(actual().isKeyguardLocked())
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public KeyguardManagerSubject isUnlockedKeyguard() {
    isNotNull();
    check().withFailureMessage("is unlocked keyguard")
        .that(actual().isKeyguardLocked())
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public KeyguardManagerSubject isSecureKeyguard() {
    isNotNull();
    check().withFailureMessage("is secure keyguard")
        .that(actual().isKeyguardSecure())
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public KeyguardManagerSubject isInsecureKeyguard() {
    isNotNull();
    check().withFailureMessage("is insecure keyguard")
        .that(actual().isKeyguardSecure())
        .isFalse();
    return this;
  }

  private static class KeyguardManagerSubjectFactory extends SubjectFactory<KeyguardManagerSubject, KeyguardManager> {
    @Override
    public KeyguardManagerSubject getSubject(FailureStrategy fs, KeyguardManager that) {
      return new KeyguardManagerSubject(fs, that);
    }
  }
}
