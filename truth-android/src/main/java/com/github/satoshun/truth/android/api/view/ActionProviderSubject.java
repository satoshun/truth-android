package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.view.ActionProvider;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;

@TargetApi(ICE_CREAM_SANDWICH)
public class ActionProviderSubject extends BaseSubject<ActionProviderSubject, ActionProvider> {

  public static final ActionProviderSubjectFactory FACTORY = new ActionProviderSubjectFactory();

  public ActionProviderSubject(FailureStrategy failureStrategy, ActionProvider actual) {
    super(failureStrategy, actual);
  }

  public ActionProviderSubject hasSubMenu() {
    isNotNull();
    check().withFailureMessage("has sub menu")
        .that(actual().hasSubMenu())
        .isTrue();
    return this;
  }

  public ActionProviderSubject hasNoSubMenu() {
    isNotNull();
    check().withFailureMessage("has no sub menu")
        .that(actual().hasSubMenu())
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionProviderSubject isVisible() {
    isNotNull();
    check().withFailureMessage("is visible")
        .that(actual().isVisible())
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionProviderSubject isNotVisible() {
    isNotNull();
    check().withFailureMessage("is not visible")
        .that(actual().isVisible())
        .isFalse();
    return this;
  }

  private static class ActionProviderSubjectFactory extends SubjectFactory<ActionProviderSubject, ActionProvider> {
    @Override
    public ActionProviderSubject getSubject(FailureStrategy fs, ActionProvider that) {
      return new ActionProviderSubject(fs, that);
    }
  }
}
