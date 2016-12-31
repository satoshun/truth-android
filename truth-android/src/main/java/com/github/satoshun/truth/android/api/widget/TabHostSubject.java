package com.github.satoshun.truth.android.api.widget;

import android.view.View;
import android.widget.TabHost;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class TabHostSubject extends FrameLayoutSubject<TabHostSubject, TabHost> {

  public static final TabHostSubjectFactory FACTORY = new TabHostSubjectFactory();

  public TabHostSubject(FailureStrategy failureStrategy, TabHost actual) {
    super(failureStrategy, actual);
  }

  public TabHostSubject isCurrentTab(int tab) {
    isNotNull();
    check().withFailureMessage("is current tab")
        .that(actual().getCurrentTab())
        .isEqualTo(tab);
    return this;
  }

  public TabHostSubject isCurrentTabTag(String tag) {
    isNotNull();
    check().withFailureMessage("is current tab tag")
        .that(actual().getCurrentTabTag())
        .isEqualTo(tag);
    return this;
  }

  public TabHostSubject isCurrentTabView(View view) {
    isNotNull();
    check().withFailureMessage("is current tab view")
        .that(actual().getCurrentTabView())
        .isSameAs(view);
    return this;
  }

  public TabHostSubject isCurrentView(View view) {
    isNotNull();
    check().withFailureMessage("is current view")
        .that(actual().getCurrentView())
        .isSameAs(view);
    return this;
  }

  private static class TabHostSubjectFactory extends SubjectFactory<TabHostSubject, TabHost> {
    @Override
    public TabHostSubject getSubject(FailureStrategy fs, TabHost that) {
      return new TabHostSubject(fs, that);
    }
  }
}
