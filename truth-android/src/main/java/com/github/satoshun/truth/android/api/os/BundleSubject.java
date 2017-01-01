package com.github.satoshun.truth.android.api.os;

import android.os.Bundle;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

public class BundleSubject extends BaseSubject<BundleSubject, Bundle> {

  public static final BundleSubjectFactory FACTORY = new BundleSubjectFactory();

  public BundleSubject(FailureStrategy failureStrategy, Bundle actual) {
    super(failureStrategy, actual);
  }

  public BundleSubject hasKey(String key) {
    isNotNull();
    check().withFailureMessage("has key")
        .that(actual().containsKey(key))
        .isTrue();
    return this;
  }

  public BundleSubject isEmpty() {
    isNotNull();
    check().withFailureMessage("is empty")
        .that(actual().isEmpty())
        .isTrue();
    return this;
  }

  public BundleSubject isNotEmpty() {
    isNotNull();
    check().withFailureMessage("is not empty")
        .that(actual().isEmpty())
        .isFalse();
    return this;
  }

  public BundleSubject isSize(int size) {
    isNotNull();
    check().withFailureMessage("is size")
        .that(actual().size())
        .isEqualTo(size);
    return this;
  }

  private static class BundleSubjectFactory extends SubjectFactory<BundleSubject, Bundle> {
    @Override
    public BundleSubject getSubject(FailureStrategy fs, Bundle that) {
      return new BundleSubject(fs, that);
    }
  }
}
