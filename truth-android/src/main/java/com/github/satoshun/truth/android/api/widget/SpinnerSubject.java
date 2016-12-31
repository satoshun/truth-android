package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.Spinner;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public class SpinnerSubject extends AbsSpinnerSubject<SpinnerSubject, Spinner> {

  public static final SpinnerSubjectFactory FACTORY = new SpinnerSubjectFactory();

  public SpinnerSubject(FailureStrategy failureStrategy, Spinner actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(JELLY_BEAN)
  public SpinnerSubject isDropDownHorizontalOffset(int offset) {
    isNotNull();
    check().withFailureMessage("is drop down horizontal offset")
        .that(actual().getDropDownHorizontalOffset())
        .isEqualTo(offset);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SpinnerSubject isDropDownVerticalOffset(int offset) {
    isNotNull();
    check().withFailureMessage("is drop down vertical offset")
        .that(actual().getDropDownVerticalOffset())
        .isEqualTo(offset);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SpinnerSubject isDropDownWidth(int width) {
    isNotNull();
    check().withFailureMessage("is drop down width")
        .that(actual().getDropDownWidth())
        .isEqualTo(width);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SpinnerSubject isGravity(int gravity) {
    isNotNull();
    check().withFailureMessage("is gravity")
        .that(actual().getGravity())
        .isEqualTo(gravity);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SpinnerSubject isPopupBackground(Drawable background) {
    isNotNull();
    check().withFailureMessage("is popup background")
        .that(actual().getPopupBackground())
        .isSameAs(background);
    return this;
  }

  public SpinnerSubject isPrompt(CharSequence text) {
    isNotNull();
    check().withFailureMessage("is prompt")
        .that(actual().getPrompt())
        .isEqualTo(text);
    return this;
  }

  public SpinnerSubject isPrompt(int resId) {
    isNotNull();
    return isPrompt(actual().getContext().getString(resId));
  }

  private static class SpinnerSubjectFactory extends SubjectFactory<SpinnerSubject, Spinner> {
    @Override
    public SpinnerSubject getSubject(FailureStrategy fs, Spinner that) {
      return new SpinnerSubject(fs, that);
    }
  }
}
