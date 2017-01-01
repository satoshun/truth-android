package com.github.satoshun.truth.android.api.app;

import android.app.UiModeManager;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.app.UiModeManager.MODE_NIGHT_NO;


public class UiModeManagerSubject extends BaseSubject<UiModeManagerSubject, UiModeManager> {

  public static final UiModeManagerSubjectFactory FACTORY = new UiModeManagerSubjectFactory();

  public UiModeManagerSubject(FailureStrategy failureStrategy, UiModeManager actual) {
    super(failureStrategy, actual);
  }

  public UiModeManagerSubject isNightMode() {
    isNotNull();
    check().withFailureMessage("is night mode")
        .that(actual().getNightMode())
        .isNotEqualTo(MODE_NIGHT_NO);
    return this;
  }

  public UiModeManagerSubject isNotNightMode() {
    isNotNull();
    check().withFailureMessage("is not night mode")
        .that(actual().getNightMode())
        .isEqualTo(MODE_NIGHT_NO);
    return this;
  }

  public UiModeManagerSubject isInUiModeType(int mode) {
    isNotNull();
    check().withFailureMessage("is in ui mode type")
        .that(actual().getCurrentModeType())
        .isEqualTo(mode);
    return this;
  }

  public UiModeManagerSubject isNotInUiModeType(int mode) {
    isNotNull();
    check().withFailureMessage("is not in ui mode type")
        .that(actual().getCurrentModeType())
        .isNotEqualTo(mode);
    return this;
  }

  private static class UiModeManagerSubjectFactory extends SubjectFactory<UiModeManagerSubject, UiModeManager> {
    @Override
    public UiModeManagerSubject getSubject(FailureStrategy fs, UiModeManager that) {
      return new UiModeManagerSubject(fs, that);
    }
  }
}
