package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.Display;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.util.Arrays;

import static android.os.Build.VERSION_CODES.FROYO;
import static android.os.Build.VERSION_CODES.HONEYCOMB_MR2;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.KITKAT_WATCH;
import static android.view.Surface.ROTATION_0;
import static android.view.Surface.ROTATION_180;
import static android.view.Surface.ROTATION_270;
import static android.view.Surface.ROTATION_90;

public class DisplaySubject extends BaseSubject<DisplaySubject, Display> {

  public static final DisplaySubjectFactory FACTORY = new DisplaySubjectFactory();

  public DisplaySubject(FailureStrategy failureStrategy, Display actual) {
    super(failureStrategy, actual);
  }

  public DisplaySubject isDisplayId(int id) {
    isNotNull();
    check().withFailureMessage("is display id")
        .that(actual().getDisplayId())
        .isEqualTo(id);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public DisplaySubject hasFlag(int flag) {
    isNotNull();
    check().withFailureMessage("has flag")
        .that(actual().getFlags() & flag)
        .isNotEqualTo(0);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public DisplaySubject isFlags(int flags) {
    isNotNull();
    check().withFailureMessage("is flags")
        .that(actual().getFlags())
        .isEqualTo(flags);
    return this;
  }

  public DisplaySubject isHeight(int height) {
    isNotNull();
    check().withFailureMessage("is height")
        .that(actual().getHeight())
        .isEqualTo(height);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public DisplaySubject isName(String name) {
    isNotNull();
    check().withFailureMessage("is name")
        .that(actual().getName())
        .isEqualTo(name);
    return this;
  }

  public DisplaySubject isOrientation(int orientation) {
    isNotNull();
    check().withFailureMessage("is orientation")
        .that(actual().getOrientation())
        .isEqualTo(orientation);
    return this;
  }

  public DisplaySubject isPortrait() {
    isNotNull();
    check().withFailureMessage("is portrait")
        .that(actual().getOrientation())
        .isIn(Arrays.asList(ROTATION_0, ROTATION_180));
    return this;
  }

  public DisplaySubject isLandscape() {
    isNotNull();
    check().withFailureMessage("is landscape")
        .that(actual().getOrientation())
        .isIn(Arrays.asList(ROTATION_90, ROTATION_270));
    return this;
  }

  public DisplaySubject isPixelFormat(int format) {
    isNotNull();
    check().withFailureMessage("is pixel format")
        .that(actual().getPixelFormat())
        .isEqualTo(format);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public DisplaySubject isRealSize(int width, int height) {
    isNotNull();
    Point actualSize = new Point();
    actual().getRealSize(actualSize);
    check().withFailureMessage("is real size width")
        .that(actualSize.x)
        .isEqualTo(width);
    check().withFailureMessage("is real size height")
        .that(actualSize.y)
        .isEqualTo(height);
    return this;
  }

  public DisplaySubject isRefreshRate(float rate) {
    isNotNull();
    check().withFailureMessage("is refresh rate")
        .that(actual().getRefreshRate())
        .isEqualTo(rate);
    return this;
  }

  @TargetApi(FROYO)
  public DisplaySubject isRotation(int rotation) {
    isNotNull();
    check().withFailureMessage("is rotation")
        .that(actual().getRotation())
        .isEqualTo(rotation);
    return this;
  }

  @TargetApi(HONEYCOMB_MR2)
  public DisplaySubject isSize(int width, int height) {
    isNotNull();
    Point actualSize = new Point();
    actual().getSize(actualSize);
    check().withFailureMessage("is size width")
        .that(actualSize.x)
        .isEqualTo(width);
    check().withFailureMessage("is size height")
        .that(actualSize.y)
        .isEqualTo(height);
    return this;
  }

  @TargetApi(KITKAT_WATCH)
  public DisplaySubject hasState(int state) {
    isNotNull();
    check().withFailureMessage("is state")
        .that(actual().getState())
        .isEqualTo(state);
    return this;
  }

  public DisplaySubject isWidth(int width) {
    isNotNull();
    check().withFailureMessage("is width")
        .that(actual().getWidth())
        .isEqualTo(width);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public DisplaySubject isValid() {
    isNotNull();
    check().withFailureMessage("is valid")
        .that(actual().isValid())
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public DisplaySubject isNotValid() {
    isNotNull();
    check().withFailureMessage("is not valid")
        .that(actual().isValid())
        .isFalse();
    return this;
  }

  private static class DisplaySubjectFactory extends SubjectFactory<DisplaySubject, Display> {
    @Override
    public DisplaySubject getSubject(FailureStrategy fs, Display that) {
      return new DisplaySubject(fs, that);
    }
  }
}
