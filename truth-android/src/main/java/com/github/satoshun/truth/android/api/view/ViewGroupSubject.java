package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

/**
 * Propositions for ViewGroup subject
 */
public abstract class ViewGroupSubject<S extends ViewGroupSubject<S, T>, T extends ViewGroup>
    extends ViewSubject<S, T> {

  public static final ViewGroupSubjectFactory FACTORY = new ViewGroupSubjectFactory();

  public ViewGroupSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S addStatesFromChildren() {
    isNotNull();
    check().withFailureMessage("add states from children")
        .that(actual().addStatesFromChildren())
        .isTrue();
    return myself();
  }

  public S doesNotAddStatesFromChildren() {
    isNotNull();
    check().withFailureMessage("does not add states from children")
        .that(actual().addStatesFromChildren())
        .isFalse();
    return myself();
  }

  public S isChildCount(int count) {
    isNotNull();
    check().withFailureMessage("is child count")
        .that(actual().getChildCount())
        .isEqualTo(count);
    return myself();
  }

  public S isDescendantFocusability(int focusability) {
    isNotNull();
    check().withFailureMessage("is descendant focusability")
        .that(actual().getDescendantFocusability())
        .isEqualTo(focusability);
    return myself();
  }

  public S isFocusedChild(View view) {
    isNotNull();
    check().withFailureMessage("is focused child")
        .that(actual().getFocusedChild())
        .isSameAs(view);
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isLayoutMode(int layoutMode) {
    isNotNull();
    check().withFailureMessage("is layout mode")
        .that(actual().getLayoutMode())
        .isEqualTo(layoutMode);
    return myself();
  }

  public S isPersistentDrawingCache(int cache) {
    isNotNull();
    check().withFailureMessage("is persistent drawing cache")
        .that(actual().getPersistentDrawingCache())
        .isEqualTo(cache);
    return myself();
  }

  public S isAlwaysDrawnWithCache() {
    isNotNull();
    check().withFailureMessage("is always drawn with cache")
        .that(actual().isAlwaysDrawnWithCacheEnabled())
        .isTrue();
    return myself();
  }

  public S isNotAlwaysDrawnWithCache() {
    isNotNull();
    check().withFailureMessage("is not always drawn with cache")
        .that(actual().isAlwaysDrawnWithCacheEnabled())
        .isFalse();
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isClipChildren() {
    isNotNull();
    check().withFailureMessage("is clip children")
        .that(actual().getClipChildren())
        .isTrue();
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isNotClippingChildren() {
    isNotNull();
    check().withFailureMessage("is not clip children")
        .that(actual().getClipChildren())
        .isFalse();
    return myself();
  }

  public S isAnimationCacheEnabled() {
    isNotNull();
    check().withFailureMessage("is animation cache enabled")
        .that(actual().isAnimationCacheEnabled())
        .isTrue();
    return myself();
  }

  public S isAnimationCacheDisabled() {
    isNotNull();
    check().withFailureMessage("is animation cache disabled")
        .that(actual().isAnimationCacheEnabled())
        .isFalse();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isMotionEventSplittingEnabled() {
    isNotNull();
    check().withFailureMessage("is motion event splitting enabled")
        .that(actual().isMotionEventSplittingEnabled())
        .isTrue();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S hasMotionEventSplittingDisabled() {
    isNotNull();
    check().withFailureMessage("is motion event splitting disabled")
        .that(actual().isMotionEventSplittingEnabled())
        .isFalse();
    return myself();
  }

  private static class ViewGroupSubjectImpl extends ViewGroupSubject<ViewGroupSubjectImpl, ViewGroup> {
    ViewGroupSubjectImpl(FailureStrategy failureStrategy, ViewGroup actual) {
      super(failureStrategy, actual);
    }
  }

  private static class ViewGroupSubjectFactory extends SubjectFactory<ViewGroupSubjectImpl, ViewGroup> {
    @Override
    public ViewGroupSubjectImpl getSubject(FailureStrategy fs, ViewGroup that) {
      return new ViewGroupSubjectImpl(fs, that);
    }
  }
}
