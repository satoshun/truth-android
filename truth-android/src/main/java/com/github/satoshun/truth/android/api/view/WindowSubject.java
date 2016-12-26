package com.github.satoshun.truth.android.api.view;

import android.annotation.TargetApi;
import android.view.View;
import android.view.Window;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

public class WindowSubject extends BaseSubject<WindowSubject, Window> {

  public static final WindowSubjectFactory FACTORY = new WindowSubjectFactory();

  public WindowSubject(FailureStrategy failureStrategy, Window actual) {
    super(failureStrategy, actual);
  }

  public WindowSubject isCurrentFocus(View view) {
    isNotNull();
    check().withFailureMessage("is current focus")
        .that(actual().getCurrentFocus())
        .isSameAs(view);
    return myself();
  }

  public WindowSubject hasChildren() {
    isNotNull();
    check().withFailureMessage("has children")
        .that(actual().hasChildren())
        .isTrue();
    return myself();
  }

  public WindowSubject hasNoChildren() {
    isNotNull();
    check().withFailureMessage("has no children")
        .that(actual().hasChildren())
        .isFalse();
    return myself();
  }

  @TargetApi(HONEYCOMB)
  public WindowSubject hasFeature(int feature) {
    isNotNull();
    check().withFailureMessage("has feature")
        .that(actual().hasFeature(feature))
        .isTrue();
    return myself();
  }

  public WindowSubject isActive() {
    isNotNull();
    check().withFailureMessage("is active")
        .that(actual().isActive())
        .isTrue();
    return myself();
  }

  public WindowSubject isNotActive() {
    isNotNull();
    check().withFailureMessage("is not active")
        .that(actual().isActive())
        .isFalse();
    return myself();
  }

  public WindowSubject isFloating() {
    isNotNull();
    check().withFailureMessage("is floating")
        .that(actual().isFloating())
        .isTrue();
    return myself();
  }

  public WindowSubject isNotFloating() {
    isNotNull();
    check().withFailureMessage("is not floating")
        .that(actual().isFloating())
        .isFalse();
    return myself();
  }

  private static class WindowSubjectFactory extends SubjectFactory<WindowSubject, Window> {
    @Override
    public WindowSubject getSubject(FailureStrategy fs, Window that) {
      return new WindowSubject(fs, that);
    }
  }
}
