package com.github.satoshun.truth.android.api.app;

import android.content.Intent;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.app.Instrumentation.ActivityResult;

public class ActivityResultSubject extends BaseSubject<ActivityResultSubject, ActivityResult> {

  public static final ActivityResultSubjectFactory FACTORY = new ActivityResultSubjectFactory();

  public ActivityResultSubject(FailureStrategy failureStrategy, ActivityResult actual) {
    super(failureStrategy, actual);
  }

  public ActivityResultSubject isResultCode(int code) {
    isNotNull();
    check().withFailureMessage("is result code")
        .that(actual().getResultCode())
        .isEqualTo(code);
    return this;
  }

  public ActivityResultSubject hasResultData(Intent intent) {
    isNotNull();
    check().withFailureMessage("is result data")
        .that(actual().getResultData())
        .isEqualTo(intent);
    return this;
  }

  private static class ActivityResultSubjectFactory extends SubjectFactory<ActivityResultSubject, ActivityResult> {
    @Override
    public ActivityResultSubject getSubject(FailureStrategy fs, ActivityResult that) {
      return new ActivityResultSubject(fs, that);
    }
  }
}
