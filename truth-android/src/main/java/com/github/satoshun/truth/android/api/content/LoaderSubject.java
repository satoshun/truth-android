package com.github.satoshun.truth.android.api.content;


import android.annotation.TargetApi;
import android.content.Loader;

import com.github.satoshun.truth.android.api.BaseSubject;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.HONEYCOMB;

@TargetApi(HONEYCOMB)
public abstract class LoaderSubject<S extends LoaderSubject<S, T>, T extends Loader>
    extends BaseSubject<S, T> {

  public static final LoaderSubjectFactory FACTORY = new LoaderSubjectFactory();

  public LoaderSubject(FailureStrategy failureStrategy, T actual) {
    super(failureStrategy, actual);
  }

  public S isId(int id) {
    isNotNull();
    check().withFailureMessage("is id")
        .that(actual().getId())
        .isEqualTo(id);
    return myself();
  }

  public S isAbandoned() {
    isNotNull();
    check().withFailureMessage("is abandoned")
        .that(actual().isAbandoned())
        .isTrue();
    return myself();
  }

  public S isNotAbandoned() {
    isNotNull();
    check().withFailureMessage("is not abandoned")
        .that(actual().isAbandoned())
        .isFalse();
    return myself();
  }

  public S isReset() {
    isNotNull();
    check().withFailureMessage("is reset")
        .that(actual().isReset())
        .isTrue();
    return myself();
  }

  public S isNotReset() {
    isNotNull();
    check().withFailureMessage("is not reset")
        .that(actual().isReset())
        .isFalse();
    return myself();
  }

  public S isStarted() {
    isNotNull();
    check().withFailureMessage("is started")
        .that(actual().isStarted())
        .isTrue();
    return myself();
  }

  public S isNotStarted() {
    isNotNull();
    check().withFailureMessage("is nto started")
        .that(actual().isStarted())
        .isFalse();
    return myself();
  }

  private static class LoaderSubjectImpl extends LoaderSubject<LoaderSubjectImpl, Loader> {
    LoaderSubjectImpl(FailureStrategy failureStrategy, Loader actual) {
      super(failureStrategy, actual);
    }
  }

  private static class LoaderSubjectFactory extends SubjectFactory<LoaderSubjectImpl, Loader> {
    @Override
    public LoaderSubjectImpl getSubject(FailureStrategy fs, Loader that) {
      return new LoaderSubjectImpl(fs, that);
    }
  }
}
