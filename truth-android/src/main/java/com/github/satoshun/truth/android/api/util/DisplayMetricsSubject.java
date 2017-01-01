package com.github.satoshun.truth.android.api.util;

import android.util.DisplayMetrics;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class DisplayMetricsSubject extends BaseSubject<DisplayMetricsSubject, DisplayMetrics> {

  public static final DisplayMetricsSubjectFactory FACTORY = new DisplayMetricsSubjectFactory();

  public DisplayMetricsSubject(FailureStrategy failureStrategy, DisplayMetrics actual) {
    super(failureStrategy, actual);
  }

  public DisplayMetricsSubject isDensity(float density) {
    isNotNull();
    check().withFailureMessage("is density")
        .that(actual().density)
        .isEqualTo(density);
    return this;
  }

  public DisplayMetricsSubject isDpi(int dpi) {
    isNotNull();
    check().withFailureMessage("is dpi")
        .that(actual().densityDpi)
        .isEqualTo(dpi);
    return this;
  }

  public DisplayMetricsSubject isHeight(int height) {
    isNotNull();
    check().withFailureMessage("is height")
        .that(actual().heightPixels)
        .isEqualTo(height);
    return this;
  }

  public DisplayMetricsSubject isScaledDensity(float scaledDensity) {
    isNotNull();
    check().withFailureMessage("is scaled density")
        .that(actual().scaledDensity)
        .isEqualTo(scaledDensity);
    return this;
  }

  public DisplayMetricsSubject isWidth(int width) {
    isNotNull();
    check().withFailureMessage("is width")
        .that(actual().widthPixels)
        .isEqualTo(width);
    return this;
  }

  public DisplayMetricsSubject isXDpi(float xDpi) {
    isNotNull();
    check().withFailureMessage("is x dpi")
        .that(actual().xdpi)
        .isEqualTo(xDpi);
    return this;
  }

  public DisplayMetricsSubject isYDpi(float yDpi) {
    isNotNull();
    check().withFailureMessage("is y dpi")
        .that(actual().ydpi)
        .isEqualTo(yDpi);
    return this;
  }

  private static class DisplayMetricsSubjectFactory extends SubjectFactory<DisplayMetricsSubject, DisplayMetrics> {
    @Override
    public DisplayMetricsSubject getSubject(FailureStrategy fs, DisplayMetrics that) {
      return new DisplayMetricsSubject(fs, that);
    }
  }
}
