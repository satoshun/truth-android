package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.view.View;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

public class ViewSubject extends Subject<ViewSubject, View> {

  public static final ViewSubjectFactory FACTORY = new ViewSubjectFactory();

  ViewSubject(FailureStrategy failureStrategy, View actual) {
    super(failureStrategy, actual);
  }

  @TargetApi(HONEYCOMB)
  public ViewSubject isSameAlpha(float alpha) {
    if (actual().getAlpha() != alpha) {
      fail("is same alpha", actual().getAlpha());
    }
    return this;
  }

  public ViewSubject isVisible() {
    isNotNull();
    if (actual().getVisibility() != View.VISIBLE) {
      fail("is visible", actual().getVisibility());
    }
    return this;
  }

  public ViewSubject isNotVisible() {
    isNotNull();
    if (actual().getVisibility() == View.VISIBLE) {
      fail("is not visible", actual().getVisibility());
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