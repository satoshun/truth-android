package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public class CheckedTextViewSubject extends TextViewSubject<CheckedTextViewSubject, CheckedTextView> {

  public static final CheckedTextViewSubjectFactory FACTORY = new CheckedTextViewSubjectFactory();

  public CheckedTextViewSubject(FailureStrategy failureStrategy, CheckedTextView actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(JELLY_BEAN)
  public CheckedTextViewSubject isCheckMarkDrawable(Drawable drawable) {
    isNotNull();
    check().withFailureMessage("is check mark drawable")
        .that(actual().getCheckMarkDrawable())
        .isSameAs(drawable);
    return this;
  }

  public CheckedTextViewSubject isChecked() {
    isNotNull();
    check().withFailureMessage("is checked")
        .that(actual().isChecked())
        .isTrue();
    return this;
  }

  public CheckedTextViewSubject isNotChecked() {
    isNotNull();
    check().withFailureMessage("is not checked")
        .that(actual().isChecked())
        .isFalse();
    return this;
  }

  private static class CheckedTextViewSubjectFactory extends SubjectFactory<CheckedTextViewSubject, CheckedTextView> {
    @Override
    public CheckedTextViewSubject getSubject(FailureStrategy fs, CheckedTextView that) {
      return new CheckedTextViewSubject(fs, that);
    }
  }
}
