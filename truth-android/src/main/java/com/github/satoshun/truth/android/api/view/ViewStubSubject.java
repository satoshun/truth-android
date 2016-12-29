package com.github.satoshun.truth.android.api.view;

import android.view.ViewStub;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public class ViewStubSubject extends ViewSubject<ViewStubSubject, ViewStub> {

  public static final ViewStubSubjectFactory FACTORY = new ViewStubSubjectFactory();

  public ViewStubSubject(FailureStrategy failureStrategy, ViewStub actual) {
    super(failureStrategy, actual);
  }

  public ViewStubSubject isInflatedId(int id) {
    isNotNull();
    check().withFailureMessage("is inflated id")
        .that(actual().getInflatedId())
        .isEqualTo(id);
    return myself();
  }

  public ViewStubSubject isLayoutResource(int resId) {
    isNotNull();
    check().withFailureMessage("is layout resource")
        .that(actual().getLayoutResource())
        .isEqualTo(resId);
    return myself();
  }

  private static class ViewStubSubjectFactory extends SubjectFactory<ViewStubSubject, ViewStub> {
    @Override
    public ViewStubSubject getSubject(FailureStrategy fs, ViewStub that) {
      return new ViewStubSubject(fs, that);
    }
  }
}
