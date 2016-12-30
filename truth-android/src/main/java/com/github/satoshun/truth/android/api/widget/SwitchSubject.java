package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.Switch;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;

@TargetApi(ICE_CREAM_SANDWICH)
public class SwitchSubject extends CompoundButtonSubject<SwitchSubject, Switch> {

  public static final SwitchSubjectFactory FACTORY = new SwitchSubjectFactory();

  public SwitchSubject(FailureStrategy failureStrategy, Switch actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(JELLY_BEAN)
  public SwitchSubject isSwitchMinWidth(int width) {
    isNotNull();
    check().withFailureMessage("is switch min width")
        .that(actual().getSwitchMinWidth())
        .isEqualTo(width);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SwitchSubject isSwitchPadding(int padding) {
    isNotNull();
    check().withFailureMessage("is switch padding")
        .that(actual().getSwitchPadding())
        .isEqualTo(padding);
    return this;
  }

  public SwitchSubject isOnText(CharSequence text) {
    isNotNull();
    check().withFailureMessage("is on text")
        .that(actual().getTextOn())
        .isEqualTo(text);
    return this;
  }

  public SwitchSubject isOnText(int resId) {
    isNotNull();
    return isOnText(actual().getContext().getString(resId));
  }

  public SwitchSubject isOffText(CharSequence text) {
    isNotNull();
    check().withFailureMessage("is off text")
        .that(actual().getTextOff())
        .isEqualTo(text);
    return this;
  }

  public SwitchSubject isOffText(int resId) {
    isNotNull();
    return isOffText(actual().getContext().getString(resId));
  }

  @TargetApi(JELLY_BEAN)
  public SwitchSubject isThumbDrawable(Drawable drawable) {
    isNotNull();
    check().withFailureMessage("is thumb drawable")
        .that(actual().getThumbDrawable())
        .isSameAs(drawable);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SwitchSubject isThumbTextPadding(int padding) {
    isNotNull();
    check().withFailureMessage("is thumb text padding")
        .that(actual().getThumbTextPadding())
        .isEqualTo(padding);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SwitchSubject isTrackDrawable(Drawable drawable) {
    isNotNull();
    check().withFailureMessage("is track drawable")
        .that(actual().getTrackDrawable())
        .isSameAs(drawable);
    return this;
  }

  private static class SwitchSubjectFactory extends SubjectFactory<SwitchSubject, Switch> {
    @Override
    public SwitchSubject getSubject(FailureStrategy fs, Switch that) {
      return new SwitchSubject(fs, that);
    }
  }
}
