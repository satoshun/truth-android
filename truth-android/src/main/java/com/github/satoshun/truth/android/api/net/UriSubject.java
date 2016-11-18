package com.github.satoshun.truth.android.api.net;

import android.net.Uri;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

public abstract class UriSubject<S extends UriSubject<S, T>, T extends Uri> extends BaseSubject<S, T> {

  public static final UriSubjectFactory FACTORY = new UriSubjectFactory();

  public UriSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S sameAsPath(String path) {
    isNotNull();
    String actualPath = actual().getPath();
    check().withFailureMessage("has path")
            .that(actualPath)
            .isEqualTo(path);
    return myself();
  }

  private static class UriSubjectImpl extends UriSubject<UriSubjectImpl, Uri> {
    UriSubjectImpl(FailureStrategy failureStrategy, Uri actual) {
      super(failureStrategy, actual);
    }
  }

  private static class UriSubjectFactory extends SubjectFactory<UriSubjectImpl, Uri> {
    @Override
    public UriSubjectImpl getSubject(FailureStrategy fs, Uri that) {
      return new UriSubjectImpl(fs, that);
    }
  }
}
