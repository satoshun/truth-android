package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public class AutoCompleteTextViewSubject extends BaseSubject<AutoCompleteTextViewSubject, AutoCompleteTextView> {

  public static final AutoCompleteTextViewSubjectFactory FACTORY = new AutoCompleteTextViewSubjectFactory();

  public AutoCompleteTextViewSubject(FailureStrategy failureStrategy, AutoCompleteTextView actual) {
    super(failureStrategy, actual);
  }

  public AutoCompleteTextViewSubject isEnoughToFilter() {
    isNotNull();
    check().withFailureMessage("is enough to filter")
        .that(actual().enoughToFilter())
        .isTrue();
    return this;
  }

  public AutoCompleteTextViewSubject isAdapter(ListAdapter adapter) {
    isNotNull();
    check().withFailureMessage("is adapter")
        .that(actual().getAdapter())
        .isSameAs(adapter);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AutoCompleteTextViewSubject isCompletionHint(CharSequence hint) {
    isNotNull();
    check().withFailureMessage("is completion hint")
        .that(actual().getCompletionHint())
        .isEqualTo(hint);
    return this;
  }

  public AutoCompleteTextViewSubject isCompletionHint(int resId) {
    isNotNull();
    return isCompletionHint(actual().getContext().getString(resId));
  }

  public AutoCompleteTextViewSubject isDropDownAnchor(int id) {
    isNotNull();
    check().withFailureMessage("is drop down anchor")
        .that(actual().getDropDownAnchor())
        .isEqualTo(id);
    return this;
  }

  public AutoCompleteTextViewSubject isDropDownBackground(Drawable background) {
    isNotNull();
    check().withFailureMessage("is drop down background")
        .that(actual().getDropDownBackground())
        .isSameAs(background);
    return this;
  }

  public AutoCompleteTextViewSubject isDropDownHeight(int height) {
    isNotNull();
    check().withFailureMessage("is drop down height")
        .that(actual().getDropDownHeight())
        .isEqualTo(height);
    return this;
  }

  public AutoCompleteTextViewSubject isDropDownHorizontalOffset(int offset) {
    isNotNull();
    check().withFailureMessage("is drop down horizontal offset")
        .that(actual().getDropDownHorizontalOffset())
        .isEqualTo(offset);
    return this;
  }

  public AutoCompleteTextViewSubject isDropDownVerticalOffset(int offset) {
    isNotNull();
    check().withFailureMessage("is drop down vertical offset")
        .that(actual().getDropDownVerticalOffset())
        .isEqualTo(offset);
    return this;
  }

  public AutoCompleteTextViewSubject isDropDownWidth(int width) {
    isNotNull();
    check().withFailureMessage("is drop down width")
        .that(actual().getDropDownWidth())
        .isEqualTo(width);
    return this;
  }

  public AutoCompleteTextViewSubject isListSelection(int position) {
    isNotNull();
    check().withFailureMessage("is list selection")
        .that(actual().getListSelection())
        .isEqualTo(position);
    return this;
  }

  public AutoCompleteTextViewSubject isThreshold(int threshold) {
    isNotNull();
    check().withFailureMessage("is threshold")
        .that(actual().getThreshold())
        .isEqualTo(threshold);
    return this;
  }

  public AutoCompleteTextViewSubject isPerformingCompletion() {
    isNotNull();
    check().withFailureMessage("is performing completion")
        .that(actual().isPerformingCompletion())
        .isTrue();
    return this;
  }

  public AutoCompleteTextViewSubject isNotPerformingCompletion() {
    isNotNull();
    check().withFailureMessage("is not performing completion")
        .that(actual().isPerformingCompletion())
        .isFalse();
    return this;
  }

  public AutoCompleteTextViewSubject isShowingPopup() {
    isNotNull();
    check().withFailureMessage("is showing popup")
        .that(actual().isPopupShowing())
        .isTrue();
    return this;
  }

  public AutoCompleteTextViewSubject isNotShowingPopup() {
    isNotNull();
    check().withFailureMessage("is not showing popup")
        .that(actual().isPopupShowing())
        .isFalse();
    return this;
  }

  private static class AutoCompleteTextViewSubjectFactory extends SubjectFactory<AutoCompleteTextViewSubject, AutoCompleteTextView> {
    @Override
    public AutoCompleteTextViewSubject getSubject(FailureStrategy fs, AutoCompleteTextView that) {
      return new AutoCompleteTextViewSubject(fs, that);
    }
  }
}
