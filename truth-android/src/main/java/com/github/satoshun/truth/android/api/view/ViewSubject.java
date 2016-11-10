package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

public class ViewSubject extends Subject<ViewSubject, View> {

  public static final ViewSubjectFactory FACTORY = new ViewSubjectFactory();

  ViewSubject(FailureStrategy failureStrategy, View actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(HONEYCOMB)
  public ViewSubject sameAsAlpha(float alpha) {
    isNotNull();
    if (actual().getAlpha() != alpha) {
      fail("same as alpha", actual().getAlpha());
    }
    return this;
  }

  public ViewSubject sameAsAnimation(Animation animation) {
    isNotNull();
    if (actual().getAnimation() != animation) {
      fail("same as animation", actual().getAnimation());
    }
    return this;
  }

  public ViewSubject sameAsBackground(Drawable background) {
    isNotNull();
    if (actual().getBackground() != background) {
      fail("same as background", actual().getBackground());
    }
    return this;
  }

  public ViewSubject sameAsWidth(int width) {
    isNotNull();
    if (actual().getWidth() != width) {
      fail("same as width", actual().getWidth());
    }
    return this;
  }

  public ViewSubject sameAsHeight(int height) {
    isNotNull();
    if (actual().getHeight() != height) {
      fail("same as height", actual().getHeight());
    }
    return this;
  }

  public ViewSubject isVisible() {
    isNotNull();
    if (actual().getVisibility() != View.VISIBLE) {
      fail("is visible", actual().getVisibility());
    }
    return this;
  }

  public ViewSubject isNotVisible() {
    isNotNull();
    if (actual().getVisibility() == View.VISIBLE) {
      fail("is not visible", actual().getVisibility());
    }
    return this;

  }

  private static class ViewSubjectFactory extends SubjectFactory<ViewSubject, View> {
    @Override
    public ViewSubject getSubject(FailureStrategy fs, View that) {
      return new ViewSubject(fs, that);
    }
  }
}