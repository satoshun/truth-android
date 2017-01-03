package com.github.satoshun.truth.android.api.view.accessibility;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityNodeInfo;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

@TargetApi(ICE_CREAM_SANDWICH)
public class AccessibilityNodeInfoSubject extends BaseSubject<AccessibilityNodeInfoSubject, AccessibilityNodeInfo> {

  public static final AccessibilityNodeInfoSubjectFactory FACTORY = new AccessibilityNodeInfoSubjectFactory();

  public AccessibilityNodeInfoSubject(FailureStrategy failureStrategy, AccessibilityNodeInfo actual) {
    super(failureStrategy, actual);
  }

  public AccessibilityNodeInfoSubject isActions(int actions) {
    isNotNull();
    check().withFailureMessage("is actions")
        .that(actual().getActions())
        .isEqualTo(actions);
    return this;
  }

  public AccessibilityNodeInfoSubject isChildCount(int count) {
    isNotNull();
    check().withFailureMessage("is child count")
        .that(actual().getChildCount())
        .isEqualTo(count);
    return this;
  }

  public AccessibilityNodeInfoSubject isClassName(CharSequence name) {
    isNotNull();
    check().withFailureMessage("is class name")
        .that(actual().getClassName())
        .isEqualTo(name);
    return this;
  }

  public AccessibilityNodeInfoSubject isContentDescription(CharSequence description) {
    isNotNull();
    check().withFailureMessage("is content description")
        .that(actual().getContentDescription())
        .isEqualTo(description);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isMovementGranularities(int granularities) {
    isNotNull();
    check().withFailureMessage("is movement granularities")
        .that(actual().getMovementGranularities())
        .isEqualTo(granularities);
    return this;
  }

  public AccessibilityNodeInfoSubject isPackageName(CharSequence name) {
    isNotNull();
    check().withFailureMessage("is package name")
        .that(actual().getPackageName())
        .isEqualTo(name);
    return this;
  }

  public AccessibilityNodeInfoSubject isText(CharSequence text) {
    isNotNull();
    check().withFailureMessage("is text")
        .that(actual().getText())
        .isEqualTo(text);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject isTextSelectionStart(int position) {
    isNotNull();
    check().withFailureMessage("is text selection start")
        .that(actual().getTextSelectionStart())
        .isEqualTo(position);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject isTextSelectionEnd(int position) {
    isNotNull();
    check().withFailureMessage("is text selection end")
        .that(actual().getTextSelectionEnd())
        .isEqualTo(position);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject isViewIdResourceName(String name) {
    isNotNull();
    check().withFailureMessage("is view id resource name")
        .that(actual().getViewIdResourceName())
        .isEqualTo(name);
    return this;
  }

  public AccessibilityNodeInfoSubject isWindowId(int id) {
    isNotNull();
    check().withFailureMessage("is window id")
        .that(actual().getWindowId())
        .isEqualTo(id);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isAccessibilityFocused() {
    isNotNull();
    check().withFailureMessage("is accessibility focused")
        .that(actual().isAccessibilityFocused())
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isNotAccessibilityFocused() {
    isNotNull();
    check().withFailureMessage("is not accessibility focused")
        .that(actual().isAccessibilityFocused())
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isCheckable() {
    isNotNull();
    check().withFailureMessage("is checkable")
        .that(actual().isCheckable())
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotCheckable() {
    isNotNull();
    check().withFailureMessage("is not checkable")
        .that(actual().isCheckable())
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isChecked() {
    isNotNull();
    check().withFailureMessage("is checked")
        .that(actual().isChecked())
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotChecked() {
    isNotNull();
    check().withFailureMessage("is not checked")
        .that(actual().isChecked())
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isClickable() {
    isNotNull();
    check().withFailureMessage("is clickable")
        .that(actual().isClickable())
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotClickable() {
    isNotNull();
    check().withFailureMessage("is not clickable")
        .that(actual().isClickable())
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject isEditable() {
    isNotNull();
    check().withFailureMessage("is editable")
        .that(actual().isEditable())
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject isNotEditable() {
    isNotNull();
    check().withFailureMessage("is not editable")
        .that(actual().isEditable())
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isEnabled() {
    isNotNull();
    check().withFailureMessage("is enabled")
        .that(actual().isEnabled())
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotEnabled() {
    isNotNull();
    check().withFailureMessage("is not enabled")
        .that(actual().isEnabled())
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isFocusable() {
    isNotNull();
    check().withFailureMessage("is focusable")
        .that(actual().isFocusable())
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotFocusable() {
    isNotNull();
    check().withFailureMessage("is not focusable")
        .that(actual().isFocusable())
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isFocused() {
    isNotNull();
    check().withFailureMessage("is focused")
        .that(actual().isFocused())
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotFocused() {
    isNotNull();
    check().withFailureMessage("is not focused")
        .that(actual().isFocused())
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isLongClickable() {
    isNotNull();
    check().withFailureMessage("is long clickable")
        .that(actual().isLongClickable())
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotLongClickable() {
    isNotNull();
    check().withFailureMessage("is not long clickable")
        .that(actual().isLongClickable())
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isPassword() {
    isNotNull();
    check().withFailureMessage("is password")
        .that(actual().isPassword())
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotPassword() {
    isNotNull();
    check().withFailureMessage("is not password")
        .that(actual().isPassword())
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isScrollable() {
    isNotNull();
    check().withFailureMessage("is scrollable")
        .that(actual().isScrollable())
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotScrollable() {
    isNotNull();
    check().withFailureMessage("is not scrollable")
        .that(actual().isScrollable())
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isSelected() {
    isNotNull();
    check().withFailureMessage("is selected")
        .that(actual().isSelected())
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotSelected() {
    isNotNull();
    check().withFailureMessage("is not selected")
        .that(actual().isSelected())
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isVisibleToUser() {
    isNotNull();
    check().withFailureMessage("is visible to user")
        .that(actual().isVisibleToUser())
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isNotVisibleToUser() {
    isNotNull();
    check().withFailureMessage("is not visible to user")
        .that(actual().isVisibleToUser())
        .isFalse();
    return this;
  }

  private static class AccessibilityNodeInfoSubjectFactory extends SubjectFactory<AccessibilityNodeInfoSubject, AccessibilityNodeInfo> {
    @Override
    public AccessibilityNodeInfoSubject getSubject(FailureStrategy fs, AccessibilityNodeInfo that) {
      return new AccessibilityNodeInfoSubject(fs, that);
    }
  }
}
