package com.github.satoshun.truth.android.api.view;

import android.view.ViewTreeObserver;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class ViewTreeObserverSubject extends BaseSubject<ViewTreeObserverSubject, ViewTreeObserver> {

  public static final ViewTreeObserverSubjectFactory FACTORY = new ViewTreeObserverSubjectFactory();

  public ViewTreeObserverSubject(FailureStrategy failureStrategy, ViewTreeObserver actual) {
    super(failureStrategy, actual);
  }

  public ViewTreeObserverSubject isAlive() {
    isNotNull();
    check().withFailureMessage("is alive")
        .that(actual().isAlive())
        .isTrue();
    return myself();
  }

  public ViewTreeObserverSubject isNotAlive() {
    isNotNull();
    check().withFailureMessage("is not alive")
        .that(actual().isAlive())
        .isFalse();
    return myself();
  }

  private static class ViewTreeObserverSubjectFactory extends SubjectFactory<ViewTreeObserverSubject, ViewTreeObserver> {
    @Override
    public ViewTreeObserverSubject getSubject(FailureStrategy fs, ViewTreeObserver that) {
      return new ViewTreeObserverSubject(fs, that);
    }
  }
}
