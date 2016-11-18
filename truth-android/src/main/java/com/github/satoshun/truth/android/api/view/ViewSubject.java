package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;
import com.google.common.truth.TestVerb;
import com.google.common.truth.Truth;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

/**
 * Propositions for View subject
 */
public abstract class ViewSubject<S extends ViewSubject<S, T>, T extends View> extends BaseSubject<S, T> {

  public static final ViewSubjectFactory FACTORY = new ViewSubjectFactory();

  private static final TestVerb ASSERT = Truth.assert_();

  ViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(HONEYCOMB)
  public S sameAsAlpha(float alpha) {
    isNotNull();
    ASSERT.withFailureMessage("same as alpha")
            .that(alpha)
            .isEqualTo(actual().getAlpha());
    return myself();
  }

  public S sameAsAnimation(Animation animation) {
    isNotNull();
    ASSERT.withFailureMessage("same as animation")
            .that(animation)
            .isEqualTo(actual().getAnimation());
    return myself();
  }

  public S sameAsBackground(Drawable background) {
    isNotNull();
    ASSERT.withFailureMessage("same as background")
            .that(background)
            .isEqualTo(actual().getBackground());
    return myself();
  }

  public S sameAsWidth(int width) {
    isNotNull();
    ASSERT.withFailureMessage("same as width")
            .that(width)
            .isEqualTo(actual().getWidth());
    return myself();
  }

  public S sameAsHeight(int height) {
    isNotNull();
    ASSERT.withFailureMessage("same as height")
            .that(height)
            .isEqualTo(actual().getHeight());
    return myself();
  }

  public S sameAsId(int id) {
    isNotNull();
    ASSERT.withFailureMessage("same as id")
            .that(id)
            .isEqualTo(actual().getId());
    return myself();
  }

  public S isVisible() {
    isNotNull();
    ASSERT.withFailureMessage("is visible")
            .that(View.VISIBLE)
            .isEqualTo(actual().getVisibility());
    return myself();
  }

  public S isNotVisible() {
    isNotNull();
    ASSERT.withFailureMessage("is visible")
            .that(View.VISIBLE)
            .isNotEqualTo(actual().getVisibility());
    return myself();
  }

  public S isClickable() {
    isNotNull();
    ASSERT.withFailureMessage("is clickable")
            .that(actual().isClickable())
            .isTrue();
    return myself();
  }

  public S isNotClickable() {
    isNotNull();
    ASSERT.withFailureMessage("is not clickable")
            .that(actual().isClickable())
            .isFalse();
    return myself();
  }

  @SuppressWarnings("unchecked")
  protected S myself() {
    return (S) this;
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
