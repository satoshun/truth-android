package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static android.os.Build.VERSION_CODES.KITKAT;
import static android.os.Build.VERSION_CODES.LOLLIPOP;
import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * Propositions for View subject
 */
public abstract class ViewSubject<S extends ViewSubject<S, T>, T extends View>
    extends BaseSubject<S, T> {

  public static final ViewSubjectFactory FACTORY = new ViewSubjectFactory();

  public ViewSubject(FailureStrategy failureStrategy, T actual) {
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

  public S isBaseline(int baseline) {
    isNotNull();
    check().withFailureMessage("is baseline")
        .that(actual().getBaseline())
        .isEqualTo(baseline);
    return myself();
  }

  public S isBottom(int bottom) {
    isNotNull();
    check().withFailureMessage("is bottom")
        .that(actual().getBottom())
        .isEqualTo(bottom);
    return myself();
  }

  public S isContentDescription(CharSequence contentDescription) {
    isNotNull();
    check().withFailureMessage("is content description")
        .that(actual().getContentDescription())
        .isEqualTo(contentDescription);
    return myself();
  }

  public S isContentDescription(int resId) {
    isNotNull();
    return isContentDescription(actual().getContext().getString(resId));
  }

  public S isDrawingCacheBackgroundColor(int color) {
    isNotNull();
    check().withFailureMessage("is drawing cache background color")
        .that(actual().getDrawingCacheBackgroundColor())
        .isEqualTo(color);
    return myself();
  }

  public S isDrawingCacheQuality(int quality) {
    isNotNull();
    check().withFailureMessage("is drawing cache quality")
        .that(actual().getDrawingCacheQuality())
        .isEqualTo(quality);
    return myself();
  }

  @TargetApi(LOLLIPOP)
  public S isElevation(float elevation) {
    isNotNull();
    check().withFailureMessage("is elevation")
        .that(actual().getElevation())
        .isEqualTo(elevation);
    return myself();
  }

  public S isHeight(int height) {
    isNotNull();
    check().withFailureMessage("is height")
        .that(actual().getHeight())
        .isEqualTo(height);
    return myself();
  }

  public S isHorizontalFadingEdgeLength(int length) {
    isNotNull();
    check().withFailureMessage("is horizontal fading edge length")
        .that(actual().getHorizontalFadingEdgeLength())
        .isEqualTo(length);
    return myself();
  }

  public S isId(int id) {
    isNotNull();
    check().withFailureMessage("is id")
        .that(actual().getId())
        .isEqualTo(id);
    return myself();
  }

  public S isKeepingScreenOn() {
    isNotNull();
    check().withFailureMessage("is keeping screen on")
        .that(actual().getKeepScreenOn())
        .isTrue();
    return myself();
  }

  public S isNotKeepingScreenOn() {
    isNotNull();
    check().withFailureMessage("is not keeping screen on")
        .that(actual().getKeepScreenOn())
        .isFalse();
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isLabelFor(int id) {
    isNotNull();
    check().withFailureMessage("is label for")
        .that(actual().getLabelFor())
        .isEqualTo(id);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isLayerType(int type) {
    isNotNull();
    check().withFailureMessage("is layer type")
        .that(actual().getLayerType())
        .isEqualTo(type);
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isLayoutDirection(int direction) {
    isNotNull();
    check().withFailureMessage("is layout direction")
        .that(actual().getLayoutDirection())
        .isEqualTo(direction);
    return myself();
  }

  public S isLeft(int left) {
    isNotNull();
    check().withFailureMessage("is left")
        .that(actual().getLeft())
        .isEqualTo(left);
    return myself();
  }

  public S isMeasuredHeight(int height) {
    isNotNull();
    check().withFailureMessage("is measured height")
        .that(actual().getMeasuredHeight())
        .isEqualTo(height);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isMeasuredHeightAndState(int heightAndState) {
    isNotNull();
    check().withFailureMessage("is meaasured height and state")
        .that(actual().getMeasuredHeightAndState())
        .isEqualTo(heightAndState);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isMeasuredState(int state) {
    isNotNull();
    check().withFailureMessage("is measured state")
        .that(actual().getMeasuredState())
        .isEqualTo(state);
    return myself();
  }

  public S isMeasuredWidth(int width) {
    isNotNull();
    check().withFailureMessage("is measured width")
        .that(actual().getMeasuredWidth())
        .isEqualTo(width);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isMeasuredWidthAndState(int widthAndState) {
    isNotNull();
    check().withFailureMessage("is measured width and state")
        .that(actual().getMeasuredWidthAndState())
        .isEqualTo(widthAndState);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isMinimumHeight(int height) {
    isNotNull();
    check().withFailureMessage("is minimum height")
        .that(actual().getMinimumHeight())
        .isEqualTo(height);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isMinimumWidth(int width) {
    isNotNull();
    check().withFailureMessage("is minimum width")
        .that(actual().getMinimumWidth())
        .isEqualTo(width);
    return myself();
  }

  public S isNextFocusDownId(int id) {
    isNotNull();
    check().withFailureMessage("is next focus down id")
        .that(actual().getNextFocusDownId())
        .isEqualTo(id);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isNextFocusForwardId(int id) {
    isNotNull();
    check().withFailureMessage("is next focus forward id")
        .that(actual().getNextFocusForwardId())
        .isEqualTo(id);
    return myself();
  }

  public S idNextFocusLeftId(int id) {
    isNotNull();
    check().withFailureMessage("is next focus left id")
        .that(actual().getNextFocusLeftId())
        .isEqualTo(id);
    return myself();
  }

  public S isNextFocusRightId(int id) {
    isNotNull();
    check().withFailureMessage("is next focus right id")
        .that(actual().getNextFocusRightId())
        .isEqualTo(id);
    return myself();
  }

  public S isNextFocusUpId(int id) {
    isNotNull();
    check().withFailureMessage("is next focus up id")
        .that(actual().getNextFocusUpId())
        .isEqualTo(id);
    return myself();
  }

  public S isOverScrollMode(int mode) {
    isNotNull();
    check().withFailureMessage("is over scroll mode")
        .that(actual().getOverScrollMode())
        .isEqualTo(mode);
    return myself();
  }

  public S isPaddingBottom(int padding) {
    isNotNull();
    check().withFailureMessage("is padding bottom")
        .that(actual().getPaddingBottom())
        .isEqualTo(padding);
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isPaddingEnd(int padding) {
    isNotNull();
    check().withFailureMessage("is padding end")
        .that(actual().getPaddingEnd())
        .isEqualTo(padding);
    return myself();
  }

  public S isPaddingLeft(int padding) {
    isNotNull();
    check().withFailureMessage("is padding left")
        .that(actual().getPaddingLeft())
        .isEqualTo(padding);
    return myself();
  }

  public S isPaddingRight(int padding) {
    isNotNull();
    check().withFailureMessage("is padding right")
        .that(actual().getPaddingRight())
        .isEqualTo(padding);
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isPaddingStart(int padding) {
    isNotNull();
    check().withFailureMessage("is padding start")
        .that(actual().getPaddingStart())
        .isEqualTo(padding);
    return myself();
  }

  public S isPaddingTop(int padding) {
    isNotNull();
    check().withFailureMessage("is padding top")
        .that(actual().getPaddingTop())
        .isEqualTo(padding);
    return myself();
  }

  public S isParent(ViewParent parent) {
    isNotNull();
    check().withFailureMessage("is parent")
        .that(actual().getParent())
        .isSameAs(parent);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isParentForAccessibility(ViewParent parent) {
    isNotNull();
    check().withFailureMessage("is parent for accessibility")
        .that(actual().getParentForAccessibility())
        .isSameAs(parent);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isPivotX(float pivotX) {
    isNotNull();
    check().withFailureMessage("is pivot x")
        .that(actual().getPivotX())
        .isEqualTo(pivotX);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isPivotY(float pivotY) {
    isNotNull();
    check().withFailureMessage("is pivot y")
        .that(actual().getPivotY())
        .isEqualTo(pivotY);
    return myself();
  }

  public S isRight(int right) {
    isNotNull();
    check().withFailureMessage("is right")
        .that(actual().getRight())
        .isEqualTo(right);
    return myself();
  }

  public S isRootView(View view) {
    isNotNull();
    check().withFailureMessage("is root view")
        .that(actual().getRootView())
        .isSameAs(view);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isRotation(float rotation) {
    isNotNull();
    check().withFailureMessage("is rotation")
        .that(actual().getRotation())
        .isEqualTo(rotation);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isRotationX(float rotation) {
    isNotNull();
    check().withFailureMessage("is rotation x")
        .that(actual().getRotationX())
        .isEqualTo(rotation);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S hasRotationY(float rotation) {
    isNotNull();
    check().withFailureMessage("is rotation y")
        .that(actual().getRotationY())
        .isEqualTo(rotation);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isScaleX(float scale) {
    isNotNull();
    check().withFailureMessage("is scale x")
        .that(actual().getScaleX())
        .isEqualTo(scale);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isScaleY(float scale) {
    isNotNull();
    check().withFailureMessage("is scale y")
        .that(actual().getScaleY())
        .isEqualTo(scale);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isScrollBarDefaultDelayBeforeFade(int fade) {
    isNotNull();
    check().withFailureMessage("is scroll bar default delay before fade")
        .that(actual().getScrollBarDefaultDelayBeforeFade())
        .isEqualTo(fade);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isScrollBarFadeDuration(int fade) {
    isNotNull();
    check().withFailureMessage("is scroll bar fade duration")
        .that(actual().getScrollBarFadeDuration())
        .isEqualTo(fade);
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isScrollBarSize(int size) {
    isNotNull();
    check().withFailureMessage("is scroll bar size")
        .that(actual().getScrollBarSize())
        .isEqualTo(size);
    return myself();
  }

  public S isScrollBarStyle(int style) {
    isNotNull();
    check().withFailureMessage("is scroll bar style")
        .that(actual().getScrollBarStyle())
        .isEqualTo(style);
    return myself();
  }

  public S isScrollX(int scroll) {
    isNotNull();
    check().withFailureMessage("is scroll x")
        .that(actual().getScrollX())
        .isEqualTo(scroll);
    return myself();
  }

  public S isScrollY(int scroll) {
    isNotNull();
    check().withFailureMessage("is scroll y")
        .that(actual().getScrollY())
        .isEqualTo(scroll);
    return myself();
  }

  public S isSolidColor(int color) {
    isNotNull();
    check().withFailureMessage("is solid color")
        .that(actual().getSolidColor())
        .isEqualTo(color);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isSystemUiVisibility(int visibility) {
    isNotNull();
    check().withFailureMessage("is system ui visibility")
        .that(actual().getSystemUiVisibility())
        .isEqualTo(visibility);
    return myself();
  }

  public S isTag(int key, Object tag) {
    isNotNull();
    check().withFailureMessage("is tag with key")
        .that(actual().getTag(key))
        .isEqualTo(tag);
    return myself();
  }

  public S isTag(Object tag) {
    isNotNull();
    check().withFailureMessage("is tag")
        .that(actual().getTag())
        .isEqualTo(tag);
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isTextAlignment(int alignment) {
    isNotNull();
    check().withFailureMessage("is text alignment")
        .that(actual().getTextAlignment())
        .isEqualTo(alignment);
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isTextDirection(int direction) {
    isNotNull();
    check().withFailureMessage("is text direction")
        .that(actual().getTextDirection())
        .isEqualTo(direction);
    return myself();
  }

  public S isTop(int top) {
    isNotNull();
    check().withFailureMessage("is top")
        .that(actual().getTop())
        .isEqualTo(top);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isTranslationX(float translation) {
    isNotNull();
    check().withFailureMessage("is translation x")
        .that(actual().getTranslationX())
        .isEqualTo(translation);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isTranslationY(float translation) {
    isNotNull();
    check().withFailureMessage("is translation y")
        .that(actual().getTranslationY())
        .isEqualTo(translation);
    return myself();
  }

  @TargetApi(LOLLIPOP)
  public S isTranslationZ(float translation) {
    isNotNull();
    check().withFailureMessage("is translation z")
        .that(actual().getTranslationZ())
        .isEqualTo(translation);
    return myself();
  }

  public S isVerticalFadingEdgeLength(int length) {
    isNotNull();
    check().withFailureMessage("is vertical fading edge length")
        .that(actual().getVerticalFadingEdgeLength())
        .isEqualTo(length);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isVerticalScrollbarPosition(int position) {
    isNotNull();
    check().withFailureMessage("is vertical scrollbar position")
        .that(actual().getVerticalScrollbarPosition())
        .isEqualTo(position);
    return myself();
  }

  public S isVerticalScrollbarWidth(int width) {
    isNotNull();
    check().withFailureMessage("is vertical scrollbar width")
        .that(actual().getVerticalScrollbarWidth())
        .isEqualTo(width);
    return myself();
  }

  public S isVisibility(int visibility) {
    isNotNull();
    check().withFailureMessage("is visibility")
        .that(actual().getVisibility())
        .isEqualTo(visibility);
    return myself();
  }

  public S isVisible() {
    isNotNull();
    check().withFailureMessage("is visible")
        .that(actual().getVisibility())
        .isEqualTo(VISIBLE);
    return myself();
  }

  public S isNotVisible() {
    isNotNull();
    check().withFailureMessage("is not visible")
        .that(actual().getVisibility())
        .isNotEqualTo(VISIBLE);
    return myself();
  }

  public S isInvisible() {
    isNotNull();
    check().withFailureMessage("is invisible")
        .that(actual().getVisibility())
        .isEqualTo(INVISIBLE);
    return myself();
  }

  public S isNotInvisible() {
    isNotNull();
    check().withFailureMessage("is not invisible")
        .that(actual().getVisibility())
        .isNotEqualTo(INVISIBLE);
    return myself();
  }

  public S isGone() {
    isNotNull();
    check().withFailureMessage("is gone")
        .that(actual().getVisibility())
        .isEqualTo(GONE);
    return myself();
  }

  public S isNotGone() {
    isNotNull();
    check().withFailureMessage("is not gone")
        .that(actual().getVisibility())
        .isNotEqualTo(GONE);
    return myself();
  }

  public S isWidth(int width) {
    isNotNull();
    check().withFailureMessage("is width")
        .that(width)
        .isEqualTo(actual().getWidth());
    return myself();
  }

  public S isWindowVisibility(int visibility) {
    isNotNull();
    check().withFailureMessage("is window visibility")
        .that(actual().getWindowVisibility())
        .isEqualTo(visibility);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isX(float x) {
    isNotNull();
    check().withFailureMessage("is x")
        .that(actual().getX())
        .isEqualTo(x);
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isY(float y) {
    isNotNull();
    check().withFailureMessage("is y")
        .that(actual().getY())
        .isEqualTo(y);
    return myself();
  }

  @TargetApi(LOLLIPOP)
  public S isZ(float z) {
    isNotNull();
    check().withFailureMessage("is z")
        .that(actual().getZ())
        .isEqualTo(z);
    return myself();
  }

  public S hasFocus() {
    isNotNull();
    check().withFailureMessage("has focus")
        .that(actual().hasFocus())
        .isTrue();
    return myself();
  }

  public S hasNoFocus() {
    isNotNull();
    check().withFailureMessage("has no focus")
        .that(actual().hasFocus())
        .isFalse();
    return myself();
  }

  public S hasFocusable() {
    isNotNull();
    check().withFailureMessage("has focusable")
        .that(actual().hasFocusable())
        .isTrue();
    return myself();
  }

  public S isInFocusedWindow() {
    isNotNull();
    check().withFailureMessage("is in focused window")
        .that(actual().hasWindowFocus())
        .isTrue();
    return myself();
  }

  public S isNotInFocusedWindow() {
    isNotNull();
    check().withFailureMessage("is not in focused window")
        .that(actual().hasWindowFocus())
        .isFalse();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isActivated() {
    isNotNull();
    check().withFailureMessage("is activated")
        .that(actual().isActivated())
        .isTrue();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isNotActivated() {
    check().withFailureMessage("is not activated")
        .that(actual().isActivated())
        .isFalse();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isDirty() {
    isNotNull();
    check().withFailureMessage("is dirty")
        .that(actual().isDirty())
        .isTrue();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isNotDirty() {
    isNotNull();
    check().withFailureMessage("is not dirty")
        .that(actual().isDirty())
        .isFalse();
    return myself();
  }

  public S isUsingDrawingCache() {
    isNotNull();
    check().withFailureMessage("is using drawing cache")
        .that(actual().isDrawingCacheEnabled())
        .isTrue();
    return myself();
  }

  public S isNotUsingDrawingCache() {
    isNotNull();
    check().withFailureMessage("is not using drawing cache")
        .that(actual().isDrawingCacheEnabled())
        .isFalse();
    return myself();
  }

  public S isDuplicatingParentState() {
    isNotNull();
    check().withFailureMessage("is duplicating parent state")
        .that(actual().isDuplicateParentStateEnabled())
        .isTrue();
    return myself();
  }

  public S isNotDuplicatingParentState() {
    isNotNull();
    check().withFailureMessage("is not duplicating parent state")
        .that(actual().isDuplicateParentStateEnabled())
        .isFalse();
    return myself();
  }

  public S isEnabled() {
    isNotNull();
    check().withFailureMessage("is enabled")
        .that(actual().isEnabled())
        .isTrue();
    return myself();
  }

  public S isDisabled() {
    isNotNull();
    check().withFailureMessage("is disabled")
        .that(actual().isEnabled())
        .isFalse();
    return myself();
  }

  public S isFocusable() {
    isNotNull();
    check().withFailureMessage("is focusable")
        .that(actual().isFocusable())
        .isTrue();
    return myself();
  }

  public S isNotFocusable() {
    isNotNull();
    check().withFailureMessage("is not focusable")
        .that(actual().isFocusable())
        .isFalse();
    return myself();
  }

  public S isFocusableInTouchMode() {
    isNotNull();
    check().withFailureMessage("is focusable in touch mode")
        .that(actual().isFocusableInTouchMode())
        .isTrue();
    return myself();
  }

  public S isNotFocusableInTouchMode() {
    isNotNull();
    check().withFailureMessage("is not focusable in touch mode")
        .that(actual().isFocusableInTouchMode())
        .isFalse();
    return myself();
  }

  public S isFocused() {
    isNotNull();
    check().withFailureMessage("is focused")
        .that(actual().isFocused())
        .isTrue();
    return myself();
  }

  public S isNotFocused() {
    isNotNull();
    check().withFailureMessage("is not focused")
        .that(actual().isFocused())
        .isFalse();
    return myself();
  }

  public S isHapticFeedbackEnabled() {
    isNotNull();
    check().withFailureMessage("is haptic feedback enabled")
        .that(actual().isHapticFeedbackEnabled())
        .isTrue();
    return myself();
  }

  public S isHapticFeedbackDisabled() {
    isNotNull();
    check().withFailureMessage("is haptic feedback disabled")
        .that(actual().isHapticFeedbackEnabled())
        .isFalse();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isHardwareAccelerated() {
    isNotNull();
    check().withFailureMessage("is hardware accelerated")
        .that(actual().isHardwareAccelerated())
        .isTrue();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isNotHardwareAccelerated() {
    isNotNull();
    check().withFailureMessage("is not hardware accelerated")
        .that(actual().isHardwareAccelerated())
        .isFalse();
    return myself();
  }

  public S isHorizontalFadingEdgesEnabled() {
    isNotNull();
    check().withFailureMessage("is horizontal fading edge enabled")
        .that(actual().isHorizontalFadingEdgeEnabled())
        .isTrue();
    return myself();
  }

  public S isHorizontalFadingEdgesDisabled() {
    isNotNull();
    check().withFailureMessage("is horizontal fading edge disabled")
        .that(actual().isHorizontalFadingEdgeEnabled())
        .isFalse();
    return myself();
  }

  public S isHorizontalScrollbarEnabled() {
    isNotNull();
    check().withFailureMessage("is horizontal scrollbar enabled")
        .that(actual().isHorizontalScrollBarEnabled())
        .isTrue();
    return myself();
  }

  public S isHorizontalScrollbarDisabled() {
    isNotNull();
    check().withFailureMessage("is horizontal scrollbar disabled")
        .that(actual().isHorizontalScrollBarEnabled())
        .isFalse();
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public S isHovered() {
    isNotNull();
    check().withFailureMessage("is hovered")
        .that(actual().isHovered())
        .isTrue();
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public S isNotHovered() {
    isNotNull();
    check().withFailureMessage("is not hovered")
        .that(actual().isHovered())
        .isFalse();
    return myself();
  }

  public S isInEditMode() {
    isNotNull();
    check().withFailureMessage("is in edit mode")
        .that(actual().isInEditMode())
        .isTrue();
    return myself();
  }

  public S isNotInEditMode() {
    isNotNull();
    check().withFailureMessage("is not in edit mode")
        .that(actual().isInEditMode())
        .isFalse();
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isInLayout() {
    isNotNull();
    check().withFailureMessage("is in layout")
        .that(actual().isInLayout())
        .isTrue();
    return myself();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isNotInLayout() {
    isNotNull();
    check().withFailureMessage("is not in layout")
        .that(actual().isInLayout())
        .isFalse();
    return myself();
  }

  public S isInTouchMode() {
    isNotNull();
    check().withFailureMessage("is in touch mode")
        .that(actual().isInTouchMode())
        .isTrue();
    return myself();
  }

  public S isNotInTouchMode() {
    isNotNull();
    check().withFailureMessage("is not in touch mode")
        .that(actual().isInTouchMode())
        .isFalse();
    return myself();
  }

  public S isLayoutRequested() {
    isNotNull();
    check().withFailureMessage("is layout requested")
        .that(actual().isLayoutRequested())
        .isTrue();
    return myself();
  }

  public S isNotLayoutRequested() {
    isNotNull();
    check().withFailureMessage("is not layout requested")
        .that(actual().isLayoutRequested())
        .isFalse();
    return myself();
  }

  public S isLongClickable() {
    isNotNull();
    check().withFailureMessage("is long clickable")
        .that(actual().isLongClickable())
        .isTrue();
    return myself();
  }

  public S isNotLongClickable() {
    isNotNull();
    check().withFailureMessage("is not long clickable")
        .that(actual().isLongClickable())
        .isFalse();
    return myself();
  }

  public S isOpaque() {
    isNotNull();
    check().withFailureMessage("is opaque")
        .that(actual().isOpaque())
        .isTrue();
    return myself();
  }

  public S isNotOpaque() {
    isNotNull();
    check().withFailureMessage("is not opaque")
        .that(actual().isOpaque())
        .isFalse();
    return myself();
  }

  public S isPressed() {
    isNotNull();
    check().withFailureMessage("is pressed")
        .that(actual().isPressed())
        .isTrue();
    return myself();
  }

  public S isNotPressed() {
    isNotNull();
    check().withFailureMessage("is not pressed")
        .that(actual().isPressed())
        .isFalse();
    return myself();
  }

  public S isSaveEnabled() {
    isNotNull();
    check().withFailureMessage("is save enabled")
        .that(actual().isSaveEnabled())
        .isTrue();
    return myself();
  }

  public S isSaveDisabled() {
    isNotNull();
    check().withFailureMessage("is save diabled")
        .that(actual().isSaveEnabled())
        .isFalse();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isSaveFromParentEnabled() {
    isNotNull();
    check().withFailureMessage("is save from parent enabled")
        .that(actual().isSaveFromParentEnabled())
        .isTrue();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public S isSaveFromParentDisabled() {
    isNotNull();
    check().withFailureMessage("is save from parent disabled")
        .that(actual().isSaveFromParentEnabled())
        .isFalse();
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isScrollContainer() {
    isNotNull();
    check().withFailureMessage("is scroll container")
        .that(actual().isScrollContainer())
        .isTrue();
    return myself();
  }

  @TargetApi(JELLY_BEAN)
  public S isNotScrollContainer() {
    isNotNull();
    check().withFailureMessage("is not scroll container")
        .that(actual().isScrollContainer())
        .isFalse();
    return myself();
  }

  public S isScrollbarFadingEnabled() {
    isNotNull();
    check().withFailureMessage("is scrollbar fading enabled")
        .that(actual().isScrollbarFadingEnabled())
        .isTrue();
    return myself();
  }

  public S isScrollbarFadingDisabled() {
    isNotNull();
    check().withFailureMessage("is scrollbar fading disabled")
        .that(actual().isScrollbarFadingEnabled())
        .isFalse();
    return myself();
  }

  public S isSelected() {
    isNotNull();
    check().withFailureMessage("is selected")
        .that(actual().isSelected())
        .isTrue();
    return myself();
  }

  public S isNotSelected() {
    isNotNull();
    check().withFailureMessage("is not selected")
        .that(actual().isSelected())
        .isFalse();
    return myself();
  }

  public S isShown() {
    isNotNull();
    check().withFailureMessage("is shown")
        .that(actual().isShown())
        .isTrue();
    return myself();
  }

  public S isNotShown() {
    isNotNull();
    check().withFailureMessage("is not shown")
        .that(actual().isShown())
        .isFalse();
    return myself();
  }

  public S isSoundEffectsEnabled() {
    isNotNull();
    check().withFailureMessage("is sound effect enabled")
        .that(actual().isSoundEffectsEnabled())
        .isTrue();
    return myself();
  }

  public S isSoundEffectsDisabled() {
    isNotNull();
    check().withFailureMessage("is sound effect disabled")
        .that(actual().isSoundEffectsEnabled())
        .isFalse();
    return myself();
  }

  public S isVerticalFadingEdgeEnabled() {
    isNotNull();
    check().withFailureMessage("is vertical fading edge enabled")
        .that(actual().isVerticalFadingEdgeEnabled())
        .isTrue();
    return myself();
  }

  public S isVerticalFadingEdgeDisabled() {
    isNotNull();
    check().withFailureMessage("is vertical fading edge disabled")
        .that(actual().isVerticalFadingEdgeEnabled())
        .isFalse();
    return myself();
  }

  public S isVerticalScrollBarEnabled() {
    isNotNull();
    check().withFailureMessage("is vertical scroll bar enabled")
        .that(actual().isVerticalScrollBarEnabled())
        .isTrue();
    return myself();
  }

  public S isVerticalScrollBarDisabled() {
    isNotNull();
    check().withFailureMessage("is vertical scroll bar disabled")
        .that(actual().isVerticalScrollBarEnabled())
        .isFalse();
    return myself();
  }

  @TargetApi(KITKAT)
  public S canResolveLayoutDirection() {
    isNotNull();
    check().withFailureMessage("can resolve layout direction")
        .that(actual().canResolveLayoutDirection())
        .isTrue();
    return myself();
  }

  @TargetApi(KITKAT)
  public S canNotResolveLayoutDirection() {
    isNotNull();
    check().withFailureMessage("can not resolve layout direction")
        .that(actual().canResolveLayoutDirection())
        .isFalse();
    return myself();
  }

  @TargetApi(KITKAT)
  public S canResolveTextAlignment() {
    isNotNull();
    check().withFailureMessage("can resolve text alignment")
        .that(actual().canResolveTextAlignment())
        .isTrue();
    return myself();
  }

  @TargetApi(KITKAT)
  public S canNotResolveTextAlignment() {
    isNotNull();
    check().withFailureMessage("can not resolve text alignment")
        .that(actual().canResolveTextAlignment())
        .isFalse();
    return myself();
  }

  @TargetApi(KITKAT)
  public S canResolveTextDirection() {
    isNotNull();
    check().withFailureMessage("can resolve text direction")
        .that(actual().canResolveTextDirection())
        .isTrue();
    return myself();
  }

  @TargetApi(KITKAT)
  public S canNotResolveTextDirection() {
    isNotNull();
    check().withFailureMessage("can not resolve text direction")
        .that(actual().canResolveTextDirection())
        .isFalse();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isLaidOut() {
    isNotNull();
    check().withFailureMessage("is laid out")
        .that(actual().isLaidOut())
        .isTrue();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isNotLaidOut() {
    isNotNull();
    check().withFailureMessage("is not laid out")
        .that(actual().isLaidOut())
        .isFalse();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isResolvedTextAlignment() {
    isNotNull();
    check().withFailureMessage("is resolved text alignment")
        .that(actual().isTextAlignmentResolved())
        .isTrue();
    return myself();
  }

  @TargetApi(KITKAT)
  public S isNotResolvedTextAlignment() {
    isNotNull();
    check().withFailureMessage("is not resolved text alignment")
        .that(actual().isTextAlignmentResolved())
        .isFalse();
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
