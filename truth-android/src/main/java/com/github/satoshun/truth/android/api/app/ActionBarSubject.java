package com.github.satoshun.truth.android.api.app;

import android.annotation.TargetApi;
import android.app.ActionBar;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;

@TargetApi(HONEYCOMB)
public class ActionBarSubject extends BaseSubject<ActionBarSubject, ActionBar> {

  public static final ActionBarSubjectFactory FACTORY = new ActionBarSubjectFactory();

  public ActionBarSubject(FailureStrategy failureStrategy, ActionBar actual) {
    super(failureStrategy, actual);
  }

  public ActionBarSubject hasCustomView() {
    isNotNull();
    check().withFailureMessage("has custom view")
        .that(actual().getCustomView())
        .isNotNull();
    return this;
  }

  public ActionBarSubject isDisplayOptions(int options) {
    isNotNull();
    check().withFailureMessage("is display options")
        .that(actual().getDisplayOptions())
        .isEqualTo(options);
    return this;
  }

  public ActionBarSubject isHeight(int height) {
    isNotNull();
    check().withFailureMessage("is height")
        .that(actual().getHeight())
        .isEqualTo(height);
    return this;
  }

  public ActionBarSubject isNavigationItemCount(int count) {
    isNotNull();
    check().withFailureMessage("is navigation item count")
        .that(actual().getNavigationItemCount())
        .isEqualTo(count);
    return this;
  }

  public ActionBarSubject isNavigationMode(int mode) {
    isNotNull();
    check().withFailureMessage("is navigation mode")
        .that(actual().getNavigationMode())
        .isEqualTo(mode);
    return this;
  }

  public ActionBarSubject isSelectedNavigationIndex(int index) {
    isNotNull();
    check().withFailureMessage("is selected navigation index")
        .that(actual().getSelectedNavigationIndex())
        .isEqualTo(index);
    return this;
  }

  public ActionBarSubject isSubtitle(CharSequence subtitle) {
    isNotNull();
    check().withFailureMessage("is subtitle")
        .that(actual().getSubtitle())
        .isEqualTo(subtitle);
    return this;
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public ActionBarSubject isSubtitle(int resId) {
    return isSubtitle(actual().getThemedContext().getString(resId));
  }

  public ActionBarSubject isTabCount(int count) {
    isNotNull();
    check().withFailureMessage("is tab count")
        .that(actual().getTabCount())
        .isEqualTo(count);
    return this;
  }

  public ActionBarSubject isTitle(CharSequence title) {
    isNotNull();
    check().withFailureMessage("is title")
        .that(actual().getTitle())
        .isEqualTo(title);
    return this;
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public ActionBarSubject isTitle(int resId) {
    return isTitle(actual().getThemedContext().getString(resId));
  }

  public ActionBarSubject isShowing() {
    isNotNull();
    check().withFailureMessage("is showing")
        .that(actual().isShowing())
        .isTrue();
    return this;
  }

  public ActionBarSubject isNotShowing() {
    isNotNull();
    check().withFailureMessage("is not showing")
        .that(actual().isShowing())
        .isFalse();
    return this;
  }

  private static class ActionBarSubjectFactory extends SubjectFactory<ActionBarSubject, ActionBar> {
    @Override
    public ActionBarSubject getSubject(FailureStrategy fs, ActionBar that) {
      return new ActionBarSubject(fs, that);
    }
  }
}
