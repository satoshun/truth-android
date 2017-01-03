package com.github.satoshun.truth.android.api.view.accessibility;


import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.util.List;

import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1;

@TargetApi(ICE_CREAM_SANDWICH)
public abstract class AccessibilityRecordSubject<S extends AccessibilityRecordSubject<S, T>, T extends AccessibilityRecord>
    extends BaseSubject<S, T> {

  public static final AccessibilityRecordSubjectFactory FACTORY = new AccessibilityRecordSubjectFactory();

  public AccessibilityRecordSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isAddedCount(int count) {
    isNotNull();
    check().withFailureMessage("is added count")
        .that(actual().getAddedCount())
        .isEqualTo(count);
    return myself();
  }

  public S isBeforeText(CharSequence text) {
    isNotNull();
    check().withFailureMessage("is before text")
        .that(actual().getBeforeText())
        .isEqualTo(text);
    return myself();
  }

  public S isClassName(CharSequence name) {
    isNotNull();
    check().withFailureMessage("is class name")
        .that(actual().getClassName())
        .isEqualTo(name);
    return myself();
  }

  public S isContentDescription(CharSequence description) {
    isNotNull();
    check().withFailureMessage("is content description")
        .that(actual().getContentDescription())
        .isEqualTo(description);
    return myself();
  }

  public S isCurrentItemIndex(int index) {
    isNotNull();
    check().withFailureMessage("is current item index")
        .that(actual().getCurrentItemIndex())
        .isEqualTo(index);
    return myself();
  }

  public S isFromIndex(int index) {
    isNotNull();
    check().withFailureMessage("is from index")
        .that(actual().getFromIndex())
        .isEqualTo(index);
    return myself();
  }

  public S isItemCount(int count) {
    isNotNull();
    check().withFailureMessage("is item count")
        .that(actual().getItemCount())
        .isEqualTo(count);
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH_MR1)
  public S isMaximumScrollX(int scroll) {
    isNotNull();
    check().withFailureMessage("is maximum scroll x")
        .that(actual().getMaxScrollX())
        .isEqualTo(scroll);
    return myself();
  }

  @TargetApi(ICE_CREAM_SANDWICH_MR1)
  public S isMaximumScrollY(int scroll) {
    isNotNull();
    check().withFailureMessage("is maximum scroll y")
        .that(actual().getMaxScrollY())
        .isEqualTo(scroll);
    return myself();
  }

  public S isRemovedCount(int count) {
    isNotNull();
    check().withFailureMessage("is remove count")
        .that(actual().getRemovedCount())
        .isEqualTo(count);
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

  public S isSource(AccessibilityNodeInfo info) {
    isNotNull();
    check().withFailureMessage("is source")
        .that(actual().getSource())
        .isSameAs(info);
    return myself();
  }

  public S isText(List<CharSequence> text) {
    isNotNull();
    check().withFailureMessage("is text")
        .that(actual().getText())
        .isEqualTo(text);
    return myself();
  }

  public S isToIndex(int index) {
    isNotNull();
    check().withFailureMessage("is to index")
        .that(actual().getToIndex())
        .isEqualTo(index);
    return myself();
  }

  public S isWindowId(int id) {
    isNotNull();
    check().withFailureMessage("is window id")
        .that(actual().getWindowId())
        .isEqualTo(id);
    return myself();
  }

  public S isChecked() {
    isNotNull();
    check().withFailureMessage("is checked")
        .that(actual().isChecked())
        .isTrue();
    return myself();
  }

  public S isNotChecked() {
    isNotNull();
    check().withFailureMessage("is not checked")
        .that(actual().isChecked())
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

  public S isNotEnabled() {
    isNotNull();
    check().withFailureMessage("is not enabled")
        .that(actual().isEnabled())
        .isFalse();
    return myself();
  }

  public S isFullScreen() {
    isNotNull();
    check().withFailureMessage("is fullscreen")
        .that(actual().isFullScreen())
        .isTrue();
    return myself();
  }

  public S isNotFullScreen() {
    isNotNull();
    check().withFailureMessage("is not fullscreen")
        .that(actual().isFullScreen())
        .isFalse();
    return myself();
  }

  public S isPassword() {
    isNotNull();
    check().withFailureMessage("is password")
        .that(actual().isPassword())
        .isTrue();
    return myself();
  }

  public S isNotPassword() {
    isNotNull();
    check().withFailureMessage("is not password")
        .that(actual().isPassword())
        .isFalse();
    return myself();
  }

  public S isScrollable() {
    isNotNull();
    check().withFailureMessage("is scrollable")
        .that(actual().isScrollable())
        .isTrue();
    return myself();
  }

  public S isNotScrollable() {
    isNotNull();
    check().withFailureMessage("is not scrollable")
        .that(actual().isScrollable())
        .isFalse();
    return myself();
  }

  private static class AccessibilityRecordSubjectImpl extends AccessibilityRecordSubject<AccessibilityRecordSubjectImpl, AccessibilityRecord> {
    AccessibilityRecordSubjectImpl(FailureStrategy failureStrategy, AccessibilityRecord actual) {
      super(failureStrategy, actual);
    }
  }

  private static class AccessibilityRecordSubjectFactory extends SubjectFactory<AccessibilityRecordSubjectImpl, AccessibilityRecord> {
    @Override
    public AccessibilityRecordSubjectImpl getSubject(FailureStrategy fs, AccessibilityRecord that) {
      return new AccessibilityRecordSubjectImpl(fs, that);
    }
  }
}
