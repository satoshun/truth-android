package com.github.satoshun.truth.android.api.widget;

import android.widget.Chronometer;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class ChronometerSubject extends TextViewSubject<ChronometerSubject, Chronometer> {

  public static final ChronometerSubjectFactory FACTORY = new ChronometerSubjectFactory();

  public ChronometerSubject(FailureStrategy failureStrategy, Chronometer actual) {
    super(failureStrategy, actual);
  }

  public ChronometerSubject isBase(long base) {
    isNotNull();
    check().withFailureMessage("is base")
        .that(actual().getBase())
        .isEqualTo(base);
    return this;
  }

  public ChronometerSubject isFormat(String format) {
    isNotNull();
    check().withFailureMessage("is format")
        .that(actual().getFormat())
        .isEqualTo(format);
    return this;
  }

  private static class ChronometerSubjectFactory extends SubjectFactory<ChronometerSubject, Chronometer> {
    @Override
    public ChronometerSubject getSubject(FailureStrategy fs, Chronometer that) {
      return new ChronometerSubject(fs, that);
    }
  }
}
