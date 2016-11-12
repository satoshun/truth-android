package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

public abstract class ViewSubject<S extends ViewSubject<S, T>, T extends View> extends Subject<S, T> {

  public static final ViewSubjectFactory FACTORY = new ViewSubjectFactory();

  ViewSubject(FailureStrategy failureStrategy, T actual) {
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

  public ViewSubject sameAsId(int id) {
    isNotNull();
    if (actual().getId() != id) {
      fail("same as id", actual().getId());
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

  public ViewSubject isClickable() {
    isNotNull();
    if (!actual().isClickable()) {
      fail("is clickable", actual().isClickable());
    }
    return this;
  }

  public ViewSubject isNotClickable() {
    isNotNull();
    if (actual().isClickable()) {
      fail("is not clickable", actual().isClickable());
    }
    return this;
  }

  private static class ViewSubjectImpl extends ViewSubject<ViewSubjectImpl, View> {
    ViewSubjectImpl(FailureStrategy failureStrategy, View actual) {
      super(failureStrategy, actual);
    }
  }

  private static class ViewSubjectFactory extends SubjectFactory<ViewSubjectImpl, View> {
    @Override
    public ViewSubjectImpl getSubject(FailureStrategy fs, View that) {
      return new ViewSubjectImpl(fs, that);
    }
  }
}
