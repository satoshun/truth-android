package com.github.satoshun.truth.android.api.text;

import android.annotation.TargetApi;
import android.text.BidiFormatter;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

@TargetApi(JELLY_BEAN_MR2)
public class BidiFormatterSubject extends BaseSubject<BidiFormatterSubject, BidiFormatter> {

  public static final BidiFormatterSubjectFactory FACTORY = new BidiFormatterSubjectFactory();

  public BidiFormatterSubject(FailureStrategy failureStrategy, BidiFormatter actual) {
    super(failureStrategy, actual);
  }

  public BidiFormatterSubject isRtlContext() {
    isNotNull();
    check().withFailureMessage("is rtl context")
        .that(actual().isRtlContext())
        .isTrue();
    return this;
  }

  public BidiFormatterSubject isNotRtlContext() {
    isNotNull();
    check().withFailureMessage("is not rtl context")
        .that(actual().isRtlContext())
        .isFalse();
    return this;
  }

  private static class BidiFormatterSubjectFactory extends SubjectFactory<BidiFormatterSubject, BidiFormatter> {
    @Override
    public BidiFormatterSubject getSubject(FailureStrategy fs, BidiFormatter that) {
      return new BidiFormatterSubject(fs, that);
    }
  }
}
