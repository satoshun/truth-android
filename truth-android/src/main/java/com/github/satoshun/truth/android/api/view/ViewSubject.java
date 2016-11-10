package com.github.satoshun.truth.android.api.view;

import android.view.View;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

public class ViewSubject extends Subject<ViewSubject, View> {

  public static final ViewSubjectFactory FACTORY = new ViewSubjectFactory();

  ViewSubject(FailureStrategy failureStrategy, View actual) {
    super(failureStrategy, actual);
  }

  public ViewSubject isVisible() {
    // TODO: check NULL

    if (actual().getVisibility() != View.VISIBLE) {
      fail("is visible", actual().getVisibility());
    }
    return this;
  }

  private static class ViewSubjectFactory extends SubjectFactory<ViewSubject, View> {
    @Override
    public ViewSubject getSubject(FailureStrategy fs, View that) {
      return new ViewSubject(fs, that);
    }
  }
}