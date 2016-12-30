package com.github.satoshun.truth.android.api.widget;

import android.widget.ToggleButton;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class ToggleButtonSubject extends CompoundButtonSubject<ToggleButtonSubject, ToggleButton> {

  public static final ToggleButtonSubjectFactory FACTORY = new ToggleButtonSubjectFactory();

  public ToggleButtonSubject(FailureStrategy failureStrategy, ToggleButton actual) {
    super(failureStrategy, actual);
  }

  public ToggleButtonSubject isOnText(CharSequence text) {
    isNotNull();
    check().withFailureMessage("is on text")
        .that(actual().getTextOn())
        .isEqualTo(text);
    return this;
  }

  public ToggleButtonSubject isOnText(int resId) {
    isNotNull();
    return isOnText(actual().getContext().getString(resId));
  }

  public ToggleButtonSubject isOffText(CharSequence text) {
    isNotNull();
    check().withFailureMessage("is off text")
        .that(actual().getTextOff())
        .isEqualTo(text);
    return this;
  }

  public ToggleButtonSubject isOffText(int resId) {
    isNotNull();
    return isOffText(actual().getContext().getString(resId));
  }

  private static class ToggleButtonSubjectFactory extends SubjectFactory<ToggleButtonSubject, ToggleButton> {
    @Override
    public ToggleButtonSubject getSubject(FailureStrategy fs, ToggleButton that) {
      return new ToggleButtonSubject(fs, that);
    }
  }
}
