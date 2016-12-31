package com.github.satoshun.truth.android.api.widget;

import android.view.View;
import android.widget.Toast;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class ToastSubject extends BaseSubject<ToastSubject, Toast> {

  public static final ToastSubjectFactory FACTORY = new ToastSubjectFactory();

  public ToastSubject(FailureStrategy failureStrategy, Toast actual) {
    super(failureStrategy, actual);
  }

  public ToastSubject isDuration(int duration) {
    isNotNull();
    check().withFailureMessage("is duration")
        .that(actual().getDuration())
        .isEqualTo(duration);
    return this;
  }

  public ToastSubject isGravity(int gravity) {
    isNotNull();
    check().withFailureMessage("is gravity")
        .that(actual().getGravity())
        .isEqualTo(gravity);
    return this;
  }

  public ToastSubject isHorizontalMargin(float margin) {
    isNotNull();
    check().withFailureMessage("is horizontal margin")
        .that(actual().getHorizontalMargin())
        .isEqualTo(margin);
    return this;
  }

  public ToastSubject isVerticalMargin(float margin) {
    isNotNull();
    check().withFailureMessage("is vertical margin")
        .that(actual().getVerticalMargin())
        .isEqualTo(margin);
    return this;
  }

  public ToastSubject isView(View view) {
    isNotNull();
    check().withFailureMessage("is view")
        .that(actual().getView())
        .isSameAs(view);
    return this;
  }

  public ToastSubject isXOffset(int offset) {
    isNotNull();
    check().withFailureMessage("is x offset")
        .that(actual().getXOffset())
        .isEqualTo(offset);
    return this;
  }

  public ToastSubject isYOffset(int offset) {
    isNotNull();
    check().withFailureMessage("is y offset")
        .that(actual().getYOffset())
        .isEqualTo(offset);
    return this;
  }

  private static class ToastSubjectFactory extends SubjectFactory<ToastSubject, Toast> {
    @Override
    public ToastSubject getSubject(FailureStrategy fs, Toast that) {
      return new ToastSubject(fs, that);
    }
  }
}
