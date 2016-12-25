package com.github.satoshun.recyclerview.v7.api.widget;

import android.support.v7.widget.RecyclerView;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class RecyclerViewLayoutManagerSubject extends BaseSubject<RecyclerViewLayoutManagerSubject, RecyclerView.LayoutManager> {

  public static final RecyclerViewLayoutManagerSubjectFactory FACTORY = new RecyclerViewLayoutManagerSubjectFactory();

  public RecyclerViewLayoutManagerSubject(FailureStrategy failureStrategy, RecyclerView.LayoutManager actual) {
    super(failureStrategy, actual);
  }

  public RecyclerViewLayoutManagerSubject supportsPredictiveItemAnimations() {
    isNotNull();
    check().withFailureMessage("supports predictive item animations")
        .that(actual().supportsPredictiveItemAnimations())
        .isTrue();
    return myself();
  }

  public RecyclerViewLayoutManagerSubject doesNotSupportPredictiveItemAnimations() {
    isNotNull();
    check().withFailureMessage("does not supports predictive item animations")
        .that(actual().supportsPredictiveItemAnimations())
        .isFalse();
    return myself();
  }

  public RecyclerViewLayoutManagerSubject canScrollHorizontally() {
    isNotNull();
    check().withFailureMessage("can scroll horizontally")
        .that(actual().canScrollHorizontally())
        .isTrue();
    return myself();
  }

  public RecyclerViewLayoutManagerSubject canNotScrollHorizontally() {
    isNotNull();
    check().withFailureMessage("can not scroll horizontally")
        .that(actual().canScrollHorizontally())
        .isFalse();
    return myself();
  }

  public RecyclerViewLayoutManagerSubject canScrollVertically() {
    isNotNull();
    check().withFailureMessage("can scroll vertically")
        .that(actual().canScrollVertically())
        .isTrue();
    return myself();
  }

  public RecyclerViewLayoutManagerSubject canNotScrollVertically() {
    isNotNull();
    check().withFailureMessage("can not scroll vertically")
        .that(actual().canScrollVertically())
        .isFalse();
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isSmoothScrolling() {
    isNotNull();
    check().withFailureMessage("is smooth scrolling")
        .that(actual().isSmoothScrolling())
        .isTrue();
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isNotSmoothScrolling() {
    isNotNull();
    check().withFailureMessage("is not smooth scrolling")
        .that(actual().isSmoothScrolling())
        .isFalse();
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isLayoutDirection(int direction) {
    isNotNull();
    check().withFailureMessage("is layout direction")
        .that(actual().getLayoutDirection())
        .isEqualTo(direction);
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isChildCount(int count) {
    isNotNull();
    check().withFailureMessage("is child count")
        .that(actual().getChildCount())
        .isEqualTo(count);
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isWidth(int width) {
    isNotNull();
    check().withFailureMessage("is width")
        .that(actual().getWidth())
        .isEqualTo(width);
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isHeight(int height) {
    isNotNull();
    check().withFailureMessage("is height")
        .that(actual().getHeight())
        .isEqualTo(height);
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isPaddingLeft(int padding) {
    isNotNull();
    check().withFailureMessage("is padding left")
        .that(actual().getPaddingLeft())
        .isEqualTo(padding);
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isPaddingTop(int padding) {
    isNotNull();
    check().withFailureMessage("is padding top")
        .that(actual().getPaddingTop())
        .isEqualTo(padding);
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isPaddingRight(int padding) {
    isNotNull();
    check().withFailureMessage("is padding right")
        .that(actual().getPaddingRight())
        .isEqualTo(padding);
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isPaddingBottom(int padding) {
    isNotNull();
    check().withFailureMessage("is padding bottom")
        .that(actual().getPaddingBottom())
        .isEqualTo(padding);
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isPaddingStart(int padding) {
    isNotNull();
    check().withFailureMessage("is padding start")
        .that(actual().getPaddingStart())
        .isEqualTo(padding);
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isPaddingEnd(int padding) {
    isNotNull();
    check().withFailureMessage("is padding end")
        .that(actual().getPaddingEnd())
        .isEqualTo(padding);
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isFocused() {
    isNotNull();
    check().withFailureMessage("is focused")
        .that(actual().isFocused())
        .isTrue();
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isNotFocused() {
    isNotNull();
    check().withFailureMessage("is not focused")
        .that(actual().isFocused())
        .isFalse();
    return myself();
  }

  public RecyclerViewLayoutManagerSubject hasFocus() {
    isNotNull();
    check().withFailureMessage("has focus")
        .that(actual().hasFocus())
        .isTrue();
    return myself();
  }

  public RecyclerViewLayoutManagerSubject doesNotHaveFocus() {
    isNotNull();
    check().withFailureMessage("does not have focus")
        .that(actual().hasFocus())
        .isFalse();
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isItemCount(int count) {
    isNotNull();
    check().withFailureMessage("is item count")
        .that(actual().getItemCount())
        .isEqualTo(count);
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isMinimumWidth(int width) {
    isNotNull();
    check().withFailureMessage("is minimum width")
        .that(actual().getMinimumWidth())
        .isEqualTo(width);
    return myself();
  }

  public RecyclerViewLayoutManagerSubject isMinimumHeight(int height) {
    isNotNull();
    check().withFailureMessage("is minimum height")
        .that(actual().getMinimumHeight())
        .isEqualTo(height);
    return myself();
  }

  private static class RecyclerViewLayoutManagerSubjectFactory extends SubjectFactory<RecyclerViewLayoutManagerSubject, RecyclerView.LayoutManager> {
    @Override
    public RecyclerViewLayoutManagerSubject getSubject(FailureStrategy fs, RecyclerView.LayoutManager that) {
      return new RecyclerViewLayoutManagerSubject(fs, that);
    }
  }
}
