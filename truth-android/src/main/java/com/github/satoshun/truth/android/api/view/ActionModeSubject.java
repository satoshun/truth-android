package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.View;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;

@TargetApi(HONEYCOMB)
public class ActionModeSubject extends BaseSubject<ActionModeSubject, ActionMode> {

  public static final ActionModeSubjectFactory FACTORY = new ActionModeSubjectFactory();

  public ActionModeSubject(FailureStrategy failureStrategy, ActionMode actual) {
    super(failureStrategy, actual);
  }

  public ActionModeSubject hasCustomView() {
    isNotNull();
    check().withFailureMessage("has custom view")
        .that(actual().getCustomView())
        .isNotNull();
    return this;
  }

  public ActionModeSubject isCustomView(View view) {
    isNotNull();
    check().withFailureMessage("is custom view")
        .that(actual().getCustomView())
        .isEqualTo(view);
    return this;
  }

  public ActionModeSubject isSubtitle(CharSequence subtitle) {
    isNotNull();
    check().withFailureMessage("is sub title")
        .that(actual().getSubtitle())
        .isEqualTo(subtitle);
    return this;
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public ActionModeSubject isTag(Object tag) {
    isNotNull();
    check().withFailureMessage("is tag")
        .that(actual().getTag())
        .isEqualTo(tag);
    return this;
  }

  public ActionModeSubject isTitle(CharSequence title) {
    isNotNull();
    check().withFailureMessage("is title")
        .that(actual().getTitle())
        .isEqualTo(title);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionModeSubject hasOptionalTitleHint() {
    isNotNull();
    check().withFailureMessage("has optional title hint")
        .that(actual().getTitleOptionalHint())
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionModeSubject hasNonOptionalTitleHint() {
    isNotNull();
    check().withFailureMessage("has non optional title hint")
        .that(actual().getTitleOptionalHint())
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionModeSubject isOptionalTitle() {
    isNotNull();
    check().withFailureMessage("is optional title")
        .that(actual().isTitleOptional())
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionModeSubject isNotOptionalTitle() {
    isNotNull();
    check().withFailureMessage("is not optional title")
        .that(actual().isTitleOptional())
        .isFalse();
    return this;
  }

  private static class ActionModeSubjectFactory extends SubjectFactory<ActionModeSubject, ActionMode> {
    @Override
    public ActionModeSubject getSubject(FailureStrategy fs, ActionMode that) {
      return new ActionModeSubject(fs, that);
    }
  }
}
