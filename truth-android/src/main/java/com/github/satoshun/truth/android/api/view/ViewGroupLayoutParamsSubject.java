package com.github.satoshun.truth.android.api.view;

import android.view.ViewGroup;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class ViewGroupLayoutParamsSubject extends BaseSubject<ViewGroupLayoutParamsSubject, ViewGroup.LayoutParams> {

  public static final ViewGroupLayoutParamsSubjectFactory FACTORY = new ViewGroupLayoutParamsSubjectFactory();

  public ViewGroupLayoutParamsSubject(FailureStrategy failureStrategy, ViewGroup.LayoutParams actual) {
    super(failureStrategy, actual);
  }

  public ViewGroupLayoutParamsSubject isHeight(int height) {
    isNotNull();
    check().withFailureMessage("is height")
        .that(actual().height)
        .isEqualTo(height);
    return myself();
  }

  public ViewGroupLayoutParamsSubject isWidth(int width) {
    isNotNull();
    check().withFailureMessage("is width")
        .that(actual().width)
        .isEqualTo(width);
    return myself();
  }

  private static class ViewGroupLayoutParamsSubjectFactory extends SubjectFactory<ViewGroupLayoutParamsSubject, ViewGroup.LayoutParams> {
    @Override
    public ViewGroupLayoutParamsSubject getSubject(FailureStrategy fs, ViewGroup.LayoutParams that) {
      return new ViewGroupLayoutParamsSubject(fs, that);
    }
  }
}
