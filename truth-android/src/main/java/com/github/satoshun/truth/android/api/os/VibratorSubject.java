package com.github.satoshun.truth.android.api.os;

import android.annotation.TargetApi;
import android.os.Vibrator;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

public class VibratorSubject extends BaseSubject<VibratorSubject, Vibrator> {

  public static final VibratorSubjectFactory FACTORY = new VibratorSubjectFactory();

  public VibratorSubject(FailureStrategy failureStrategy, Vibrator actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(HONEYCOMB)
  public VibratorSubject hasVibrator() {
    isNotNull();
    check().withFailureMessage("has vibrator")
        .that(actual().hasVibrator())
        .isTrue();
    return this;
  }

  @TargetApi(HONEYCOMB)
  public VibratorSubject hasNoVibrator() {
    isNotNull();
    check().withFailureMessage("has no vibrator")
        .that(actual().hasVibrator())
        .isFalse();
    return this;
  }

  private static class VibratorSubjectFactory extends SubjectFactory<VibratorSubject, Vibrator> {
    @Override
    public VibratorSubject getSubject(FailureStrategy fs, Vibrator that) {
      return new VibratorSubject(fs, that);
    }
  }
}
