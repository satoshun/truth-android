package com.github.satoshun.truth.android.api.widget;

import android.annotation.TargetApi;
import android.widget.TabWidget;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.FROYO;

public class TabWidgetSubject extends LinearLayoutSubject<TabWidgetSubject, TabWidget> {

  public static final TabWidgetSubjectFactory FACTORY = new TabWidgetSubjectFactory();

  public TabWidgetSubject(FailureStrategy failureStrategy, TabWidget actual) {
    super(failureStrategy, actual);
  }

  public TabWidgetSubject isTabCount(int count) {
    isNotNull();
    check().withFailureMessage("is tab count")
        .that(actual().getTabCount())
        .isEqualTo(count);
    return this;
  }

  @TargetApi(FROYO)
  public TabWidgetSubject isStripEnabled() {
    isNotNull();
    check().withFailureMessage("is strip enabled")
        .that(actual().isStripEnabled())
        .isTrue();
    return this;
  }

  @TargetApi(FROYO)
  public TabWidgetSubject isStripDisabled() {
    isNotNull();
    check().withFailureMessage("is strip disabled")
        .that(actual().isStripEnabled())
        .isFalse();
    return this;
  }

  private static class TabWidgetSubjectFactory extends SubjectFactory<TabWidgetSubject, TabWidget> {
    @Override
    public TabWidgetSubject getSubject(FailureStrategy fs, TabWidget that) {
      return new TabWidgetSubject(fs, that);
    }
  }
}
