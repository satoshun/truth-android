package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.KITKAT;

/**
 * Propositions for View subject
 */
public abstract class ViewSubject<S extends ViewSubject<S, T>, T extends View>
    extends BaseSubject<S, T> {

  public static final ViewSubjectFactory FACTORY = new ViewSubjectFactory();

  ViewSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(HONEYCOMB)
  public S isAlpha(float alpha) {
    isNotNull();
    check().withFailureMessage("is alpha")
        .that(alpha)
        .isEqualTo(actual().getAlpha());
    return myself();
  }

  public S isAnimation(Animation animation) {
    isNotNull();
    check().withFailureMessage("is animation")
        .that(animation)
        .isEqualTo(actual().getAnimation());
    return myself();
  }

  public S isBackground(Drawable background) {
    isNotNull();
    check().withFailureMessage("is background")
        .that(background)
        .isEqualTo(actual().getBackground());
    return myself();
  }

  public S isWidth(int width) {
    isNotNull();
    check().withFailureMessage("is width")
        .that(width)
        .isEqualTo(actual().getWidth());
    return myself();
  }

  public S isHeight(int height) {
    isNotNull();
    check().withFailureMessage("is height")
        .that(height)
        .isEqualTo(actual().getHeight());
    return myself();
  }

  public S isId(int id) {
    isNotNull();
    check().withFailureMessage("is id")
        .that(id)
        .isEqualTo(actual().getId());
    return myself();
  }

  public S isVisible() {
    isNotNull();
    check().withFailureMessage("is visible")
        .that(View.VISIBLE)
        .isEqualTo(actual().getVisibility());
    return myself();
  }

  public S isNotVisible() {
    isNotNull();
    check().withFailureMessage("is visible")
        .that(View.VISIBLE)
        .isNotEqualTo(actual().getVisibility());
    return myself();
  }

  public S isClickable() {
    isNotNull();
    check().withFailureMessage("is clickable")
        .that(actual().isClickable())
        .isTrue();
    return myself();
  }

  public S isNotClickable() {
    isNotNull();
    check().withFailureMessage("is not clickable")
        .that(actual().isClickable())
        .isFalse();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isAttachedToWindow() {
    isNotNull();
    check().withFailureMessage("is attached to window")
        .that(actual().isAttachedToWindow())
        .isTrue();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isNotAttachedToWindow() {
    isNotNull();
    check().withFailureMessage("is not attached to window")
        .that(actual().isAttachedToWindow())
        .isFalse();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isResolvedLayoutDirection() {
    isNotNull();
    check().withFailureMessage("is resolvedLayoutDirection")
        .that(actual().isLayoutDirectionResolved())
        .isTrue();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isNotResolvedLayoutDirection() {
    isNotNull();
    check().withFailureMessage("is not resolvedLayoutDirection")
        .that(actual().isLayoutDirectionResolved())
        .isFalse();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isTextAlignmentResolvedIsTrue() {
    isNotNull();
    check().withFailureMessage("is textAlignmentResolved")
        .that(actual().isTextAlignmentResolved())
        .isTrue();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isNotTextAlignmentResolved() {
    isNotNull();
    check().withFailureMessage("is not textAlignmentResolved")
        .that(actual().isTextAlignmentResolved())
        .isFalse();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isResolvedTextDirection() {
    isNotNull();
    check().withFailureMessage("is resolvedTextDirection")
        .that(actual().isTextDirectionResolved())
        .isTrue();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isNotResolvedTextDirection() {
    isNotNull();
    check().withFailureMessage("is not resolvedTextDirection")
        .that(actual().isTextDirectionResolved())
        .isFalse();
    return myself();
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
