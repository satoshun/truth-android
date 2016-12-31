package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public class ImageViewSubject extends BaseSubject<ImageViewSubject, ImageView> {

  public static final ImageViewSubjectFactory FACTORY = new ImageViewSubjectFactory();

  public ImageViewSubject(FailureStrategy failureStrategy, ImageView actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(HONEYCOMB)
  public ImageViewSubject isAligningBaselineToBottom() {
    isNotNull();
    check().withFailureMessage("is aligning baseline to bottom")
        .that(actual().getBaselineAlignBottom())
        .isTrue();
    return this;
  }

  @TargetApi(HONEYCOMB)
  public ImageViewSubject isNotAligningBaselineToBottom() {
    isNotNull();
    check().withFailureMessage("is not aligning baseline to bottom")
        .that(actual().getBaselineAlignBottom())
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ImageViewSubject isCroppingToPadding() {
    isNotNull();
    check().withFailureMessage("is cropping to padding")
        .that(actual().getCropToPadding())
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ImageViewSubject isNotCroppingToPadding() {
    isNotNull();
    check().withFailureMessage("is not cropping to padding")
        .that(actual().getCropToPadding())
        .isFalse();
    return this;
  }

  public ImageViewSubject isDrawable(Drawable drawable) {
    isNotNull();
    check().withFailureMessage("is drawable")
        .that(actual().getDrawable())
        .isSameAs(drawable);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ImageViewSubject isImageAlpha(int alpha) {
    isNotNull();
    check().withFailureMessage("is image alpha")
        .that(actual().getImageAlpha())
        .isEqualTo(alpha);
    return this;
  }

  public ImageViewSubject isScaleType(ImageView.ScaleType type) {
    isNotNull();
    check().withFailureMessage("is scale type")
        .that(actual().getScaleType())
        .isEqualTo(type);
    return this;
  }

  private static class ImageViewSubjectFactory extends SubjectFactory<ImageViewSubject, ImageView> {
    @Override
    public ImageViewSubject getSubject(FailureStrategy fs, ImageView that) {
      return new ImageViewSubject(fs, that);
    }
  }
}
