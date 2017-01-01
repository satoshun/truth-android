package com.github.satoshun.truth.android.api.os;

import android.annotation.TargetApi;
import android.os.PowerManager;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.KITKAT_WATCH;

public class PowerManagerSubject extends BaseSubject<PowerManagerSubject, PowerManager> {

  public static final PowerManagerSubjectFactory FACTORY = new PowerManagerSubjectFactory();

  public PowerManagerSubject(FailureStrategy failureStrategy, PowerManager actual) {
    super(failureStrategy, actual);
  }

  public PowerManagerSubject isScreenOn() {
    isNotNull();
    check().withFailureMessage("is screen on")
        .that(actual().isScreenOn())
        .isTrue();
    return this;
  }

  public PowerManagerSubject isScreenOff() {
    isNotNull();
    check().withFailureMessage("is screen off")
        .that(actual().isScreenOn())
        .isFalse();
    return this;
  }

  @TargetApi(KITKAT_WATCH)
  public PowerManagerSubject isInteractive() {
    isNotNull();
    check().withFailureMessage("is interactive")
        .that(actual().isInteractive())
        .isTrue();
    return this;
  }

  @TargetApi(KITKAT_WATCH)
  public PowerManagerSubject isNotInteractive() {
    isNotNull();
    check().withFailureMessage("is not interactive")
        .that(actual().isInteractive())
        .isFalse();
    return this;
  }

  private static class PowerManagerSubjectFactory extends SubjectFactory<PowerManagerSubject, PowerManager> {
    @Override
    public PowerManagerSubject getSubject(FailureStrategy fs, PowerManager that) {
      return new PowerManagerSubject(fs, that);
    }
  }
}
